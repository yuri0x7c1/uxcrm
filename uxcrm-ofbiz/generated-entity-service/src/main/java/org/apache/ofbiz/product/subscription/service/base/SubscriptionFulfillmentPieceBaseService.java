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
import org.apache.ofbiz.product.subscription.SubscriptionFulfillmentPiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.subscription.Subscription;
import org.apache.ofbiz.product.subscription.SubscriptionActivity;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SubscriptionFulfillmentPieceBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SubscriptionFulfillmentPieceBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SubscriptionFulfillmentPieces
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SubscriptionFulfillmentPiece.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SubscriptionFulfillmentPieces
	 */
	public List<SubscriptionFulfillmentPiece> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<SubscriptionFulfillmentPiece> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SubscriptionFulfillmentPiece.NAME);
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
				entityList = SubscriptionFulfillmentPiece.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SubscriptionFulfillmentPiece
	 */
	public Optional<SubscriptionFulfillmentPiece> findOne(
			Object subscriptionActivityId, Object subscriptionId) {
		List<SubscriptionFulfillmentPiece> entityList = null;
		In in = new In();
		in.setEntityName(SubscriptionFulfillmentPiece.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("subscriptionActivityId", EntityOperator.EQUALS,
						subscriptionActivityId),
				new EntityExpr("subscriptionId", EntityOperator.EQUALS,
						subscriptionId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionFulfillmentPiece.fromValues(out
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

	/**
	 * Get subscription
	 */
	public Optional<Subscription> getSubscription(
			SubscriptionFulfillmentPiece subscriptionFulfillmentPiece) {
		List<Subscription> entityList = null;
		In in = new In();
		in.setEntityName(Subscription.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionId", EntityOperator.EQUALS,
						subscriptionFulfillmentPiece.getSubscriptionId())),
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

	/**
	 * Get subscription activity
	 */
	public Optional<SubscriptionActivity> getSubscriptionActivity(
			SubscriptionFulfillmentPiece subscriptionFulfillmentPiece) {
		List<SubscriptionActivity> entityList = null;
		In in = new In();
		in.setEntityName(SubscriptionActivity.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionActivityId",
						EntityOperator.EQUALS, subscriptionFulfillmentPiece
								.getSubscriptionActivityId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionActivity.fromValues(out.getListIt()
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