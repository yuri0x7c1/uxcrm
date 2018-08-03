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
import org.apache.ofbiz.shipment.shipment.ShipmentGatewayConfigType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.shipment.shipment.ShipmentGatewayConfig;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ShipmentGatewayConfigTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ShipmentGatewayConfigTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ShipmentGatewayConfigTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ShipmentGatewayConfigType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ShipmentGatewayConfigTypes
	 */
	public List<ShipmentGatewayConfigType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ShipmentGatewayConfigType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentGatewayConfigType.NAME);
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
				entityList = ShipmentGatewayConfigType.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ShipmentGatewayConfigType
	 */
	public Optional<ShipmentGatewayConfigType> findOne(
			Object shipmentGatewayConfTypeId) {
		List<ShipmentGatewayConfigType> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentGatewayConfigType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentGatewayConfTypeId",
						EntityOperator.EQUALS, shipmentGatewayConfTypeId)),
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
	 * Get parent shipment gateway config type
	 */
	public Optional<ShipmentGatewayConfigType> getParentShipmentGatewayConfigType(
			ShipmentGatewayConfigType shipmentGatewayConfigType) {
		List<ShipmentGatewayConfigType> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentGatewayConfigType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentGatewayConfTypeId",
						EntityOperator.EQUALS, shipmentGatewayConfigType
								.getParentTypeId())), EntityOperator.AND));
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
	 * Get sibling shipment gateway config types
	 */
	public List<ShipmentGatewayConfigType> getSiblingShipmentGatewayConfigTypes(
			ShipmentGatewayConfigType shipmentGatewayConfigType, Integer start,
			Integer number, List<String> orderBy) {
		List<ShipmentGatewayConfigType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentGatewayConfigType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						shipmentGatewayConfigType.getParentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentGatewayConfigType.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shipment gateway configs
	 */
	public List<ShipmentGatewayConfig> getShipmentGatewayConfigs(
			ShipmentGatewayConfigType shipmentGatewayConfigType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentGatewayConfTypeId",
						EntityOperator.EQUALS, shipmentGatewayConfigType
								.getShipmentGatewayConfTypeId())),
				EntityOperator.AND));
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
	 * Get child shipment gateway config types
	 */
	public List<ShipmentGatewayConfigType> getChildShipmentGatewayConfigTypes(
			ShipmentGatewayConfigType shipmentGatewayConfigType, Integer start,
			Integer number, List<String> orderBy) {
		List<ShipmentGatewayConfigType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentGatewayConfigType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						shipmentGatewayConfigType
								.getShipmentGatewayConfTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentGatewayConfigType.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}