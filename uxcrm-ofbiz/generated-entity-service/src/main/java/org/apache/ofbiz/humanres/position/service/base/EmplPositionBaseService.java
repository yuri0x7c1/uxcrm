package org.apache.ofbiz.humanres.position.service.base;

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
import org.apache.ofbiz.humanres.position.EmplPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.accounting.budget.BudgetItem;
import org.apache.ofbiz.humanres.position.EmplPositionType;
import org.apache.ofbiz.humanres.position.EmplPositionFulfillment;
import org.apache.ofbiz.humanres.position.EmplPositionReportingStruct;
import org.apache.ofbiz.humanres.position.EmplPositionResponsibility;
import org.apache.ofbiz.humanres.employment.EmploymentApp;
import org.apache.ofbiz.humanres.ability.PerfReview;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EmplPositionBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EmplPositionBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EmplPositions
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EmplPosition.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EmplPositions
	 */
	public List<EmplPosition> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<EmplPosition> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPosition.NAME);
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
				entityList = EmplPosition.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EmplPosition
	 */
	public Optional<EmplPosition> findOne(Object emplPositionId) {
		List<EmplPosition> entityList = null;
		In in = new In();
		in.setEntityName(EmplPosition.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPositionId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPosition.fromValues(out.getListIt()
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
	public Optional<StatusItem> getStatusItem(EmplPosition emplPosition) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						emplPosition.getStatusId())), EntityOperator.AND));
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
	 * Get party
	 */
	public Optional<Party> getParty(EmplPosition emplPosition) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						emplPosition.getPartyId())), EntityOperator.AND));
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
	 * Get budget item
	 */
	public Optional<BudgetItem> getBudgetItem(EmplPosition emplPosition) {
		List<BudgetItem> entityList = null;
		In in = new In();
		in.setEntityName(BudgetItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("budgetId", EntityOperator.EQUALS, emplPosition
						.getBudgetId()),
				new EntityExpr("budgetItemSeqId", EntityOperator.EQUALS,
						emplPosition.getBudgetItemSeqId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetItem.fromValues(out.getListIt()
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
	 * Get empl position type
	 */
	public Optional<EmplPositionType> getEmplPositionType(
			EmplPosition emplPosition) {
		List<EmplPositionType> entityList = null;
		In in = new In();
		in.setEntityName(EmplPositionType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, emplPosition
								.getEmplPositionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionType.fromValues(out.getListIt()
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
	 * Get empl position fulfillments
	 */
	public List<EmplPositionFulfillment> getEmplPositionFulfillments(
			EmplPosition emplPosition, Integer start, Integer number,
			List<String> orderBy) {
		List<EmplPositionFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionFulfillment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPosition.getEmplPositionId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionFulfillment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get reporting to empl position reporting structs
	 */
	public List<EmplPositionReportingStruct> getReportingToEmplPositionReportingStructs(
			EmplPosition emplPosition, Integer start, Integer number,
			List<String> orderBy) {
		List<EmplPositionReportingStruct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionReportingStruct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("emplPositionIdReportingTo",
						EntityOperator.EQUALS, emplPosition.getEmplPositionId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionReportingStruct.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get managed by empl position reporting structs
	 */
	public List<EmplPositionReportingStruct> getManagedByEmplPositionReportingStructs(
			EmplPosition emplPosition, Integer start, Integer number,
			List<String> orderBy) {
		List<EmplPositionReportingStruct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionReportingStruct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("emplPositionIdManagedBy",
						EntityOperator.EQUALS, emplPosition.getEmplPositionId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionReportingStruct.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get empl position responsibilities
	 */
	public List<EmplPositionResponsibility> getEmplPositionResponsibilities(
			EmplPosition emplPosition, Integer start, Integer number,
			List<String> orderBy) {
		List<EmplPositionResponsibility> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionResponsibility.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPosition.getEmplPositionId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionResponsibility.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get employment apps
	 */
	public List<EmploymentApp> getEmploymentApps(EmplPosition emplPosition,
			Integer start, Integer number, List<String> orderBy) {
		List<EmploymentApp> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmploymentApp.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPosition.getEmplPositionId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmploymentApp.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get perf reviews
	 */
	public List<PerfReview> getPerfReviews(EmplPosition emplPosition,
			Integer start, Integer number, List<String> orderBy) {
		List<PerfReview> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PerfReview.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPosition.getEmplPositionId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReview.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}