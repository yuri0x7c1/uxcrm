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
import org.apache.ofbiz.product.subscription.SubscriptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.subscription.Subscription;
import org.apache.ofbiz.product.subscription.SubscriptionTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SubscriptionTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SubscriptionTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SubscriptionTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SubscriptionType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SubscriptionTypes
	 */
	public List<SubscriptionType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SubscriptionType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SubscriptionType.NAME);
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
				entityList = SubscriptionType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SubscriptionType
	 */
	public Optional<SubscriptionType> findOne(Object subscriptionTypeId) {
		List<SubscriptionType> entityList = null;
		In in = new In();
		in.setEntityName(SubscriptionType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionTypeId",
						EntityOperator.EQUALS, subscriptionTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionType.fromValues(out.getListIt()
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
	 * Get parent subscription type
	 */
	public Optional<SubscriptionType> getParentSubscriptionType(
			SubscriptionType subscriptionType) {
		List<SubscriptionType> entityList = null;
		In in = new In();
		in.setEntityName(SubscriptionType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionTypeId",
						EntityOperator.EQUALS, subscriptionType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionType.fromValues(out.getListIt()
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
	 * Get subscriptions
	 */
	public List<Subscription> getSubscriptions(
			SubscriptionType subscriptionType, Integer start, Integer number,
			List<String> orderBy) {
		List<Subscription> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionTypeId",
						EntityOperator.EQUALS, subscriptionType
								.getSubscriptionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Subscription.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child subscription types
	 */
	public List<SubscriptionType> getChildSubscriptionTypes(
			SubscriptionType subscriptionType, Integer start, Integer number,
			List<String> orderBy) {
		List<SubscriptionType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SubscriptionType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						subscriptionType.getSubscriptionTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get subscription type attrs
	 */
	public List<SubscriptionTypeAttr> getSubscriptionTypeAttrs(
			SubscriptionType subscriptionType, Integer start, Integer number,
			List<String> orderBy) {
		List<SubscriptionTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SubscriptionTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionTypeId",
						EntityOperator.EQUALS, subscriptionType
								.getSubscriptionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}