package com.github.yuri0x7c1.uxerp.content.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.ofbiz.common.datasource.entity.DataSource;
import org.apache.ofbiz.common.service.PerformFindItemService;
import org.apache.ofbiz.common.service.PerformFindListService;
import org.apache.ofbiz.content.content.entity.Content;
import org.apache.ofbiz.content.content.entity.ContentAssoc;
import org.apache.ofbiz.content.content.entity.ContentAssocPredicate;
import org.apache.ofbiz.content.content.entity.ContentAssocType;
import org.apache.ofbiz.content.content.entity.view.ContentDataResourceView;
import org.apache.ofbiz.security.login.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;
import com.github.yuri0x7c1.uxerp.common.find.util.InputFieldBuilder;

@Component
@SuppressWarnings("unchecked")
public class ContentAssocBaseService {

	@Autowired
	private PerformFindListService performFindListService;
	@Autowired
	private PerformFindItemService performFindItemService;

	public List<ContentAssoc> find(Integer viewIndex, Integer viewSize,
			String orderBy, Map<String, String> inputFields) {
		return ContentAssoc.fromValues(performFindListService.runSync(
				PerformFindListService.In
						.builder()
						.entityName(ContentAssoc.NAME)
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
						.entityName(ContentAssoc.NAME)
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

	public ContentAssoc findOne(String contentId, String contentIdTo,
			String contentAssocTypeId, String fromDate) {
		return ContentAssoc
				.fromValue(performFindItemService
						.runSync(
								PerformFindItemService.In
										.builder()
										.entityName(ContentAssoc.NAME)
										.inputFields(
												new InputFieldBuilder()
														.addInputField(
																ContentAssoc.Fields.contentId
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																contentId)
														.addInputField(
																ContentAssoc.Fields.contentIdTo
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																contentIdTo)
														.addInputField(
																ContentAssoc.Fields.contentAssocTypeId
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																contentAssocTypeId)
														.addInputField(
																ContentAssoc.Fields.fromDate
																		.name(),
																FindUtil.OPTION_EQUALS,
																false, fromDate)
														.build()).build())
						.getItem());
	}

	public Content getFromContent(ContentAssoc contentAssoc) {
		return Content.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(ContentDataResourceView.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										Content.Fields.contentId.name(),
										FindUtil.OPTION_EQUALS, false,
										contentAssoc.getContentId()).build())
						.build()).getItem());
	}

	public Content getToContent(ContentAssoc contentAssoc) {
		return Content.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(ContentDataResourceView.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										Content.Fields.contentId.name(),
										FindUtil.OPTION_EQUALS, false,
										contentAssoc.getContentIdTo()).build())
						.build()).getItem());
	}

	public ContentAssocType getContentAssocType(ContentAssoc contentAssoc) {
		return ContentAssocType
				.fromValue(performFindItemService
						.runSync(
								PerformFindItemService.In
										.builder()
										.entityName(ContentAssocType.NAME)
										.inputFields(
												new InputFieldBuilder()
														.addInputField(
																ContentAssocType.Fields.contentAssocTypeId
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																contentAssoc
																		.getContentAssocTypeId())
														.build()).build())
						.getItem());
	}

	public UserLogin getCreatedByUserLoginRelation(ContentAssoc contentAssoc) {
		return UserLogin.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(UserLogin.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										UserLogin.Fields.userLoginId.name(),
										FindUtil.OPTION_EQUALS, false,
										contentAssoc.getCreatedByUserLogin())
										.build()).build()).getItem());
	}

	public UserLogin getLastModifiedByUserLoginRelation(
			ContentAssoc contentAssoc) {
		return UserLogin.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(UserLogin.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										UserLogin.Fields.userLoginId.name(),
										FindUtil.OPTION_EQUALS,
										false,
										contentAssoc
												.getLastModifiedByUserLogin())
										.build()).build()).getItem());
	}

	public ContentAssocPredicate getContentAssocPredicate(
			ContentAssoc contentAssoc) {
		return ContentAssocPredicate
				.fromValue(performFindItemService
						.runSync(
								PerformFindItemService.In
										.builder()
										.entityName(ContentAssocPredicate.NAME)
										.inputFields(
												new InputFieldBuilder()
														.addInputField(
																ContentAssocPredicate.Fields.contentAssocPredicateId
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																contentAssoc
																		.getContentAssocPredicateId())
														.build()).build())
						.getItem());
	}

	public DataSource getDataSource(ContentAssoc contentAssoc) {
		return DataSource.fromValue(performFindItemService
				.runSync(
						PerformFindItemService.In
								.builder()
								.entityName(DataSource.NAME)
								.inputFields(
										new InputFieldBuilder().addInputField(
												DataSource.Fields.dataSourceId
														.name(),
												FindUtil.OPTION_EQUALS, false,
												contentAssoc.getDataSourceId())
												.build()).build()).getItem());
	}
}