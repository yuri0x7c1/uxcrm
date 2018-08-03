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
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAssocAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAssoc;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAssocTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WorkEffortAssocAttributeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WorkEffortAssocAttributeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WorkEffortAssocAttributes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WorkEffortAssocAttribute.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WorkEffortAssocAttributes
	 */
	public List<WorkEffortAssocAttribute> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one WorkEffortAssocAttribute
	 */
	public Optional<WorkEffortAssocAttribute> findOne(Object workEffortIdFrom,
			Object workEffortIdTo, Object workEffortAssocTypeId, Object attrName) {
		List<WorkEffortAssocAttribute> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortAssocAttribute.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortIdFrom", EntityOperator.EQUALS,
						workEffortIdFrom), new EntityExpr("workEffortIdTo",
						EntityOperator.EQUALS, workEffortIdTo), new EntityExpr(
						"workEffortAssocTypeId", EntityOperator.EQUALS,
						workEffortAssocTypeId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAssocAttribute.fromValues(out
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
	 * Get work effort assoc
	 */
	public Optional<WorkEffortAssoc> getWorkEffortAssoc(
			WorkEffortAssocAttribute workEffortAssocAttribute) {
		List<WorkEffortAssoc> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortAssoc.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortIdFrom", EntityOperator.EQUALS,
						workEffortAssocAttribute.getWorkEffortIdFrom()),
				new EntityExpr("workEffortIdTo", EntityOperator.EQUALS,
						workEffortAssocAttribute.getWorkEffortIdTo()),
				new EntityExpr("workEffortAssocTypeId", EntityOperator.EQUALS,
						workEffortAssocAttribute.getWorkEffortAssocTypeId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						workEffortAssocAttribute.getFromDate())),
				EntityOperator.AND));
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
	 * Get work effort assoc type attrs
	 */
	public List<WorkEffortAssocTypeAttr> getWorkEffortAssocTypeAttrs(
			WorkEffortAssocAttribute workEffortAssocAttribute, Integer start,
			Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						workEffortAssocAttribute.getAttrName())),
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
}