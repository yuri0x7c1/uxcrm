package org.apache.ofbiz.humanres.ability.service.base;

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
import org.apache.ofbiz.humanres.ability.ResponsibilityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.position.EmplPositionResponsibility;
import org.apache.ofbiz.humanres.position.ValidResponsibility;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ResponsibilityTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ResponsibilityTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ResponsibilityTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ResponsibilityType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ResponsibilityTypes
	 */
	public List<ResponsibilityType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ResponsibilityType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ResponsibilityType.NAME);
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
				entityList = ResponsibilityType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ResponsibilityType
	 */
	public Optional<ResponsibilityType> findOne(Object responsibilityTypeId) {
		List<ResponsibilityType> entityList = null;
		In in = new In();
		in.setEntityName(ResponsibilityType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("responsibilityTypeId",
						EntityOperator.EQUALS, responsibilityTypeId)),
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

	/**
	 * Get parent responsibility type
	 */
	public Optional<ResponsibilityType> getParentResponsibilityType(
			ResponsibilityType responsibilityType) {
		List<ResponsibilityType> entityList = null;
		In in = new In();
		in.setEntityName(ResponsibilityType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("responsibilityTypeId",
						EntityOperator.EQUALS, responsibilityType
								.getParentTypeId())), EntityOperator.AND));
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

	/**
	 * Get empl position responsibilities
	 */
	public List<EmplPositionResponsibility> getEmplPositionResponsibilities(
			ResponsibilityType responsibilityType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("responsibilityTypeId",
						EntityOperator.EQUALS, responsibilityType
								.getResponsibilityTypeId())),
				EntityOperator.AND));
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
	 * Get child responsibility types
	 */
	public List<ResponsibilityType> getChildResponsibilityTypes(
			ResponsibilityType responsibilityType, Integer start,
			Integer number, List<String> orderBy) {
		List<ResponsibilityType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ResponsibilityType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						responsibilityType.getResponsibilityTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ResponsibilityType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get valid responsibilities
	 */
	public List<ValidResponsibility> getValidResponsibilities(
			ResponsibilityType responsibilityType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("responsibilityTypeId",
						EntityOperator.EQUALS, responsibilityType
								.getResponsibilityTypeId())),
				EntityOperator.AND));
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
}