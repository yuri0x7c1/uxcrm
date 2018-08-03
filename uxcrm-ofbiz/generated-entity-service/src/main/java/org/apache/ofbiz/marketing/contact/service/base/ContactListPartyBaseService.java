package org.apache.ofbiz.marketing.contact.service.base;

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
import org.apache.ofbiz.marketing.contact.ContactListParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.marketing.contact.ContactList;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.party.contact.ContactMech;
import org.apache.ofbiz.marketing.contact.ContactListPartyStatus;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContactListPartyBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContactListPartyBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContactListParties
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContactListParty.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContactListParties
	 */
	public List<ContactListParty> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ContactListParty> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContactListParty.NAME);
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
				entityList = ContactListParty.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContactListParty
	 */
	public Optional<ContactListParty> findOne(Object contactListId,
			Object partyId, Object fromDate) {
		List<ContactListParty> entityList = null;
		In in = new In();
		in.setEntityName(ContactListParty.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contactListId", EntityOperator.EQUALS,
						contactListId), new EntityExpr("partyId",
						EntityOperator.EQUALS, partyId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactListParty.fromValues(out.getListIt()
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
	 * Get contact list
	 */
	public Optional<ContactList> getContactList(
			ContactListParty contactListParty) {
		List<ContactList> entityList = null;
		In in = new In();
		in.setEntityName(ContactList.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactListId", EntityOperator.EQUALS,
						contactListParty.getContactListId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactList.fromValues(out.getListIt()
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
	public Optional<Party> getParty(ContactListParty contactListParty) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						contactListParty.getPartyId())), EntityOperator.AND));
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
	 * Get status item
	 */
	public Optional<StatusItem> getStatusItem(ContactListParty contactListParty) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						contactListParty.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusItem.fromValues(out.getListIt()
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
	 * Get preferred contact mech
	 */
	public Optional<ContactMech> getPreferredContactMech(
			ContactListParty contactListParty) {
		List<ContactMech> entityList = null;
		In in = new In();
		in.setEntityName(ContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						contactListParty.getPreferredContactMechId())),
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
	 * Get contact list party statuses
	 */
	public List<ContactListPartyStatus> getContactListPartyStatuses(
			ContactListParty contactListParty, Integer start, Integer number,
			List<String> orderBy) {
		List<ContactListPartyStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContactListPartyStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contactListId", EntityOperator.EQUALS,
						contactListParty.getContactListId()),
				new EntityExpr("partyId", EntityOperator.EQUALS,
						contactListParty.getPartyId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						contactListParty.getFromDate())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactListPartyStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}