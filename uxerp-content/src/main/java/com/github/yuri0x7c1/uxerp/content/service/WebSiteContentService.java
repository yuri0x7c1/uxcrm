package com.github.yuri0x7c1.uxerp.content.service;

import static com.github.yuri0x7c1.uxerp.common.find.util.FindUtil.OPTION_EQUALS;
import static com.github.yuri0x7c1.uxerp.common.find.util.FindUtil.Y;
import static com.github.yuri0x7c1.uxerp.common.find.util.FindUtil.getFieldIgnoreCaseKey;
import static com.github.yuri0x7c1.uxerp.common.find.util.FindUtil.getFieldOptionKey;

import java.util.HashMap;

import org.apache.commons.collections4.MapUtils;
import org.apache.ofbiz.common.service.PerformFindItemService;
import org.apache.ofbiz.common.service.PerformFindItemService.In;
import org.apache.ofbiz.common.service.PerformFindListService;
import org.apache.ofbiz.content.content.entity.Content;
import org.apache.ofbiz.content.content.entity.view.ContentDataResourceView;
import org.apache.ofbiz.content.website.entity.WebSiteContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebSiteContentService {
	private final PerformFindListService performFindListService;
	private final PerformFindItemService performFindItemService;

	@Autowired
	public WebSiteContentService(PerformFindListService performFindListService, PerformFindItemService performFindItemService) {
		super();
		this.performFindListService = performFindListService;
		this.performFindItemService = performFindItemService;
	}

	public Content getContent(WebSiteContent webSiteContent) {
		In in = In.builder()
				.entityName(ContentDataResourceView.NAME) // TODO: Using ContentDataResourceView.NAME because find Content entity throws NPE
				.inputFields(MapUtils.putAll(new HashMap<String, String>(), new String[][] {
					{getFieldOptionKey("contentId"), OPTION_EQUALS },
					{getFieldIgnoreCaseKey("contentId"), Y} ,
					{"contentId", webSiteContent.getContentId()}
				}))
				.build();

		return Content.fromValue(performFindItemService.runSync(in).getItem());
	}
}