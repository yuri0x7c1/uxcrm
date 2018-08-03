package org.apache.ofbiz.humanres.recruitment.service.base;

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
import org.apache.ofbiz.humanres.recruitment.JobRequisition;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.ability.SkillType;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.humanres.employment.EmploymentApp;
import org.apache.ofbiz.humanres.recruitment.JobInterview;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class JobRequisitionBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public JobRequisitionBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count JobRequisitions
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(JobRequisition.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find JobRequisitions
	 */
	public List<JobRequisition> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<JobRequisition> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(JobRequisition.NAME);
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
				entityList = JobRequisition.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one JobRequisition
	 */
	public Optional<JobRequisition> findOne(Object jobRequisitionId) {
		List<JobRequisition> entityList = null;
		In in = new In();
		in.setEntityName(JobRequisition.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("jobRequisitionId",
						EntityOperator.EQUALS, jobRequisitionId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = JobRequisition.fromValues(out.getListIt()
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
	 * Get skill type
	 */
	public Optional<SkillType> getSkillType(JobRequisition jobRequisition) {
		List<SkillType> entityList = null;
		In in = new In();
		in.setEntityName(SkillType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("skillTypeId", EntityOperator.EQUALS,
						jobRequisition.getSkillTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SkillType.fromValues(out.getListIt()
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
	 * Get exam type enumeration
	 */
	public Optional<Enumeration> getExamTypeEnumeration(
			JobRequisition jobRequisition) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						jobRequisition.getExamTypeEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
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
	 * Get job posting type enumeration
	 */
	public Optional<Enumeration> getJobPostingTypeEnumeration(
			JobRequisition jobRequisition) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						jobRequisition.getJobPostingTypeEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
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
	public List<EmploymentApp> getEmploymentApps(JobRequisition jobRequisition,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("jobRequisitionId",
						EntityOperator.EQUALS, jobRequisition
								.getJobRequisitionId())), EntityOperator.AND));
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
	 * Get job interviews
	 */
	public List<JobInterview> getJobInterviews(JobRequisition jobRequisition,
			Integer start, Integer number, List<String> orderBy) {
		List<JobInterview> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(JobInterview.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("jobRequisitionId",
						EntityOperator.EQUALS, jobRequisition
								.getJobRequisitionId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = JobInterview.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}