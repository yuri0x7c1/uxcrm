package org.apache.ofbiz.shipment.shipment.service.base;

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
import org.apache.ofbiz.shipment.shipment.ShipmentRouteSegment;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.shipment.shipment.Shipment;
import org.apache.ofbiz.shipment.shipment.Delivery;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.Person;
import org.apache.ofbiz.party.party.PartyGroup;
import org.apache.ofbiz.shipment.shipment.ShipmentMethodType;
import org.apache.ofbiz.product.facility.Facility;
import org.apache.ofbiz.party.contact.ContactMech;
import org.apache.ofbiz.party.contact.PostalAddress;
import org.apache.ofbiz.party.contact.TelecomNumber;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.shipment.shipment.ShipmentPackageRouteSeg;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ShipmentRouteSegmentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ShipmentRouteSegmentBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ShipmentRouteSegments
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ShipmentRouteSegment.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ShipmentRouteSegments
	 */
	public List<ShipmentRouteSegment> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one ShipmentRouteSegment
	 */
	public Optional<ShipmentRouteSegment> findOne(Object shipmentId,
			Object shipmentRouteSegmentId) {
		List<ShipmentRouteSegment> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentRouteSegment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentId), new EntityExpr("shipmentRouteSegmentId",
						EntityOperator.EQUALS, shipmentRouteSegmentId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentRouteSegment.fromValues(out.getListIt()
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
	 * Get shipment
	 */
	public Optional<Shipment> getShipment(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<Shipment> entityList = null;
		In in = new In();
		in.setEntityName(Shipment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentRouteSegment.getShipmentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Shipment.fromValues(out.getListIt()
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
	 * Get delivery
	 */
	public Optional<Delivery> getDelivery(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<Delivery> entityList = null;
		In in = new In();
		in.setEntityName(Delivery.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("deliveryId", EntityOperator.EQUALS,
						shipmentRouteSegment.getDeliveryId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Delivery.fromValues(out.getListIt()
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
	 * Get carrier party
	 */
	public Optional<Party> getCarrierParty(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						shipmentRouteSegment.getCarrierPartyId())),
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
	 * Get carrier person
	 */
	public Optional<Person> getCarrierPerson(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<Person> entityList = null;
		In in = new In();
		in.setEntityName(Person.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						shipmentRouteSegment.getCarrierPartyId())),
				EntityOperator.AND));
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
	 * Get carrier party group
	 */
	public Optional<PartyGroup> getCarrierPartyGroup(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<PartyGroup> entityList = null;
		In in = new In();
		in.setEntityName(PartyGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						shipmentRouteSegment.getCarrierPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyGroup.fromValues(out.getListIt()
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
	 * Get shipment method type
	 */
	public Optional<ShipmentMethodType> getShipmentMethodType(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<ShipmentMethodType> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentMethodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentMethodTypeId",
						EntityOperator.EQUALS, shipmentRouteSegment
								.getShipmentMethodTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentMethodType.fromValues(out.getListIt()
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
	 * Get origin facility
	 */
	public Optional<Facility> getOriginFacility(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<Facility> entityList = null;
		In in = new In();
		in.setEntityName(Facility.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						shipmentRouteSegment.getOriginFacilityId())),
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
	 * Get dest facility
	 */
	public Optional<Facility> getDestFacility(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<Facility> entityList = null;
		In in = new In();
		in.setEntityName(Facility.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						shipmentRouteSegment.getDestFacilityId())),
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
	 * Get origin contact mech
	 */
	public Optional<ContactMech> getOriginContactMech(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<ContactMech> entityList = null;
		In in = new In();
		in.setEntityName(ContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						shipmentRouteSegment.getOriginContactMechId())),
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
	 * Get dest contact mech
	 */
	public Optional<ContactMech> getDestContactMech(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<ContactMech> entityList = null;
		In in = new In();
		in.setEntityName(ContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						shipmentRouteSegment.getDestContactMechId())),
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
	 * Get origin postal address
	 */
	public Optional<PostalAddress> getOriginPostalAddress(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<PostalAddress> entityList = null;
		In in = new In();
		in.setEntityName(PostalAddress.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						shipmentRouteSegment.getOriginContactMechId())),
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
	 * Get origin telecom number
	 */
	public Optional<TelecomNumber> getOriginTelecomNumber(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<TelecomNumber> entityList = null;
		In in = new In();
		in.setEntityName(TelecomNumber.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						shipmentRouteSegment.getOriginTelecomNumberId())),
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

	/**
	 * Get dest postal address
	 */
	public Optional<PostalAddress> getDestPostalAddress(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<PostalAddress> entityList = null;
		In in = new In();
		in.setEntityName(PostalAddress.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						shipmentRouteSegment.getDestContactMechId())),
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
	 * Get dest telecom number
	 */
	public Optional<TelecomNumber> getDestTelecomNumber(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<TelecomNumber> entityList = null;
		In in = new In();
		in.setEntityName(TelecomNumber.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						shipmentRouteSegment.getDestTelecomNumberId())),
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

	/**
	 * Get carrier service status item
	 */
	public Optional<StatusItem> getCarrierServiceStatusItem(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						shipmentRouteSegment.getCarrierServiceStatusId())),
				EntityOperator.AND));
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
	 * Get currency uom
	 */
	public Optional<Uom> getCurrencyUom(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						shipmentRouteSegment.getCurrencyUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Uom.fromValues(out.getListIt().getCompleteList());
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
	 * Get billing weight uom
	 */
	public Optional<Uom> getBillingWeightUom(
			ShipmentRouteSegment shipmentRouteSegment) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						shipmentRouteSegment.getBillingWeightUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Uom.fromValues(out.getListIt().getCompleteList());
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
	 * Get shipment package route segs
	 */
	public List<ShipmentPackageRouteSeg> getShipmentPackageRouteSegs(
			ShipmentRouteSegment shipmentRouteSegment, Integer start,
			Integer number, List<String> orderBy) {
		List<ShipmentPackageRouteSeg> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentPackageRouteSeg.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentRouteSegment.getShipmentId()), new EntityExpr(
						"shipmentRouteSegmentId", EntityOperator.EQUALS,
						shipmentRouteSegment.getShipmentRouteSegmentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentPackageRouteSeg.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}