package com.github.yuri0x7c1.uxerp.devtools.config;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.entity.model.ModelReader;
import org.apache.ofbiz.service.LocalDispatcher;
import org.apache.ofbiz.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Configuration
public class DevtoolsConfiguration {

	@Autowired
	Delegator delegator;

	@Autowired
	LocalDispatcher dispatcher;

	@RequiredArgsConstructor
	public static class ModelOfbiz {

		@NonNull
		Map<String, ModelEntity> entities;

		@NonNull
		Map<String, ModelService> services;

		public Map<String, ModelEntity> getEntities() {
			return UnmodifiableMap.unmodifiableMap(entities);
		}

		public Map<String, ModelService> getServices() {
			return UnmodifiableMap.unmodifiableMap(services);
		}

	}

	@Bean
	public ModelOfbiz modelOfbiz() throws Exception {

		// get all entities
		ModelReader modelReader = delegator.getModelReader();
		Map<String, ModelEntity> entities = new TreeMap<>();
		Set<String> entityNames = modelReader.getEntityNames();
		for (String entityName : entityNames) {
			entities.put(entityName, modelReader.getModelEntity(entityName));
		}

		// get all services
		Map<String, ModelService> services = new TreeMap<>();

		ModelOfbiz modelOfbiz = new ModelOfbiz(entities, services);
		return modelOfbiz;
	}
}
