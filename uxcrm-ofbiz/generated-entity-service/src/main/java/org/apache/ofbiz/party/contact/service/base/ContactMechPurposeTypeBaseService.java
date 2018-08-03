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
import org.apache.ofbiz.party.contact.ContactMechPurposeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.contact.ContactMechTypePurpose;
import org.apache.ofbiz.product.facility.FacilityContactMechPurpose;
import org.apache.ofbiz.accounting.invoice.InvoiceContactMech;
import org.apache.ofbiz.order.order.OrderContactMech;
import org.apache.ofbiz.order.order.OrderItemContactMech;
import org.apache.ofbiz.party.contact.PartyContactMechPurpose;
import org.apache.ofbiz.order._return.ReturnContactMech;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContactMechPurposeTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContactMechPurposeTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContactMechPurposeTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContactMechPurposeType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContactMechPurposeTypes
	 */
	public List<ContactMechPurposeType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ContactMechPurposeType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContactMechPurposeType.NAME);
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
				entityList = ContactMechPurposeType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContactMechPurposeType
	 */
	public Optional<ContactMechPurposeType> findOne(
			Object contactMechPurposeTypeId) {
		List<ContactMechPurposeType> entityList = null;
		In in = new In();
		in.setEntityName(ContactMechPurposeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechPurposeTypeId",
						EntityOperator.EQUALS, contactMechPurposeTypeId)),
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
	 * Get contact mech type purposes
	 */
	public List<ContactMechTypePurpose> getContactMechTypePurposes(
			ContactMechPurposeType contactMechPurposeType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechPurposeTypeId",
						EntityOperator.EQUALS, contactMechPurposeType
								.getContactMechPurposeTypeId())),
				EntityOperator.AND));
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
	 * Get facility contact mech purposes
	 */
	public List<FacilityContactMechPurpose> getFacilityContactMechPurposes(
			ContactMechPurposeType contactMechPurposeType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechPurposeTypeId",
						EntityOperator.EQUALS, contactMechPurposeType
								.getContactMechPurposeTypeId())),
				EntityOperator.AND));
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
	 * Get invoice contact meches
	 */
	public List<InvoiceContactMech> getInvoiceContactMeches(
			ContactMechPurposeType contactMechPurposeType, Integer start,
			Integer number, List<String> orderBy) {
		List<InvoiceContactMech> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceContactMech.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechPurposeTypeId",
						EntityOperator.EQUALS, contactMechPurposeType
								.getContactMechPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceContactMech.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order contact meches
	 */
	public List<OrderContactMech> getOrderContactMeches(
			ContactMechPurposeType contactMechPurposeType, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderContactMech> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderContactMech.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechPurposeTypeId",
						EntityOperator.EQUALS, contactMechPurposeType
								.getContactMechPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderContactMech.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item contact meches
	 */
	public List<OrderItemContactMech> getOrderItemContactMeches(
			ContactMechPurposeType contactMechPurposeType, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderItemContactMech> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemContactMech.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechPurposeTypeId",
						EntityOperator.EQUALS, contactMechPurposeType
								.getContactMechPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemContactMech.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party contact mech purposes
	 */
	public List<PartyContactMechPurpose> getPartyContactMechPurposes(
			ContactMechPurposeType contactMechPurposeType, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyContactMechPurpose> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyContactMechPurpose.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechPurposeTypeId",
						EntityOperator.EQUALS, contactMechPurposeType
								.getContactMechPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyContactMechPurpose.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get return contact meches
	 */
	public List<ReturnContactMech> getReturnContactMeches(
			ContactMechPurposeType contactMechPurposeType, Integer start,
			Integer number, List<String> orderBy) {
		List<ReturnContactMech> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnContactMech.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechPurposeTypeId",
						EntityOperator.EQUALS, contactMechPurposeType
								.getContactMechPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnContactMech.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}