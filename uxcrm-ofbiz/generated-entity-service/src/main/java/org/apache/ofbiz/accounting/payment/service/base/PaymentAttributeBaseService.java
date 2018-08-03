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
import org.apache.ofbiz.accounting.payment.PaymentAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.payment.Payment;
import org.apache.ofbiz.accounting.payment.PaymentTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PaymentAttributeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PaymentAttributeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PaymentAttributes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PaymentAttribute.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PaymentAttributes
	 */
	public List<PaymentAttribute> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PaymentAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentAttribute.NAME);
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
				entityList = PaymentAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PaymentAttribute
	 */
	public Optional<PaymentAttribute> findOne(Object paymentId, Object attrName) {
		List<PaymentAttribute> entityList = null;
		In in = new In();
		in.setEntityName(PaymentAttribute.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("paymentId", EntityOperator.EQUALS, paymentId),
				new EntityExpr("attrName", EntityOperator.EQUALS, attrName)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentAttribute.fromValues(out.getListIt()
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
	public Optional<Payment> getPayment(PaymentAttribute paymentAttribute) {
		List<Payment> entityList = null;
		In in = new In();
		in.setEntityName(Payment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentId", EntityOperator.EQUALS,
						paymentAttribute.getPaymentId())), EntityOperator.AND));
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
	 * Get payment type attrs
	 */
	public List<PaymentTypeAttr> getPaymentTypeAttrs(
			PaymentAttribute paymentAttribute, Integer start, Integer number,
			List<String> orderBy) {
		List<PaymentTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						paymentAttribute.getAttrName())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}