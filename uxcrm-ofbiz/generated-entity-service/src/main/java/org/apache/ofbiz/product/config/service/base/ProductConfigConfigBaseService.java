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
import org.apache.ofbiz.product.config.ProductConfigConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.config.ProductConfigItem;
import org.apache.ofbiz.product.config.ProductConfigOption;
import org.apache.ofbiz.product.config.ConfigOptionProductOption;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductConfigConfigBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductConfigConfigBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductConfigConfigs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductConfigConfig.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductConfigConfigs
	 */
	public List<ProductConfigConfig> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductConfigConfig> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductConfigConfig.NAME);
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
				entityList = ProductConfigConfig.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductConfigConfig
	 */
	public Optional<ProductConfigConfig> findOne(Object configId,
			Object configItemId, Object configOptionId, Object sequenceNum) {
		List<ProductConfigConfig> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigConfig.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configId", EntityOperator.EQUALS, configId),
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						configItemId), new EntityExpr("configOptionId",
						EntityOperator.EQUALS, configOptionId), new EntityExpr(
						"sequenceNum", EntityOperator.EQUALS, sequenceNum)),
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
	 * Get config item product config item
	 */
	public Optional<ProductConfigItem> getConfigItemProductConfigItem(
			ProductConfigConfig productConfigConfig) {
		List<ProductConfigItem> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigConfig.getConfigItemId())),
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
			ProductConfigConfig productConfigConfig) {
		List<ProductConfigOption> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigOption.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigConfig.getConfigItemId()), new EntityExpr(
						"configOptionId", EntityOperator.EQUALS,
						productConfigConfig.getConfigOptionId())),
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
	 * Get config config option product options
	 */
	public List<ConfigOptionProductOption> getConfigConfigOptionProductOptions(
			ProductConfigConfig productConfigConfig, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configId", EntityOperator.EQUALS,
						productConfigConfig.getConfigId()), new EntityExpr(
						"configItemId", EntityOperator.EQUALS,
						productConfigConfig.getConfigItemId()), new EntityExpr(
						"configOptionId", EntityOperator.EQUALS,
						productConfigConfig.getConfigOptionId()),
				new EntityExpr("sequenceNum", EntityOperator.EQUALS,
						productConfigConfig.getSequenceNum())),
				EntityOperator.AND));
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
}