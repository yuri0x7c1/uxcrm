package org.apache.ofbiz.accounting.invoice.service.base;

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
import org.apache.ofbiz.accounting.invoice.InvoiceItemAndAssocProduct;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class InvoiceItemAndAssocProductBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public InvoiceItemAndAssocProductBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count InvoiceItemAndAssocProducts
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(InvoiceItemAndAssocProduct.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find InvoiceItemAndAssocProducts
	 */
	public List<InvoiceItemAndAssocProduct> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<InvoiceItemAndAssocProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceItemAndAssocProduct.NAME);
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
				entityList = InvoiceItemAndAssocProduct.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one InvoiceItemAndAssocProduct
	 */
	public Optional<InvoiceItemAndAssocProduct> findOne(Object productId,
			Object invoiceItemSeqIdFrom, Object fromDate, Object invoiceIdFrom,
			Object invoiceItemSeqIdTo, Object invoiceItemAssocTypeId,
			Object invoiceIdTo) {
		List<InvoiceItemAndAssocProduct> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItemAndAssocProduct.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productId),
				new EntityExpr("invoiceItemSeqIdFrom", EntityOperator.EQUALS,
						invoiceItemSeqIdFrom), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate), new EntityExpr(
						"invoiceIdFrom", EntityOperator.EQUALS, invoiceIdFrom),
				new EntityExpr("invoiceItemSeqIdTo", EntityOperator.EQUALS,
						invoiceItemSeqIdTo), new EntityExpr(
						"invoiceItemAssocTypeId", EntityOperator.EQUALS,
						invoiceItemAssocTypeId), new EntityExpr("invoiceIdTo",
						EntityOperator.EQUALS, invoiceIdTo)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemAndAssocProduct.fromValues(out
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