package com.github.yuri0x7c1.uxcrm.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.vaadin.spring.i18n.CompositeMessageSource;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.spring.i18n.MessageProvider;
import org.vaadin.spring.i18n.MessageProviderCacheCleanupExecutor;
import org.vaadin.spring.i18n.ResourceBundleMessageProvider;
import org.vaadin.spring.i18n.annotation.EnableI18N;

@EnableI18N
@Configuration
public class I18nConfig {
	@Bean
    I18N i18n(ApplicationContext context) {
        return new I18N(context);
    }

    @Bean
    CompositeMessageSource messageSource(ApplicationContext context) {
        return new CompositeMessageSource(context);
    }

    @Bean
    MessageProviderCacheCleanupExecutor messageProviderCacheCleanupExecutor(Environment environment,
        CompositeMessageSource messageSource) {
        return new MessageProviderCacheCleanupExecutor(environment, messageSource);
    }

	@Bean
	MessageProvider messageProvider() {
		return new ResourceBundleMessageProvider("messages");
	}
}
