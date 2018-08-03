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
import org.apache.ofbiz.accounting.payment.PaymentMethodAndEftAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.payment.PaymentMethod;
import org.apache.ofbiz.accounting.payment.PaymentMethodType;
import org.apache.ofbiz.accounting.payment.EftAccount;
import org.apache.ofbiz.party.contact.PostalAddress;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PaymentMethodAndEftAccountBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PaymentMethodAndEftAccountBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PaymentMethodAndEftAccounts
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PaymentMethodAndEftAccount.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PaymentMethodAndEftAccounts
	 */
	public List<PaymentMethodAndEftAccount> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PaymentMethodAndEftAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentMethodAndEftAccount.NAME);
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
				entityList = PaymentMethodAndEftAccount.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PaymentMethodAndEftAccount
	 */
	public Optional<PaymentMethodAndEftAccount> findOne(Object paymentMethodId) {
		List<PaymentMethodAndEftAccount> entityList = null;
		In in = new In();
		in.setEntityName(PaymentMethodAndEftAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentMethodId",
						EntityOperator.EQUALS, paymentMethodId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentMethodAndEftAccount.fromValues(out
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

	/**
	 * Get payment method
	 */
	public Optional<PaymentMethod> getPaymentMethod(
			PaymentMethodAndEftAccount paymentMethodAndEftAccount) {
		List<PaymentMethod> entityList = null;
		In in = new In();
		in.setEntityName(PaymentMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentMethodId",
						EntityOperator.EQUALS, paymentMethodAndEftAccount
								.getPaymentMethodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentMethod.fromValues(out.getListIt()
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
	 * Get payment method type
	 */
	public Optional<PaymentMethodType> getPaymentMethodType(
			PaymentMethodAndEftAccount paymentMethodAndEftAccount) {
		List<PaymentMethodType> entityList = null;
		In in = new In();
		in.setEntityName(PaymentMethodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentMethodTypeId",
						EntityOperator.EQUALS, paymentMethodAndEftAccount
								.getPaymentMethodTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentMethodType.fromValues(out.getListIt()
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
	 * Get eft account
	 */
	public Optional<EftAccount> getEftAccount(
			PaymentMethodAndEftAccount paymentMethodAndEftAccount) {
		List<EftAccount> entityList = null;
		In in = new In();
		in.setEntityName(EftAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentMethodId",
						EntityOperator.EQUALS, paymentMethodAndEftAccount
								.getPaymentMethodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EftAccount.fromValues(out.getListIt()
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
	 * Get postal address
	 */
	public Optional<PostalAddress> getPostalAddress(
			PaymentMethodAndEftAccount paymentMethodAndEftAccount) {
		List<PostalAddress> entityList = null;
		In in = new In();
		in.setEntityName(PostalAddress.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						paymentMethodAndEftAccount.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PostalAddress.fromValues(out.getListIt()
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