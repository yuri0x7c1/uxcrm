package org.apache.ofbiz.product.price.service.base;

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
import org.apache.ofbiz.product.price.ProductPricePurpose;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.order.OrderPaymentPreference;
import org.apache.ofbiz.product.price.ProductPaymentMethodType;
import org.apache.ofbiz.product.price.ProductPrice;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductPricePurposeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductPricePurposeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductPricePurposes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductPricePurpose.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductPricePurposes
	 */
	public List<ProductPricePurpose> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductPricePurpose> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPricePurpose.NAME);
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
				entityList = ProductPricePurpose.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductPricePurpose
	 */
	public Optional<ProductPricePurpose> findOne(Object productPricePurposeId) {
		List<ProductPricePurpose> entityList = null;
		In in = new In();
		in.setEntityName(ProductPricePurpose.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPricePurposeId",
						EntityOperator.EQUALS, productPricePurposeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPricePurpose.fromValues(out.getListIt()
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
	 * Get order payment preferences
	 */
	public List<OrderPaymentPreference> getOrderPaymentPreferences(
			ProductPricePurpose productPricePurpose, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderPaymentPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderPaymentPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPricePurposeId",
						EntityOperator.EQUALS, productPricePurpose
								.getProductPricePurposeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderPaymentPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product payment method types
	 */
	public List<ProductPaymentMethodType> getProductPaymentMethodTypes(
			ProductPricePurpose productPricePurpose, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductPaymentMethodType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPaymentMethodType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPricePurposeId",
						EntityOperator.EQUALS, productPricePurpose
								.getProductPricePurposeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPaymentMethodType.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product prices
	 */
	public List<ProductPrice> getProductPrices(
			ProductPricePurpose productPricePurpose, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductPrice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPrice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPricePurposeId",
						EntityOperator.EQUALS, productPricePurpose
								.getProductPricePurposeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPrice.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}