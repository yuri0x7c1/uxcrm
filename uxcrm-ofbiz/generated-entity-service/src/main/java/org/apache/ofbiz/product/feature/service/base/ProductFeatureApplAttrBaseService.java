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
import org.apache.ofbiz.product.feature.ProductFeatureApplAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.feature.ProductFeature;
import org.apache.ofbiz.product.feature.ProductFeatureAppl;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductFeatureApplAttrBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductFeatureApplAttrBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductFeatureApplAttrs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductFeatureApplAttr.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductFeatureApplAttrs
	 */
	public List<ProductFeatureApplAttr> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one ProductFeatureApplAttr
	 */
	public Optional<ProductFeatureApplAttr> findOne(Object productId,
			Object productFeatureId, Object fromDate, Object attrName) {
		List<ProductFeatureApplAttr> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureApplAttr.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productId),
				new EntityExpr("productFeatureId", EntityOperator.EQUALS,
						productFeatureId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate), new EntityExpr(
						"attrName", EntityOperator.EQUALS, attrName)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureApplAttr.fromValues(out.getListIt()
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
	public Optional<Product> getProduct(
			ProductFeatureApplAttr productFeatureApplAttr) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						productFeatureApplAttr.getProductId())),
				EntityOperator.AND));
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
			ProductFeatureApplAttr productFeatureApplAttr) {
		List<ProductFeature> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeature.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productFeatureId",
						EntityOperator.EQUALS, productFeatureApplAttr
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
			ProductFeatureApplAttr productFeatureApplAttr) {
		List<ProductFeatureAppl> entityList = null;
		In in = new In();
		in.setEntityName(ProductFeatureAppl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS,
						productFeatureApplAttr.getProductId()), new EntityExpr(
						"productFeatureId", EntityOperator.EQUALS,
						productFeatureApplAttr.getProductFeatureId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						productFeatureApplAttr.getFromDate())),
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
}