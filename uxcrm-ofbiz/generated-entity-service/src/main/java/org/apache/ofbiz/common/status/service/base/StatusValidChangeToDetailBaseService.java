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
import org.apache.ofbiz.common.status.StatusValidChangeToDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.status.StatusValidChange;
import org.apache.ofbiz.common.status.StatusItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class StatusValidChangeToDetailBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public StatusValidChangeToDetailBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count StatusValidChangeToDetails
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(StatusValidChangeToDetail.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find StatusValidChangeToDetails
	 */
	public List<StatusValidChangeToDetail> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<StatusValidChangeToDetail> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(StatusValidChangeToDetail.NAME);
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
				entityList = StatusValidChangeToDetail.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one StatusValidChangeToDetail
	 */
	public Optional<StatusValidChangeToDetail> findOne(Object statusId,
			Object statusIdTo) {
		List<StatusValidChangeToDetail> entityList = null;
		In in = new In();
		in.setEntityName(StatusValidChangeToDetail.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						statusId), new EntityExpr("statusIdTo",
						EntityOperator.EQUALS, statusIdTo)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusValidChangeToDetail.fromValues(out
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
	 * Get status valid change
	 */
	public Optional<StatusValidChange> getStatusValidChange(
			StatusValidChangeToDetail statusValidChangeToDetail) {
		List<StatusValidChange> entityList = null;
		In in = new In();
		in.setEntityName(StatusValidChange.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("statusId", EntityOperator.EQUALS,
						statusValidChangeToDetail.getStatusId()),
				new EntityExpr("statusIdTo", EntityOperator.EQUALS,
						statusValidChangeToDetail.getStatusIdTo())),
				EntityOperator.AND));
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
	 * Get status item
	 */
	public Optional<StatusItem> getStatusItem(
			StatusValidChangeToDetail statusValidChangeToDetail) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						statusValidChangeToDetail.getStatusId())),
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
}