package com.lkl.sp.db.dc.mapping.gen;

import com.lkl.sp.db.dc.mapping.gen.bean.SpOrder;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrderExample.Criteria;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrderExample.Criterion;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SpOrderSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_order`
     *
     * @mbggenerated
     */
    public String countByExample(SpOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("`sp_order`");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_order`
     *
     * @mbggenerated
     */
    public String deleteByExample(SpOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("`sp_order`");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_order`
     *
     * @mbggenerated
     */
    public String insertSelective(SpOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("`sp_order`");
        
        if (record.getOrderNo() != null) {
            sql.VALUES("order_no", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceChannel() != null) {
            sql.VALUES("price_channel", "#{priceChannel,jdbcType=DOUBLE}");
        }
        
        if (record.getGoodNo() != null) {
            sql.VALUES("good_no", "#{goodNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_order`
     *
     * @mbggenerated
     */
    public String selectByExample(SpOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.getSFields()!=null &&  example.getSFields().size()>0) {
            	for(String sfield:example.getSFields()){
                		sql.SELECT(sfield);
                	}
            }else{
                if (example != null && example.isDistinct()) {
                    sql.SELECT_DISTINCT("order_no");
                } else {
                    sql.SELECT("order_no");
                }
                sql.SELECT("price_channel");
                sql.SELECT("good_no");
                sql.SELECT("create_time");
                sql.SELECT("update_time");
            }
            sql.FROM("`sp_order`");
            applyWhere(sql, example, false);
            
            if (example != null && example.getOrderByClause() != null) {
                sql.ORDER_BY(example.getOrderByClause());
            }
            
             String sqlStr = sql.toString();
            if(example.getPage()!=null){
                sqlStr = sqlStr+" limit "+example.getPage().getOffset()+","+example.getPage().getLimit()+"";
                 }
                return sqlStr;
            }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_order`
     *
     * @mbggenerated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SpOrder record = (SpOrder) parameter.get("record");
        SpOrderExample example = (SpOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("`sp_order`");
        
        if (record.getOrderNo() != null) {
            sql.SET("order_no = #{record.orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceChannel() != null) {
            sql.SET("price_channel = #{record.priceChannel,jdbcType=DOUBLE}");
        }
        
        if (record.getGoodNo() != null) {
            sql.SET("good_no = #{record.goodNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_order`
     *
     * @mbggenerated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("`sp_order`");
        
        sql.SET("order_no = #{record.orderNo,jdbcType=VARCHAR}");
        sql.SET("price_channel = #{record.priceChannel,jdbcType=DOUBLE}");
        sql.SET("good_no = #{record.goodNo,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        SpOrderExample example = (SpOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table `sp_order`
     *
     * @mbggenerated
     */
    protected void applyWhere(SQL sql, SpOrderExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}