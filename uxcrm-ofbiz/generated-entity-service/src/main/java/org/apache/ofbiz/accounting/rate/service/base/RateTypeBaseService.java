package org.apache.ofbiz.accounting.rate.service.base;

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
import org.apache.ofbiz.accounting.rate.RateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.position.EmplPositionTypeRate;
import org.apache.ofbiz.humanres.position.OldEmplPositionTypeRate;
import org.apache.ofbiz.workeffort.timesheet.OldPartyRate;
import org.apache.ofbiz.workeffort.timesheet.OldWorkEffortAssignmentRate;
import org.apache.ofbiz.accounting.rate.PartyRate;
import org.apache.ofbiz.accounting.rate.RateAmount;
import org.apache.ofbiz.workeffort.timesheet.TimeEntry;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class RateTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public RateTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count RateTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(RateType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find RateTypes
	 */
	public List<RateType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<RateType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RateType.NAME);
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
				entityList = RateType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one RateType
	 */
	public Optional<RateType> findOne(Object rateTypeId) {
		List<RateType> entityList = null;
		In in = new In();
		in.setEntityName(RateType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateTypeId", EntityOperator.EQUALS,
						rateTypeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RateType.fromValues(out.getListIt()
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
	 * Get empl position type rates
	 */
	public List<EmplPositionTypeRate> getEmplPositionTypeRates(
			RateType rateType, Integer start, Integer number,
			List<String> orderBy) {
		List<EmplPositionTypeRate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionTypeRate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateTypeId", EntityOperator.EQUALS,
						rateType.getRateTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionTypeRate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get old empl position type rates
	 */
	public List<OldEmplPositionTypeRate> getOldEmplPositionTypeRates(
			RateType rateType, Integer start, Integer number,
			List<String> orderBy) {
		List<OldEmplPositionTypeRate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldEmplPositionTypeRate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateTypeId", EntityOperator.EQUALS,
						rateType.getRateTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldEmplPositionTypeRate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get old party rates
	 */
	public List<OldPartyRate> getOldPartyRates(RateType rateType,
			Integer start, Integer number, List<String> orderBy) {
		List<OldPartyRate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldPartyRate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateTypeId", EntityOperator.EQUALS,
						rateType.getRateTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldPartyRate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get old work effort assignment rates
	 */
	public List<OldWorkEffortAssignmentRate> getOldWorkEffortAssignmentRates(
			RateType rateType, Integer start, Integer number,
			List<String> orderBy) {
		List<OldWorkEffortAssignmentRate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldWorkEffortAssignmentRate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateTypeId", EntityOperator.EQUALS,
						rateType.getRateTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldWorkEffortAssignmentRate.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party rates
	 */
	public List<PartyRate> getPartyRates(RateType rateType, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyRate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateTypeId", EntityOperator.EQUALS,
						rateType.getRateTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get rate amounts
	 */
	public List<RateAmount> getRateAmounts(RateType rateType, Integer start,
			Integer number, List<String> orderBy) {
		List<RateAmount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RateAmount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateTypeId", EntityOperator.EQUALS,
						rateType.getRateTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RateAmount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get time entries
	 */
	public List<TimeEntry> getTimeEntries(RateType rateType, Integer start,
			Integer number, List<String> orderBy) {
		List<TimeEntry> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TimeEntry.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateTypeId", EntityOperator.EQUALS,
						rateType.getRateTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TimeEntry.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}