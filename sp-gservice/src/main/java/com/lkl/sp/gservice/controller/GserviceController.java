package com.lkl.sp.gservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lkl.sp.base.common.ReturnResult;
import com.lkl.sp.gservice.service.IDGenService;

@RestController
@RequestMapping("gservice")
class GserviceController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	IDGenService genService;
	
	@RequestMapping(value = {"v1.0/genNo"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ReturnResult genNo(@RequestParam String pre){
		ReturnResult returnResult = new ReturnResult();
		returnResult.setData(genService.getGenNo(pre));
		return returnResult;
	}
}