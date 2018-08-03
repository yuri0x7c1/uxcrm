package org.apache.ofbiz.humanres.employment.service.base;

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
import org.apache.ofbiz.humanres.employment.EmplLeaveReasonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.employment.EmplLeave;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EmplLeaveReasonTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EmplLeaveReasonTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EmplLeaveReasonTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EmplLeaveReasonType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EmplLeaveReasonTypes
	 */
	public List<EmplLeaveReasonType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<EmplLeaveReasonType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplLeaveReasonType.NAME);
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
				entityList = EmplLeaveReasonType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EmplLeaveReasonType
	 */
	public Optional<EmplLeaveReasonType> findOne(Object emplLeaveReasonTypeId) {
		List<EmplLeaveReasonType> entityList = null;
		In in = new In();
		in.setEntityName(EmplLeaveReasonType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplLeaveReasonTypeId",
						EntityOperator.EQUALS, emplLeaveReasonTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplLeaveReasonType.fromValues(out.getListIt()
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
	 * Get parent empl leave reason type
	 */
	public Optional<EmplLeaveReasonType> getParentEmplLeaveReasonType(
			EmplLeaveReasonType emplLeaveReasonType) {
		List<EmplLeaveReasonType> entityList = null;
		In in = new In();
		in.setEntityName(EmplLeaveReasonType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplLeaveReasonTypeId",
						EntityOperator.EQUALS, emplLeaveReasonType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplLeaveReasonType.fromValues(out.getListIt()
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
	 * Get empl leaves
	 */
	public List<EmplLeave> getEmplLeaves(
			EmplLeaveReasonType emplLeaveReasonType, Integer start,
			Integer number, List<String> orderBy) {
		List<EmplLeave> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplLeave.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplLeaveReasonTypeId",
						EntityOperator.EQUALS, emplLeaveReasonType
								.getEmplLeaveReasonTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplLeave.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child empl leave reason types
	 */
	public List<EmplLeaveReasonType> getChildEmplLeaveReasonTypes(
			EmplLeaveReasonType emplLeaveReasonType, Integer start,
			Integer number, List<String> orderBy) {
		List<EmplLeaveReasonType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplLeaveReasonType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						emplLeaveReasonType.getEmplLeaveReasonTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplLeaveReasonType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}