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
import org.apache.ofbiz.marketing.campaign.MarketingCampaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.marketing.contact.ContactList;
import org.apache.ofbiz.marketing.campaign.MarketingCampaignNote;
import org.apache.ofbiz.marketing.campaign.MarketingCampaignPrice;
import org.apache.ofbiz.marketing.campaign.MarketingCampaignPromo;
import org.apache.ofbiz.marketing.campaign.MarketingCampaignRole;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunity;
import org.apache.ofbiz.marketing.tracking.TrackingCode;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class MarketingCampaignBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public MarketingCampaignBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count MarketingCampaigns
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(MarketingCampaign.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find MarketingCampaigns
	 */
	public List<MarketingCampaign> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<MarketingCampaign> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketingCampaign.NAME);
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
				entityList = MarketingCampaign.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one MarketingCampaign
	 */
	public Optional<MarketingCampaign> findOne(Object marketingCampaignId) {
		List<MarketingCampaign> entityList = null;
		In in = new In();
		in.setEntityName(MarketingCampaign.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaignId)),
				EntityOperator.AND));
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
	 * Get parent marketing campaign
	 */
	public Optional<MarketingCampaign> getParentMarketingCampaign(
			MarketingCampaign marketingCampaign) {
		List<MarketingCampaign> entityList = null;
		In in = new In();
		in.setEntityName(MarketingCampaign.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaign
								.getParentCampaignId())), EntityOperator.AND));
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
	 * Get status item
	 */
	public Optional<StatusItem> getStatusItem(
			MarketingCampaign marketingCampaign) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						marketingCampaign.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusItem.fromValues(out.getListIt()
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
	 * Get uom
	 */
	public Optional<Uom> getUom(MarketingCampaign marketingCampaign) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						marketingCampaign.getCurrencyUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Uom.fromValues(out.getListIt().getCompleteList());
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
	 * Get contact lists
	 */
	public List<ContactList> getContactLists(
			MarketingCampaign marketingCampaign, Integer start, Integer number,
			List<String> orderBy) {
		List<ContactList> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContactList.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaign
								.getMarketingCampaignId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactList.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child marketing campaigns
	 */
	public List<MarketingCampaign> getChildMarketingCampaigns(
			MarketingCampaign marketingCampaign, Integer start, Integer number,
			List<String> orderBy) {
		List<MarketingCampaign> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketingCampaign.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentCampaignId",
						EntityOperator.EQUALS, marketingCampaign
								.getMarketingCampaignId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaign.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get marketing campaign notes
	 */
	public List<MarketingCampaignNote> getMarketingCampaignNotes(
			MarketingCampaign marketingCampaign, Integer start, Integer number,
			List<String> orderBy) {
		List<MarketingCampaignNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketingCampaignNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaign
								.getMarketingCampaignId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaignNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get marketing campaign prices
	 */
	public List<MarketingCampaignPrice> getMarketingCampaignPrices(
			MarketingCampaign marketingCampaign, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaign
								.getMarketingCampaignId())), EntityOperator.AND));
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
	 * Get marketing campaign promoes
	 */
	public List<MarketingCampaignPromo> getMarketingCampaignPromoes(
			MarketingCampaign marketingCampaign, Integer start, Integer number,
			List<String> orderBy) {
		List<MarketingCampaignPromo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketingCampaignPromo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaign
								.getMarketingCampaignId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaignPromo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get marketing campaign roles
	 */
	public List<MarketingCampaignRole> getMarketingCampaignRoles(
			MarketingCampaign marketingCampaign, Integer start, Integer number,
			List<String> orderBy) {
		List<MarketingCampaignRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketingCampaignRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaign
								.getMarketingCampaignId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaignRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales opportunities
	 */
	public List<SalesOpportunity> getSalesOpportunities(
			MarketingCampaign marketingCampaign, Integer start, Integer number,
			List<String> orderBy) {
		List<SalesOpportunity> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesOpportunity.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaign
								.getMarketingCampaignId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunity.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tracking codes
	 */
	public List<TrackingCode> getTrackingCodes(
			MarketingCampaign marketingCampaign, Integer start, Integer number,
			List<String> orderBy) {
		List<TrackingCode> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TrackingCode.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaign
								.getMarketingCampaignId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TrackingCode.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}