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
import org.apache.ofbiz.product.store.ProductStoreGroupRollup;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.store.ProductStoreGroup;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductStoreGroupRollupBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductStoreGroupRollupBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductStoreGroupRollups
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductStoreGroupRollup.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductStoreGroupRollups
	 */
	public List<ProductStoreGroupRollup> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductStoreGroupRollup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreGroupRollup.NAME);
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
				entityList = ProductStoreGroupRollup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductStoreGroupRollup
	 */
	public Optional<ProductStoreGroupRollup> findOne(
			Object productStoreGroupId, Object parentGroupId, Object fromDate) {
		List<ProductStoreGroupRollup> entityList = null;
		In in = new In();
		in.setEntityName(ProductStoreGroupRollup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productStoreGroupId", EntityOperator.EQUALS,
						productStoreGroupId), new EntityExpr("parentGroupId",
						EntityOperator.EQUALS, parentGroupId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreGroupRollup.fromValues(out.getListIt()
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
	 * Get current product store group
	 */
	public Optional<ProductStoreGroup> getCurrentProductStoreGroup(
			ProductStoreGroupRollup productStoreGroupRollup) {
		List<ProductStoreGroup> entityList = null;
		In in = new In();
		in.setEntityName(ProductStoreGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreGroupId",
						EntityOperator.EQUALS, productStoreGroupRollup
								.getProductStoreGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreGroup.fromValues(out.getListIt()
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
	 * Get parent product store group
	 */
	public Optional<ProductStoreGroup> getParentProductStoreGroup(
			ProductStoreGroupRollup productStoreGroupRollup) {
		List<ProductStoreGroup> entityList = null;
		In in = new In();
		in.setEntityName(ProductStoreGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreGroupId",
						EntityOperator.EQUALS, productStoreGroupRollup
								.getParentGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreGroup.fromValues(out.getListIt()
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
	 * Get child product store group rollups
	 */
	public List<ProductStoreGroupRollup> getChildProductStoreGroupRollups(
			ProductStoreGroupRollup productStoreGroupRollup, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductStoreGroupRollup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreGroupRollup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentGroupId", EntityOperator.EQUALS,
						productStoreGroupRollup.getProductStoreGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreGroupRollup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get parent product store group rollups
	 */
	public List<ProductStoreGroupRollup> getParentProductStoreGroupRollups(
			ProductStoreGroupRollup productStoreGroupRollup, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductStoreGroupRollup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreGroupRollup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreGroupId",
						EntityOperator.EQUALS, productStoreGroupRollup
								.getParentGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreGroupRollup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sibling product store group rollups
	 */
	public List<ProductStoreGroupRollup> getSiblingProductStoreGroupRollups(
			ProductStoreGroupRollup productStoreGroupRollup, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductStoreGroupRollup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreGroupRollup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentGroupId", EntityOperator.EQUALS,
						productStoreGroupRollup.getParentGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreGroupRollup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}