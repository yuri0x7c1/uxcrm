package org.apache.ofbiz.accounting.finaccount.service.base;

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
import org.apache.ofbiz.accounting.finaccount.FinAccountTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.finaccount.FinAccountTransType;
import org.apache.ofbiz.accounting.finaccount.FinAccountTransTypeAttr;
import org.apache.ofbiz.accounting.finaccount.FinAccount;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.accounting.payment.Payment;
import org.apache.ofbiz.order.order.OrderItem;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.accounting.ledger.GlReconciliation;
import org.apache.ofbiz.accounting.ledger.AcctgTrans;
import org.apache.ofbiz.accounting.finaccount.FinAccountTransAttribute;
import org.apache.ofbiz.order._return.ReturnItemResponse;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FinAccountTransBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FinAccountTransBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FinAccountTranses
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FinAccountTrans.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FinAccountTranses
	 */
	public List<FinAccountTrans> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FinAccountTrans> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTrans.NAME);
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
				entityList = FinAccountTrans.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FinAccountTrans
	 */
	public Optional<FinAccountTrans> findOne(Object finAccountTransId) {
		List<FinAccountTrans> entityList = null;
		In in = new In();
		in.setEntityName(FinAccountTrans.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransId",
						EntityOperator.EQUALS, finAccountTransId)),
				EntityOperator.AND));
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
	 * Get fin account trans type
	 */
	public Optional<FinAccountTransType> getFinAccountTransType(
			FinAccountTrans finAccountTrans) {
		List<FinAccountTransType> entityList = null;
		In in = new In();
		in.setEntityName(FinAccountTransType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransTypeId",
						EntityOperator.EQUALS, finAccountTrans
								.getFinAccountTransTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTransType.fromValues(out.getListIt()
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
	 * Get fin account trans type attrs
	 */
	public List<FinAccountTransTypeAttr> getFinAccountTransTypeAttrs(
			FinAccountTrans finAccountTrans, Integer start, Integer number,
			List<String> orderBy) {
		List<FinAccountTransTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTransTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransTypeId",
						EntityOperator.EQUALS, finAccountTrans
								.getFinAccountTransTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTransTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fin account
	 */
	public Optional<FinAccount> getFinAccount(FinAccountTrans finAccountTrans) {
		List<FinAccount> entityList = null;
		In in = new In();
		in.setEntityName(FinAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountId", EntityOperator.EQUALS,
						finAccountTrans.getFinAccountId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccount.fromValues(out.getListIt()
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
	 * Get party
	 */
	public Optional<Party> getParty(FinAccountTrans finAccountTrans) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						finAccountTrans.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party
						.fromValues(out.getListIt().getCompleteList());
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
	public Optional<Payment> getPayment(FinAccountTrans finAccountTrans) {
		List<Payment> entityList = null;
		In in = new In();
		in.setEntityName(Payment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentId", EntityOperator.EQUALS,
						finAccountTrans.getPaymentId())), EntityOperator.AND));
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
	 * Get order item
	 */
	public Optional<OrderItem> getOrderItem(FinAccountTrans finAccountTrans) {
		List<OrderItem> entityList = null;
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						finAccountTrans.getOrderId()), new EntityExpr(
						"orderItemSeqId", EntityOperator.EQUALS,
						finAccountTrans.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItem.fromValues(out.getListIt()
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
	 * Get performed by party
	 */
	public Optional<Party> getPerformedByParty(FinAccountTrans finAccountTrans) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						finAccountTrans.getPerformedByPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party
						.fromValues(out.getListIt().getCompleteList());
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
	 * Get reason enumeration
	 */
	public Optional<Enumeration> getReasonEnumeration(
			FinAccountTrans finAccountTrans) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						finAccountTrans.getReasonEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
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
	 * Get status item
	 */
	public Optional<StatusItem> getStatusItem(FinAccountTrans finAccountTrans) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						finAccountTrans.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusItem.fromValues(out.getListIt()
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
	 * Get gl reconciliation
	 */
	public Optional<GlReconciliation> getGlReconciliation(
			FinAccountTrans finAccountTrans) {
		List<GlReconciliation> entityList = null;
		In in = new In();
		in.setEntityName(GlReconciliation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glReconciliationId",
						EntityOperator.EQUALS, finAccountTrans
								.getGlReconciliationId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlReconciliation.fromValues(out.getListIt()
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
	 * Get acctg transes
	 */
	public List<AcctgTrans> getAcctgTranses(FinAccountTrans finAccountTrans,
			Integer start, Integer number, List<String> orderBy) {
		List<AcctgTrans> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTrans.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransId",
						EntityOperator.EQUALS, finAccountTrans
								.getFinAccountTransId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTrans.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fin account trans attributes
	 */
	public List<FinAccountTransAttribute> getFinAccountTransAttributes(
			FinAccountTrans finAccountTrans, Integer start, Integer number,
			List<String> orderBy) {
		List<FinAccountTransAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTransAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransId",
						EntityOperator.EQUALS, finAccountTrans
								.getFinAccountTransId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTransAttribute.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get return item responses
	 */
	public List<ReturnItemResponse> getReturnItemResponses(
			FinAccountTrans finAccountTrans, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransId",
						EntityOperator.EQUALS, finAccountTrans
								.getFinAccountTransId())), EntityOperator.AND));
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
}