package org.apache.ofbiz.product.category.service.base;

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
import org.apache.ofbiz.product.category.ProductCategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.category.ProductCategory;
import org.apache.ofbiz.product.category.ProductCategoryTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductCategoryTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductCategoryTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductCategoryTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductCategoryType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductCategoryTypes
	 */
	public List<ProductCategoryType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductCategoryType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryType.NAME);
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
				entityList = ProductCategoryType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductCategoryType
	 */
	public Optional<ProductCategoryType> findOne(Object productCategoryTypeId) {
		List<ProductCategoryType> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategoryType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryTypeId",
						EntityOperator.EQUALS, productCategoryTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryType.fromValues(out.getListIt()
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
	 * Get parent product category type
	 */
	public Optional<ProductCategoryType> getParentProductCategoryType(
			ProductCategoryType productCategoryType) {
		List<ProductCategoryType> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategoryType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryTypeId",
						EntityOperator.EQUALS, productCategoryType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryType.fromValues(out.getListIt()
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
	 * Get product categories
	 */
	public List<ProductCategory> getProductCategories(
			ProductCategoryType productCategoryType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryTypeId",
						EntityOperator.EQUALS, productCategoryType
								.getProductCategoryTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child product category types
	 */
	public List<ProductCategoryType> getChildProductCategoryTypes(
			ProductCategoryType productCategoryType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductCategoryType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						productCategoryType.getProductCategoryTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product category type attrs
	 */
	public List<ProductCategoryTypeAttr> getProductCategoryTypeAttrs(
			ProductCategoryType productCategoryType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductCategoryTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryTypeId",
						EntityOperator.EQUALS, productCategoryType
								.getProductCategoryTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}