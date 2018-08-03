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
import org.apache.ofbiz.product.feature.ProductFeatureAppl;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.feature.ProductFeatureApplType;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.feature.ProductFeature;
import org.apache.ofbiz.product.feature.ProductFeatureApplAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductFeatureApplBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductFeatureApplBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductFeatureAppls
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductFeatureAppl.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductFeatureAppls
	 */
	public List<ProductFeatureAppl> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductFeatureAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureAppl.NAME);
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
				entityList = ProductFeatureAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductFeatureAppl
	 */
	public Optional<ProductFeatureAppl> findOne(Object productId,
			Object productFeatureId, Object fromDate) {
		List<ProductFeatureAppl> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureAppl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productId),
				new EntityExpr("productFeatureId", EntityOperator.EQUALS,
						productFeatureId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
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
	 * Get product feature appl type
	 */
	public Optional<ProductFeatureApplType> getProductFeatureApplType(
			ProductFeatureAppl productFeatureAppl) {
		List<ProductFeatureApplType> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureApplType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureApplTypeId",
						EntityOperator.EQUALS, productFeatureAppl
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
	 * Get product
	 */
	public Optional<Product> getProduct(ProductFeatureAppl productFeatureAppl) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						productFeatureAppl.getProductId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt()
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
			ProductFeatureAppl productFeatureAppl) {
		List<ProductFeature> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeature.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureId",
						EntityOperator.EQUALS, productFeatureAppl
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
	 * Get product feature appl attrs
	 */
	public List<ProductFeatureApplAttr> getProductFeatureApplAttrs(
			ProductFeatureAppl productFeatureAppl, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductFeatureApplAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureApplAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS,
						productFeatureAppl.getProductId()), new EntityExpr(
						"productFeatureId", EntityOperator.EQUALS,
						productFeatureAppl.getProductFeatureId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						productFeatureAppl.getFromDate())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureApplAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}