package org.apache.ofbiz.common.status.service.base;

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
import org.apache.ofbiz.common.status.StatusValidChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.shipment.picklist.PicklistStatusHistory;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class StatusValidChangeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public StatusValidChangeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count StatusValidChanges
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(StatusValidChange.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find StatusValidChanges
	 */
	public List<StatusValidChange> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<StatusValidChange> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(StatusValidChange.NAME);
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
				entityList = StatusValidChange.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one StatusValidChange
	 */
	public Optional<StatusValidChange> findOne(Object statusId,
			Object statusIdTo) {
		List<StatusValidChange> entityList = null;
		In in = new In();
		in.setEntityName(StatusValidChange.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						statusId), new EntityExpr("statusIdTo",
						EntityOperator.EQUALS, statusIdTo)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusValidChange.fromValues(out.getListIt()
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
	 * Get main status item
	 */
	public Optional<StatusItem> getMainStatusItem(
			StatusValidChange statusValidChange) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						statusValidChange.getStatusId())), EntityOperator.AND));
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
	 * Get to status item
	 */
	public Optional<StatusItem> getToStatusItem(
			StatusValidChange statusValidChange) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						statusValidChange.getStatusIdTo())), EntityOperator.AND));
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
	 * Get picklist status histories
	 */
	public List<PicklistStatusHistory> getPicklistStatusHistories(
			StatusValidChange statusValidChange, Integer start, Integer number,
			List<String> orderBy) {
		List<PicklistStatusHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PicklistStatusHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("statusId", EntityOperator.EQUALS,
						statusValidChange.getStatusId()),
				new EntityExpr("statusIdTo", EntityOperator.EQUALS,
						statusValidChange.getStatusIdTo())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PicklistStatusHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}