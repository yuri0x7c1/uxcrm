package com.github.yuri0x7c1.uxcrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.github.yuri0x7c1.uxcrm", "org.apache.ofbiz"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
    @Bean
    TomcatEmbeddedServletContainerFactory tomcat() {
         return new TomcatEmbeddedServletContainerFactory();
    }
}
