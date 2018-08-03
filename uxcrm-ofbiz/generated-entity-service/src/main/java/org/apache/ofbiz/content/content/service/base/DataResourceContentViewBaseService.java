package org.apache.ofbiz.content.content.service.base;

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
import org.apache.ofbiz.content.content.DataResourceContentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.data.ElectronicText;
import org.apache.ofbiz.content.data.ImageDataResource;
import org.apache.ofbiz.content.data.OtherDataResource;
import org.apache.ofbiz.content.data.DataResourceType;
import org.apache.ofbiz.content.data.DataCategory;
import org.apache.ofbiz.common.datasource.DataSource;
import org.apache.ofbiz.content.data.MimeType;
import org.apache.ofbiz.content.data.CharacterSet;
import org.apache.ofbiz.content.data.DataResourceTypeAttr;
import org.apache.ofbiz.content.data.DataResourceAttribute;
import org.apache.ofbiz.content.data.DataResourceRole;
import org.apache.ofbiz.security.login.UserLogin;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class DataResourceContentViewBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public DataResourceContentViewBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count DataResourceContentViews
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(DataResourceContentView.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find DataResourceContentViews
	 */
	public List<DataResourceContentView> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<DataResourceContentView> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResourceContentView.NAME);
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
				entityList = DataResourceContentView.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one DataResourceContentView
	 */
	public Optional<DataResourceContentView> findOne(Object dataResourceId,
			Object coContentId) {
		List<DataResourceContentView> entityList = null;
		In in = new In();
		in.setEntityName(DataResourceContentView.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResourceId), new EntityExpr("coContentId",
						EntityOperator.EQUALS, coContentId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourceContentView.fromValues(out.getListIt()
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
	 * Get electronic text
	 */
	public Optional<ElectronicText> getElectronicText(
			DataResourceContentView dataResourceContentView) {
		List<ElectronicText> entityList = null;
		In in = new In();
		in.setEntityName(ElectronicText.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResourceContentView.getDataResourceId())),
				EntityOperator.AND));
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
			DataResourceContentView dataResourceContentView) {
		List<ImageDataResource> entityList = null;
		In in = new In();
		in.setEntityName(ImageDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResourceContentView.getDataResourceId())),
				EntityOperator.AND));
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
			DataResourceContentView dataResourceContentView) {
		List<OtherDataResource> entityList = null;
		In in = new In();
		in.setEntityName(OtherDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResourceContentView.getDataResourceId())),
				EntityOperator.AND));
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
	 * Get data resource type
	 */
	public Optional<DataResourceType> getDataResourceType(
			DataResourceContentView dataResourceContentView) {
		List<DataResourceType> entityList = null;
		In in = new In();
		in.setEntityName(DataResourceType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceTypeId",
						EntityOperator.EQUALS, dataResourceContentView
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
	 * Get data category
	 */
	public Optional<DataCategory> getDataCategory(
			DataResourceContentView dataResourceContentView) {
		List<DataCategory> entityList = null;
		In in = new In();
		in.setEntityName(DataCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataCategoryId", EntityOperator.EQUALS,
						dataResourceContentView.getDataCategoryId())),
				EntityOperator.AND));
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
	public Optional<DataSource> getDataSource(
			DataResourceContentView dataResourceContentView) {
		List<DataSource> entityList = null;
		In in = new In();
		in.setEntityName(DataSource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataSourceId", EntityOperator.EQUALS,
						dataResourceContentView.getDataSourceId())),
				EntityOperator.AND));
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
	public Optional<MimeType> getMimeType(
			DataResourceContentView dataResourceContentView) {
		List<MimeType> entityList = null;
		In in = new In();
		in.setEntityName(MimeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("mimeTypeId", EntityOperator.EQUALS,
						dataResourceContentView.getMimeTypeId())),
				EntityOperator.AND));
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
	public Optional<CharacterSet> getCharacterSet(
			DataResourceContentView dataResourceContentView) {
		List<CharacterSet> entityList = null;
		In in = new In();
		in.setEntityName(CharacterSet.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("characterSetId", EntityOperator.EQUALS,
						dataResourceContentView.getCharacterSetId())),
				EntityOperator.AND));
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
			DataResourceContentView dataResourceContentView, Integer start,
			Integer number, List<String> orderBy) {
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
						EntityOperator.EQUALS, dataResourceContentView
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
	 * Get data resource attributes
	 */
	public List<DataResourceAttribute> getDataResourceAttributes(
			DataResourceContentView dataResourceContentView, Integer start,
			Integer number, List<String> orderBy) {
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
						dataResourceContentView.getDataResourceId())),
				EntityOperator.AND));
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
	 * Get data resource roles
	 */
	public List<DataResourceRole> getDataResourceRoles(
			DataResourceContentView dataResourceContentView, Integer start,
			Integer number, List<String> orderBy) {
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
						dataResourceContentView.getDataResourceId())),
				EntityOperator.AND));
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
	 * Get created by user login
	 */
	public Optional<UserLogin> getCreatedByUserLogin(
			DataResourceContentView dataResourceContentView) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						dataResourceContentView.getCreatedByUserLogin())),
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
			DataResourceContentView dataResourceContentView) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						dataResourceContentView.getLastModifiedByUserLogin())),
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
}