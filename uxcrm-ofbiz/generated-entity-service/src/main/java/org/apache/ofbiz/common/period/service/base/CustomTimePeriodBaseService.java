package org.apache.ofbiz.common.period.service.base;

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
import org.apache.ofbiz.common.period.CustomTimePeriod;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.period.PeriodType;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.accounting.budget.Budget;
import org.apache.ofbiz.accounting.ledger.GlAccountHistory;
import org.apache.ofbiz.marketing.opportunity.SalesForecast;
import org.apache.ofbiz.marketing.opportunity.SalesForecastHistory;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CustomTimePeriodBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CustomTimePeriodBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CustomTimePeriods
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CustomTimePeriod.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CustomTimePeriods
	 */
	public List<CustomTimePeriod> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<CustomTimePeriod> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustomTimePeriod.NAME);
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
				entityList = CustomTimePeriod.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CustomTimePeriod
	 */
	public Optional<CustomTimePeriod> findOne(Object customTimePeriodId) {
		List<CustomTimePeriod> entityList = null;
		In in = new In();
		in.setEntityName(CustomTimePeriod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customTimePeriodId",
						EntityOperator.EQUALS, customTimePeriodId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomTimePeriod.fromValues(out.getListIt()
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
	 * Get parent custom time period
	 */
	public Optional<CustomTimePeriod> getParentCustomTimePeriod(
			CustomTimePeriod customTimePeriod) {
		List<CustomTimePeriod> entityList = null;
		In in = new In();
		in.setEntityName(CustomTimePeriod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customTimePeriodId",
						EntityOperator.EQUALS, customTimePeriod
								.getParentPeriodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomTimePeriod.fromValues(out.getListIt()
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
	 * Get period type
	 */
	public Optional<PeriodType> getPeriodType(CustomTimePeriod customTimePeriod) {
		List<PeriodType> entityList = null;
		In in = new In();
		in.setEntityName(PeriodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("periodTypeId", EntityOperator.EQUALS,
						customTimePeriod.getPeriodTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PeriodType.fromValues(out.getListIt()
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
	 * Get organization party
	 */
	public Optional<Party> getOrganizationParty(
			CustomTimePeriod customTimePeriod) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						customTimePeriod.getOrganizationPartyId())),
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
	 * Get budgets
	 */
	public List<Budget> getBudgets(CustomTimePeriod customTimePeriod,
			Integer start, Integer number, List<String> orderBy) {
		List<Budget> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Budget.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customTimePeriodId",
						EntityOperator.EQUALS, customTimePeriod
								.getCustomTimePeriodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Budget.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child custom time periods
	 */
	public List<CustomTimePeriod> getChildCustomTimePeriods(
			CustomTimePeriod customTimePeriod, Integer start, Integer number,
			List<String> orderBy) {
		List<CustomTimePeriod> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustomTimePeriod.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentPeriodId", EntityOperator.EQUALS,
						customTimePeriod.getCustomTimePeriodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomTimePeriod.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get gl account histories
	 */
	public List<GlAccountHistory> getGlAccountHistories(
			CustomTimePeriod customTimePeriod, Integer start, Integer number,
			List<String> orderBy) {
		List<GlAccountHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customTimePeriodId",
						EntityOperator.EQUALS, customTimePeriod
								.getCustomTimePeriodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales forecasts
	 */
	public List<SalesForecast> getSalesForecasts(
			CustomTimePeriod customTimePeriod, Integer start, Integer number,
			List<String> orderBy) {
		List<SalesForecast> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesForecast.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customTimePeriodId",
						EntityOperator.EQUALS, customTimePeriod
								.getCustomTimePeriodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesForecast.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales forecast histories
	 */
	public List<SalesForecastHistory> getSalesForecastHistories(
			CustomTimePeriod customTimePeriod, Integer start, Integer number,
			List<String> orderBy) {
		List<SalesForecastHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesForecastHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customTimePeriodId",
						EntityOperator.EQUALS, customTimePeriod
								.getCustomTimePeriodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesForecastHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}