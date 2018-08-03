package org.apache.ofbiz.accounting.payment.service.base;

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
import org.apache.ofbiz.accounting.payment.PaymentBudgetAllocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.budget.Budget;
import org.apache.ofbiz.accounting.budget.BudgetItem;
import org.apache.ofbiz.accounting.payment.Payment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PaymentBudgetAllocationBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PaymentBudgetAllocationBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PaymentBudgetAllocations
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PaymentBudgetAllocation.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PaymentBudgetAllocations
	 */
	public List<PaymentBudgetAllocation> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PaymentBudgetAllocation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentBudgetAllocation.NAME);
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
				entityList = PaymentBudgetAllocation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PaymentBudgetAllocation
	 */
	public Optional<PaymentBudgetAllocation> findOne(Object budgetId,
			Object budgetItemSeqId, Object paymentId) {
		List<PaymentBudgetAllocation> entityList = null;
		In in = new In();
		in.setEntityName(PaymentBudgetAllocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("budgetId", EntityOperator.EQUALS, budgetId),
				new EntityExpr("budgetItemSeqId", EntityOperator.EQUALS,
						budgetItemSeqId), new EntityExpr("paymentId",
						EntityOperator.EQUALS, paymentId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentBudgetAllocation.fromValues(out.getListIt()
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
	 * Get budget
	 */
	public Optional<Budget> getBudget(
			PaymentBudgetAllocation paymentBudgetAllocation) {
		List<Budget> entityList = null;
		In in = new In();
		in.setEntityName(Budget.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						paymentBudgetAllocation.getBudgetId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Budget.fromValues(out.getListIt()
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
	 * Get budget item
	 */
	public Optional<BudgetItem> getBudgetItem(
			PaymentBudgetAllocation paymentBudgetAllocation) {
		List<BudgetItem> entityList = null;
		In in = new In();
		in.setEntityName(BudgetItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("budgetId", EntityOperator.EQUALS,
						paymentBudgetAllocation.getBudgetId()), new EntityExpr(
						"budgetItemSeqId", EntityOperator.EQUALS,
						paymentBudgetAllocation.getBudgetItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetItem.fromValues(out.getListIt()
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
	public Optional<Payment> getPayment(
			PaymentBudgetAllocation paymentBudgetAllocation) {
		List<Payment> entityList = null;
		In in = new In();
		in.setEntityName(Payment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentId", EntityOperator.EQUALS,
						paymentBudgetAllocation.getPaymentId())),
				EntityOperator.AND));
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
}