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
import org.apache.ofbiz.party.contact.ContactMechTypePurpose;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.contact.ContactMechType;
import org.apache.ofbiz.party.contact.ContactMechPurposeType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContactMechTypePurposeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContactMechTypePurposeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContactMechTypePurposes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContactMechTypePurpose.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContactMechTypePurposes
	 */
	public List<ContactMechTypePurpose> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ContactMechTypePurpose> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContactMechTypePurpose.NAME);
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
				entityList = ContactMechTypePurpose.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContactMechTypePurpose
	 */
	public Optional<ContactMechTypePurpose> findOne(Object contactMechTypeId,
			Object contactMechPurposeTypeId) {
		List<ContactMechTypePurpose> entityList = null;
		In in = new In();
		in.setEntityName(ContactMechTypePurpose.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contactMechTypeId", EntityOperator.EQUALS,
						contactMechTypeId), new EntityExpr(
						"contactMechPurposeTypeId", EntityOperator.EQUALS,
						contactMechPurposeTypeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactMechTypePurpose.fromValues(out.getListIt()
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
	 * Get contact mech type
	 */
	public Optional<ContactMechType> getContactMechType(
			ContactMechTypePurpose contactMechTypePurpose) {
		List<ContactMechType> entityList = null;
		In in = new In();
		in.setEntityName(ContactMechType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechTypeId",
						EntityOperator.EQUALS, contactMechTypePurpose
								.getContactMechTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactMechType.fromValues(out.getListIt()
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
	 * Get contact mech purpose type
	 */
	public Optional<ContactMechPurposeType> getContactMechPurposeType(
			ContactMechTypePurpose contactMechTypePurpose) {
		List<ContactMechPurposeType> entityList = null;
		In in = new In();
		in.setEntityName(ContactMechPurposeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechPurposeTypeId",
						EntityOperator.EQUALS, contactMechTypePurpose
								.getContactMechPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactMechPurposeType.fromValues(out.getListIt()
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