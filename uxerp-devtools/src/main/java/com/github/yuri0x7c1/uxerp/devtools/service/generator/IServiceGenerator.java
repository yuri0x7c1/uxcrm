package com.github.yuri0x7c1.uxerp.devtools.service.generator;

import org.apache.ofbiz.service.ModelService;

public interface IServiceGenerator {
	String generate(ModelService service) throws Exception;
}
