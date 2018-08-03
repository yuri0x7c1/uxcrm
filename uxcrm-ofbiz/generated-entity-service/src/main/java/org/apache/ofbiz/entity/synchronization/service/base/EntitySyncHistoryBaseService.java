package org.apache.ofbiz.entity.synchronization.service.base;

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
import org.apache.ofbiz.entity.synchronization.EntitySyncHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.entity.synchronization.EntitySync;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EntitySyncHistoryBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EntitySyncHistoryBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EntitySyncHistories
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EntitySyncHistory.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EntitySyncHistories
	 */
	public List<EntitySyncHistory> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<EntitySyncHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EntitySyncHistory.NAME);
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
				entityList = EntitySyncHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EntitySyncHistory
	 */
	public Optional<EntitySyncHistory> findOne(Object entitySyncId,
			Object startDate) {
		List<EntitySyncHistory> entityList = null;
		In in = new In();
		in.setEntityName(EntitySyncHistory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySyncId), new EntityExpr("startDate",
						EntityOperator.EQUALS, startDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EntitySyncHistory.fromValues(out.getListIt()
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
	 * Get entity sync
	 */
	public Optional<EntitySync> getEntitySync(
			EntitySyncHistory entitySyncHistory) {
		List<EntitySync> entityList = null;
		In in = new In();
		in.setEntityName(EntitySync.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySyncHistory.getEntitySyncId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EntitySync.fromValues(out.getListIt()
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
	 * Get last entity sync
	 */
	public Optional<EntitySync> getLastEntitySync(
			EntitySyncHistory entitySyncHistory) {
		List<EntitySync> entityList = null;
		In in = new In();
		in.setEntityName(EntitySync.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySyncHistory.getEntitySyncId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EntitySync.fromValues(out.getListIt()
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