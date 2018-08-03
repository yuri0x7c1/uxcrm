package org.apache.ofbiz.product.feature.service.base;

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
import org.apache.ofbiz.product.feature.ProductFeatureCategoryAppl;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.category.ProductCategory;
import org.apache.ofbiz.product.feature.ProductFeatureCategory;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductFeatureCategoryApplBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductFeatureCategoryApplBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductFeatureCategoryAppls
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductFeatureCategoryAppl.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductFeatureCategoryAppls
	 */
	public List<ProductFeatureCategoryAppl> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductFeatureCategoryAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureCategoryAppl.NAME);
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
				entityList = ProductFeatureCategoryAppl.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductFeatureCategoryAppl
	 */
	public Optional<ProductFeatureCategoryAppl> findOne(
			Object productCategoryId, Object productFeatureCategoryId,
			Object fromDate) {
		List<ProductFeatureCategoryAppl> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureCategoryAppl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productCategoryId", EntityOperator.EQUALS,
						productCategoryId), new EntityExpr(
						"productFeatureCategoryId", EntityOperator.EQUALS,
						productFeatureCategoryId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureCategoryAppl.fromValues(out
						.getListIt().getCompleteList());
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
	 * Get product category
	 */
	public Optional<ProductCategory> getProductCategory(
			ProductFeatureCategoryAppl productFeatureCategoryAppl) {
		List<ProductCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productFeatureCategoryAppl
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategory.fromValues(out.getListIt()
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
	 * Get product feature category
	 */
	public Optional<ProductFeatureCategory> getProductFeatureCategory(
			ProductFeatureCategoryAppl productFeatureCategoryAppl) {
		List<ProductFeatureCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureCategoryId",
						EntityOperator.EQUALS, productFeatureCategoryAppl
								.getProductFeatureCategoryId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureCategory.fromValues(out.getListIt()
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