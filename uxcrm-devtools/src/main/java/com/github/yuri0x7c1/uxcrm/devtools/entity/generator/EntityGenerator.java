package com.github.yuri0x7c1.uxcrm.devtools.entity.generator;

import org.apache.ofbiz.entity.model.ModelEntity;

import com.github.yuri0x7c1.uxcrm.devtools.generator.util.Generator;

public interface EntityGenerator extends Generator {
	String generate(ModelEntity entity) throws Exception;
}
