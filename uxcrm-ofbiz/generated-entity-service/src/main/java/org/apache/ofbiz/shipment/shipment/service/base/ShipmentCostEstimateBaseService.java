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
import org.apache.ofbiz.shipment.shipment.ShipmentCostEstimate;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.shipment.shipment.CarrierShipmentMethod;
import org.apache.ofbiz.product.store.ProductStoreShipmentMeth;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.RoleType;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.common.geo.Geo;
import org.apache.ofbiz.product.price.QuantityBreak;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ShipmentCostEstimateBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ShipmentCostEstimateBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ShipmentCostEstimates
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ShipmentCostEstimate.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ShipmentCostEstimates
	 */
	public List<ShipmentCostEstimate> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one ShipmentCostEstimate
	 */
	public Optional<ShipmentCostEstimate> findOne(Object shipmentCostEstimateId) {
		List<ShipmentCostEstimate> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentCostEstimate.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentCostEstimateId",
						EntityOperator.EQUALS, shipmentCostEstimateId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentCostEstimate.fromValues(out.getListIt()
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
			ShipmentCostEstimate shipmentCostEstimate) {
		List<CarrierShipmentMethod> entityList = null;
		In in = new In();
		in.setEntityName(CarrierShipmentMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentMethodTypeId", EntityOperator.EQUALS,
						shipmentCostEstimate.getShipmentMethodTypeId()),
				new EntityExpr("partyId", EntityOperator.EQUALS,
						shipmentCostEstimate.getCarrierPartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						shipmentCostEstimate.getCarrierRoleTypeId())),
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
	 * Get product store shipment meth
	 */
	public Optional<ProductStoreShipmentMeth> getProductStoreShipmentMeth(
			ShipmentCostEstimate shipmentCostEstimate) {
		List<ProductStoreShipmentMeth> entityList = null;
		In in = new In();
		in.setEntityName(ProductStoreShipmentMeth.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreShipMethId",
						EntityOperator.EQUALS, shipmentCostEstimate
								.getProductStoreShipMethId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreShipmentMeth.fromValues(out
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
	 * Get party
	 */
	public Optional<Party> getParty(ShipmentCostEstimate shipmentCostEstimate) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						shipmentCostEstimate.getPartyId())), EntityOperator.AND));
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
	 * Get role type
	 */
	public Optional<RoleType> getRoleType(
			ShipmentCostEstimate shipmentCostEstimate) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						shipmentCostEstimate.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RoleType.fromValues(out.getListIt()
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
	 * Get party role
	 */
	public Optional<PartyRole> getPartyRole(
			ShipmentCostEstimate shipmentCostEstimate) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS,
						shipmentCostEstimate.getPartyId()), new EntityExpr(
						"roleTypeId", EntityOperator.EQUALS,
						shipmentCostEstimate.getRoleTypeId())),
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
	 * Get weight uom
	 */
	public Optional<Uom> getWeightUom(ShipmentCostEstimate shipmentCostEstimate) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						shipmentCostEstimate.getWeightUomId())),
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
	 * Get quantity uom
	 */
	public Optional<Uom> getQuantityUom(
			ShipmentCostEstimate shipmentCostEstimate) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						shipmentCostEstimate.getQuantityUomId())),
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
	 * Get price uom
	 */
	public Optional<Uom> getPriceUom(ShipmentCostEstimate shipmentCostEstimate) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						shipmentCostEstimate.getPriceUomId())),
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
	 * Get to geo
	 */
	public Optional<Geo> getToGeo(ShipmentCostEstimate shipmentCostEstimate) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						shipmentCostEstimate.getGeoIdTo())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Geo.fromValues(out.getListIt().getCompleteList());
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
	 * Get from geo
	 */
	public Optional<Geo> getFromGeo(ShipmentCostEstimate shipmentCostEstimate) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						shipmentCostEstimate.getGeoIdFrom())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Geo.fromValues(out.getListIt().getCompleteList());
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
	 * Get weight quantity break
	 */
	public Optional<QuantityBreak> getWeightQuantityBreak(
			ShipmentCostEstimate shipmentCostEstimate) {
		List<QuantityBreak> entityList = null;
		In in = new In();
		in.setEntityName(QuantityBreak.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityBreakId",
						EntityOperator.EQUALS, shipmentCostEstimate
								.getWeightBreakId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuantityBreak.fromValues(out.getListIt()
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
	 * Get quantity quantity break
	 */
	public Optional<QuantityBreak> getQuantityQuantityBreak(
			ShipmentCostEstimate shipmentCostEstimate) {
		List<QuantityBreak> entityList = null;
		In in = new In();
		in.setEntityName(QuantityBreak.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityBreakId",
						EntityOperator.EQUALS, shipmentCostEstimate
								.getQuantityBreakId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuantityBreak.fromValues(out.getListIt()
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
	 * Get price quantity break
	 */
	public Optional<QuantityBreak> getPriceQuantityBreak(
			ShipmentCostEstimate shipmentCostEstimate) {
		List<QuantityBreak> entityList = null;
		In in = new In();
		in.setEntityName(QuantityBreak.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityBreakId",
						EntityOperator.EQUALS, shipmentCostEstimate
								.getPriceBreakId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuantityBreak.fromValues(out.getListIt()
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