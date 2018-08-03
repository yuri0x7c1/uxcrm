package org.apache.ofbiz.shipment.receipt.service.base;

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
import org.apache.ofbiz.shipment.receipt.RejectionReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.shipment.receipt.ShipmentReceipt;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class RejectionReasonBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public RejectionReasonBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count RejectionReasons
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(RejectionReason.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find RejectionReasons
	 */
	public List<RejectionReason> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<RejectionReason> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RejectionReason.NAME);
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
				entityList = RejectionReason.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one RejectionReason
	 */
	public Optional<RejectionReason> findOne(Object rejectionId) {
		List<RejectionReason> entityList = null;
		In in = new In();
		in.setEntityName(RejectionReason.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rejectionId", EntityOperator.EQUALS,
						rejectionId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RejectionReason.fromValues(out.getListIt()
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
	 * Get shipment receipts
	 */
	public List<ShipmentReceipt> getShipmentReceipts(
			RejectionReason rejectionReason, Integer start, Integer number,
			List<String> orderBy) {
		List<ShipmentReceipt> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentReceipt.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rejectionId", EntityOperator.EQUALS,
						rejectionReason.getRejectionId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentReceipt.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}