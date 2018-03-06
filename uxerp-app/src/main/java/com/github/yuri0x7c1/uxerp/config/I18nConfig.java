package com.github.yuri0x7c1.uxerp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vaadin.spring.i18n.MessageProvider;
import org.vaadin.spring.i18n.ResourceBundleMessageProvider;

@Configuration
public class I18nConfig {
	@Bean
	MessageProvider messageProvider() {
		return new ResourceBundleMessageProvider("messages");
	}
}
