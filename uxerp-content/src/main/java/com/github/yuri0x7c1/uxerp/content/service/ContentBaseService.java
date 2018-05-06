package com.github.yuri0x7c1.uxerp.content.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.ofbiz.common._enum.entity.Enumeration;
import org.apache.ofbiz.common.datasource.entity.DataSource;
import org.apache.ofbiz.common.method.entity.CustomMethod;
import org.apache.ofbiz.common.service.PerformFindItemService;
import org.apache.ofbiz.common.service.PerformFindListService;
import org.apache.ofbiz.common.status.entity.StatusItem;
import org.apache.ofbiz.content.content.entity.Content;
import org.apache.ofbiz.content.content.entity.ContentType;
import org.apache.ofbiz.content.content.entity.ContentTypeAttr;
import org.apache.ofbiz.content.content.entity.view.ContentDataResourceView;
import org.apache.ofbiz.content.data.entity.CharacterSet;
import org.apache.ofbiz.content.data.entity.DataResource;
import org.apache.ofbiz.content.data.entity.MimeType;
import org.apache.ofbiz.product.feature.entity.ProductFeatureDataResource;
import org.apache.ofbiz.security.login.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;
import com.github.yuri0x7c1.uxerp.common.find.util.InputFieldBuilder;

@Component
@SuppressWarnings("unchecked")
public class ContentBaseService {

	@Autowired
	private PerformFindListService performFindListService;
	@Autowired
	private PerformFindItemService performFindItemService;

	public List<Content> find(Integer viewIndex, Integer viewSize,
			String orderBy, Map<String, String> inputFields) {
		return Content.fromValues(performFindListService.runSync(
				PerformFindListService.In
						.builder()
						.entityName(ContentDataResourceView.NAME)
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
						.entityName(ContentDataResourceView.NAME)
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

	public Content findOne(String contentId) {
		return Content.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(ContentDataResourceView.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										Content.Fields.contentId.name(),
										FindUtil.OPTION_EQUALS, false,
										contentId).build()).build()).getItem());
	}

	public ContentType getContentType(Content content) {
		return ContentType
				.fromValue(performFindItemService
						.runSync(
								PerformFindItemService.In
										.builder()
										.entityName(ContentType.NAME)
										.inputFields(
												new InputFieldBuilder()
														.addInputField(
																ContentType.Fields.contentTypeId
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																content.getContentTypeId())
														.build()).build())
						.getItem());
	}

	public DataResource getDataResource(Content content) {
		return DataResource.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(DataResource.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										DataResource.Fields.dataResourceId
												.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getDataResourceId()).build())
						.build()).getItem());
	}

	public DataResource getTemplateDataResource(Content content) {
		return DataResource.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(DataResource.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										DataResource.Fields.dataResourceId
												.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getTemplateDataResourceId())
										.build()).build()).getItem());
	}

	public StatusItem getStatusItem(Content content) {
		return StatusItem.fromValue(performFindItemService
				.runSync(
						PerformFindItemService.In
								.builder()
								.entityName(StatusItem.NAME)
								.inputFields(
										new InputFieldBuilder().addInputField(
												StatusItem.Fields.statusId
														.name(),
												FindUtil.OPTION_EQUALS, false,
												content.getStatusId()).build())
								.build()).getItem());
	}

	public Enumeration getPrivilegeEnumeration(Content content) {
		return Enumeration.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(Enumeration.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										Enumeration.Fields.enumId.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getPrivilegeEnumId()).build())
						.build()).getItem());
	}

	public CustomMethod getCustomMethod(Content content) {
		return CustomMethod.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(CustomMethod.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										CustomMethod.Fields.customMethodId
												.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getCustomMethodId()).build())
						.build()).getItem());
	}

	public MimeType getMimeType(Content content) {
		return MimeType.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(MimeType.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										MimeType.Fields.mimeTypeId.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getMimeTypeId()).build())
						.build()).getItem());
	}

	public CharacterSet getCharacterSet(Content content) {
		return CharacterSet.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(CharacterSet.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										CharacterSet.Fields.characterSetId
												.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getCharacterSetId()).build())
						.build()).getItem());
	}

	public List<ContentTypeAttr> getContentTypeAttrs(Content content,
			Integer viewIndex, Integer viewSize, String orderBy) {
		return ContentTypeAttr.fromValues(performFindListService.runSync(
				PerformFindListService.In
						.builder()
						.viewIndex(viewIndex)
						.viewSize(viewSize)
						.inputFields(
								new InputFieldBuilder().addInputField(
										ContentTypeAttr.Fields.contentTypeId
												.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getContentTypeId()).build())
						.build()).getList());
	}

	public UserLogin getCreatedByUserLoginRelation(Content content) {
		return UserLogin.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(UserLogin.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										UserLogin.Fields.userLoginId.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getCreatedByUserLogin())
										.build()).build()).getItem());
	}

	public UserLogin getLastModifiedByUserLoginRelation(Content content) {
		return UserLogin.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(UserLogin.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										UserLogin.Fields.userLoginId.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getLastModifiedByUserLogin())
										.build()).build()).getItem());
	}

	public List<ProductFeatureDataResource> getProductFeatureDataResources(
			Content content, Integer viewIndex, Integer viewSize, String orderBy) {
		return ProductFeatureDataResource
				.fromValues(performFindListService
						.runSync(
								PerformFindListService.In
										.builder()
										.viewIndex(viewIndex)
										.viewSize(viewSize)
										.inputFields(
												new InputFieldBuilder()
														.addInputField(
																ProductFeatureDataResource.Fields.dataResourceId
																		.name(),
																FindUtil.OPTION_EQUALS,
																false,
																content.getDataResourceId())
														.build()).build())
						.getList());
	}

	public DataSource getDataSource(Content content) {
		return DataSource.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(DataSource.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										DataSource.Fields.dataSourceId.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getDataSourceId()).build())
						.build()).getItem());
	}

	public Content getDecoratorContent(Content content) {
		return Content.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(ContentDataResourceView.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										Content.Fields.contentId.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getDecoratorContentId())
										.build()).build()).getItem());
	}

	public Content getOwnerContent(Content content) {
		return Content.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(ContentDataResourceView.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										Content.Fields.contentId.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getOwnerContentId()).build())
						.build()).getItem());
	}

	public Content getInstanceOfContent(Content content) {
		return Content.fromValue(performFindItemService.runSync(
				PerformFindItemService.In
						.builder()
						.entityName(ContentDataResourceView.NAME)
						.inputFields(
								new InputFieldBuilder().addInputField(
										Content.Fields.contentId.name(),
										FindUtil.OPTION_EQUALS, false,
										content.getInstanceOfContentId())
										.build()).build()).getItem());
	}
}