package org.apache.ofbiz.content.content.service;

import org.apache.ofbiz.common.ExecuteFindService;
import org.apache.ofbiz.content.content.service.base.ContentAssocBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentAssocService extends ContentAssocBaseService {
	@Autowired
	public ContentAssocService(ExecuteFindService executeFindService) {
		super(executeFindService);
	}
}
