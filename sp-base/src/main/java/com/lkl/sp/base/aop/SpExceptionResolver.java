package com.lkl.sp.base.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.lkl.sp.base.exceptions.BaseException;

public class SpExceptionResolver extends DefaultHandlerExceptionResolver {

	private static final Logger log = LoggerFactory.getLogger(SpExceptionResolver.class);

	public SpExceptionResolver() {
		setOrder(HIGHEST_PRECEDENCE);
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		if(ex instanceof BaseException){
			BaseException be = (BaseException)ex;
			ModelAndView result = new ModelAndView(new FastJsonJsonView());
			result.addObject("status", be.returnCode.getCode());
			result.addObject("message", be.getMessage());
			return result;
		}else{
			ModelAndView result = new ModelAndView(new FastJsonJsonView());
			result.addObject("status", 4002);
			result.addObject("message", ex.getMessage());
			return result;
		}
	}

}
