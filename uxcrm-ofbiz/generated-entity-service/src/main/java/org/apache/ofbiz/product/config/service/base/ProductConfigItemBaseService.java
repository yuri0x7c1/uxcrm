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
import org.apache.ofbiz.product.config.ProductConfigItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.config.ProdConfItemContent;
import org.apache.ofbiz.product.config.ProductConfig;
import org.apache.ofbiz.product.config.ProductConfigConfig;
import org.apache.ofbiz.product.config.ProductConfigOption;
import org.apache.ofbiz.product.config.ProductConfigOptionIactn;
import org.apache.ofbiz.product.config.ProductConfigProduct;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductConfigItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductConfigItemBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductConfigItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductConfigItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductConfigItems
	 */
	public List<ProductConfigItem> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductConfigItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductConfigItem.NAME);
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
				entityList = ProductConfigItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductConfigItem
	 */
	public Optional<ProductConfigItem> findOne(Object configItemId) {
		List<ProductConfigItem> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						configItemId)), EntityOperator.AND));
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
	 * Get prod conf item contents
	 */
	public List<ProdConfItemContent> getProdConfItemContents(
			ProductConfigItem productConfigItem, Integer start, Integer number,
			List<String> orderBy) {
		List<ProdConfItemContent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProdConfItemContent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigItem.getConfigItemId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdConfItemContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get config item product configs
	 */
	public List<ProductConfig> getConfigItemProductConfigs(
			ProductConfigItem productConfigItem, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductConfig> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductConfig.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigItem.getConfigItemId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfig.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get config item product config configs
	 */
	public List<ProductConfigConfig> getConfigItemProductConfigConfigs(
			ProductConfigItem productConfigItem, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigItem.getConfigItemId())),
				EntityOperator.AND));
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
	 * Get config item product config options
	 */
	public List<ProductConfigOption> getConfigItemProductConfigOptions(
			ProductConfigItem productConfigItem, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductConfigOption> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductConfigOption.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigItem.getConfigItemId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfigOption.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get config item product config option iactns
	 */
	public List<ProductConfigOptionIactn> getConfigItemProductConfigOptionIactns(
			ProductConfigItem productConfigItem, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigItem.getConfigItemId())),
				EntityOperator.AND));
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
	 * Get config item to product config option iactns
	 */
	public List<ProductConfigOptionIactn> getConfigItemToProductConfigOptionIactns(
			ProductConfigItem productConfigItem, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemIdTo", EntityOperator.EQUALS,
						productConfigItem.getConfigItemId())),
				EntityOperator.AND));
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
	 * Get config item product config products
	 */
	public List<ProductConfigProduct> getConfigItemProductConfigProducts(
			ProductConfigItem productConfigItem, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductConfigProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductConfigProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigItem.getConfigItemId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductConfigProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}