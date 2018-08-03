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
import org.apache.ofbiz.product.store.ProductStorePromoAppl;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.product.promo.ProductPromo;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductStorePromoApplBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductStorePromoApplBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductStorePromoAppls
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductStorePromoAppl.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductStorePromoAppls
	 */
	public List<ProductStorePromoAppl> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductStorePromoAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStorePromoAppl.NAME);
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
				entityList = ProductStorePromoAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductStorePromoAppl
	 */
	public Optional<ProductStorePromoAppl> findOne(Object productStoreId,
			Object productPromoId, Object fromDate) {
		List<ProductStorePromoAppl> entityList = null;
		In in = new In();
		in.setEntityName(ProductStorePromoAppl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productStoreId", EntityOperator.EQUALS,
						productStoreId), new EntityExpr("productPromoId",
						EntityOperator.EQUALS, productPromoId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStorePromoAppl.fromValues(out.getListIt()
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
	 * Get product store
	 */
	public Optional<ProductStore> getProductStore(
			ProductStorePromoAppl productStorePromoAppl) {
		List<ProductStore> entityList = null;
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreId", EntityOperator.EQUALS,
						productStorePromoAppl.getProductStoreId())),
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
	 * Get product promo
	 */
	public Optional<ProductPromo> getProductPromo(
			ProductStorePromoAppl productStorePromoAppl) {
		List<ProductPromo> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productStorePromoAppl.getProductPromoId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromo.fromValues(out.getListIt()
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