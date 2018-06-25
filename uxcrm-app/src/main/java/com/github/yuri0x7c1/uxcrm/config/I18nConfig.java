package com.github.yuri0x7c1.uxcrm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vaadin.spring.i18n.MessageProvider;
import org.vaadin.spring.i18n.ResourceBundleMessageProvider;
import org.vaadin.spring.i18n.annotation.EnableI18N;

@EnableI18N
@Configuration
public class I18nConfig {
	@Bean
	MessageProvider messageProvider() {
		return new ResourceBundleMessageProvider("messages");
	}
}
