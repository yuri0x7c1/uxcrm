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
import org.apache.ofbiz.party.party.PartyRelationshipAndContactMechDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.PartyRelationship;
import org.apache.ofbiz.party.party.PartyRelationshipType;
import org.apache.ofbiz.party.contact.PartyContactMech;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.contact.ContactMech;
import org.apache.ofbiz.party.contact.PostalAddress;
import org.apache.ofbiz.party.contact.TelecomNumber;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyRelationshipAndContactMechDetailBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyRelationshipAndContactMechDetailBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PartyRelationshipAndContactMechDetails
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PartyRelationshipAndContactMechDetail.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PartyRelationshipAndContactMechDetails
	 */
	public List<PartyRelationshipAndContactMechDetail> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<PartyRelationshipAndContactMechDetail> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationshipAndContactMechDetail.NAME);
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
				entityList = PartyRelationshipAndContactMechDetail
						.fromValues(out.getListIt().getPartialList(start,
								number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PartyRelationshipAndContactMechDetail
	 */
	public Optional<PartyRelationshipAndContactMechDetail> findOne(
			Object contactMechId, Object partyId, Object roleTypeIdTo,
			Object partyIdFrom, Object roleTypeIdFrom, Object fromDate,
			Object partyIdTo, Object paContactMechId, Object tnContactMechId) {
		List<PartyRelationshipAndContactMechDetail> entityList = null;
		In in = new In();
		in.setEntityName(PartyRelationshipAndContactMechDetail.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contactMechId", EntityOperator.EQUALS,
						contactMechId), new EntityExpr("partyId",
						EntityOperator.EQUALS, partyId), new EntityExpr(
						"roleTypeIdTo", EntityOperator.EQUALS, roleTypeIdTo),
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						partyIdFrom), new EntityExpr("roleTypeIdFrom",
						EntityOperator.EQUALS, roleTypeIdFrom), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyIdTo),
				new EntityExpr("paContactMechId", EntityOperator.EQUALS,
						paContactMechId), new EntityExpr("tnContactMechId",
						EntityOperator.EQUALS, tnContactMechId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationshipAndContactMechDetail
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
	 * Get party relationship
	 */
	public Optional<PartyRelationship> getPartyRelationship(
			PartyRelationshipAndContactMechDetail partyRelationshipAndContactMechDetail) {
		List<PartyRelationship> entityList = null;
		In in = new In();
		in.setEntityName(PartyRelationship.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(
						new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
								partyRelationshipAndContactMechDetail
										.getPartyIdFrom()),
						new EntityExpr("partyIdTo", EntityOperator.EQUALS,
								partyRelationshipAndContactMechDetail
										.getPartyIdTo()),
						new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
								partyRelationshipAndContactMechDetail
										.getRoleTypeIdFrom()),
						new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
								partyRelationshipAndContactMechDetail
										.getRoleTypeIdTo()),
						new EntityExpr("fromDate", EntityOperator.EQUALS,
								partyRelationshipAndContactMechDetail
										.getFromDate())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationship.fromValues(out.getListIt()
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
	 * Get party relationship type
	 */
	public Optional<PartyRelationshipType> getPartyRelationshipType(
			PartyRelationshipAndContactMechDetail partyRelationshipAndContactMechDetail) {
		List<PartyRelationshipType> entityList = null;
		In in = new In();
		in.setEntityName(PartyRelationshipType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyRelationshipTypeId",
						EntityOperator.EQUALS,
						partyRelationshipAndContactMechDetail
								.getPartyRelationshipTypeId())),
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
	 * Get party contact mech
	 */
	public Optional<PartyContactMech> getPartyContactMech(
			PartyRelationshipAndContactMechDetail partyRelationshipAndContactMechDetail) {
		List<PartyContactMech> entityList = null;
		In in = new In();
		in.setEntityName(PartyContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS,
						partyRelationshipAndContactMechDetail.getPartyId()),
				new EntityExpr("contactMechId", EntityOperator.EQUALS,
						partyRelationshipAndContactMechDetail
								.getContactMechId()), new EntityExpr(
						"fromDate", EntityOperator.EQUALS,
						partyRelationshipAndContactMechDetail.getFromDate())),
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
			PartyRelationshipAndContactMechDetail partyRelationshipAndContactMechDetail) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyRelationshipAndContactMechDetail.getPartyId())),
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
	 * Get contact mech
	 */
	public Optional<ContactMech> getContactMech(
			PartyRelationshipAndContactMechDetail partyRelationshipAndContactMechDetail) {
		List<ContactMech> entityList = null;
		In in = new In();
		in.setEntityName(ContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						partyRelationshipAndContactMechDetail
								.getContactMechId())), EntityOperator.AND));
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
			PartyRelationshipAndContactMechDetail partyRelationshipAndContactMechDetail) {
		List<PostalAddress> entityList = null;
		In in = new In();
		in.setEntityName(PostalAddress.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						partyRelationshipAndContactMechDetail
								.getContactMechId())), EntityOperator.AND));
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
			PartyRelationshipAndContactMechDetail partyRelationshipAndContactMechDetail) {
		List<TelecomNumber> entityList = null;
		In in = new In();
		in.setEntityName(TelecomNumber.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						partyRelationshipAndContactMechDetail
								.getContactMechId())), EntityOperator.AND));
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