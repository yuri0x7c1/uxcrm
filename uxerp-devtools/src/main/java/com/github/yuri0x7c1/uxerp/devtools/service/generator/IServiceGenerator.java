package com.github.yuri0x7c1.uxerp.devtools.service.generator;

import org.apache.ofbiz.service.ModelService;

import com.github.yuri0x7c1.uxerp.devtools.generator.util.Generator;

public interface IServiceGenerator extends Generator {
	String generate(ModelService service) throws Exception;
}
