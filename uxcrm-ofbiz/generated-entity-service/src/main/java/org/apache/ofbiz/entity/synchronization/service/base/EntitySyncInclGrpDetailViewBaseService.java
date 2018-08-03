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
import org.apache.ofbiz.entity.synchronization.EntitySyncInclGrpDetailView;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EntitySyncInclGrpDetailViewBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EntitySyncInclGrpDetailViewBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EntitySyncInclGrpDetailViews
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EntitySyncInclGrpDetailView.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EntitySyncInclGrpDetailViews
	 */
	public List<EntitySyncInclGrpDetailView> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one EntitySyncInclGrpDetailView
	 */
	public Optional<EntitySyncInclGrpDetailView> findOne(Object entitySyncId,
			Object entityGroupId, Object entityOrPackage) {
		List<EntitySyncInclGrpDetailView> entityList = null;
		In in = new In();
		in.setEntityName(EntitySyncInclGrpDetailView.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("entitySyncId", EntityOperator.EQUALS,
						entitySyncId), new EntityExpr("entityGroupId",
						EntityOperator.EQUALS, entityGroupId), new EntityExpr(
						"entityOrPackage", EntityOperator.EQUALS,
						entityOrPackage)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EntitySyncInclGrpDetailView.fromValues(out
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
}