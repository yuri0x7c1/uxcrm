package org.apache.ofbiz.party.contact.service.base;

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
import org.apache.ofbiz.party.contact.ContactListPartyAndContactMech;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.marketing.contact.ContactListParty;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContactListPartyAndContactMechBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContactListPartyAndContactMechBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContactListPartyAndContactMeches
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContactListPartyAndContactMech.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContactListPartyAndContactMeches
	 */
	public List<ContactListPartyAndContactMech> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<ContactListPartyAndContactMech> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(ContactListPartyAndContactMech.NAME);
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
				entityList = ContactListPartyAndContactMech.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContactListPartyAndContactMech
	 */
	public Optional<ContactListPartyAndContactMech> findOne(
			Object contactFromDate, Object fromDate, Object contactListId,
			Object partyId, Object contactMechId) {
		List<ContactListPartyAndContactMech> entityList = null;
		In in = new In();
		in.setEntityName(ContactListPartyAndContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contactFromDate", EntityOperator.EQUALS,
						contactFromDate), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate), new EntityExpr(
						"contactListId", EntityOperator.EQUALS, contactListId),
				new EntityExpr("partyId", EntityOperator.EQUALS, partyId),
				new EntityExpr("contactMechId", EntityOperator.EQUALS,
						contactMechId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactListPartyAndContactMech.fromValues(out
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
	 * Get contact list party
	 */
	public Optional<ContactListParty> getContactListParty(
			ContactListPartyAndContactMech contactListPartyAndContactMech) {
		List<ContactListParty> entityList = null;
		In in = new In();
		in.setEntityName(ContactListParty.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contactListId", EntityOperator.EQUALS,
						contactListPartyAndContactMech.getContactListId()),
				new EntityExpr("partyId", EntityOperator.EQUALS,
						contactListPartyAndContactMech.getPartyId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						contactListPartyAndContactMech.getFromDate())),
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
}