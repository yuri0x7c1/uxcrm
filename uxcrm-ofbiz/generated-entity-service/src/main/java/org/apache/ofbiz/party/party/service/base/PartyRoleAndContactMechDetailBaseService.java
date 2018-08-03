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
import org.apache.ofbiz.party.party.PartyRoleAndContactMechDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.party.contact.PartyContactMech;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.RoleType;
import org.apache.ofbiz.party.contact.ContactMech;
import org.apache.ofbiz.party.contact.PostalAddress;
import org.apache.ofbiz.party.contact.TelecomNumber;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyRoleAndContactMechDetailBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyRoleAndContactMechDetailBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PartyRoleAndContactMechDetails
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PartyRoleAndContactMechDetail.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PartyRoleAndContactMechDetails
	 */
	public List<PartyRoleAndContactMechDetail> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<PartyRoleAndContactMechDetail> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(PartyRoleAndContactMechDetail.NAME);
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
				entityList = PartyRoleAndContactMechDetail.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PartyRoleAndContactMechDetail
	 */
	public Optional<PartyRoleAndContactMechDetail> findOne(Object partyId,
			Object roleTypeId, Object contactMechId, Object fromDate,
			Object paContactMechId, Object tnContactMechId) {
		List<PartyRoleAndContactMechDetail> entityList = null;
		In in = new In();
		in.setEntityName(PartyRoleAndContactMechDetail.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyId), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, roleTypeId), new EntityExpr(
						"contactMechId", EntityOperator.EQUALS, contactMechId),
						new EntityExpr("fromDate", EntityOperator.EQUALS,
								fromDate), new EntityExpr("paContactMechId",
								EntityOperator.EQUALS, paContactMechId),
						new EntityExpr("tnContactMechId",
								EntityOperator.EQUALS, tnContactMechId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRoleAndContactMechDetail.fromValues(out
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
	 * Get party role
	 */
	public Optional<PartyRole> getPartyRole(
			PartyRoleAndContactMechDetail partyRoleAndContactMechDetail) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS,
						partyRoleAndContactMechDetail.getPartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						partyRoleAndContactMechDetail.getRoleTypeId())),
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
	 * Get party contact mech
	 */
	public Optional<PartyContactMech> getPartyContactMech(
			PartyRoleAndContactMechDetail partyRoleAndContactMechDetail) {
		List<PartyContactMech> entityList = null;
		In in = new In();
		in.setEntityName(PartyContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS,
						partyRoleAndContactMechDetail.getPartyId()),
				new EntityExpr("contactMechId", EntityOperator.EQUALS,
						partyRoleAndContactMechDetail.getContactMechId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						partyRoleAndContactMechDetail.getFromDate())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyContactMech.fromValues(out.getListIt()
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
			PartyRoleAndContactMechDetail partyRoleAndContactMechDetail) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyRoleAndContactMechDetail.getPartyId())),
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
	 * Get role type
	 */
	public Optional<RoleType> getRoleType(
			PartyRoleAndContactMechDetail partyRoleAndContactMechDetail) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						partyRoleAndContactMechDetail.getRoleTypeId())),
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
	 * Get contact mech
	 */
	public Optional<ContactMech> getContactMech(
			PartyRoleAndContactMechDetail partyRoleAndContactMechDetail) {
		List<ContactMech> entityList = null;
		In in = new In();
		in.setEntityName(ContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						partyRoleAndContactMechDetail.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactMech.fromValues(out.getListIt()
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
	 * Get postal address
	 */
	public Optional<PostalAddress> getPostalAddress(
			PartyRoleAndContactMechDetail partyRoleAndContactMechDetail) {
		List<PostalAddress> entityList = null;
		In in = new In();
		in.setEntityName(PostalAddress.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						partyRoleAndContactMechDetail.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PostalAddress.fromValues(out.getListIt()
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
	 * Get telecom number
	 */
	public Optional<TelecomNumber> getTelecomNumber(
			PartyRoleAndContactMechDetail partyRoleAndContactMechDetail) {
		List<TelecomNumber> entityList = null;
		In in = new In();
		in.setEntityName(TelecomNumber.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						partyRoleAndContactMechDetail.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TelecomNumber.fromValues(out.getListIt()
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