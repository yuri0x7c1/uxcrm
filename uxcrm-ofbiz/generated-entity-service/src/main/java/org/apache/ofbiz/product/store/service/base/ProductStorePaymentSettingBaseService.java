package org.apache.ofbiz.product.store.service.base;

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
import org.apache.ofbiz.product.store.ProductStorePaymentSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.accounting.payment.PaymentMethodType;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.accounting.payment.PaymentGatewayConfig;
import org.apache.ofbiz.common.method.CustomMethod;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductStorePaymentSettingBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductStorePaymentSettingBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductStorePaymentSettings
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductStorePaymentSetting.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductStorePaymentSettings
	 */
	public List<ProductStorePaymentSetting> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one ProductStorePaymentSetting
	 */
	public Optional<ProductStorePaymentSetting> findOne(Object productStoreId,
			Object paymentMethodTypeId, Object paymentServiceTypeEnumId) {
		List<ProductStorePaymentSetting> entityList = null;
		In in = new In();
		in.setEntityName(ProductStorePaymentSetting.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productStoreId", EntityOperator.EQUALS,
						productStoreId), new EntityExpr("paymentMethodTypeId",
						EntityOperator.EQUALS, paymentMethodTypeId),
				new EntityExpr("paymentServiceTypeEnumId",
						EntityOperator.EQUALS, paymentServiceTypeEnumId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStorePaymentSetting.fromValues(out
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
	 * Get product store
	 */
	public Optional<ProductStore> getProductStore(
			ProductStorePaymentSetting productStorePaymentSetting) {
		List<ProductStore> entityList = null;
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreId", EntityOperator.EQUALS,
						productStorePaymentSetting.getProductStoreId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
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
			ProductStorePaymentSetting productStorePaymentSetting) {
		List<PaymentMethodType> entityList = null;
		In in = new In();
		in.setEntityName(PaymentMethodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentMethodTypeId",
						EntityOperator.EQUALS, productStorePaymentSetting
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
	 * Get enumeration
	 */
	public Optional<Enumeration> getEnumeration(
			ProductStorePaymentSetting productStorePaymentSetting) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						productStorePaymentSetting
								.getPaymentServiceTypeEnumId())),
				EntityOperator.AND));
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
	 * Get payment gateway config
	 */
	public Optional<PaymentGatewayConfig> getPaymentGatewayConfig(
			ProductStorePaymentSetting productStorePaymentSetting) {
		List<PaymentGatewayConfig> entityList = null;
		In in = new In();
		in.setEntityName(PaymentGatewayConfig.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentGatewayConfigId",
						EntityOperator.EQUALS, productStorePaymentSetting
								.getPaymentGatewayConfigId())),
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
	 * Get custom method
	 */
	public Optional<CustomMethod> getCustomMethod(
			ProductStorePaymentSetting productStorePaymentSetting) {
		List<CustomMethod> entityList = null;
		In in = new In();
		in.setEntityName(CustomMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("customMethodId",
						EntityOperator.EQUALS, productStorePaymentSetting
								.getPaymentCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomMethod.fromValues(out.getListIt()
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