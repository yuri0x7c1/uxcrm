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
import org.apache.ofbiz.accounting.payment.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.payment.Payment;
import org.apache.ofbiz.accounting.payment.PaymentGlAccountTypeMap;
import org.apache.ofbiz.accounting.payment.PaymentTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PaymentTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PaymentTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PaymentTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PaymentType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PaymentTypes
	 */
	public List<PaymentType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PaymentType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentType.NAME);
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
				entityList = PaymentType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PaymentType
	 */
	public Optional<PaymentType> findOne(Object paymentTypeId) {
		List<PaymentType> entityList = null;
		In in = new In();
		in.setEntityName(PaymentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentTypeId", EntityOperator.EQUALS,
						paymentTypeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentType.fromValues(out.getListIt()
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
	 * Get parent payment type
	 */
	public Optional<PaymentType> getParentPaymentType(PaymentType paymentType) {
		List<PaymentType> entityList = null;
		In in = new In();
		in.setEntityName(PaymentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentTypeId", EntityOperator.EQUALS,
						paymentType.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentType.fromValues(out.getListIt()
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
	 * Get payments
	 */
	public List<Payment> getPayments(PaymentType paymentType, Integer start,
			Integer number, List<String> orderBy) {
		List<Payment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Payment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentTypeId", EntityOperator.EQUALS,
						paymentType.getPaymentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Payment.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get payment gl account type maps
	 */
	public List<PaymentGlAccountTypeMap> getPaymentGlAccountTypeMaps(
			PaymentType paymentType, Integer start, Integer number,
			List<String> orderBy) {
		List<PaymentGlAccountTypeMap> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentGlAccountTypeMap.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentTypeId", EntityOperator.EQUALS,
						paymentType.getPaymentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGlAccountTypeMap.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child payment types
	 */
	public List<PaymentType> getChildPaymentTypes(PaymentType paymentType,
			Integer start, Integer number, List<String> orderBy) {
		List<PaymentType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						paymentType.getPaymentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get payment type attrs
	 */
	public List<PaymentTypeAttr> getPaymentTypeAttrs(PaymentType paymentType,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("paymentTypeId", EntityOperator.EQUALS,
						paymentType.getPaymentTypeId())), EntityOperator.AND));
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