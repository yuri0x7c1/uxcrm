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
import org.apache.ofbiz.party.contact.TelecomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.contact.ContactMech;
import org.apache.ofbiz.product.facility.FacilityContactMech;
import org.apache.ofbiz.workeffort.workeffort.OldWorkEffortContactMech;
import org.apache.ofbiz.order.order.OrderItemShipGroup;
import org.apache.ofbiz.party.contact.PartyContactMech;
import org.apache.ofbiz.party.contact.PartyContactMechPurpose;
import org.apache.ofbiz.shipment.shipment.Shipment;
import org.apache.ofbiz.shipment.shipment.ShipmentRouteSegment;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortContactMech;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TelecomNumberBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TelecomNumberBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TelecomNumbers
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TelecomNumber.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TelecomNumbers
	 */
	public List<TelecomNumber> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TelecomNumber> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TelecomNumber.NAME);
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
				entityList = TelecomNumber.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TelecomNumber
	 */
	public Optional<TelecomNumber> findOne(Object contactMechId) {
		List<TelecomNumber> entityList = null;
		In in = new In();
		in.setEntityName(TelecomNumber.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						contactMechId)), EntityOperator.AND));
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

	/**
	 * Get contact mech
	 */
	public Optional<ContactMech> getContactMech(TelecomNumber telecomNumber) {
		List<ContactMech> entityList = null;
		In in = new In();
		in.setEntityName(ContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						telecomNumber.getContactMechId())), EntityOperator.AND));
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
	 * Get facility contact meches
	 */
	public List<FacilityContactMech> getFacilityContactMeches(
			TelecomNumber telecomNumber, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						telecomNumber.getContactMechId())), EntityOperator.AND));
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
	 * Get old work effort contact meches
	 */
	public List<OldWorkEffortContactMech> getOldWorkEffortContactMeches(
			TelecomNumber telecomNumber, Integer start, Integer number,
			List<String> orderBy) {
		List<OldWorkEffortContactMech> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldWorkEffortContactMech.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						telecomNumber.getContactMechId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldWorkEffortContactMech.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get telecom order item ship groups
	 */
	public List<OrderItemShipGroup> getTelecomOrderItemShipGroups(
			TelecomNumber telecomNumber, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemShipGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemShipGroup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("telecomContactMechId",
						EntityOperator.EQUALS, telecomNumber.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party contact meches
	 */
	public List<PartyContactMech> getPartyContactMeches(
			TelecomNumber telecomNumber, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyContactMech> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyContactMech.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						telecomNumber.getContactMechId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyContactMech.fromValues(out.getListIt()
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
			TelecomNumber telecomNumber, Integer start, Integer number,
			List<String> orderBy) {
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
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						telecomNumber.getContactMechId())), EntityOperator.AND));
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
	 * Get origin shipments
	 */
	public List<Shipment> getOriginShipments(TelecomNumber telecomNumber,
			Integer start, Integer number, List<String> orderBy) {
		List<Shipment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Shipment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("originTelecomNumberId",
						EntityOperator.EQUALS, telecomNumber.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Shipment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get destination shipments
	 */
	public List<Shipment> getDestinationShipments(TelecomNumber telecomNumber,
			Integer start, Integer number, List<String> orderBy) {
		List<Shipment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Shipment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("destinationTelecomNumberId",
						EntityOperator.EQUALS, telecomNumber.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Shipment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get origin shipment route segments
	 */
	public List<ShipmentRouteSegment> getOriginShipmentRouteSegments(
			TelecomNumber telecomNumber, Integer start, Integer number,
			List<String> orderBy) {
		List<ShipmentRouteSegment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentRouteSegment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("originTelecomNumberId",
						EntityOperator.EQUALS, telecomNumber.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentRouteSegment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get dest shipment route segments
	 */
	public List<ShipmentRouteSegment> getDestShipmentRouteSegments(
			TelecomNumber telecomNumber, Integer start, Integer number,
			List<String> orderBy) {
		List<ShipmentRouteSegment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentRouteSegment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("destTelecomNumberId",
						EntityOperator.EQUALS, telecomNumber.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentRouteSegment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort contact meches
	 */
	public List<WorkEffortContactMech> getWorkEffortContactMeches(
			TelecomNumber telecomNumber, Integer start, Integer number,
			List<String> orderBy) {
		List<WorkEffortContactMech> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortContactMech.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						telecomNumber.getContactMechId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortContactMech.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}