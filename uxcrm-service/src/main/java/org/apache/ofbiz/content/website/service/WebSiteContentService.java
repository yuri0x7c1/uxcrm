package org.apache.ofbiz.content.website.service;

import org.apache.ofbiz.common.ExecuteFindService;
import org.apache.ofbiz.content.website.service.base.WebSiteContentBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebSiteContentService extends WebSiteContentBaseService {
	@Autowired
	public WebSiteContentService(ExecuteFindService executeFindService) {
		super(executeFindService);
	}
}
