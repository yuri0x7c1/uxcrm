package org.apache.ofbiz.manufacturing.techdata.service.base;

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
import org.apache.ofbiz.manufacturing.techdata.TechDataCalendarWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.manufacturing.techdata.TechDataCalendar;
import org.apache.ofbiz.manufacturing.techdata.TechDataCalendarExcWeek;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TechDataCalendarWeekBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TechDataCalendarWeekBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TechDataCalendarWeeks
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TechDataCalendarWeek.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TechDataCalendarWeeks
	 */
	public List<TechDataCalendarWeek> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TechDataCalendarWeek> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TechDataCalendarWeek.NAME);
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
				entityList = TechDataCalendarWeek.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TechDataCalendarWeek
	 */
	public Optional<TechDataCalendarWeek> findOne(Object calendarWeekId) {
		List<TechDataCalendarWeek> entityList = null;
		In in = new In();
		in.setEntityName(TechDataCalendarWeek.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("calendarWeekId", EntityOperator.EQUALS,
						calendarWeekId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TechDataCalendarWeek.fromValues(out.getListIt()
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
	 * Get tech data calendars
	 */
	public List<TechDataCalendar> getTechDataCalendars(
			TechDataCalendarWeek techDataCalendarWeek, Integer start,
			Integer number, List<String> orderBy) {
		List<TechDataCalendar> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TechDataCalendar.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("calendarWeekId", EntityOperator.EQUALS,
						techDataCalendarWeek.getCalendarWeekId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TechDataCalendar.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tech data calendar exc weeks
	 */
	public List<TechDataCalendarExcWeek> getTechDataCalendarExcWeeks(
			TechDataCalendarWeek techDataCalendarWeek, Integer start,
			Integer number, List<String> orderBy) {
		List<TechDataCalendarExcWeek> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TechDataCalendarExcWeek.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("calendarWeekId", EntityOperator.EQUALS,
						techDataCalendarWeek.getCalendarWeekId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TechDataCalendarExcWeek.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}