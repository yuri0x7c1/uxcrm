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
import org.apache.ofbiz.product.facility.FacilityCarrierShipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.product.facility.Facility;
import org.apache.ofbiz.shipment.shipment.ShipmentMethodType;
import org.apache.ofbiz.shipment.shipment.CarrierShipmentMethod;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FacilityCarrierShipmentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FacilityCarrierShipmentBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FacilityCarrierShipments
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FacilityCarrierShipment.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FacilityCarrierShipments
	 */
	public List<FacilityCarrierShipment> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FacilityCarrierShipment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityCarrierShipment.NAME);
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
				entityList = FacilityCarrierShipment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FacilityCarrierShipment
	 */
	public Optional<FacilityCarrierShipment> findOne(Object facilityId,
			Object partyId, Object roleTypeId, Object shipmentMethodTypeId) {
		List<FacilityCarrierShipment> entityList = null;
		In in = new In();
		in.setEntityName(FacilityCarrierShipment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						facilityId), new EntityExpr("partyId",
						EntityOperator.EQUALS, partyId), new EntityExpr(
						"roleTypeId", EntityOperator.EQUALS, roleTypeId),
						new EntityExpr("shipmentMethodTypeId",
								EntityOperator.EQUALS, shipmentMethodTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityCarrierShipment.fromValues(out.getListIt()
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
			FacilityCarrierShipment facilityCarrierShipment) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						facilityCarrierShipment.getPartyId())),
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
	 * Get facility
	 */
	public Optional<Facility> getFacility(
			FacilityCarrierShipment facilityCarrierShipment) {
		List<Facility> entityList = null;
		In in = new In();
		in.setEntityName(Facility.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						facilityCarrierShipment.getFacilityId())),
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
	 * Get shipment method type
	 */
	public Optional<ShipmentMethodType> getShipmentMethodType(
			FacilityCarrierShipment facilityCarrierShipment) {
		List<ShipmentMethodType> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentMethodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentMethodTypeId",
						EntityOperator.EQUALS, facilityCarrierShipment
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
	 * Get carrier shipment method
	 */
	public Optional<CarrierShipmentMethod> getCarrierShipmentMethod(
			FacilityCarrierShipment facilityCarrierShipment) {
		List<CarrierShipmentMethod> entityList = null;
		In in = new In();
		in.setEntityName(CarrierShipmentMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentMethodTypeId", EntityOperator.EQUALS,
						facilityCarrierShipment.getShipmentMethodTypeId()),
				new EntityExpr("partyId", EntityOperator.EQUALS,
						facilityCarrierShipment.getPartyId()), new EntityExpr(
						"roleTypeId", EntityOperator.EQUALS,
						facilityCarrierShipment.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CarrierShipmentMethod.fromValues(out.getListIt()
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