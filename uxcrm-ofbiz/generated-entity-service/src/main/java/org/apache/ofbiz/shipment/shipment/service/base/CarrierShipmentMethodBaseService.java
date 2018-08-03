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
import org.apache.ofbiz.shipment.shipment.CarrierShipmentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.shipment.shipment.ShipmentMethodType;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.product.facility.FacilityCarrierShipment;
import org.apache.ofbiz.order.order.OldOrderShipmentPreference;
import org.apache.ofbiz.order.order.OrderItemShipGroup;
import org.apache.ofbiz.shipment.shipment.ShipmentCostEstimate;
import org.apache.ofbiz.order.shoppinglist.ShoppingList;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CarrierShipmentMethodBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CarrierShipmentMethodBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CarrierShipmentMethods
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CarrierShipmentMethod.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CarrierShipmentMethods
	 */
	public List<CarrierShipmentMethod> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<CarrierShipmentMethod> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CarrierShipmentMethod.NAME);
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
				entityList = CarrierShipmentMethod.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CarrierShipmentMethod
	 */
	public Optional<CarrierShipmentMethod> findOne(Object shipmentMethodTypeId,
			Object partyId, Object roleTypeId) {
		List<CarrierShipmentMethod> entityList = null;
		In in = new In();
		in.setEntityName(CarrierShipmentMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentMethodTypeId", EntityOperator.EQUALS,
						shipmentMethodTypeId), new EntityExpr("partyId",
						EntityOperator.EQUALS, partyId), new EntityExpr(
						"roleTypeId", EntityOperator.EQUALS, roleTypeId)),
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

	/**
	 * Get shipment method type
	 */
	public Optional<ShipmentMethodType> getShipmentMethodType(
			CarrierShipmentMethod carrierShipmentMethod) {
		List<ShipmentMethodType> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentMethodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentMethodTypeId",
						EntityOperator.EQUALS, carrierShipmentMethod
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
	 * Get party
	 */
	public Optional<Party> getParty(CarrierShipmentMethod carrierShipmentMethod) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						carrierShipmentMethod.getPartyId())),
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
	 * Get party role
	 */
	public Optional<PartyRole> getPartyRole(
			CarrierShipmentMethod carrierShipmentMethod) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS,
						carrierShipmentMethod.getPartyId()), new EntityExpr(
						"roleTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getRoleTypeId())),
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
	 * Get facility carrier shipments
	 */
	public List<FacilityCarrierShipment> getFacilityCarrierShipments(
			CarrierShipmentMethod carrierShipmentMethod, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentMethodTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getShipmentMethodTypeId()),
				new EntityExpr("partyId", EntityOperator.EQUALS,
						carrierShipmentMethod.getPartyId()), new EntityExpr(
						"roleTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get old order shipment preferences
	 */
	public List<OldOrderShipmentPreference> getOldOrderShipmentPreferences(
			CarrierShipmentMethod carrierShipmentMethod, Integer start,
			Integer number, List<String> orderBy) {
		List<OldOrderShipmentPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldOrderShipmentPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentMethodTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getShipmentMethodTypeId()),
				new EntityExpr("carrierPartyId", EntityOperator.EQUALS,
						carrierShipmentMethod.getPartyId()), new EntityExpr(
						"carrierRoleTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldOrderShipmentPreference.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item ship groups
	 */
	public List<OrderItemShipGroup> getOrderItemShipGroups(
			CarrierShipmentMethod carrierShipmentMethod, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentMethodTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getShipmentMethodTypeId()),
				new EntityExpr("carrierPartyId", EntityOperator.EQUALS,
						carrierShipmentMethod.getPartyId()), new EntityExpr(
						"carrierRoleTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getRoleTypeId())),
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
	 * Get shipment cost estimates
	 */
	public List<ShipmentCostEstimate> getShipmentCostEstimates(
			CarrierShipmentMethod carrierShipmentMethod, Integer start,
			Integer number, List<String> orderBy) {
		List<ShipmentCostEstimate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentCostEstimate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentMethodTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getShipmentMethodTypeId()),
				new EntityExpr("carrierPartyId", EntityOperator.EQUALS,
						carrierShipmentMethod.getPartyId()), new EntityExpr(
						"carrierRoleTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentCostEstimate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shopping lists
	 */
	public List<ShoppingList> getShoppingLists(
			CarrierShipmentMethod carrierShipmentMethod, Integer start,
			Integer number, List<String> orderBy) {
		List<ShoppingList> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentMethodTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getShipmentMethodTypeId()),
				new EntityExpr("carrierPartyId", EntityOperator.EQUALS,
						carrierShipmentMethod.getPartyId()), new EntityExpr(
						"carrierRoleTypeId", EntityOperator.EQUALS,
						carrierShipmentMethod.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingList.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}