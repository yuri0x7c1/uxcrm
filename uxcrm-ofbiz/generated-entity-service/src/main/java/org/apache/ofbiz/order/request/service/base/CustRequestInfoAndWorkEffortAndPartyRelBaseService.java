package org.apache.ofbiz.order.request.service.base;

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
import org.apache.ofbiz.order.request.CustRequestInfoAndWorkEffortAndPartyRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CustRequestInfoAndWorkEffortAndPartyRelBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CustRequestInfoAndWorkEffortAndPartyRelBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CustRequestInfoAndWorkEffortAndPartyRels
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CustRequestInfoAndWorkEffortAndPartyRel.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CustRequestInfoAndWorkEffortAndPartyRels
	 */
	public List<CustRequestInfoAndWorkEffortAndPartyRel> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<CustRequestInfoAndWorkEffortAndPartyRel> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(CustRequestInfoAndWorkEffortAndPartyRel.NAME);
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
				entityList = CustRequestInfoAndWorkEffortAndPartyRel
						.fromValues(out.getListIt().getPartialList(start,
								number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CustRequestInfoAndWorkEffortAndPartyRel
	 */
	public Optional<CustRequestInfoAndWorkEffortAndPartyRel> findOne(
			Object partyIdFrom, Object roleTypeIdFrom, Object partyIdTo,
			Object roleTypeIdTo, Object custRequestId, Object workEffortId) {
		List<CustRequestInfoAndWorkEffortAndPartyRel> entityList = null;
		In in = new In();
		in.setEntityName(CustRequestInfoAndWorkEffortAndPartyRel.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						partyIdFrom), new EntityExpr("roleTypeIdFrom",
						EntityOperator.EQUALS, roleTypeIdFrom), new EntityExpr(
						"partyIdTo", EntityOperator.EQUALS, partyIdTo),
				new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						roleTypeIdTo), new EntityExpr("custRequestId",
						EntityOperator.EQUALS, custRequestId), new EntityExpr(
						"workEffortId", EntityOperator.EQUALS, workEffortId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestInfoAndWorkEffortAndPartyRel
						.fromValues(out.getListIt().getCompleteList());
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
	 * Get work effort
	 */
	public Optional<WorkEffort> getWorkEffort(
			CustRequestInfoAndWorkEffortAndPartyRel custRequestInfoAndWorkEffortAndPartyRel) {
		List<WorkEffort> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						custRequestInfoAndWorkEffortAndPartyRel
								.getWorkEffortId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
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