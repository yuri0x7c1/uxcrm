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
import org.apache.ofbiz.product.supplier.SupplierPrefOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.supplier.SupplierProduct;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SupplierPrefOrderBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SupplierPrefOrderBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SupplierPrefOrders
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SupplierPrefOrder.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SupplierPrefOrders
	 */
	public List<SupplierPrefOrder> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SupplierPrefOrder> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SupplierPrefOrder.NAME);
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
				entityList = SupplierPrefOrder.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SupplierPrefOrder
	 */
	public Optional<SupplierPrefOrder> findOne(Object supplierPrefOrderId) {
		List<SupplierPrefOrder> entityList = null;
		In in = new In();
		in.setEntityName(SupplierPrefOrder.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("supplierPrefOrderId",
						EntityOperator.EQUALS, supplierPrefOrderId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SupplierPrefOrder.fromValues(out.getListIt()
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
	 * Get supplier products
	 */
	public List<SupplierProduct> getSupplierProducts(
			SupplierPrefOrder supplierPrefOrder, Integer start, Integer number,
			List<String> orderBy) {
		List<SupplierProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SupplierProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("supplierPrefOrderId",
						EntityOperator.EQUALS, supplierPrefOrder
								.getSupplierPrefOrderId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SupplierProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}