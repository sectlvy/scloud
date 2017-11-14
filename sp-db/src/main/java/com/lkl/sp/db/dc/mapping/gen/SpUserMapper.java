package com.lkl.sp.db.dc.mapping.gen;

import com.lkl.sp.db.dc.mapping.gen.bean.SpUser;
import com.lkl.sp.db.dc.mapping.gen.bean.SpUserExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SpUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_user`
     *
     * @mbggenerated
     */
    @SelectProvider(type=SpUserSqlProvider.class, method="countByExample")
    int countByExample(SpUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_user`
     *
     * @mbggenerated
     */
    @DeleteProvider(type=SpUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(SpUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_user`
     *
     * @mbggenerated
     */
    @Insert({
        "insert into `sp_user` (user_id, user_name, ",
        "user_desc, create_time, ",
        "update_time)",
        "values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userDesc,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(SpUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_user`
     *
     * @mbggenerated
     */
    @InsertProvider(type=SpUserSqlProvider.class, method="insertSelective")
    int insertSelective(SpUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_user`
     *
     * @mbggenerated
     */
    @SelectProvider(type=SpUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_desc", property="userDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SpUser> selectByExample(SpUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_user`
     *
     * @mbggenerated
     */
    @UpdateProvider(type=SpUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SpUser record, @Param("example") SpUserExample example);
}