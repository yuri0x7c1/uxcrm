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
import org.apache.ofbiz.product.config.ProductConfigProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.config.ProductConfigItem;
import org.apache.ofbiz.product.config.ProductConfigOption;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.config.ConfigOptionProductOption;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductConfigProductBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductConfigProductBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductConfigProducts
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductConfigProduct.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductConfigProducts
	 */
	public List<ProductConfigProduct> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one ProductConfigProduct
	 */
	public Optional<ProductConfigProduct> findOne(Object configItemId,
			Object configOptionId, Object productId) {
		List<ProductConfigProduct> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigProduct.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						configItemId), new EntityExpr("configOptionId",
						EntityOperator.EQUALS, configOptionId), new EntityExpr(
						"productId", EntityOperator.EQUALS, productId)),
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

	/**
	 * Get config item product config item
	 */
	public Optional<ProductConfigItem> getConfigItemProductConfigItem(
			ProductConfigProduct productConfigProduct) {
		List<ProductConfigItem> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigProduct.getConfigItemId())),
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
			ProductConfigProduct productConfigProduct) {
		List<ProductConfigOption> entityList = null;
		In in = new In();
		in.setEntityName(ProductConfigOption.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigProduct.getConfigItemId()),
				new EntityExpr("configOptionId", EntityOperator.EQUALS,
						productConfigProduct.getConfigOptionId())),
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
	 * Get product product
	 */
	public Optional<Product> getProductProduct(
			ProductConfigProduct productConfigProduct) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						productConfigProduct.getProductId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt()
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
	 * Get product config option product options
	 */
	public List<ConfigOptionProductOption> getProductConfigOptionProductOptions(
			ProductConfigProduct productConfigProduct, Integer start,
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
				new EntityExpr("configItemId", EntityOperator.EQUALS,
						productConfigProduct.getConfigItemId()),
				new EntityExpr("configOptionId", EntityOperator.EQUALS,
						productConfigProduct.getConfigOptionId()),
				new EntityExpr("productId", EntityOperator.EQUALS,
						productConfigProduct.getProductId())),
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