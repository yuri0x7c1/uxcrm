package org.apache.ofbiz.humanres.position.service.base;

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
import org.apache.ofbiz.humanres.position.EmplPositionFulfillment;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.position.EmplPosition;
import org.apache.ofbiz.party.party.Party;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EmplPositionFulfillmentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EmplPositionFulfillmentBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EmplPositionFulfillments
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EmplPositionFulfillment.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EmplPositionFulfillments
	 */
	public List<EmplPositionFulfillment> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<EmplPositionFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionFulfillment.NAME);
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
				entityList = EmplPositionFulfillment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EmplPositionFulfillment
	 */
	public Optional<EmplPositionFulfillment> findOne(Object emplPositionId,
			Object partyId, Object fromDate) {
		List<EmplPositionFulfillment> entityList = null;
		In in = new In();
		in.setEntityName(EmplPositionFulfillment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPositionId), new EntityExpr("partyId",
						EntityOperator.EQUALS, partyId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionFulfillment.fromValues(out.getListIt()
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
	 * Get empl position
	 */
	public Optional<EmplPosition> getEmplPosition(
			EmplPositionFulfillment emplPositionFulfillment) {
		List<EmplPosition> entityList = null;
		In in = new In();
		in.setEntityName(EmplPosition.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionId", EntityOperator.EQUALS,
						emplPositionFulfillment.getEmplPositionId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPosition.fromValues(out.getListIt()
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
	 * Get party
	 */
	public Optional<Party> getParty(
			EmplPositionFulfillment emplPositionFulfillment) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						emplPositionFulfillment.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party
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
}