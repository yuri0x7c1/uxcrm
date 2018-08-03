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
import org.apache.ofbiz.product.feature.ProductFeatureAndAppl;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.feature.ProductFeature;
import org.apache.ofbiz.product.feature.ProductFeatureAppl;
import org.apache.ofbiz.product.feature.ProductFeatureType;
import org.apache.ofbiz.product.feature.ProductFeatureApplType;
import org.apache.ofbiz.product.feature.ProductFeatureCategory;
import org.apache.ofbiz.product.supplier.SupplierProductFeature;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductFeatureAndApplBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductFeatureAndApplBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductFeatureAndAppls
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductFeatureAndAppl.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductFeatureAndAppls
	 */
	public List<ProductFeatureAndAppl> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductFeatureAndAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureAndAppl.NAME);
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
				entityList = ProductFeatureAndAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductFeatureAndAppl
	 */
	public Optional<ProductFeatureAndAppl> findOne(Object productFeatureId,
			Object productId, Object fromDate) {
		List<ProductFeatureAndAppl> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureAndAppl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productFeatureId", EntityOperator.EQUALS,
						productFeatureId), new EntityExpr("productId",
						EntityOperator.EQUALS, productId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureAndAppl.fromValues(out.getListIt()
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
	 * Get product feature
	 */
	public Optional<ProductFeature> getProductFeature(
			ProductFeatureAndAppl productFeatureAndAppl) {
		List<ProductFeature> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeature.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureId",
						EntityOperator.EQUALS, productFeatureAndAppl
								.getProductFeatureId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeature.fromValues(out.getListIt()
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
	 * Get product feature appl
	 */
	public Optional<ProductFeatureAppl> getProductFeatureAppl(
			ProductFeatureAndAppl productFeatureAndAppl) {
		List<ProductFeatureAppl> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureAppl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS,
						productFeatureAndAppl.getProductId()), new EntityExpr(
						"productFeatureId", EntityOperator.EQUALS,
						productFeatureAndAppl.getProductFeatureId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						productFeatureAndAppl.getFromDate())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureAppl.fromValues(out.getListIt()
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
	 * Get product feature type
	 */
	public Optional<ProductFeatureType> getProductFeatureType(
			ProductFeatureAndAppl productFeatureAndAppl) {
		List<ProductFeatureType> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureTypeId",
						EntityOperator.EQUALS, productFeatureAndAppl
								.getProductFeatureTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureType.fromValues(out.getListIt()
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
	 * Get product feature appl type
	 */
	public Optional<ProductFeatureApplType> getProductFeatureApplType(
			ProductFeatureAndAppl productFeatureAndAppl) {
		List<ProductFeatureApplType> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureApplType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureApplTypeId",
						EntityOperator.EQUALS, productFeatureAndAppl
								.getProductFeatureApplTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureApplType.fromValues(out.getListIt()
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
			ProductFeatureAndAppl productFeatureAndAppl) {
		List<ProductFeatureCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureCategoryId",
						EntityOperator.EQUALS, productFeatureAndAppl
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

	/**
	 * Get supplier product features
	 */
	public List<SupplierProductFeature> getSupplierProductFeatures(
			ProductFeatureAndAppl productFeatureAndAppl, Integer start,
			Integer number, List<String> orderBy) {
		List<SupplierProductFeature> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SupplierProductFeature.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureId",
						EntityOperator.EQUALS, productFeatureAndAppl
								.getProductFeatureId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SupplierProductFeature.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}