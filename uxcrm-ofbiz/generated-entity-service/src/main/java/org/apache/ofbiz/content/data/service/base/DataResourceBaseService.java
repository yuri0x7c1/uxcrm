package org.apache.ofbiz.content.data.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.common.ExecuteFindService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Optional;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import com.github.yuri0x7c1.uxcrm.util.OfbizUtil;
import org.apache.ofbiz.content.data.DataResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.content.data.DataResourceType;
import org.apache.ofbiz.content.data.DataTemplateType;
import org.apache.ofbiz.content.data.DataCategory;
import org.apache.ofbiz.common.datasource.DataSource;
import org.apache.ofbiz.content.data.MimeType;
import org.apache.ofbiz.content.data.CharacterSet;
import org.apache.ofbiz.content.data.DataResourceTypeAttr;
import org.apache.ofbiz.security.login.UserLogin;
import org.apache.ofbiz.content.survey.Survey;
import org.apache.ofbiz.content.survey.SurveyResponse;
import org.apache.ofbiz.content.data.AudioDataResource;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.content.content.ContentRevisionItem;
import org.apache.ofbiz.content.data.DataResourceAttribute;
import org.apache.ofbiz.content.data.DataResourceMetaData;
import org.apache.ofbiz.content.data.DataResourcePurpose;
import org.apache.ofbiz.content.data.DataResourceRole;
import org.apache.ofbiz.content.data.ElectronicText;
import org.apache.ofbiz.content.data.ImageDataResource;
import org.apache.ofbiz.content.data.OtherDataResource;
import org.apache.ofbiz.product.feature.ProductFeatureDataResource;
import org.apache.ofbiz.content.data.VideoDataResource;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class DataResourceBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public DataResourceBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count DataResources
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(DataResource.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find DataResources
	 */
	public List<DataResource> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<DataResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResource.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one DataResource
	 */
	public Optional<DataResource> findOne(Object dataResourceId) {
		List<DataResource> entityList = null;
		In in = new In();
		in.setEntityName(DataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResourceId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResource.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get status item
	 */
	public Optional<StatusItem> getStatusItem(DataResource dataResource) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						dataResource.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusItem.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get data resource type
	 */
	public Optional<DataResourceType> getDataResourceType(
			DataResource dataResource) {
		List<DataResourceType> entityList = null;
		In in = new In();
		in.setEntityName(DataResourceType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceTypeId",
						EntityOperator.EQUALS, dataResource
								.getDataResourceTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourceType.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get data template type
	 */
	public Optional<DataTemplateType> getDataTemplateType(
			DataResource dataResource) {
		List<DataTemplateType> entityList = null;
		In in = new In();
		in.setEntityName(DataTemplateType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataTemplateTypeId",
						EntityOperator.EQUALS, dataResource
								.getDataTemplateTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataTemplateType.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get data category
	 */
	public Optional<DataCategory> getDataCategory(DataResource dataResource) {
		List<DataCategory> entityList = null;
		In in = new In();
		in.setEntityName(DataCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataCategoryId", EntityOperator.EQUALS,
						dataResource.getDataCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataCategory.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get data source
	 */
	public Optional<DataSource> getDataSource(DataResource dataResource) {
		List<DataSource> entityList = null;
		In in = new In();
		in.setEntityName(DataSource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataSourceId", EntityOperator.EQUALS,
						dataResource.getDataSourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataSource.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get mime type
	 */
	public Optional<MimeType> getMimeType(DataResource dataResource) {
		List<MimeType> entityList = null;
		In in = new In();
		in.setEntityName(MimeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("mimeTypeId", EntityOperator.EQUALS,
						dataResource.getMimeTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MimeType.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get character set
	 */
	public Optional<CharacterSet> getCharacterSet(DataResource dataResource) {
		List<CharacterSet> entityList = null;
		In in = new In();
		in.setEntityName(CharacterSet.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("characterSetId", EntityOperator.EQUALS,
						dataResource.getCharacterSetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CharacterSet.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get data resource type attrs
	 */
	public List<DataResourceTypeAttr> getDataResourceTypeAttrs(
			DataResource dataResource, Integer start, Integer number,
			List<String> orderBy) {
		List<DataResourceTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResourceTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceTypeId",
						EntityOperator.EQUALS, dataResource
								.getDataResourceTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourceTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get created by user login
	 */
	public Optional<UserLogin> getCreatedByUserLogin(DataResource dataResource) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						dataResource.getCreatedByUserLogin())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get last modified by user login
	 */
	public Optional<UserLogin> getLastModifiedByUserLogin(
			DataResource dataResource) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						dataResource.getLastModifiedByUserLogin())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get survey
	 */
	public Optional<Survey> getSurvey(DataResource dataResource) {
		List<Survey> entityList = null;
		In in = new In();
		in.setEntityName(Survey.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyId", EntityOperator.EQUALS,
						dataResource.getSurveyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Survey.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get survey response
	 */
	public Optional<SurveyResponse> getSurveyResponse(DataResource dataResource) {
		List<SurveyResponse> entityList = null;
		In in = new In();
		in.setEntityName(SurveyResponse.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("surveyResponseId",
						EntityOperator.EQUALS, dataResource
								.getSurveyResponseId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyResponse.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get audio data resource
	 */
	public Optional<AudioDataResource> getAudioDataResource(
			DataResource dataResource) {
		List<AudioDataResource> entityList = null;
		In in = new In();
		in.setEntityName(AudioDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AudioDataResource.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get contents
	 */
	public List<Content> getContents(DataResource dataResource, Integer start,
			Integer number, List<String> orderBy) {
		List<Content> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Content.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Content.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get template contents
	 */
	public List<Content> getTemplateContents(DataResource dataResource,
			Integer start, Integer number, List<String> orderBy) {
		List<Content> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Content.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("templateDataResourceId",
						EntityOperator.EQUALS, dataResource.getDataResourceId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Content.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get old content revision items
	 */
	public List<ContentRevisionItem> getOldContentRevisionItems(
			DataResource dataResource, Integer start, Integer number,
			List<String> orderBy) {
		List<ContentRevisionItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentRevisionItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("oldDataResourceId",
						EntityOperator.EQUALS, dataResource.getDataResourceId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentRevisionItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get new content revision items
	 */
	public List<ContentRevisionItem> getNewContentRevisionItems(
			DataResource dataResource, Integer start, Integer number,
			List<String> orderBy) {
		List<ContentRevisionItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentRevisionItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("newDataResourceId",
						EntityOperator.EQUALS, dataResource.getDataResourceId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentRevisionItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get data resource attributes
	 */
	public List<DataResourceAttribute> getDataResourceAttributes(
			DataResource dataResource, Integer start, Integer number,
			List<String> orderBy) {
		List<DataResourceAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResourceAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourceAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get data resource meta datas
	 */
	public List<DataResourceMetaData> getDataResourceMetaDatas(
			DataResource dataResource, Integer start, Integer number,
			List<String> orderBy) {
		List<DataResourceMetaData> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResourceMetaData.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourceMetaData.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get data resource purposes
	 */
	public List<DataResourcePurpose> getDataResourcePurposes(
			DataResource dataResource, Integer start, Integer number,
			List<String> orderBy) {
		List<DataResourcePurpose> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResourcePurpose.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourcePurpose.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get data resource roles
	 */
	public List<DataResourceRole> getDataResourceRoles(
			DataResource dataResource, Integer start, Integer number,
			List<String> orderBy) {
		List<DataResourceRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResourceRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourceRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get electronic text
	 */
	public Optional<ElectronicText> getElectronicText(DataResource dataResource) {
		List<ElectronicText> entityList = null;
		In in = new In();
		in.setEntityName(ElectronicText.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ElectronicText.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get image data resource
	 */
	public Optional<ImageDataResource> getImageDataResource(
			DataResource dataResource) {
		List<ImageDataResource> entityList = null;
		In in = new In();
		in.setEntityName(ImageDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ImageDataResource.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get other data resource
	 */
	public Optional<OtherDataResource> getOtherDataResource(
			DataResource dataResource) {
		List<OtherDataResource> entityList = null;
		In in = new In();
		in.setEntityName(OtherDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OtherDataResource.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get product feature data resources
	 */
	public List<ProductFeatureDataResource> getProductFeatureDataResources(
			DataResource dataResource, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductFeatureDataResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureDataResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureDataResource.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get video data resource
	 */
	public Optional<VideoDataResource> getVideoDataResource(
			DataResource dataResource) {
		List<VideoDataResource> entityList = null;
		In in = new In();
		in.setEntityName(VideoDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResource.getDataResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VideoDataResource.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}
}