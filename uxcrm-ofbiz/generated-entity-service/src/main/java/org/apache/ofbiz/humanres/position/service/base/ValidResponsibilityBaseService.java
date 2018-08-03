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
import org.apache.ofbiz.humanres.position.ValidResponsibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.position.EmplPositionType;
import org.apache.ofbiz.humanres.ability.ResponsibilityType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ValidResponsibilityBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ValidResponsibilityBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ValidResponsibilities
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ValidResponsibility.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ValidResponsibilities
	 */
	public List<ValidResponsibility> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ValidResponsibility> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ValidResponsibility.NAME);
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
				entityList = ValidResponsibility.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ValidResponsibility
	 */
	public Optional<ValidResponsibility> findOne(Object emplPositionTypeId,
			Object responsibilityTypeId, Object fromDate) {
		List<ValidResponsibility> entityList = null;
		In in = new In();
		in.setEntityName(ValidResponsibility.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("emplPositionTypeId", EntityOperator.EQUALS,
						emplPositionTypeId), new EntityExpr(
						"responsibilityTypeId", EntityOperator.EQUALS,
						responsibilityTypeId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ValidResponsibility.fromValues(out.getListIt()
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
	 * Get empl position type
	 */
	public Optional<EmplPositionType> getEmplPositionType(
			ValidResponsibility validResponsibility) {
		List<EmplPositionType> entityList = null;
		In in = new In();
		in.setEntityName(EmplPositionType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, validResponsibility
								.getEmplPositionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionType.fromValues(out.getListIt()
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
			ValidResponsibility validResponsibility) {
		List<ResponsibilityType> entityList = null;
		In in = new In();
		in.setEntityName(ResponsibilityType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("responsibilityTypeId",
						EntityOperator.EQUALS, validResponsibility
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