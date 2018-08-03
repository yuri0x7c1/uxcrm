package org.apache.ofbiz.product.config.service.base;

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
import org.apache.ofbiz.product.config.ConfigOptionProductOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.config.ProductConfigConfig;
import org.apache.ofbiz.product.config.ProductConfigProduct;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ConfigOptionProductOptionBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ConfigOptionProductOptionBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ConfigOptionProductOptions
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ConfigOptionProductOption.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ConfigOptionProductOptions
	 */
	public List<ConfigOptionProductOption> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ConfigOptionProductOption> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ConfigOptionProductOption.NAME);
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
				entityList = ConfigOptionProductOption.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ConfigOptionProductOption
	 */
	public Optional<ConfigOptionProductOption> findOne(Object configId,
			Object configItemId, Object configOptionId, Object sequenceNum,
			Object productId) {
		List<ConfigOptionProductOption> entityList = null;
		In in = new In();
		in.setEntityName(ConfigOptionProductOption.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configId", EntityOperator.EQUALS, configId),
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						configItemId), new EntityExpr("configOptionId",
						EntityOperator.EQUALS, configOptionId), new EntityExpr(
						"sequenceNum", EntityOperator.EQUALS, sequenceNum),
				new EntityExpr("productId", EntityOperator.EQUALS, productId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ConfigOptionProductOption.fromValues(out
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
	 * Get config product config config
	 */
	public Optional<ProductConfigConfig> getConfigProductConfigConfig(
			ConfigOptionProductOption configOptionProductOption) {
		List<ProductConfigConfig> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigConfig.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configId", EntityOperator.EQUALS,
						configOptionProductOption.getConfigId()),
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						configOptionProductOption.getConfigItemId()),
				new EntityExpr("configOptionId", EntityOperator.EQUALS,
						configOptionProductOption.getConfigOptionId()),
				new EntityExpr("sequenceNum", EntityOperator.EQUALS,
						configOptionProductOption.getSequenceNum())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfigConfig.fromValues(out.getListIt()
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
	 * Get product product config product
	 */
	public Optional<ProductConfigProduct> getProductProductConfigProduct(
			ConfigOptionProductOption configOptionProductOption) {
		List<ProductConfigProduct> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigProduct.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						configOptionProductOption.getConfigItemId()),
				new EntityExpr("configOptionId", EntityOperator.EQUALS,
						configOptionProductOption.getConfigOptionId()),
				new EntityExpr("productId", EntityOperator.EQUALS,
						configOptionProductOption.getProductId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfigProduct.fromValues(out.getListIt()
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