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
import org.apache.ofbiz.workeffort.workeffort.WorkEffortAndPartyAssignAndType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortPartyAssignment;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortType;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.Person;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.party.party.RoleType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WorkEffortAndPartyAssignAndTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WorkEffortAndPartyAssignAndTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WorkEffortAndPartyAssignAndTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WorkEffortAndPartyAssignAndType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WorkEffortAndPartyAssignAndTypes
	 */
	public List<WorkEffortAndPartyAssignAndType> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<WorkEffortAndPartyAssignAndType> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortAndPartyAssignAndType.NAME);
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
				entityList = WorkEffortAndPartyAssignAndType.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one WorkEffortAndPartyAssignAndType
	 */
	public Optional<WorkEffortAndPartyAssignAndType> findOne(
			Object workEffortId, Object roleTypeId, Object fromDate,
			Object partyId) {
		List<WorkEffortAndPartyAssignAndType> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortAndPartyAssignAndType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortId), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, roleTypeId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate),
				new EntityExpr("partyId", EntityOperator.EQUALS, partyId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortAndPartyAssignAndType.fromValues(out
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
	 * Get work effort
	 */
	public Optional<WorkEffort> getWorkEffort(
			WorkEffortAndPartyAssignAndType workEffortAndPartyAssignAndType) {
		List<WorkEffort> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndPartyAssignAndType.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
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
			WorkEffortAndPartyAssignAndType workEffortAndPartyAssignAndType) {
		List<WorkEffortPartyAssignment> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortPartyAssignment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortAndPartyAssignAndType.getWorkEffortId()),
				new EntityExpr("partyId", EntityOperator.EQUALS,
						workEffortAndPartyAssignAndType.getPartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						workEffortAndPartyAssignAndType.getRoleTypeId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						workEffortAndPartyAssignAndType.getFromDate())),
				EntityOperator.AND));
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
	 * Get work effort type
	 */
	public Optional<WorkEffortType> getWorkEffortType(
			WorkEffortAndPartyAssignAndType workEffortAndPartyAssignAndType) {
		List<WorkEffortType> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortTypeId",
						EntityOperator.EQUALS, workEffortAndPartyAssignAndType
								.getWorkEffortTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortType.fromValues(out.getListIt()
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
	 * Get party
	 */
	public Optional<Party> getParty(
			WorkEffortAndPartyAssignAndType workEffortAndPartyAssignAndType) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						workEffortAndPartyAssignAndType.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party
						.fromValues(out.getListIt().getCompleteList());
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
	 * Get person
	 */
	public Optional<Person> getPerson(
			WorkEffortAndPartyAssignAndType workEffortAndPartyAssignAndType) {
		List<Person> entityList = null;
		In in = new In();
		in.setEntityName(Person.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						workEffortAndPartyAssignAndType.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Person.fromValues(out.getListIt()
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
	 * Get party role
	 */
	public Optional<PartyRole> getPartyRole(
			WorkEffortAndPartyAssignAndType workEffortAndPartyAssignAndType) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS,
						workEffortAndPartyAssignAndType.getPartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						workEffortAndPartyAssignAndType.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRole.fromValues(out.getListIt()
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
	 * Get role type
	 */
	public Optional<RoleType> getRoleType(
			WorkEffortAndPartyAssignAndType workEffortAndPartyAssignAndType) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						workEffortAndPartyAssignAndType.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RoleType.fromValues(out.getListIt()
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