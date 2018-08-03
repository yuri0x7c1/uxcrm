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
import org.apache.ofbiz.humanres.employment.EmploymentAppSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.employment.EmploymentApp;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EmploymentAppSourceTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EmploymentAppSourceTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EmploymentAppSourceTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EmploymentAppSourceType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EmploymentAppSourceTypes
	 */
	public List<EmploymentAppSourceType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<EmploymentAppSourceType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmploymentAppSourceType.NAME);
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
				entityList = EmploymentAppSourceType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EmploymentAppSourceType
	 */
	public Optional<EmploymentAppSourceType> findOne(
			Object employmentAppSourceTypeId) {
		List<EmploymentAppSourceType> entityList = null;
		In in = new In();
		in.setEntityName(EmploymentAppSourceType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("employmentAppSourceTypeId",
						EntityOperator.EQUALS, employmentAppSourceTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmploymentAppSourceType.fromValues(out.getListIt()
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
	 * Get parent employment app source type
	 */
	public Optional<EmploymentAppSourceType> getParentEmploymentAppSourceType(
			EmploymentAppSourceType employmentAppSourceType) {
		List<EmploymentAppSourceType> entityList = null;
		In in = new In();
		in.setEntityName(EmploymentAppSourceType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("employmentAppSourceTypeId",
						EntityOperator.EQUALS, employmentAppSourceType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmploymentAppSourceType.fromValues(out.getListIt()
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
	 * Get employment apps
	 */
	public List<EmploymentApp> getEmploymentApps(
			EmploymentAppSourceType employmentAppSourceType, Integer start,
			Integer number, List<String> orderBy) {
		List<EmploymentApp> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmploymentApp.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("employmentAppSourceTypeId",
						EntityOperator.EQUALS, employmentAppSourceType
								.getEmploymentAppSourceTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmploymentApp.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child employment app source types
	 */
	public List<EmploymentAppSourceType> getChildEmploymentAppSourceTypes(
			EmploymentAppSourceType employmentAppSourceType, Integer start,
			Integer number, List<String> orderBy) {
		List<EmploymentAppSourceType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmploymentAppSourceType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("parentTypeId",
						EntityOperator.EQUALS, employmentAppSourceType
								.getEmploymentAppSourceTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmploymentAppSourceType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}