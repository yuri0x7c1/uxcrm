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
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAssocType;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAssocTypeAttr;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAssocAttribute;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WorkEffortAssocBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WorkEffortAssocBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WorkEffortAssocs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WorkEffortAssoc.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WorkEffortAssocs
	 */
	public List<WorkEffortAssoc> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one WorkEffortAssoc
	 */
	public Optional<WorkEffortAssoc> findOne(Object workEffortIdFrom,
			Object workEffortIdTo, Object workEffortAssocTypeId, Object fromDate) {
		List<WorkEffortAssoc> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortAssoc.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortIdFrom", EntityOperator.EQUALS,
						workEffortIdFrom), new EntityExpr("workEffortIdTo",
						EntityOperator.EQUALS, workEffortIdTo), new EntityExpr(
						"workEffortAssocTypeId", EntityOperator.EQUALS,
						workEffortAssocTypeId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAssoc.fromValues(out.getListIt()
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
	 * Get work effort assoc type
	 */
	public Optional<WorkEffortAssocType> getWorkEffortAssocType(
			WorkEffortAssoc workEffortAssoc) {
		List<WorkEffortAssocType> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortAssocType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortAssocTypeId",
						EntityOperator.EQUALS, workEffortAssoc
								.getWorkEffortAssocTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAssocType.fromValues(out.getListIt()
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
	 * Get work effort assoc type attrs
	 */
	public List<WorkEffortAssocTypeAttr> getWorkEffortAssocTypeAttrs(
			WorkEffortAssoc workEffortAssoc, Integer start, Integer number,
			List<String> orderBy) {
		List<WorkEffortAssocTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortAssocTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortAssocTypeId",
						EntityOperator.EQUALS, workEffortAssoc
								.getWorkEffortAssocTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAssocTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from work effort
	 */
	public Optional<WorkEffort> getFromWorkEffort(
			WorkEffortAssoc workEffortAssoc) {
		List<WorkEffort> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAssoc.getWorkEffortIdFrom())),
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
	 * Get to work effort
	 */
	public Optional<WorkEffort> getToWorkEffort(WorkEffortAssoc workEffortAssoc) {
		List<WorkEffort> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAssoc.getWorkEffortIdTo())),
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
	 * Get work effort assoc attributes
	 */
	public List<WorkEffortAssocAttribute> getWorkEffortAssocAttributes(
			WorkEffortAssoc workEffortAssoc, Integer start, Integer number,
			List<String> orderBy) {
		List<WorkEffortAssocAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortAssocAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortIdFrom", EntityOperator.EQUALS,
						workEffortAssoc.getWorkEffortIdFrom()), new EntityExpr(
						"workEffortIdTo", EntityOperator.EQUALS,
						workEffortAssoc.getWorkEffortIdTo()), new EntityExpr(
						"workEffortAssocTypeId", EntityOperator.EQUALS,
						workEffortAssoc.getWorkEffortAssocTypeId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						workEffortAssoc.getFromDate())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAssocAttribute.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}