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
import org.apache.ofbiz.accounting.payment.PaymentGatewayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.payment.PaymentGatewayConfigType;
import org.apache.ofbiz.accounting.payment.PaymentGatewayAuthorizeNet;
import org.apache.ofbiz.accounting.payment.PaymentGatewayClearCommerce;
import org.apache.ofbiz.accounting.payment.PaymentGatewayCyberSource;
import org.apache.ofbiz.accounting.payment.PaymentGatewayEway;
import org.apache.ofbiz.accounting.payment.PaymentGatewayOrbital;
import org.apache.ofbiz.accounting.payment.PaymentGatewayPayPal;
import org.apache.ofbiz.accounting.payment.PaymentGatewayPayflowPro;
import org.apache.ofbiz.accounting.payment.PaymentGatewaySagePay;
import org.apache.ofbiz.accounting.payment.PaymentGatewaySecurePay;
import org.apache.ofbiz.accounting.payment.PaymentGatewayWorldPay;
import org.apache.ofbiz.accounting.payment.PaymentGatewayiDEAL;
import org.apache.ofbiz.product.store.ProductStorePaymentSetting;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PaymentGatewayConfigBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PaymentGatewayConfigBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PaymentGatewayConfigs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PaymentGatewayConfig.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PaymentGatewayConfigs
	 */
	public List<PaymentGatewayConfig> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one PaymentGatewayConfig
	 */
	public Optional<PaymentGatewayConfig> findOne(Object paymentGatewayConfigId) {
		List<PaymentGatewayConfig> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayConfig.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfigId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayConfig.fromValues(out.getListIt()
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
	 * Get payment gateway config type
	 */
	public Optional<PaymentGatewayConfigType> getPaymentGatewayConfigType(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewayConfigType> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayConfigType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigTypeId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigTypeId())),
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
	 * Get payment gateway authorize net
	 */
	public Optional<PaymentGatewayAuthorizeNet> getPaymentGatewayAuthorizeNet(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewayAuthorizeNet> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayAuthorizeNet.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayAuthorizeNet.fromValues(out
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
	 * Get payment gateway clear commerce
	 */
	public Optional<PaymentGatewayClearCommerce> getPaymentGatewayClearCommerce(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewayClearCommerce> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayClearCommerce.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayClearCommerce.fromValues(out
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
	 * Get payment gateway cyber source
	 */
	public Optional<PaymentGatewayCyberSource> getPaymentGatewayCyberSource(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewayCyberSource> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayCyberSource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayCyberSource.fromValues(out
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
	 * Get payment gateway eway
	 */
	public Optional<PaymentGatewayEway> getPaymentGatewayEway(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewayEway> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayEway.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayEway.fromValues(out.getListIt()
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
	 * Get payment gateway orbital
	 */
	public Optional<PaymentGatewayOrbital> getPaymentGatewayOrbital(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewayOrbital> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayOrbital.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayOrbital.fromValues(out.getListIt()
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
	 * Get payment gateway pay pal
	 */
	public Optional<PaymentGatewayPayPal> getPaymentGatewayPayPal(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewayPayPal> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayPayPal.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayPayPal.fromValues(out.getListIt()
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
	 * Get payment gateway payflow pro
	 */
	public Optional<PaymentGatewayPayflowPro> getPaymentGatewayPayflowPro(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewayPayflowPro> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayPayflowPro.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayPayflowPro.fromValues(out
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
	 * Get payment gateway sage pay
	 */
	public Optional<PaymentGatewaySagePay> getPaymentGatewaySagePay(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewaySagePay> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewaySagePay.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewaySagePay.fromValues(out.getListIt()
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
	 * Get payment gateway secure pay
	 */
	public Optional<PaymentGatewaySecurePay> getPaymentGatewaySecurePay(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewaySecurePay> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewaySecurePay.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewaySecurePay.fromValues(out.getListIt()
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
	 * Get payment gateway world pay
	 */
	public Optional<PaymentGatewayWorldPay> getPaymentGatewayWorldPay(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewayWorldPay> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayWorldPay.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayWorldPay.fromValues(out.getListIt()
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
	 * Get payment gatewayi deal
	 */
	public Optional<PaymentGatewayiDEAL> getPaymentGatewayiDEAL(
			PaymentGatewayConfig paymentGatewayConfig) {
		List<PaymentGatewayiDEAL> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayiDEAL.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayiDEAL.fromValues(out.getListIt()
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
	 * Get product store payment settings
	 */
	public List<ProductStorePaymentSetting> getProductStorePaymentSettings(
			PaymentGatewayConfig paymentGatewayConfig, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductStorePaymentSetting> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStorePaymentSetting.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, paymentGatewayConfig
								.getPaymentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStorePaymentSetting.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}