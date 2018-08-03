package org.apache.ofbiz.order._return.service.base;

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
import org.apache.ofbiz.order._return.ReturnItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.order.OrderPaymentPreference;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.accounting.payment.Payment;
import org.apache.ofbiz.accounting.payment.BillingAccount;
import org.apache.ofbiz.accounting.finaccount.FinAccountTrans;
import org.apache.ofbiz.order._return.ReturnItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ReturnItemResponseBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ReturnItemResponseBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ReturnItemResponses
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ReturnItemResponse.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ReturnItemResponses
	 */
	public List<ReturnItemResponse> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ReturnItemResponse> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnItemResponse.NAME);
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
				entityList = ReturnItemResponse.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ReturnItemResponse
	 */
	public Optional<ReturnItemResponse> findOne(Object returnItemResponseId) {
		List<ReturnItemResponse> entityList = null;
		In in = new In();
		in.setEntityName(ReturnItemResponse.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnItemResponseId",
						EntityOperator.EQUALS, returnItemResponseId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItemResponse.fromValues(out.getListIt()
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
	 * Get order payment preference
	 */
	public Optional<OrderPaymentPreference> getOrderPaymentPreference(
			ReturnItemResponse returnItemResponse) {
		List<OrderPaymentPreference> entityList = null;
		In in = new In();
		in.setEntityName(OrderPaymentPreference.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderPaymentPreferenceId",
						EntityOperator.EQUALS, returnItemResponse
								.getOrderPaymentPreferenceId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderPaymentPreference.fromValues(out.getListIt()
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
	 * Get replacement order header
	 */
	public Optional<OrderHeader> getReplacementOrderHeader(
			ReturnItemResponse returnItemResponse) {
		List<OrderHeader> entityList = null;
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderId", EntityOperator.EQUALS,
						returnItemResponse.getReplacementOrderId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderHeader.fromValues(out.getListIt()
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
	 * Get payment
	 */
	public Optional<Payment> getPayment(ReturnItemResponse returnItemResponse) {
		List<Payment> entityList = null;
		In in = new In();
		in.setEntityName(Payment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentId", EntityOperator.EQUALS,
						returnItemResponse.getPaymentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Payment.fromValues(out.getListIt()
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
	 * Get billing account
	 */
	public Optional<BillingAccount> getBillingAccount(
			ReturnItemResponse returnItemResponse) {
		List<BillingAccount> entityList = null;
		In in = new In();
		in.setEntityName(BillingAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("billingAccountId",
						EntityOperator.EQUALS, returnItemResponse
								.getBillingAccountId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BillingAccount.fromValues(out.getListIt()
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
	 * Get fin account trans
	 */
	public Optional<FinAccountTrans> getFinAccountTrans(
			ReturnItemResponse returnItemResponse) {
		List<FinAccountTrans> entityList = null;
		In in = new In();
		in.setEntityName(FinAccountTrans.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransId",
						EntityOperator.EQUALS, returnItemResponse
								.getFinAccountTransId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTrans.fromValues(out.getListIt()
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
	 * Get return items
	 */
	public List<ReturnItem> getReturnItems(
			ReturnItemResponse returnItemResponse, Integer start,
			Integer number, List<String> orderBy) {
		List<ReturnItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnItemResponseId",
						EntityOperator.EQUALS, returnItemResponse
								.getReturnItemResponseId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}