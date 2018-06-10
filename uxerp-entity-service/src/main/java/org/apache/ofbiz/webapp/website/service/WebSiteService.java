package org.apache.ofbiz.webapp.website.service;

import org.apache.ofbiz.common.ExecuteFindService;
import org.apache.ofbiz.webapp.website.service.base.WebSiteBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebSiteService extends WebSiteBaseService {
	@Autowired
	public WebSiteService(ExecuteFindService executeFindService) {
		super(executeFindService);
	}
}
