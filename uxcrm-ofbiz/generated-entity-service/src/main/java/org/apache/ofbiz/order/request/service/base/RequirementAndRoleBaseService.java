package org.apache.ofbiz.order.request.service.base;

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
import org.apache.ofbiz.order.request.RequirementAndRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.requirement.Requirement;
import org.apache.ofbiz.order.requirement.RequirementRole;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.Person;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.party.party.RoleType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class RequirementAndRoleBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public RequirementAndRoleBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count RequirementAndRoles
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(RequirementAndRole.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find RequirementAndRoles
	 */
	public List<RequirementAndRole> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<RequirementAndRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementAndRole.NAME);
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
				entityList = RequirementAndRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one RequirementAndRole
	 */
	public Optional<RequirementAndRole> findOne(Object requirementId,
			Object partyId, Object roleTypeId, Object fromDate) {
		List<RequirementAndRole> entityList = null;
		In in = new In();
		in.setEntityName(RequirementAndRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirementId), new EntityExpr("partyId",
						EntityOperator.EQUALS, partyId), new EntityExpr(
						"roleTypeId", EntityOperator.EQUALS, roleTypeId),
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementAndRole.fromValues(out.getListIt()
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
	 * Get requirement
	 */
	public Optional<Requirement> getRequirement(
			RequirementAndRole requirementAndRole) {
		List<Requirement> entityList = null;
		In in = new In();
		in.setEntityName(Requirement.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirementAndRole.getRequirementId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Requirement.fromValues(out.getListIt()
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
	 * Get requirement role
	 */
	public Optional<RequirementRole> getRequirementRole(
			RequirementAndRole requirementAndRole) {
		List<RequirementRole> entityList = null;
		In in = new In();
		in.setEntityName(RequirementRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("requirementId", EntityOperator.EQUALS,
						requirementAndRole.getRequirementId()),
				new EntityExpr("partyId", EntityOperator.EQUALS,
						requirementAndRole.getPartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						requirementAndRole.getRoleTypeId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						requirementAndRole.getFromDate())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementRole.fromValues(out.getListIt()
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
	public Optional<Party> getParty(RequirementAndRole requirementAndRole) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						requirementAndRole.getPartyId())), EntityOperator.AND));
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
	public Optional<Person> getPerson(RequirementAndRole requirementAndRole) {
		List<Person> entityList = null;
		In in = new In();
		in.setEntityName(Person.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						requirementAndRole.getPartyId())), EntityOperator.AND));
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
			RequirementAndRole requirementAndRole) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS,
						requirementAndRole.getPartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						requirementAndRole.getRoleTypeId())),
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
	public Optional<RoleType> getRoleType(RequirementAndRole requirementAndRole) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						requirementAndRole.getRoleTypeId())),
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