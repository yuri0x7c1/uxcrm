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
import org.apache.ofbiz.shipment.shipment.ShipmentGatewayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.shipment.shipment.ShipmentGatewayConfigType;
import org.apache.ofbiz.product.store.ProductStoreShipmentMeth;
import org.apache.ofbiz.shipment.shipment.ShipmentGatewayDhl;
import org.apache.ofbiz.shipment.shipment.ShipmentGatewayFedex;
import org.apache.ofbiz.shipment.shipment.ShipmentGatewayUps;
import org.apache.ofbiz.shipment.shipment.ShipmentGatewayUsps;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ShipmentGatewayConfigBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ShipmentGatewayConfigBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ShipmentGatewayConfigs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ShipmentGatewayConfig.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ShipmentGatewayConfigs
	 */
	public List<ShipmentGatewayConfig> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ShipmentGatewayConfig> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentGatewayConfig.NAME);
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
				entityList = ShipmentGatewayConfig.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ShipmentGatewayConfig
	 */
	public Optional<ShipmentGatewayConfig> findOne(
			Object shipmentGatewayConfigId) {
		List<ShipmentGatewayConfig> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentGatewayConfig.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentGatewayConfigId",
						EntityOperator.EQUALS, shipmentGatewayConfigId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentGatewayConfig.fromValues(out.getListIt()
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
	 * Get shipment gateway config type
	 */
	public Optional<ShipmentGatewayConfigType> getShipmentGatewayConfigType(
			ShipmentGatewayConfig shipmentGatewayConfig) {
		List<ShipmentGatewayConfigType> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentGatewayConfigType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentGatewayConfTypeId",
						EntityOperator.EQUALS, shipmentGatewayConfig
								.getShipmentGatewayConfTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentGatewayConfigType.fromValues(out
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
	 * Get product store shipment meths
	 */
	public List<ProductStoreShipmentMeth> getProductStoreShipmentMeths(
			ShipmentGatewayConfig shipmentGatewayConfig, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductStoreShipmentMeth> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreShipmentMeth.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentGatewayConfigId",
						EntityOperator.EQUALS, shipmentGatewayConfig
								.getShipmentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreShipmentMeth.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shipment gateway dhl
	 */
	public Optional<ShipmentGatewayDhl> getShipmentGatewayDhl(
			ShipmentGatewayConfig shipmentGatewayConfig) {
		List<ShipmentGatewayDhl> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentGatewayDhl.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentGatewayConfigId",
						EntityOperator.EQUALS, shipmentGatewayConfig
								.getShipmentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentGatewayDhl.fromValues(out.getListIt()
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
	 * Get shipment gateway fedex
	 */
	public Optional<ShipmentGatewayFedex> getShipmentGatewayFedex(
			ShipmentGatewayConfig shipmentGatewayConfig) {
		List<ShipmentGatewayFedex> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentGatewayFedex.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentGatewayConfigId",
						EntityOperator.EQUALS, shipmentGatewayConfig
								.getShipmentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentGatewayFedex.fromValues(out.getListIt()
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
	 * Get shipment gateway ups
	 */
	public Optional<ShipmentGatewayUps> getShipmentGatewayUps(
			ShipmentGatewayConfig shipmentGatewayConfig) {
		List<ShipmentGatewayUps> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentGatewayUps.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentGatewayConfigId",
						EntityOperator.EQUALS, shipmentGatewayConfig
								.getShipmentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentGatewayUps.fromValues(out.getListIt()
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
	 * Get shipment gateway usps
	 */
	public Optional<ShipmentGatewayUsps> getShipmentGatewayUsps(
			ShipmentGatewayConfig shipmentGatewayConfig) {
		List<ShipmentGatewayUsps> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentGatewayUsps.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentGatewayConfigId",
						EntityOperator.EQUALS, shipmentGatewayConfig
								.getShipmentGatewayConfigId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentGatewayUsps.fromValues(out.getListIt()
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