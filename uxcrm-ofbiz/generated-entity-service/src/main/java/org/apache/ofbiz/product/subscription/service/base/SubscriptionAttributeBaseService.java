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
import org.apache.ofbiz.product.subscription.SubscriptionAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.subscription.Subscription;
import org.apache.ofbiz.product.subscription.SubscriptionTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SubscriptionAttributeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SubscriptionAttributeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SubscriptionAttributes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SubscriptionAttribute.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SubscriptionAttributes
	 */
	public List<SubscriptionAttribute> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SubscriptionAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SubscriptionAttribute.NAME);
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
				entityList = SubscriptionAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SubscriptionAttribute
	 */
	public Optional<SubscriptionAttribute> findOne(Object subscriptionId,
			Object attrName) {
		List<SubscriptionAttribute> entityList = null;
		In in = new In();
		in.setEntityName(SubscriptionAttribute.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("subscriptionId", EntityOperator.EQUALS,
						subscriptionId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionAttribute.fromValues(out.getListIt()
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
			SubscriptionAttribute subscriptionAttribute) {
		List<Subscription> entityList = null;
		In in = new In();
		in.setEntityName(Subscription.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionId", EntityOperator.EQUALS,
						subscriptionAttribute.getSubscriptionId())),
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
	 * Get subscription type attrs
	 */
	public List<SubscriptionTypeAttr> getSubscriptionTypeAttrs(
			SubscriptionAttribute subscriptionAttribute, Integer start,
			Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						subscriptionAttribute.getAttrName())),
				EntityOperator.AND));
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