package org.apache.ofbiz.marketing.campaign.service.base;

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
import org.apache.ofbiz.marketing.campaign.MarketingCampaignPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.marketing.campaign.MarketingCampaign;
import org.apache.ofbiz.product.price.ProductPriceRule;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class MarketingCampaignPriceBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public MarketingCampaignPriceBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count MarketingCampaignPrices
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(MarketingCampaignPrice.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find MarketingCampaignPrices
	 */
	public List<MarketingCampaignPrice> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<MarketingCampaignPrice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketingCampaignPrice.NAME);
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
				entityList = MarketingCampaignPrice.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one MarketingCampaignPrice
	 */
	public Optional<MarketingCampaignPrice> findOne(Object marketingCampaignId,
			Object productPriceRuleId) {
		List<MarketingCampaignPrice> entityList = null;
		In in = new In();
		in.setEntityName(MarketingCampaignPrice.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("marketingCampaignId", EntityOperator.EQUALS,
						marketingCampaignId), new EntityExpr(
						"productPriceRuleId", EntityOperator.EQUALS,
						productPriceRuleId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaignPrice.fromValues(out.getListIt()
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
	 * Get marketing campaign
	 */
	public Optional<MarketingCampaign> getMarketingCampaign(
			MarketingCampaignPrice marketingCampaignPrice) {
		List<MarketingCampaign> entityList = null;
		In in = new In();
		in.setEntityName(MarketingCampaign.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaignPrice
								.getMarketingCampaignId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaign.fromValues(out.getListIt()
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
	 * Get product price rule
	 */
	public Optional<ProductPriceRule> getProductPriceRule(
			MarketingCampaignPrice marketingCampaignPrice) {
		List<ProductPriceRule> entityList = null;
		In in = new In();
		in.setEntityName(ProductPriceRule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPriceRuleId",
						EntityOperator.EQUALS, marketingCampaignPrice
								.getProductPriceRuleId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPriceRule.fromValues(out.getListIt()
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