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
import org.apache.ofbiz.product.product.ProductVirtualAndAssocPrices;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductVirtualAndAssocPricesBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductVirtualAndAssocPricesBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductVirtualAndAssocPriceses
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductVirtualAndAssocPrices.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductVirtualAndAssocPriceses
	 */
	public List<ProductVirtualAndAssocPrices> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<ProductVirtualAndAssocPrices> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductVirtualAndAssocPrices.NAME);
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
				entityList = ProductVirtualAndAssocPrices.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductVirtualAndAssocPrices
	 */
	public Optional<ProductVirtualAndAssocPrices> findOne(Object productId,
			Object productAssocTypeId, Object fromDate, Object assocProductId,
			Object assocProductCount, Object assocPriceTypeId,
			Object assocCurrencyUomId, Object assocProductStoreGroupId,
			Object assocPriceFromDate) {
		List<ProductVirtualAndAssocPrices> entityList = null;
		In in = new In();
		in.setEntityName(ProductVirtualAndAssocPrices.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productId),
				new EntityExpr("productAssocTypeId", EntityOperator.EQUALS,
						productAssocTypeId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate),
				new EntityExpr("assocProductId", EntityOperator.EQUALS,
						assocProductId), new EntityExpr("assocProductCount",
						EntityOperator.EQUALS, assocProductCount),
				new EntityExpr("assocPriceTypeId", EntityOperator.EQUALS,
						assocPriceTypeId), new EntityExpr("assocCurrencyUomId",
						EntityOperator.EQUALS, assocCurrencyUomId),
				new EntityExpr("assocProductStoreGroupId",
						EntityOperator.EQUALS, assocProductStoreGroupId),
				new EntityExpr("assocPriceFromDate", EntityOperator.EQUALS,
						assocPriceFromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductVirtualAndAssocPrices.fromValues(out
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
}