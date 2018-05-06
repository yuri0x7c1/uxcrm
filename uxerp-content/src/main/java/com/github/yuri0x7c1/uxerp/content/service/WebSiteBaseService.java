package com.github.yuri0x7c1.uxerp.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.MapUtils;
import org.apache.ofbiz.common.service.PerformFindListService;
import org.apache.ofbiz.common.service.PerformFindItemService;
import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;
import com.github.yuri0x7c1.uxerp.common.find.util.InputFieldBuilder;
import org.apache.ofbiz.webapp.website.entity.WebSite;
import org.apache.ofbiz.common.theme.entity.VisualThemeSet;

@Component
@SuppressWarnings("unchecked")
public class WebSiteBaseService {

	@Autowired
	private PerformFindListService performFindListService;
	@Autowired
	private PerformFindItemService performFindItemService;

	public List<WebSite> find(Integer viewIndex, Integer viewSize,
			String orderBy, Map<String, String> inputFields) {
		return WebSite.fromValues(performFindListService.runSync(
				PerformFindListService.In
						.builder()
						.entityName(WebSite.NAME)
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
						.entityName(WebSite.NAME)
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

	public WebSite findOne(String webSiteId) {
		return WebSite.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(WebSite.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										WebSite.Fields.webSiteId.name(),
										FindUtil.OPTION_EQUALS, false,
										webSiteId).build()).build()).getItem());
	}

	public VisualThemeSet getVisualThemeSet(WebSite webSite) {
		return VisualThemeSet.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(VisualThemeSet.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										VisualThemeSet.Fields.visualThemeSetId
												.name(),
										FindUtil.OPTION_EQUALS, false,
										webSite.getVisualThemeSetId()).build())
						.build()).getItem());
	}
}