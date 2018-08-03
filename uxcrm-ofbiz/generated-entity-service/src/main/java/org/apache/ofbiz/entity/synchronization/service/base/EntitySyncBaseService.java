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
import org.apache.ofbiz.entity.synchronization.EntitySync;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.entity.synchronization.EntitySyncInclGrpDetailView;
import org.apache.ofbiz.entity.synchronization.EntitySyncHistory;
import org.apache.ofbiz.entity.synchronization.EntitySyncInclude;
import org.apache.ofbiz.entity.synchronization.EntitySyncIncludeGroup;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EntitySyncBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EntitySyncBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EntitySyncs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EntitySync.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EntitySyncs
	 */
	public List<EntitySync> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<EntitySync> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EntitySync.NAME);
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
				entityList = EntitySync.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EntitySync
	 */
	public Optional<EntitySync> findOne(Object entitySyncId) {
		List<EntitySync> entityList = null;
		In in = new In();
		in.setEntityName(EntitySync.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySyncId)), EntityOperator.AND));
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
	 * Get entity sync incl grp detail views
	 */
	public List<EntitySyncInclGrpDetailView> getEntitySyncInclGrpDetailViews(
			EntitySync entitySync, Integer start, Integer number,
			List<String> orderBy) {
		List<EntitySyncInclGrpDetailView> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EntitySyncInclGrpDetailView.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySync.getEntitySyncId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EntitySyncInclGrpDetailView.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get last entity sync history
	 */
	public Optional<EntitySyncHistory> getLastEntitySyncHistory(
			EntitySync entitySync) {
		List<EntitySyncHistory> entityList = null;
		In in = new In();
		in.setEntityName(EntitySyncHistory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySync.getEntitySyncId()),
				new EntityExpr("startDate", EntityOperator.EQUALS, entitySync
						.getLastHistoryStartDate())), EntityOperator.AND));
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
	 * Get entity sync histories
	 */
	public List<EntitySyncHistory> getEntitySyncHistories(
			EntitySync entitySync, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySync.getEntitySyncId())), EntityOperator.AND));
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
	 * Get entity sync includes
	 */
	public List<EntitySyncInclude> getEntitySyncIncludes(EntitySync entitySync,
			Integer start, Integer number, List<String> orderBy) {
		List<EntitySyncInclude> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EntitySyncInclude.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySync.getEntitySyncId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EntitySyncInclude.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get entity sync include groups
	 */
	public List<EntitySyncIncludeGroup> getEntitySyncIncludeGroups(
			EntitySync entitySync, Integer start, Integer number,
			List<String> orderBy) {
		List<EntitySyncIncludeGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EntitySyncIncludeGroup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySync.getEntitySyncId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EntitySyncIncludeGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}