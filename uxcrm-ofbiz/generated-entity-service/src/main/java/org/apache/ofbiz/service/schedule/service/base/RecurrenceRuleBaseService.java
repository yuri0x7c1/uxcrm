package org.apache.ofbiz.service.schedule.service.base;

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
import org.apache.ofbiz.service.schedule.RecurrenceRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.service.schedule.RecurrenceInfo;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class RecurrenceRuleBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public RecurrenceRuleBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count RecurrenceRules
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(RecurrenceRule.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find RecurrenceRules
	 */
	public List<RecurrenceRule> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<RecurrenceRule> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RecurrenceRule.NAME);
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
				entityList = RecurrenceRule.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one RecurrenceRule
	 */
	public Optional<RecurrenceRule> findOne(Object recurrenceRuleId) {
		List<RecurrenceRule> entityList = null;
		In in = new In();
		in.setEntityName(RecurrenceRule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceRuleId",
						EntityOperator.EQUALS, recurrenceRuleId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RecurrenceRule.fromValues(out.getListIt()
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
	 * Get recurrence infoes
	 */
	public List<RecurrenceInfo> getRecurrenceInfoes(
			RecurrenceRule recurrenceRule, Integer start, Integer number,
			List<String> orderBy) {
		List<RecurrenceInfo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RecurrenceInfo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceRuleId",
						EntityOperator.EQUALS, recurrenceRule
								.getRecurrenceRuleId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RecurrenceInfo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get exception recurrence infoes
	 */
	public List<RecurrenceInfo> getExceptionRecurrenceInfoes(
			RecurrenceRule recurrenceRule, Integer start, Integer number,
			List<String> orderBy) {
		List<RecurrenceInfo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RecurrenceInfo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("exceptionRuleId",
						EntityOperator.EQUALS, recurrenceRule
								.getRecurrenceRuleId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RecurrenceInfo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}