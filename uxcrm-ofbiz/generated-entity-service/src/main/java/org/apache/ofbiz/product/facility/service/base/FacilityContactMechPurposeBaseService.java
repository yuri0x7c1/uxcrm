package org.apache.ofbiz.product.facility.service.base;

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
import org.apache.ofbiz.product.facility.FacilityContactMechPurpose;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.facility.FacilityContactMech;
import org.apache.ofbiz.party.contact.ContactMechPurposeType;
import org.apache.ofbiz.product.facility.Facility;
import org.apache.ofbiz.party.contact.ContactMech;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FacilityContactMechPurposeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FacilityContactMechPurposeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FacilityContactMechPurposes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FacilityContactMechPurpose.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FacilityContactMechPurposes
	 */
	public List<FacilityContactMechPurpose> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FacilityContactMechPurpose> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityContactMechPurpose.NAME);
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
				entityList = FacilityContactMechPurpose.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FacilityContactMechPurpose
	 */
	public Optional<FacilityContactMechPurpose> findOne(Object facilityId,
			Object contactMechId, Object contactMechPurposeTypeId,
			Object fromDate) {
		List<FacilityContactMechPurpose> entityList = null;
		In in = new In();
		in.setEntityName(FacilityContactMechPurpose.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						facilityId), new EntityExpr("contactMechId",
						EntityOperator.EQUALS, contactMechId), new EntityExpr(
						"contactMechPurposeTypeId", EntityOperator.EQUALS,
						contactMechPurposeTypeId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityContactMechPurpose.fromValues(out
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
	 * Get facility contact meches
	 */
	public List<FacilityContactMech> getFacilityContactMeches(
			FacilityContactMechPurpose facilityContactMechPurpose,
			Integer start, Integer number, List<String> orderBy) {
		List<FacilityContactMech> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityContactMech.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("facilityId", EntityOperator.EQUALS,
						facilityContactMechPurpose.getFacilityId()),
				new EntityExpr("contactMechId", EntityOperator.EQUALS,
						facilityContactMechPurpose.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityContactMech.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get contact mech purpose type
	 */
	public Optional<ContactMechPurposeType> getContactMechPurposeType(
			FacilityContactMechPurpose facilityContactMechPurpose) {
		List<ContactMechPurposeType> entityList = null;
		In in = new In();
		in.setEntityName(ContactMechPurposeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechPurposeTypeId",
						EntityOperator.EQUALS, facilityContactMechPurpose
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

	/**
	 * Get facility
	 */
	public Optional<Facility> getFacility(
			FacilityContactMechPurpose facilityContactMechPurpose) {
		List<Facility> entityList = null;
		In in = new In();
		in.setEntityName(Facility.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						facilityContactMechPurpose.getFacilityId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Facility.fromValues(out.getListIt()
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
			FacilityContactMechPurpose facilityContactMechPurpose) {
		List<ContactMech> entityList = null;
		In in = new In();
		in.setEntityName(ContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						facilityContactMechPurpose.getContactMechId())),
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
}