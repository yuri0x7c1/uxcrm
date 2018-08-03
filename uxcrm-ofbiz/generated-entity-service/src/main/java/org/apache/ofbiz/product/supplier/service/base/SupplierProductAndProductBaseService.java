package org.apache.ofbiz.product.supplier.service.base;

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
import org.apache.ofbiz.product.supplier.SupplierProductAndProduct;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SupplierProductAndProductBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SupplierProductAndProductBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SupplierProductAndProducts
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SupplierProductAndProduct.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SupplierProductAndProducts
	 */
	public List<SupplierProductAndProduct> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SupplierProductAndProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SupplierProductAndProduct.NAME);
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
				entityList = SupplierProductAndProduct.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SupplierProductAndProduct
	 */
	public Optional<SupplierProductAndProduct> findOne(Object productId,
			Object minimumOrderQuantity, Object currencyUomId,
			Object availableFromDate, Object partyId) {
		List<SupplierProductAndProduct> entityList = null;
		In in = new In();
		in.setEntityName(SupplierProductAndProduct.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productId),
				new EntityExpr("minimumOrderQuantity", EntityOperator.EQUALS,
						minimumOrderQuantity), new EntityExpr("currencyUomId",
						EntityOperator.EQUALS, currencyUomId), new EntityExpr(
						"availableFromDate", EntityOperator.EQUALS,
						availableFromDate), new EntityExpr("partyId",
						EntityOperator.EQUALS, partyId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SupplierProductAndProduct.fromValues(out
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