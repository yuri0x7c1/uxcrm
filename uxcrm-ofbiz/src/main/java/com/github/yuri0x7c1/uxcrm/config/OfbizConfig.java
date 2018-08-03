package com.github.yuri0x7c1.uxcrm.config;

import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.DelegatorFactory;
import org.apache.ofbiz.service.GenericDispatcherFactory;
import org.apache.ofbiz.service.LocalDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
public class OfbizConfig {
	@Autowired
	Environment env;

	@Bean
	public Delegator delegator() throws Exception {
		final String DELEGATOR_NAME = "default";
		log.info("Setup Entity Engine Delegator with name: {}", DELEGATOR_NAME);
		return DelegatorFactory.getDelegator(DELEGATOR_NAME);
	}

	@Bean
	public LocalDispatcher dispatcher() throws Exception {
		final String DISPATCHER_NAME = "default";
		log.info("Setup Service Engine Dispatcher with name: {}", DISPATCHER_NAME);
		return new GenericDispatcherFactory().createLocalDispatcher(DISPATCHER_NAME, delegator());
	}
}
