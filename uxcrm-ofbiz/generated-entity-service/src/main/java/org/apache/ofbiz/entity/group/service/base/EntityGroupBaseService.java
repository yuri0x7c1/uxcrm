package org.apache.ofbiz.entity.group.service.base;

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
import org.apache.ofbiz.entity.group.EntityGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.entity.group.EntityGroupEntry;
import org.apache.ofbiz.entity.synchronization.EntitySyncIncludeGroup;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EntityGroupBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EntityGroupBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EntityGroups
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EntityGroup.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EntityGroups
	 */
	public List<EntityGroup> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<EntityGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EntityGroup.NAME);
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
				entityList = EntityGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EntityGroup
	 */
	public Optional<EntityGroup> findOne(Object entityGroupId) {
		List<EntityGroup> entityList = null;
		In in = new In();
		in.setEntityName(EntityGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entityGroupId", EntityOperator.EQUALS,
						entityGroupId)), EntityOperator.AND));
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
	 * Get entity group entries
	 */
	public List<EntityGroupEntry> getEntityGroupEntries(
			EntityGroup entityGroup, Integer start, Integer number,
			List<String> orderBy) {
		List<EntityGroupEntry> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EntityGroupEntry.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("entityGroupId", EntityOperator.EQUALS,
						entityGroup.getEntityGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EntityGroupEntry.fromValues(out.getListIt()
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
			EntityGroup entityGroup, Integer start, Integer number,
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
				.asList(new EntityExpr("entityGroupId", EntityOperator.EQUALS,
						entityGroup.getEntityGroupId())), EntityOperator.AND));
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