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
import org.apache.ofbiz.product.feature.ProductFeatureCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.feature.ProductFeature;
import org.apache.ofbiz.product.feature.ProductFeatureCategoryAppl;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductFeatureCategoryBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductFeatureCategoryBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductFeatureCategories
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductFeatureCategory.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductFeatureCategories
	 */
	public List<ProductFeatureCategory> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductFeatureCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureCategory.NAME);
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
				entityList = ProductFeatureCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductFeatureCategory
	 */
	public Optional<ProductFeatureCategory> findOne(
			Object productFeatureCategoryId) {
		List<ProductFeatureCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureCategoryId",
						EntityOperator.EQUALS, productFeatureCategoryId)),
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

	/**
	 * Get parent product feature category
	 */
	public Optional<ProductFeatureCategory> getParentProductFeatureCategory(
			ProductFeatureCategory productFeatureCategory) {
		List<ProductFeatureCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureCategoryId",
						EntityOperator.EQUALS, productFeatureCategory
								.getParentCategoryId())), EntityOperator.AND));
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

	/**
	 * Get product features
	 */
	public List<ProductFeature> getProductFeatures(
			ProductFeatureCategory productFeatureCategory, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductFeature> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeature.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureCategoryId",
						EntityOperator.EQUALS, productFeatureCategory
								.getProductFeatureCategoryId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeature.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child product feature categories
	 */
	public List<ProductFeatureCategory> getChildProductFeatureCategories(
			ProductFeatureCategory productFeatureCategory, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductFeatureCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureCategory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentCategoryId",
						EntityOperator.EQUALS, productFeatureCategory
								.getProductFeatureCategoryId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product feature category appls
	 */
	public List<ProductFeatureCategoryAppl> getProductFeatureCategoryAppls(
			ProductFeatureCategory productFeatureCategory, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureCategoryId",
						EntityOperator.EQUALS, productFeatureCategory
								.getProductFeatureCategoryId())),
				EntityOperator.AND));
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
}