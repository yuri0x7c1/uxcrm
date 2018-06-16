package com.github.yuri0x7c1.uxcrm.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.base.component.ComponentConfig;
import org.apache.ofbiz.base.start.Config;
import org.apache.ofbiz.base.start.Start;
import org.apache.ofbiz.base.start.StartupCommand;
import org.apache.ofbiz.base.start.StartupCommandUtil.StartupOption;
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

	@PostConstruct
	private void forceOfbizStartConfig() throws Exception {
		log.info("Start :{}", Start.getInstance());

		// force creating ofbiz config
		List<StartupCommand> ofbizCommands = new ArrayList<>();

		StartupCommand command = new StartupCommand.Builder(StartupOption.START.getName())
				.build();
		ofbizCommands.add(command);

		Constructor<Config> configConstructor = Config.class.getDeclaredConstructor(List.class);
		configConstructor.setAccessible(true);
		Config config = configConstructor.newInstance(ofbizCommands);

		// force set config to Start singleton
		Field configField = Start.getInstance().getClass().getDeclaredField("config");
		configField.setAccessible(true);
		configField.set(Start.getInstance(), config);

		log.info("Start.getConfig(): {}", Start.getInstance().getConfig());

		String ofbizHome = env.getProperty("ofbiz.home");
		log.info("ofbiz home: {}", ofbizHome);

		/*
		    <load-component component-location="base"/>
		    <load-component component-location="entity"/>
		    <load-component component-location="security"/>
		    <load-component component-location="datafile"/>
		    <load-component component-location="minilang"/>
		    <load-component component-location="common"/>
		    <load-component component-location="service"/>
		    <load-component component-location="catalina"/>
		    <load-component component-location="entityext"/>
		    <load-component component-location="webapp"/>
		    <load-component component-location="widget"/>
		    <load-component component-location="testtools"/>
		    <load-component component-location="webtools"/>
		*/

		ComponentConfig.getComponentConfig("base", ofbizHome + "/framework/base");
		ComponentConfig.getComponentConfig("entity", ofbizHome + "/framework/entity");
		ComponentConfig.getComponentConfig("security", ofbizHome + "/framework/security");
		ComponentConfig.getComponentConfig("datafile", ofbizHome + "/framework/datafile");
		ComponentConfig.getComponentConfig("minilang", ofbizHome + "/framework/minilang");
		ComponentConfig.getComponentConfig("common", ofbizHome + "/framework/common");
		ComponentConfig.getComponentConfig("service", ofbizHome + "/framework/service");
		ComponentConfig.getComponentConfig("catalina", ofbizHome + "/framework/catalina");
		ComponentConfig.getComponentConfig("entityext", ofbizHome + "/framework/entityext");
		ComponentConfig.getComponentConfig("webapp", ofbizHome + "/framework/webapp");
		ComponentConfig.getComponentConfig("widget", ofbizHome + "/framework/widget");
		ComponentConfig.getComponentConfig("testtools", ofbizHome + "/framework/testtools");
		ComponentConfig.getComponentConfig("webtools", ofbizHome + "/framework/webtools");
		/*
		    <load-component component-location="datamodel"/>
		    <load-component component-location="party"/>
		    <load-component component-location="securityext"/>
		    <load-component component-location="content"/>
		    <load-component component-location="workeffort"/>
		    <load-component component-location="product"/>
		    <load-component component-location="manufacturing"/>
		    <load-component component-location="accounting"/>
		    <load-component component-location="humanres"/>
		    <load-component component-location="order"/>
		    <load-component component-location="marketing"/>
			<!-- common component used by most other components last because it uses info from most components-->
		    <load-component component-location="commonext"/>
		*/

		ComponentConfig.getComponentConfig("datamodel", ofbizHome + "/applications/datamodel");
		ComponentConfig.getComponentConfig("party", ofbizHome + "/applications/party");
		ComponentConfig.getComponentConfig("securityext", ofbizHome + "/applications/securityext");
		ComponentConfig.getComponentConfig("content", ofbizHome + "/applications/content");
		ComponentConfig.getComponentConfig("workeffort", ofbizHome + "/applications/workeffort");
		ComponentConfig.getComponentConfig("product", ofbizHome + "/applications/product");
		ComponentConfig.getComponentConfig("manufacturing", ofbizHome + "/applications/manufacturing");
		ComponentConfig.getComponentConfig("accounting", ofbizHome + "/applications/accounting");
		ComponentConfig.getComponentConfig("humanres", ofbizHome + "/applications/humanres");
		ComponentConfig.getComponentConfig("order", ofbizHome + "/applications/order");
		ComponentConfig.getComponentConfig("marketing", ofbizHome + "/applications/marketing");
		ComponentConfig.getComponentConfig("commonext", ofbizHome + "/applications/commonext");
	}
}
