package org.apache.ofbiz.content.content.service;

import org.apache.ofbiz.common.ExecuteFindService;
import org.apache.ofbiz.content.content.service.base.ContentAssocDataResourceViewFromBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentAssocDataResourceViewFromService extends ContentAssocDataResourceViewFromBaseService {
	@Autowired
	public ContentAssocDataResourceViewFromService(ExecuteFindService executeFindService) {
		super(executeFindService);
	}
}
