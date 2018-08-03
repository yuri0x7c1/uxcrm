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
import org.apache.ofbiz.entity.synchronization.EntitySyncIncludeGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.entity.group.EntityGroup;
import org.apache.ofbiz.entity.synchronization.EntitySync;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EntitySyncIncludeGroupBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EntitySyncIncludeGroupBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EntitySyncIncludeGroups
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EntitySyncIncludeGroup.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EntitySyncIncludeGroups
	 */
	public List<EntitySyncIncludeGroup> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one EntitySyncIncludeGroup
	 */
	public Optional<EntitySyncIncludeGroup> findOne(Object entitySyncId,
			Object entityGroupId) {
		List<EntitySyncIncludeGroup> entityList = null;
		In in = new In();
		in.setEntityName(EntitySyncIncludeGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySyncId), new EntityExpr("entityGroupId",
						EntityOperator.EQUALS, entityGroupId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EntitySyncIncludeGroup.fromValues(out.getListIt()
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
	 * Get entity group
	 */
	public Optional<EntityGroup> getEntityGroup(
			EntitySyncIncludeGroup entitySyncIncludeGroup) {
		List<EntityGroup> entityList = null;
		In in = new In();
		in.setEntityName(EntityGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entityGroupId", EntityOperator.EQUALS,
						entitySyncIncludeGroup.getEntityGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EntityGroup.fromValues(out.getListIt()
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
			EntitySyncIncludeGroup entitySyncIncludeGroup) {
		List<EntitySync> entityList = null;
		In in = new In();
		in.setEntityName(EntitySync.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySyncIncludeGroup.getEntitySyncId())),
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