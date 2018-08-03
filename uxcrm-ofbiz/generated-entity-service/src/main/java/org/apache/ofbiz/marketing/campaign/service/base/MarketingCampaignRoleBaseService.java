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
import org.apache.ofbiz.marketing.campaign.MarketingCampaignRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.marketing.campaign.MarketingCampaign;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.RoleType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class MarketingCampaignRoleBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public MarketingCampaignRoleBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count MarketingCampaignRoles
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(MarketingCampaignRole.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find MarketingCampaignRoles
	 */
	public List<MarketingCampaignRole> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one MarketingCampaignRole
	 */
	public Optional<MarketingCampaignRole> findOne(Object marketingCampaignId,
			Object partyId, Object roleTypeId) {
		List<MarketingCampaignRole> entityList = null;
		In in = new In();
		in.setEntityName(MarketingCampaignRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("marketingCampaignId", EntityOperator.EQUALS,
						marketingCampaignId), new EntityExpr("partyId",
						EntityOperator.EQUALS, partyId), new EntityExpr(
						"roleTypeId", EntityOperator.EQUALS, roleTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaignRole.fromValues(out.getListIt()
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
			MarketingCampaignRole marketingCampaignRole) {
		List<MarketingCampaign> entityList = null;
		In in = new In();
		in.setEntityName(MarketingCampaign.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("marketingCampaignId",
						EntityOperator.EQUALS, marketingCampaignRole
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
	 * Get party role
	 */
	public Optional<PartyRole> getPartyRole(
			MarketingCampaignRole marketingCampaignRole) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS,
						marketingCampaignRole.getPartyId()), new EntityExpr(
						"roleTypeId", EntityOperator.EQUALS,
						marketingCampaignRole.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRole.fromValues(out.getListIt()
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
	 * Get party
	 */
	public Optional<Party> getParty(MarketingCampaignRole marketingCampaignRole) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						marketingCampaignRole.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party
						.fromValues(out.getListIt().getCompleteList());
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
	 * Get role type
	 */
	public Optional<RoleType> getRoleType(
			MarketingCampaignRole marketingCampaignRole) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						marketingCampaignRole.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RoleType.fromValues(out.getListIt()
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