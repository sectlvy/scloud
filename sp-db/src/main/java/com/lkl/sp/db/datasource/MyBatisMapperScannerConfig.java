package com.lkl.sp.db.datasource;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyBatisMapperScannerConfig {
	static final String PACKAGE = "com.lkl.sp.db.dc";
    @Bean(name="dcMapperScanner")
    @Primary
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("dcSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(PACKAGE);
        
        return mapperScannerConfigurer;
    }
    
    static final String ReadPACKAGE = "com.lkl.sp.db.read";
    @Bean(name="readMapperScanner")
    public MapperScannerConfigurer mapperScanner2Configurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("readSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(ReadPACKAGE);
        return mapperScannerConfigurer;
    }
}