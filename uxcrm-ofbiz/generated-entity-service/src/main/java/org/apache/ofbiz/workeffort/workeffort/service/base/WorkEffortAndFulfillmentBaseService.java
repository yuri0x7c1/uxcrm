package org.apache.ofbiz.workeffort.workeffort.service.base;

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
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAndFulfillment;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.requirement.Requirement;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortType;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortTypeAttr;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAttribute;
import org.apache.ofbiz.order.order.WorkOrderItemFulfillment;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.service.schedule.RecurrenceInfo;
import org.apache.ofbiz.service.schedule.RuntimeData;
import org.apache.ofbiz.common.note.NoteData;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAssoc;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortPartyAssignment;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortStatus;
import org.apache.ofbiz.order.quote.QuoteItem;
import org.apache.ofbiz.order.requirement.WorkRequirementFulfillment;
import org.apache.ofbiz.workeffort.timesheet.TimeEntry;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortDeliverableProd;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortBilling;
import org.apache.ofbiz.accounting.rate.RateAmount;
import org.apache.ofbiz.workeffort.workeffort.CommunicationEventWorkEff;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortGoodStandard;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortFixedAssetStd;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortFixedAssetAssign;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortInventoryProduced;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortInventoryAssign;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortSkillStandard;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WorkEffortAndFulfillmentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WorkEffortAndFulfillmentBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WorkEffortAndFulfillments
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WorkEffortAndFulfillment.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WorkEffortAndFulfillments
	 */
	public List<WorkEffortAndFulfillment> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<WorkEffortAndFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortAndFulfillment.NAME);
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
				entityList = WorkEffortAndFulfillment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one WorkEffortAndFulfillment
	 */
	public Optional<WorkEffortAndFulfillment> findOne(Object workEffortId,
			Object requirementId) {
		List<WorkEffortAndFulfillment> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortAndFulfillment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortId), new EntityExpr("requirementId",
						EntityOperator.EQUALS, requirementId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAndFulfillment.fromValues(out
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

	/**
	 * Get requirement
	 */
	public Optional<Requirement> getRequirement(
			WorkEffortAndFulfillment workEffortAndFulfillment) {
		List<Requirement> entityList = null;
		In in = new In();
		in.setEntityName(Requirement.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getRequirementId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Requirement.fromValues(out.getListIt()
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
	 * Get work effort type
	 */
	public Optional<WorkEffortType> getWorkEffortType(
			WorkEffortAndFulfillment workEffortAndFulfillment) {
		List<WorkEffortType> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortTypeId",
						EntityOperator.EQUALS, workEffortAndFulfillment
								.getWorkEffortTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortType.fromValues(out.getListIt()
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
	 * Get parent work effort
	 */
	public Optional<WorkEffort> getParentWorkEffort(
			WorkEffortAndFulfillment workEffortAndFulfillment) {
		List<WorkEffort> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortParentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
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
	 * Get work effort type attrs
	 */
	public List<WorkEffortTypeAttr> getWorkEffortTypeAttrs(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortTypeId",
						EntityOperator.EQUALS, workEffortAndFulfillment
								.getWorkEffortTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort attributes
	 */
	public List<WorkEffortAttribute> getWorkEffortAttributes(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work order item fulfillments
	 */
	public List<WorkOrderItemFulfillment> getWorkOrderItemFulfillments(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkOrderItemFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkOrderItemFulfillment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkOrderItemFulfillment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get current status item
	 */
	public Optional<StatusItem> getCurrentStatusItem(
			WorkEffortAndFulfillment workEffortAndFulfillment) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getCurrentStatusId())),
				EntityOperator.AND));
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
	 * Get scope enumeration
	 */
	public Optional<Enumeration> getScopeEnumeration(
			WorkEffortAndFulfillment workEffortAndFulfillment) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getScopeEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
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
	 * Get money uom
	 */
	public Optional<Uom> getMoneyUom(
			WorkEffortAndFulfillment workEffortAndFulfillment) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getMoneyUomId())),
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
	 * Get recurrence info
	 */
	public Optional<RecurrenceInfo> getRecurrenceInfo(
			WorkEffortAndFulfillment workEffortAndFulfillment) {
		List<RecurrenceInfo> entityList = null;
		In in = new In();
		in.setEntityName(RecurrenceInfo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceInfoId",
						EntityOperator.EQUALS, workEffortAndFulfillment
								.getRecurrenceInfoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RecurrenceInfo.fromValues(out.getListIt()
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
	 * Get runtime data
	 */
	public Optional<RuntimeData> getRuntimeData(
			WorkEffortAndFulfillment workEffortAndFulfillment) {
		List<RuntimeData> entityList = null;
		In in = new In();
		in.setEntityName(RuntimeData.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("runtimeDataId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getRuntimeDataId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RuntimeData.fromValues(out.getListIt()
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
	 * Get note data
	 */
	public Optional<NoteData> getNoteData(
			WorkEffortAndFulfillment workEffortAndFulfillment) {
		List<NoteData> entityList = null;
		In in = new In();
		in.setEntityName(NoteData.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getNoteId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = NoteData.fromValues(out.getListIt()
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
	 * Get from work effort assocs
	 */
	public List<WorkEffortAssoc> getFromWorkEffortAssocs(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortIdFrom",
						EntityOperator.EQUALS, workEffortAndFulfillment
								.getWorkEffortId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to work effort assocs
	 */
	public List<WorkEffortAssoc> getToWorkEffortAssocs(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortIdTo", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort party assignments
	 */
	public List<WorkEffortPartyAssignment> getWorkEffortPartyAssignments(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortPartyAssignment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortPartyAssignment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortPartyAssignment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort statuses
	 */
	public List<WorkEffortStatus> getWorkEffortStatuses(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quote items
	 */
	public List<QuoteItem> getQuoteItems(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<QuoteItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work requirement fulfillments
	 */
	public List<WorkRequirementFulfillment> getWorkRequirementFulfillments(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkRequirementFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkRequirementFulfillment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkRequirementFulfillment.fromValues(out
						.getListIt().getPartialList(start, number));
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
	public List<TimeEntry> getTimeEntries(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
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
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
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

	/**
	 * Get work effort deliverable prods
	 */
	public List<WorkEffortDeliverableProd> getWorkEffortDeliverableProds(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortDeliverableProd> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortDeliverableProd.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortDeliverableProd.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort billings
	 */
	public List<WorkEffortBilling> getWorkEffortBillings(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortBilling> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortBilling.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortBilling.fromValues(out.getListIt()
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
	public List<RateAmount> getRateAmounts(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
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
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
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
	 * Get communication event work effs
	 */
	public List<CommunicationEventWorkEff> getCommunicationEventWorkEffs(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<CommunicationEventWorkEff> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CommunicationEventWorkEff.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommunicationEventWorkEff.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort good standards
	 */
	public List<WorkEffortGoodStandard> getWorkEffortGoodStandards(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortGoodStandard> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortGoodStandard.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortGoodStandard.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort fixed asset stds
	 */
	public List<WorkEffortFixedAssetStd> getWorkEffortFixedAssetStds(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortFixedAssetStd> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortFixedAssetStd.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortFixedAssetStd.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort fixed asset assigns
	 */
	public List<WorkEffortFixedAssetAssign> getWorkEffortFixedAssetAssigns(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortFixedAssetAssign> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortFixedAssetAssign.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortFixedAssetAssign.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort inventory produceds
	 */
	public List<WorkEffortInventoryProduced> getWorkEffortInventoryProduceds(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortInventoryProduced> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortInventoryProduced.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortInventoryProduced.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort inventory assigns
	 */
	public List<WorkEffortInventoryAssign> getWorkEffortInventoryAssigns(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortInventoryAssign> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortInventoryAssign.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortInventoryAssign.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort skill standards
	 */
	public List<WorkEffortSkillStandard> getWorkEffortSkillStandards(
			WorkEffortAndFulfillment workEffortAndFulfillment, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortSkillStandard> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortSkillStandard.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndFulfillment.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortSkillStandard.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}