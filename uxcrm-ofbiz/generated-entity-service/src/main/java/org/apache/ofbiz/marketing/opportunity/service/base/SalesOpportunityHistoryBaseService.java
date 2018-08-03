package org.apache.ofbiz.marketing.opportunity.service.base;

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
import org.apache.ofbiz.marketing.opportunity.SalesOpportunityHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunityStage;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunity;
import org.apache.ofbiz.security.login.UserLogin;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SalesOpportunityHistoryBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SalesOpportunityHistoryBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SalesOpportunityHistories
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SalesOpportunityHistory.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SalesOpportunityHistories
	 */
	public List<SalesOpportunityHistory> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SalesOpportunityHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesOpportunityHistory.NAME);
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
				entityList = SalesOpportunityHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SalesOpportunityHistory
	 */
	public Optional<SalesOpportunityHistory> findOne(
			Object salesOpportunityHistoryId) {
		List<SalesOpportunityHistory> entityList = null;
		In in = new In();
		in.setEntityName(SalesOpportunityHistory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("salesOpportunityHistoryId",
						EntityOperator.EQUALS, salesOpportunityHistoryId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunityHistory.fromValues(out.getListIt()
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
	public Optional<Uom> getUom(SalesOpportunityHistory salesOpportunityHistory) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						salesOpportunityHistory.getCurrencyUomId())),
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
	 * Get sales opportunity stage
	 */
	public Optional<SalesOpportunityStage> getSalesOpportunityStage(
			SalesOpportunityHistory salesOpportunityHistory) {
		List<SalesOpportunityStage> entityList = null;
		In in = new In();
		in.setEntityName(SalesOpportunityStage.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("opportunityStageId",
						EntityOperator.EQUALS, salesOpportunityHistory
								.getOpportunityStageId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunityStage.fromValues(out.getListIt()
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
	 * Get sales opportunity
	 */
	public Optional<SalesOpportunity> getSalesOpportunity(
			SalesOpportunityHistory salesOpportunityHistory) {
		List<SalesOpportunity> entityList = null;
		In in = new In();
		in.setEntityName(SalesOpportunity.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("salesOpportunityId",
						EntityOperator.EQUALS, salesOpportunityHistory
								.getSalesOpportunityId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunity.fromValues(out.getListIt()
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
	 * Get user login
	 */
	public Optional<UserLogin> getUserLogin(
			SalesOpportunityHistory salesOpportunityHistory) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						salesOpportunityHistory.getModifiedByUserLogin())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
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