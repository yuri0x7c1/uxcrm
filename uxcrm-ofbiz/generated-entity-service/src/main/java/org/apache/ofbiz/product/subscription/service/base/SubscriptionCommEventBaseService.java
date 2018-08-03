package org.apache.ofbiz.product.subscription.service.base;

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
import org.apache.ofbiz.product.subscription.SubscriptionCommEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.communication.CommunicationEvent;
import org.apache.ofbiz.product.subscription.Subscription;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SubscriptionCommEventBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SubscriptionCommEventBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SubscriptionCommEvents
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SubscriptionCommEvent.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SubscriptionCommEvents
	 */
	public List<SubscriptionCommEvent> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SubscriptionCommEvent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SubscriptionCommEvent.NAME);
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
				entityList = SubscriptionCommEvent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SubscriptionCommEvent
	 */
	public Optional<SubscriptionCommEvent> findOne(Object subscriptionId,
			Object communicationEventId) {
		List<SubscriptionCommEvent> entityList = null;
		In in = new In();
		in.setEntityName(SubscriptionCommEvent.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("subscriptionId", EntityOperator.EQUALS,
						subscriptionId), new EntityExpr("communicationEventId",
						EntityOperator.EQUALS, communicationEventId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionCommEvent.fromValues(out.getListIt()
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
			SubscriptionCommEvent subscriptionCommEvent) {
		List<CommunicationEvent> entityList = null;
		In in = new In();
		in.setEntityName(CommunicationEvent.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("communicationEventId",
						EntityOperator.EQUALS, subscriptionCommEvent
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

	/**
	 * Get subscription
	 */
	public Optional<Subscription> getSubscription(
			SubscriptionCommEvent subscriptionCommEvent) {
		List<Subscription> entityList = null;
		In in = new In();
		in.setEntityName(Subscription.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionId", EntityOperator.EQUALS,
						subscriptionCommEvent.getSubscriptionId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Subscription.fromValues(out.getListIt()
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