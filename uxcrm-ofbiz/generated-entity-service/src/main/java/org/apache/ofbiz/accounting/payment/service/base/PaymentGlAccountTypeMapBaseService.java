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
import org.apache.ofbiz.accounting.payment.PaymentGlAccountTypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.payment.PaymentType;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.accounting.ledger.GlAccountType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PaymentGlAccountTypeMapBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PaymentGlAccountTypeMapBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PaymentGlAccountTypeMaps
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PaymentGlAccountTypeMap.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PaymentGlAccountTypeMaps
	 */
	public List<PaymentGlAccountTypeMap> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one PaymentGlAccountTypeMap
	 */
	public Optional<PaymentGlAccountTypeMap> findOne(Object paymentTypeId,
			Object organizationPartyId) {
		List<PaymentGlAccountTypeMap> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGlAccountTypeMap.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("paymentTypeId", EntityOperator.EQUALS,
						paymentTypeId), new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, organizationPartyId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGlAccountTypeMap.fromValues(out.getListIt()
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
	 * Get payment type
	 */
	public Optional<PaymentType> getPaymentType(
			PaymentGlAccountTypeMap paymentGlAccountTypeMap) {
		List<PaymentType> entityList = null;
		In in = new In();
		in.setEntityName(PaymentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentTypeId", EntityOperator.EQUALS,
						paymentGlAccountTypeMap.getPaymentTypeId())),
				EntityOperator.AND));
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
	 * Get party
	 */
	public Optional<Party> getParty(
			PaymentGlAccountTypeMap paymentGlAccountTypeMap) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						paymentGlAccountTypeMap.getOrganizationPartyId())),
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
	 * Get gl account type
	 */
	public Optional<GlAccountType> getGlAccountType(
			PaymentGlAccountTypeMap paymentGlAccountTypeMap) {
		List<GlAccountType> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountTypeId",
						EntityOperator.EQUALS, paymentGlAccountTypeMap
								.getGlAccountTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountType.fromValues(out.getListIt()
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