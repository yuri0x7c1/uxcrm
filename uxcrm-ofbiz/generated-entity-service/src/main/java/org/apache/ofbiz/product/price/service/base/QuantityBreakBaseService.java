package org.apache.ofbiz.product.price.service.base;

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
import org.apache.ofbiz.product.price.QuantityBreak;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.price.QuantityBreakType;
import org.apache.ofbiz.shipment.shipment.ShipmentCostEstimate;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class QuantityBreakBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public QuantityBreakBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count QuantityBreaks
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(QuantityBreak.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find QuantityBreaks
	 */
	public List<QuantityBreak> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<QuantityBreak> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuantityBreak.NAME);
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
				entityList = QuantityBreak.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one QuantityBreak
	 */
	public Optional<QuantityBreak> findOne(Object quantityBreakId) {
		List<QuantityBreak> entityList = null;
		In in = new In();
		in.setEntityName(QuantityBreak.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityBreakId",
						EntityOperator.EQUALS, quantityBreakId)),
				EntityOperator.AND));
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
	 * Get quantity break type
	 */
	public Optional<QuantityBreakType> getQuantityBreakType(
			QuantityBreak quantityBreak) {
		List<QuantityBreakType> entityList = null;
		In in = new In();
		in.setEntityName(QuantityBreakType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityBreakTypeId",
						EntityOperator.EQUALS, quantityBreak
								.getQuantityBreakTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuantityBreakType.fromValues(out.getListIt()
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
	 * Get weight shipment cost estimates
	 */
	public List<ShipmentCostEstimate> getWeightShipmentCostEstimates(
			QuantityBreak quantityBreak, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("weightBreakId", EntityOperator.EQUALS,
						quantityBreak.getQuantityBreakId())),
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
	 * Get quantity shipment cost estimates
	 */
	public List<ShipmentCostEstimate> getQuantityShipmentCostEstimates(
			QuantityBreak quantityBreak, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityBreakId",
						EntityOperator.EQUALS, quantityBreak
								.getQuantityBreakId())), EntityOperator.AND));
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
	 * Get price shipment cost estimates
	 */
	public List<ShipmentCostEstimate> getPriceShipmentCostEstimates(
			QuantityBreak quantityBreak, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("priceBreakId", EntityOperator.EQUALS,
						quantityBreak.getQuantityBreakId())),
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
}