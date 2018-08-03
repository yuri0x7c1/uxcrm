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
import org.apache.ofbiz.product.config.ProductConfigOptionIactn;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.config.ProductConfigItem;
import org.apache.ofbiz.product.config.ProductConfigOption;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductConfigOptionIactnBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductConfigOptionIactnBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductConfigOptionIactns
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductConfigOptionIactn.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductConfigOptionIactns
	 */
	public List<ProductConfigOptionIactn> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductConfigOptionIactn> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductConfigOptionIactn.NAME);
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
				entityList = ProductConfigOptionIactn.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductConfigOptionIactn
	 */
	public Optional<ProductConfigOptionIactn> findOne(Object configItemId,
			Object configOptionId, Object configItemIdTo,
			Object configOptionIdTo, Object sequenceNum) {
		List<ProductConfigOptionIactn> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigOptionIactn.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						configItemId), new EntityExpr("configOptionId",
						EntityOperator.EQUALS, configOptionId),
				new EntityExpr("configItemIdTo", EntityOperator.EQUALS,
						configItemIdTo), new EntityExpr("configOptionIdTo",
						EntityOperator.EQUALS, configOptionIdTo),
				new EntityExpr("sequenceNum", EntityOperator.EQUALS,
						sequenceNum)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfigOptionIactn.fromValues(out
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
	 * Get config item product config item
	 */
	public Optional<ProductConfigItem> getConfigItemProductConfigItem(
			ProductConfigOptionIactn productConfigOptionIactn) {
		List<ProductConfigItem> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigOptionIactn.getConfigItemId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfigItem.fromValues(out.getListIt()
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
	 * Get config option product config option
	 */
	public Optional<ProductConfigOption> getConfigOptionProductConfigOption(
			ProductConfigOptionIactn productConfigOptionIactn) {
		List<ProductConfigOption> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigOption.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigOptionIactn.getConfigItemId()),
				new EntityExpr("configOptionId", EntityOperator.EQUALS,
						productConfigOptionIactn.getConfigOptionId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfigOption.fromValues(out.getListIt()
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
	 * Get config item to product config item
	 */
	public Optional<ProductConfigItem> getConfigItemToProductConfigItem(
			ProductConfigOptionIactn productConfigOptionIactn) {
		List<ProductConfigItem> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigOptionIactn.getConfigItemIdTo())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfigItem.fromValues(out.getListIt()
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
	 * Get config option to product config option
	 */
	public Optional<ProductConfigOption> getConfigOptionToProductConfigOption(
			ProductConfigOptionIactn productConfigOptionIactn) {
		List<ProductConfigOption> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigOption.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigOptionIactn.getConfigItemIdTo()),
				new EntityExpr("configOptionId", EntityOperator.EQUALS,
						productConfigOptionIactn.getConfigOptionIdTo())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfigOption.fromValues(out.getListIt()
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