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
import org.apache.ofbiz.product.store.ProductStoreEmailSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.common._enum.Enumeration;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductStoreEmailSettingBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductStoreEmailSettingBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductStoreEmailSettings
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductStoreEmailSetting.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductStoreEmailSettings
	 */
	public List<ProductStoreEmailSetting> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductStoreEmailSetting> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreEmailSetting.NAME);
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
				entityList = ProductStoreEmailSetting.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductStoreEmailSetting
	 */
	public Optional<ProductStoreEmailSetting> findOne(Object productStoreId,
			Object emailType) {
		List<ProductStoreEmailSetting> entityList = null;
		In in = new In();
		in.setEntityName(ProductStoreEmailSetting.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productStoreId", EntityOperator.EQUALS,
						productStoreId), new EntityExpr("emailType",
						EntityOperator.EQUALS, emailType)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreEmailSetting.fromValues(out
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
			ProductStoreEmailSetting productStoreEmailSetting) {
		List<ProductStore> entityList = null;
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreId", EntityOperator.EQUALS,
						productStoreEmailSetting.getProductStoreId())),
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
	 * Get enumeration
	 */
	public Optional<Enumeration> getEnumeration(
			ProductStoreEmailSetting productStoreEmailSetting) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						productStoreEmailSetting.getEmailType())),
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
}