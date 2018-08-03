package org.apache.ofbiz.order.requirement.service.base;

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
import org.apache.ofbiz.order.requirement.WorkRequirementFulfillment;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.requirement.Requirement;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;
import org.apache.ofbiz.order.requirement.WorkReqFulfType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WorkRequirementFulfillmentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WorkRequirementFulfillmentBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WorkRequirementFulfillments
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WorkRequirementFulfillment.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WorkRequirementFulfillments
	 */
	public List<WorkRequirementFulfillment> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one WorkRequirementFulfillment
	 */
	public Optional<WorkRequirementFulfillment> findOne(Object requirementId,
			Object workEffortId) {
		List<WorkRequirementFulfillment> entityList = null;
		In in = new In();
		in.setEntityName(WorkRequirementFulfillment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirementId), new EntityExpr("workEffortId",
						EntityOperator.EQUALS, workEffortId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkRequirementFulfillment.fromValues(out
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
			WorkRequirementFulfillment workRequirementFulfillment) {
		List<Requirement> entityList = null;
		In in = new In();
		in.setEntityName(Requirement.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						workRequirementFulfillment.getRequirementId())),
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
	 * Get work effort
	 */
	public Optional<WorkEffort> getWorkEffort(
			WorkRequirementFulfillment workRequirementFulfillment) {
		List<WorkEffort> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workRequirementFulfillment.getWorkEffortId())),
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
	 * Get work req fulf type
	 */
	public Optional<WorkReqFulfType> getWorkReqFulfType(
			WorkRequirementFulfillment workRequirementFulfillment) {
		List<WorkReqFulfType> entityList = null;
		In in = new In();
		in.setEntityName(WorkReqFulfType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workReqFulfTypeId",
						EntityOperator.EQUALS, workRequirementFulfillment
								.getWorkReqFulfTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkReqFulfType.fromValues(out.getListIt()
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