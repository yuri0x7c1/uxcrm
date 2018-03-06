package com.github.yuri0x7c1.uxerp;

import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.service.LocalDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.github.yuri0x7c1.uxcrm", "org.apache.ofbiz"})
public class Application implements CommandLineRunner {

	public static final String TEST_USERNAME = "admin";
	public static final String TEST_PASSWORD = "ofbiz";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Autowired
	Delegator delegator;

	@Autowired
	LocalDispatcher dispatcher;

	@Override
	public void run(String... arg0) throws Exception {
		log.info("{}", dispatcher.getDispatchContext().getAllServiceNames());
	}
}
