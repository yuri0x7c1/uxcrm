package com.github.yuri0x7c1.uxerp.content.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.ofbiz.common.service.PerformFindItemService;
import org.apache.ofbiz.common.service.PerformFindListService;
import org.apache.ofbiz.content.content.entity.Content;
import org.apache.ofbiz.content.content.entity.view.ContentDataResourceView;
import org.apache.ofbiz.content.website.entity.WebSiteContent;
import org.apache.ofbiz.content.website.entity.WebSiteContentType;
import org.apache.ofbiz.webapp.website.entity.WebSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;
import com.github.yuri0x7c1.uxerp.common.find.util.InputFieldBuilder;

@Component
@SuppressWarnings("unchecked")
public class WebSiteContentBaseService {

	@Autowired
	private PerformFindListService performFindListService;
	@Autowired
	private PerformFindItemService performFindItemService;

	public List<WebSiteContent> find(Integer viewIndex, Integer viewSize,
			String orderBy, Map<String, String> inputFields) {
		return WebSiteContent.fromValues(performFindListService.runSync(
				PerformFindListService.In
						.builder()
						.entityName(WebSiteContent.NAME)
						.viewIndex(viewIndex)
						.viewSize(viewSize)
						.inputFields(
								inputFields != null
										? inputFields
										: Collections.EMPTY_MAP)
						.noConditionFind(
								MapUtils.isNotEmpty(inputFields)
										? FindUtil.N
										: FindUtil.Y).build()).getList());
	}

	public Integer count(Map<String, String> inputFields) {
		return performFindListService.runSync(
				PerformFindListService.In
						.builder()
						.entityName(WebSiteContent.NAME)
						.viewIndex(1)
						.viewSize(1)
						.inputFields(
								inputFields != null
										? inputFields
										: Collections.EMPTY_MAP)
						.noConditionFind(
								MapUtils.isNotEmpty(inputFields)
										? FindUtil.N
										: FindUtil.Y).build()).getListSize();
	}

	public WebSiteContent findOne(String webSiteId, String contentId,
			String webSiteContentTypeId, String fromDate) {
		return WebSiteContent
				.fromValue(performFindItemService
						.runSync(
								PerformFindItemService.In
										.builder()
										.entityName(WebSiteContent.NAME)
										.inputFields(
												new InputFieldBuilder()
														.addInputField(
																WebSiteContent.Fields.webSiteId
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																webSiteId)
														.addInputField(
																WebSiteContent.Fields.contentId
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																contentId)
														.addInputField(
																WebSiteContent.Fields.webSiteContentTypeId
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																webSiteContentTypeId)
														.addInputField(
																WebSiteContent.Fields.fromDate
																		.name(),
																FindUtil.OPTION_EQUALS,
																false, fromDate)
														.build()).build())
						.getItem());
	}

	public WebSite getWebSite(WebSiteContent webSiteContent) {
		return WebSite.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(WebSite.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										WebSite.Fields.webSiteId.name(),
										FindUtil.OPTION_EQUALS, false,
										webSiteContent.getWebSiteId()).build())
						.build()).getItem());
	}

	public Content getContent(WebSiteContent webSiteContent) {
		return Content.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(ContentDataResourceView.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										Content.Fields.contentId.name(),
										FindUtil.OPTION_EQUALS, false,
										webSiteContent.getContentId()).build())
						.build()).getItem());
	}

	public WebSiteContentType getWebSiteContentType(
			WebSiteContent webSiteContent) {
		return WebSiteContentType
				.fromValue(performFindItemService
						.runSync(
								PerformFindItemService.In
										.builder()
										.entityName(WebSiteContentType.NAME)
										.inputFields(
												new InputFieldBuilder()
														.addInputField(
																WebSiteContentType.Fields.webSiteContentTypeId
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																webSiteContent
																		.getWebSiteContentTypeId())
														.build()).build())
						.getItem());
	}
}