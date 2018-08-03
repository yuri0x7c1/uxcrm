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
import org.apache.ofbiz.order.request.CustRequestAndCommEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.request.CustRequest;
import org.apache.ofbiz.party.communication.CommunicationEvent;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CustRequestAndCommEventBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CustRequestAndCommEventBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CustRequestAndCommEvents
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CustRequestAndCommEvent.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CustRequestAndCommEvents
	 */
	public List<CustRequestAndCommEvent> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<CustRequestAndCommEvent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestAndCommEvent.NAME);
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
				entityList = CustRequestAndCommEvent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CustRequestAndCommEvent
	 */
	public Optional<CustRequestAndCommEvent> findOne(
			Object communicationEventId, Object custRequestId) {
		List<CustRequestAndCommEvent> entityList = null;
		In in = new In();
		in.setEntityName(CustRequestAndCommEvent.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("communicationEventId", EntityOperator.EQUALS,
						communicationEventId), new EntityExpr("custRequestId",
						EntityOperator.EQUALS, custRequestId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestAndCommEvent.fromValues(out.getListIt()
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
	 * Get cust request
	 */
	public Optional<CustRequest> getCustRequest(
			CustRequestAndCommEvent custRequestAndCommEvent) {
		List<CustRequest> entityList = null;
		In in = new In();
		in.setEntityName(CustRequest.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequestAndCommEvent.getCustRequestId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequest.fromValues(out.getListIt()
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
	 * Get communication event
	 */
	public Optional<CommunicationEvent> getCommunicationEvent(
			CustRequestAndCommEvent custRequestAndCommEvent) {
		List<CommunicationEvent> entityList = null;
		In in = new In();
		in.setEntityName(CommunicationEvent.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("communicationEventId",
						EntityOperator.EQUALS, custRequestAndCommEvent
								.getCommunicationEventId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommunicationEvent.fromValues(out.getListIt()
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