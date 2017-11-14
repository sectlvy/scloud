/**
 * @Author lukangle
 * 2017年11月1日
 */
package com.lkl.sp.db.dc.mapping.genx.dianxiao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lkl.sp.db.dc.mapping.gen.bean.SpOrder;

public interface DxZidanRspXml {
	public List<SpOrder> getAllSpOrder(@Param("logdate")String logdate);
	
}
