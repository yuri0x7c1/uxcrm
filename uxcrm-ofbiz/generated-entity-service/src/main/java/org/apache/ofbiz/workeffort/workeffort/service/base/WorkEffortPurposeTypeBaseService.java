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
import org.apache.ofbiz.workeffort.workeffort.WorkEffortPurposeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WorkEffortPurposeTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WorkEffortPurposeTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WorkEffortPurposeTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WorkEffortPurposeType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WorkEffortPurposeTypes
	 */
	public List<WorkEffortPurposeType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<WorkEffortPurposeType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortPurposeType.NAME);
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
				entityList = WorkEffortPurposeType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one WorkEffortPurposeType
	 */
	public Optional<WorkEffortPurposeType> findOne(
			Object workEffortPurposeTypeId) {
		List<WorkEffortPurposeType> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortPurposeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortPurposeTypeId",
						EntityOperator.EQUALS, workEffortPurposeTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortPurposeType.fromValues(out.getListIt()
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
	 * Get parent work effort purpose type
	 */
	public Optional<WorkEffortPurposeType> getParentWorkEffortPurposeType(
			WorkEffortPurposeType workEffortPurposeType) {
		List<WorkEffortPurposeType> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortPurposeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortPurposeTypeId",
						EntityOperator.EQUALS, workEffortPurposeType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortPurposeType.fromValues(out.getListIt()
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
	 * Get work efforts
	 */
	public List<WorkEffort> getWorkEfforts(
			WorkEffortPurposeType workEffortPurposeType, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffort> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortPurposeTypeId",
						EntityOperator.EQUALS, workEffortPurposeType
								.getWorkEffortPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child work effort purpose types
	 */
	public List<WorkEffortPurposeType> getChildWorkEffortPurposeTypes(
			WorkEffortPurposeType workEffortPurposeType, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkEffortPurposeType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortPurposeType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						workEffortPurposeType.getWorkEffortPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortPurposeType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}