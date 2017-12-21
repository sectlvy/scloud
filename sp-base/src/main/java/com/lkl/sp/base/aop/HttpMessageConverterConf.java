package com.lkl.sp.base.aop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class HttpMessageConverterConf {
	@Bean
	public FastJsonHttpMessageConverter mapFormHttpMessageConverter() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		List<MediaType> slist = new ArrayList<>();
		slist.add(MediaType.TEXT_HTML);
		slist.add(MediaType.APPLICATION_JSON_UTF8);
		fastJsonHttpMessageConverter.setSupportedMediaTypes(slist);
		
		fastJsonHttpMessageConverter.setFeatures(SerializerFeature.QuoteFieldNames,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteDateUseDateFormat);
		return fastJsonHttpMessageConverter;
	}

}
