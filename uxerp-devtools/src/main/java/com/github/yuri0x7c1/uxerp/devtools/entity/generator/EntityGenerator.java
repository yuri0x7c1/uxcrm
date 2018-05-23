package com.github.yuri0x7c1.uxerp.devtools.entity.generator;

import org.apache.ofbiz.entity.model.ModelEntity;

import com.github.yuri0x7c1.uxerp.devtools.generator.util.Generator;

public interface EntityGenerator extends Generator {
	String generate(ModelEntity entity) throws Exception;
}
