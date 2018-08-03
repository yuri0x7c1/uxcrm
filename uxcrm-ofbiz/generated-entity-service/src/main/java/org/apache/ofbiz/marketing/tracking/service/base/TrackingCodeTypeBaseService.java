package org.apache.ofbiz.marketing.tracking.service.base;

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
import org.apache.ofbiz.marketing.tracking.TrackingCodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.marketing.tracking.TrackingCode;
import org.apache.ofbiz.marketing.tracking.TrackingCodeOrder;
import org.apache.ofbiz.marketing.tracking.TrackingCodeOrderReturn;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TrackingCodeTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TrackingCodeTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TrackingCodeTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TrackingCodeType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TrackingCodeTypes
	 */
	public List<TrackingCodeType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TrackingCodeType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TrackingCodeType.NAME);
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
				entityList = TrackingCodeType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TrackingCodeType
	 */
	public Optional<TrackingCodeType> findOne(Object trackingCodeTypeId) {
		List<TrackingCodeType> entityList = null;
		In in = new In();
		in.setEntityName(TrackingCodeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("trackingCodeTypeId",
						EntityOperator.EQUALS, trackingCodeTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TrackingCodeType.fromValues(out.getListIt()
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
	 * Get tracking codes
	 */
	public List<TrackingCode> getTrackingCodes(
			TrackingCodeType trackingCodeType, Integer start, Integer number,
			List<String> orderBy) {
		List<TrackingCode> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TrackingCode.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("trackingCodeTypeId",
						EntityOperator.EQUALS, trackingCodeType
								.getTrackingCodeTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TrackingCode.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tracking code orders
	 */
	public List<TrackingCodeOrder> getTrackingCodeOrders(
			TrackingCodeType trackingCodeType, Integer start, Integer number,
			List<String> orderBy) {
		List<TrackingCodeOrder> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TrackingCodeOrder.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("trackingCodeTypeId",
						EntityOperator.EQUALS, trackingCodeType
								.getTrackingCodeTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TrackingCodeOrder.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tracking code order returns
	 */
	public List<TrackingCodeOrderReturn> getTrackingCodeOrderReturns(
			TrackingCodeType trackingCodeType, Integer start, Integer number,
			List<String> orderBy) {
		List<TrackingCodeOrderReturn> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TrackingCodeOrderReturn.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("trackingCodeTypeId",
						EntityOperator.EQUALS, trackingCodeType
								.getTrackingCodeTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TrackingCodeOrderReturn.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}