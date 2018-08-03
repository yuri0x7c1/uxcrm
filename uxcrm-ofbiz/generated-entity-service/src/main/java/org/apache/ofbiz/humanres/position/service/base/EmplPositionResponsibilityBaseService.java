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
import org.apache.ofbiz.humanres.position.EmplPositionResponsibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.position.EmplPosition;
import org.apache.ofbiz.humanres.ability.ResponsibilityType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EmplPositionResponsibilityBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EmplPositionResponsibilityBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EmplPositionResponsibilities
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EmplPositionResponsibility.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EmplPositionResponsibilities
	 */
	public List<EmplPositionResponsibility> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<EmplPositionResponsibility> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionResponsibility.NAME);
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
				entityList = EmplPositionResponsibility.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EmplPositionResponsibility
	 */
	public Optional<EmplPositionResponsibility> findOne(Object emplPositionId,
			Object responsibilityTypeId, Object fromDate) {
		List<EmplPositionResponsibility> entityList = null;
		In in = new In();
		in.setEntityName(EmplPositionResponsibility.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPositionId), new EntityExpr("responsibilityTypeId",
						EntityOperator.EQUALS, responsibilityTypeId),
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionResponsibility.fromValues(out
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
	 * Get empl position
	 */
	public Optional<EmplPosition> getEmplPosition(
			EmplPositionResponsibility emplPositionResponsibility) {
		List<EmplPosition> entityList = null;
		In in = new In();
		in.setEntityName(EmplPosition.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPositionResponsibility.getEmplPositionId())),
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
	 * Get responsibility type
	 */
	public Optional<ResponsibilityType> getResponsibilityType(
			EmplPositionResponsibility emplPositionResponsibility) {
		List<ResponsibilityType> entityList = null;
		In in = new In();
		in.setEntityName(ResponsibilityType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("responsibilityTypeId",
						EntityOperator.EQUALS, emplPositionResponsibility
								.getResponsibilityTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ResponsibilityType.fromValues(out.getListIt()
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