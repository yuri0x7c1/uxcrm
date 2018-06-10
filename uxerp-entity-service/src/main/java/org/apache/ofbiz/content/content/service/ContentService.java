package org.apache.ofbiz.content.content.service;

import org.apache.ofbiz.common.ExecuteFindService;
import org.apache.ofbiz.content.content.service.base.ContentBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentService extends ContentBaseService {
	@Autowired
	public ContentService(ExecuteFindService executeFindService) {
		super(executeFindService);
	}
}
