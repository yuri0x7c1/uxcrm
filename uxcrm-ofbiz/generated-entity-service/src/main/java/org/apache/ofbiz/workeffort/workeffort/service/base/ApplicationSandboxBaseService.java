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
import org.apache.ofbiz.workeffort.workeffort.ApplicationSandbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortPartyAssignment;
import org.apache.ofbiz.service.schedule.RuntimeData;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ApplicationSandboxBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ApplicationSandboxBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ApplicationSandboxes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ApplicationSandbox.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ApplicationSandboxes
	 */
	public List<ApplicationSandbox> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ApplicationSandbox> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ApplicationSandbox.NAME);
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
				entityList = ApplicationSandbox.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ApplicationSandbox
	 */
	public Optional<ApplicationSandbox> findOne(Object applicationId) {
		List<ApplicationSandbox> entityList = null;
		In in = new In();
		in.setEntityName(ApplicationSandbox.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("applicationId", EntityOperator.EQUALS,
						applicationId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ApplicationSandbox.fromValues(out.getListIt()
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
	 * Get work effort party assignment
	 */
	public Optional<WorkEffortPartyAssignment> getWorkEffortPartyAssignment(
			ApplicationSandbox applicationSandbox) {
		List<WorkEffortPartyAssignment> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortPartyAssignment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortId", EntityOperator.EQUALS,
						applicationSandbox.getWorkEffortId()),
				new EntityExpr("partyId", EntityOperator.EQUALS,
						applicationSandbox.getPartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						applicationSandbox.getRoleTypeId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						applicationSandbox.getFromDate())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortPartyAssignment.fromValues(out
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
	 * Get runtime data
	 */
	public Optional<RuntimeData> getRuntimeData(
			ApplicationSandbox applicationSandbox) {
		List<RuntimeData> entityList = null;
		In in = new In();
		in.setEntityName(RuntimeData.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("runtimeDataId", EntityOperator.EQUALS,
						applicationSandbox.getRuntimeDataId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RuntimeData.fromValues(out.getListIt()
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