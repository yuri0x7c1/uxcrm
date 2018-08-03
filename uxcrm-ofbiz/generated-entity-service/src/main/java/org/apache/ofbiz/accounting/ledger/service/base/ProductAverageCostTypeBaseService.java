package org.apache.ofbiz.accounting.ledger.service.base;

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
import org.apache.ofbiz.accounting.ledger.ProductAverageCostType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.ProductAverageCost;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductAverageCostTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductAverageCostTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductAverageCostTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductAverageCostType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductAverageCostTypes
	 */
	public List<ProductAverageCostType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductAverageCostType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductAverageCostType.NAME);
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
				entityList = ProductAverageCostType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductAverageCostType
	 */
	public Optional<ProductAverageCostType> findOne(
			Object productAverageCostTypeId) {
		List<ProductAverageCostType> entityList = null;
		In in = new In();
		in.setEntityName(ProductAverageCostType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productAverageCostTypeId",
						EntityOperator.EQUALS, productAverageCostTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductAverageCostType.fromValues(out.getListIt()
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
	 * Get parent product average cost type
	 */
	public Optional<ProductAverageCostType> getParentProductAverageCostType(
			ProductAverageCostType productAverageCostType) {
		List<ProductAverageCostType> entityList = null;
		In in = new In();
		in.setEntityName(ProductAverageCostType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productAverageCostTypeId",
						EntityOperator.EQUALS, productAverageCostType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductAverageCostType.fromValues(out.getListIt()
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
	 * Get product average costs
	 */
	public List<ProductAverageCost> getProductAverageCosts(
			ProductAverageCostType productAverageCostType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductAverageCost> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductAverageCost.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productAverageCostTypeId",
						EntityOperator.EQUALS, productAverageCostType
								.getProductAverageCostTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductAverageCost.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child product average cost types
	 */
	public List<ProductAverageCostType> getChildProductAverageCostTypes(
			ProductAverageCostType productAverageCostType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductAverageCostType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductAverageCostType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						productAverageCostType.getProductAverageCostTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductAverageCostType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}