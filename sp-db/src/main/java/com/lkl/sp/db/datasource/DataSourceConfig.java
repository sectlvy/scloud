package com.lkl.sp.db.datasource;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSourceFactory;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:config/db.properties")
public class DataSourceConfig {
	private Logger log = LoggerFactory.getLogger(DataSourceConfig.class);
	@Value("${sp_jdbcUrl}")
	private String url;
	@Value("${sp_user}")
	private String username;
	@Value("${sp_password}")
	private String sp_password;
	private String driverClass = "com.mysql.jdbc.Driver";

	static final String ReadPACKAGE = "com.lkl.sp.db.read";

	@Bean(name = "dcDatasource")
	@Primary
	public DataSource readDataSource() throws Exception {
		Properties props = new Properties();
		props.put("driverClassName", driverClass);
		props.put("url", url);
		props.put("username", username);
		props.put("password", sp_password);
		props.put("connectionProperties", "druid.stat.mergeSql=true;druid.stat.slowSqlMillis=1");
		return DruidDataSourceFactory.createDataSource(props);
	}

	@Bean(name = "dcTManager")
	@Primary
	public DataSourceTransactionManager clusterTransactionManager() throws Exception {
		return new DataSourceTransactionManager(readDataSource());
	}

	@Bean(name = "dcSqlSessionFactory")
	@Primary
	public SqlSessionFactory clusterSqlSessionFactory(@Qualifier(value = "dcDatasource") DataSource readDataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(readDataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/lkl/sp/db/dc/mapping/xml/*.xml"));
		
		sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		return sessionFactory.getObject();

	}

}