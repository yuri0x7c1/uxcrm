package org.apache.ofbiz.party.party.service.base;

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
import org.apache.ofbiz.party.party.PartyRelationshipType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.RoleType;
import org.apache.ofbiz.party.party.PartyRelationship;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyRelationshipTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyRelationshipTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PartyRelationshipTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PartyRelationshipType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PartyRelationshipTypes
	 */
	public List<PartyRelationshipType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PartyRelationshipType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationshipType.NAME);
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
				entityList = PartyRelationshipType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PartyRelationshipType
	 */
	public Optional<PartyRelationshipType> findOne(
			Object partyRelationshipTypeId) {
		List<PartyRelationshipType> entityList = null;
		In in = new In();
		in.setEntityName(PartyRelationshipType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyRelationshipTypeId",
						EntityOperator.EQUALS, partyRelationshipTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationshipType.fromValues(out.getListIt()
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
	 * Get parent party relationship type
	 */
	public Optional<PartyRelationshipType> getParentPartyRelationshipType(
			PartyRelationshipType partyRelationshipType) {
		List<PartyRelationshipType> entityList = null;
		In in = new In();
		in.setEntityName(PartyRelationshipType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyRelationshipTypeId",
						EntityOperator.EQUALS, partyRelationshipType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationshipType.fromValues(out.getListIt()
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
	 * Get valid from role type
	 */
	public Optional<RoleType> getValidFromRoleType(
			PartyRelationshipType partyRelationshipType) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						partyRelationshipType.getRoleTypeIdValidFrom())),
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

	/**
	 * Get valid to role type
	 */
	public Optional<RoleType> getValidToRoleType(
			PartyRelationshipType partyRelationshipType) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						partyRelationshipType.getRoleTypeIdValidTo())),
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

	/**
	 * Get party relationships
	 */
	public List<PartyRelationship> getPartyRelationships(
			PartyRelationshipType partyRelationshipType, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyRelationship> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationship.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyRelationshipTypeId",
						EntityOperator.EQUALS, partyRelationshipType
								.getPartyRelationshipTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationship.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child party relationship types
	 */
	public List<PartyRelationshipType> getChildPartyRelationshipTypes(
			PartyRelationshipType partyRelationshipType, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyRelationshipType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationshipType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						partyRelationshipType.getPartyRelationshipTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationshipType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}