package org.apache.ofbiz.product.product.service.base;

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
import org.apache.ofbiz.product.product.ProductContentAndInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.data.ElectronicText;
import org.apache.ofbiz.content.data.ImageDataResource;
import org.apache.ofbiz.content.data.OtherDataResource;
import org.apache.ofbiz.content.content.ContentAssocDataResourceViewFrom;
import org.apache.ofbiz.content.content.ContentAssocDataResourceViewTo;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductContentAndInfoBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductContentAndInfoBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductContentAndInfoes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductContentAndInfo.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductContentAndInfoes
	 */
	public List<ProductContentAndInfo> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductContentAndInfo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductContentAndInfo.NAME);
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
				entityList = ProductContentAndInfo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductContentAndInfo
	 */
	public Optional<ProductContentAndInfo> findOne(Object productId,
			Object contentId, Object productContentTypeId, Object fromDate,
			Object drDataResourceId) {
		List<ProductContentAndInfo> entityList = null;
		In in = new In();
		in.setEntityName(ProductContentAndInfo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productId),
				new EntityExpr("contentId", EntityOperator.EQUALS, contentId),
				new EntityExpr("productContentTypeId", EntityOperator.EQUALS,
						productContentTypeId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate), new EntityExpr(
						"drDataResourceId", EntityOperator.EQUALS,
						drDataResourceId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductContentAndInfo.fromValues(out.getListIt()
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
			ProductContentAndInfo productContentAndInfo) {
		List<ElectronicText> entityList = null;
		In in = new In();
		in.setEntityName(ElectronicText.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						productContentAndInfo.getDataResourceId())),
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
			ProductContentAndInfo productContentAndInfo) {
		List<ImageDataResource> entityList = null;
		In in = new In();
		in.setEntityName(ImageDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						productContentAndInfo.getDataResourceId())),
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
			ProductContentAndInfo productContentAndInfo) {
		List<OtherDataResource> entityList = null;
		In in = new In();
		in.setEntityName(OtherDataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						productContentAndInfo.getDataResourceId())),
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
	 * Get content assoc data resource view froms
	 */
	public List<ContentAssocDataResourceViewFrom> getContentAssocDataResourceViewFroms(
			ProductContentAndInfo productContentAndInfo, Integer start,
			Integer number, List<String> orderBy) {
		List<ContentAssocDataResourceViewFrom> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewFrom.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdStart", EntityOperator.EQUALS,
						productContentAndInfo.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssocDataResourceViewFrom.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get content assoc data resource view toes
	 */
	public List<ContentAssocDataResourceViewTo> getContentAssocDataResourceViewToes(
			ProductContentAndInfo productContentAndInfo, Integer start,
			Integer number, List<String> orderBy) {
		List<ContentAssocDataResourceViewTo> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(ContentAssocDataResourceViewTo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentIdStart", EntityOperator.EQUALS,
						productContentAndInfo.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssocDataResourceViewTo.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}