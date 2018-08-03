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
import org.apache.ofbiz.humanres.position.EmplPositionReportingStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.position.EmplPosition;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EmplPositionReportingStructBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EmplPositionReportingStructBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EmplPositionReportingStructs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EmplPositionReportingStruct.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EmplPositionReportingStructs
	 */
	public List<EmplPositionReportingStruct> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one EmplPositionReportingStruct
	 */
	public Optional<EmplPositionReportingStruct> findOne(
			Object emplPositionIdReportingTo, Object emplPositionIdManagedBy,
			Object fromDate) {
		List<EmplPositionReportingStruct> entityList = null;
		In in = new In();
		in.setEntityName(EmplPositionReportingStruct.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("emplPositionIdReportingTo",
						EntityOperator.EQUALS, emplPositionIdReportingTo),
				new EntityExpr("emplPositionIdManagedBy",
						EntityOperator.EQUALS, emplPositionIdManagedBy),
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionReportingStruct.fromValues(out
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
	 * Get reporting to empl position
	 */
	public Optional<EmplPosition> getReportingToEmplPosition(
			EmplPositionReportingStruct emplPositionReportingStruct) {
		List<EmplPosition> entityList = null;
		In in = new In();
		in.setEntityName(EmplPosition.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPositionReportingStruct
								.getEmplPositionIdReportingTo())),
				EntityOperator.AND));
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
	 * Get managed by empl position
	 */
	public Optional<EmplPosition> getManagedByEmplPosition(
			EmplPositionReportingStruct emplPositionReportingStruct) {
		List<EmplPosition> entityList = null;
		In in = new In();
		in.setEntityName(EmplPosition.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPositionReportingStruct
								.getEmplPositionIdManagedBy())),
				EntityOperator.AND));
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
}