package org.apache.ofbiz.marketing.opportunity.service.base;

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
import org.apache.ofbiz.marketing.opportunity.SalesOpportunityAndRole;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SalesOpportunityAndRoleBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SalesOpportunityAndRoleBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SalesOpportunityAndRoles
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SalesOpportunityAndRole.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SalesOpportunityAndRoles
	 */
	public List<SalesOpportunityAndRole> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SalesOpportunityAndRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesOpportunityAndRole.NAME);
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
				entityList = SalesOpportunityAndRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SalesOpportunityAndRole
	 */
	public Optional<SalesOpportunityAndRole> findOne(Object partyId,
			Object roleTypeId, Object salesOpportunityId) {
		List<SalesOpportunityAndRole> entityList = null;
		In in = new In();
		in.setEntityName(SalesOpportunityAndRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyId), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, roleTypeId), new EntityExpr(
						"salesOpportunityId", EntityOperator.EQUALS,
						salesOpportunityId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunityAndRole.fromValues(out.getListIt()
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