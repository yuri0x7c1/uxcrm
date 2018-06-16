package com.github.yuri0x7c1.uxcrm.devtools.service.generator;

import org.apache.ofbiz.service.ModelService;

import com.github.yuri0x7c1.uxcrm.devtools.generator.util.Generator;

public interface ServiceGenerator extends Generator {
	String generate(ModelService service) throws Exception;
}
