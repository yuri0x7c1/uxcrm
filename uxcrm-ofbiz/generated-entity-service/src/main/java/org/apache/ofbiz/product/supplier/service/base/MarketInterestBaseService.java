package org.apache.ofbiz.product.supplier.service.base;

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
import org.apache.ofbiz.product.supplier.MarketInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.category.ProductCategory;
import org.apache.ofbiz.party.party.PartyClassificationGroup;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class MarketInterestBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public MarketInterestBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count MarketInterests
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(MarketInterest.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find MarketInterests
	 */
	public List<MarketInterest> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<MarketInterest> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketInterest.NAME);
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
				entityList = MarketInterest.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one MarketInterest
	 */
	public Optional<MarketInterest> findOne(Object productCategoryId,
			Object partyClassificationGroupId, Object fromDate) {
		List<MarketInterest> entityList = null;
		In in = new In();
		in.setEntityName(MarketInterest.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productCategoryId", EntityOperator.EQUALS,
						productCategoryId), new EntityExpr(
						"partyClassificationGroupId", EntityOperator.EQUALS,
						partyClassificationGroupId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketInterest.fromValues(out.getListIt()
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
	 * Get product category
	 */
	public Optional<ProductCategory> getProductCategory(
			MarketInterest marketInterest) {
		List<ProductCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, marketInterest
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategory.fromValues(out.getListIt()
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
	 * Get party classification group
	 */
	public Optional<PartyClassificationGroup> getPartyClassificationGroup(
			MarketInterest marketInterest) {
		List<PartyClassificationGroup> entityList = null;
		In in = new In();
		in.setEntityName(PartyClassificationGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyClassificationGroupId",
						EntityOperator.EQUALS, marketInterest
								.getPartyClassificationGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyClassificationGroup.fromValues(out
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
}