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
import org.apache.ofbiz.accounting.payment.PaymentGatewayConfigType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.payment.PaymentGatewayConfig;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PaymentGatewayConfigTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PaymentGatewayConfigTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PaymentGatewayConfigTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PaymentGatewayConfigType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PaymentGatewayConfigTypes
	 */
	public List<PaymentGatewayConfigType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PaymentGatewayConfigType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentGatewayConfigType.NAME);
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
				entityList = PaymentGatewayConfigType.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PaymentGatewayConfigType
	 */
	public Optional<PaymentGatewayConfigType> findOne(
			Object paymentGatewayConfigTypeId) {
		List<PaymentGatewayConfigType> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayConfigType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigTypeId",
						EntityOperator.EQUALS, paymentGatewayConfigTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayConfigType.fromValues(out
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
	 * Get parent payment gateway config type
	 */
	public Optional<PaymentGatewayConfigType> getParentPaymentGatewayConfigType(
			PaymentGatewayConfigType paymentGatewayConfigType) {
		List<PaymentGatewayConfigType> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayConfigType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigTypeId",
						EntityOperator.EQUALS, paymentGatewayConfigType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayConfigType.fromValues(out
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
	 * Get sibling payment gateway config types
	 */
	public List<PaymentGatewayConfigType> getSiblingPaymentGatewayConfigTypes(
			PaymentGatewayConfigType paymentGatewayConfigType, Integer start,
			Integer number, List<String> orderBy) {
		List<PaymentGatewayConfigType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentGatewayConfigType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						paymentGatewayConfigType.getParentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayConfigType.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get payment gateway configs
	 */
	public List<PaymentGatewayConfig> getPaymentGatewayConfigs(
			PaymentGatewayConfigType paymentGatewayConfigType, Integer start,
			Integer number, List<String> orderBy) {
		List<PaymentGatewayConfig> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentGatewayConfig.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigTypeId",
						EntityOperator.EQUALS, paymentGatewayConfigType
								.getPaymentGatewayConfigTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayConfig.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child payment gateway config types
	 */
	public List<PaymentGatewayConfigType> getChildPaymentGatewayConfigTypes(
			PaymentGatewayConfigType paymentGatewayConfigType, Integer start,
			Integer number, List<String> orderBy) {
		List<PaymentGatewayConfigType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentGatewayConfigType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						paymentGatewayConfigType
								.getPaymentGatewayConfigTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayConfigType.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}