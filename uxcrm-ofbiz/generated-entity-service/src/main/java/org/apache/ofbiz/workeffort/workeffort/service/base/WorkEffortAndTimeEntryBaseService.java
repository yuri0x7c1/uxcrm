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
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAndTimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortSkillStandard;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WorkEffortAndTimeEntryBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WorkEffortAndTimeEntryBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WorkEffortAndTimeEntries
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WorkEffortAndTimeEntry.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WorkEffortAndTimeEntries
	 */
	public List<WorkEffortAndTimeEntry> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<WorkEffortAndTimeEntry> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortAndTimeEntry.NAME);
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
				entityList = WorkEffortAndTimeEntry.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one WorkEffortAndTimeEntry
	 */
	public Optional<WorkEffortAndTimeEntry> findOne(Object workEffortId,
			Object timeEntryId) {
		List<WorkEffortAndTimeEntry> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortAndTimeEntry.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortId), new EntityExpr("timeEntryId",
						EntityOperator.EQUALS, timeEntryId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAndTimeEntry.fromValues(out.getListIt()
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
	 * Get work effort skill standards
	 */
	public List<WorkEffortSkillStandard> getWorkEffortSkillStandards(
			WorkEffortAndTimeEntry workEffortAndTimeEntry, Integer start,
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
						workEffortAndTimeEntry.getWorkEffortId())),
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