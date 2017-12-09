package com.lkl.sp.base.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import com.lkl.sp.base.common.ReturnResult;
import com.lkl.sp.base.exceptions.SpReturnCodeEnum;

@Component
@Aspect
public class ParameterValidator {
	private Logger log = LoggerFactory.getLogger(ParameterValidator.class);
	@Autowired
	Validator validator;
	
	@Around(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)", argNames = "jp")
	public Object basicParameterCheck(ProceedingJoinPoint jp) throws Throwable {
		Object[] args = jp.getArgs();
		for (Object arg : args) {
			if (arg instanceof BindingResult) {
				ReturnResult rs = new ReturnResult();
				rs.setStatus(Integer.parseInt("400" + SpReturnCodeEnum.PARAM_ERROR.getCode()));
				BindingResult result = BindingResult.class.cast(arg);
				if (result.hasErrors()) {
					Map<String, String> errMsgMap = new HashMap<>(result.getErrorCount());
					for (FieldError error : result.getFieldErrors()) {
						errMsgMap.put(error.getField(), error.getDefaultMessage());
					}
					String emsg = String.format(SpReturnCodeEnum.PARAM_ERROR.getMessage(), errMsgMap.toString());
					rs.setMessage(emsg);
					log.error(errMsgMap.toString());
					return rs;
				}
				break;
			}
		}

		return jp.proceed();
	}
	
	private BindingResult getBindingResult(Object[] args){
		if(args == null || args.length == 0)
			return null;
		for(Object obj : args){
			if(obj instanceof BindingResult){
				return (BindingResult) obj;
			}
		}
		return null;
	}
	
}
