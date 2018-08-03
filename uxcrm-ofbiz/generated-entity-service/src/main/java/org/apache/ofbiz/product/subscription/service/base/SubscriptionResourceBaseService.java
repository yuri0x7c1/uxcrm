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
import org.apache.ofbiz.product.subscription.SubscriptionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.webapp.website.WebSite;
import org.apache.ofbiz.product.subscription.ProductSubscriptionResource;
import org.apache.ofbiz.product.subscription.Subscription;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SubscriptionResourceBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SubscriptionResourceBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SubscriptionResources
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SubscriptionResource.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SubscriptionResources
	 */
	public List<SubscriptionResource> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SubscriptionResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SubscriptionResource.NAME);
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
				entityList = SubscriptionResource.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SubscriptionResource
	 */
	public Optional<SubscriptionResource> findOne(Object subscriptionResourceId) {
		List<SubscriptionResource> entityList = null;
		In in = new In();
		in.setEntityName(SubscriptionResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionResourceId",
						EntityOperator.EQUALS, subscriptionResourceId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionResource.fromValues(out.getListIt()
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
	 * Get parent subscription resource
	 */
	public Optional<SubscriptionResource> getParentSubscriptionResource(
			SubscriptionResource subscriptionResource) {
		List<SubscriptionResource> entityList = null;
		In in = new In();
		in.setEntityName(SubscriptionResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionResourceId",
						EntityOperator.EQUALS, subscriptionResource
								.getParentResourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionResource.fromValues(out.getListIt()
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
	 * Get content
	 */
	public Optional<Content> getContent(
			SubscriptionResource subscriptionResource) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						subscriptionResource.getContentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Content.fromValues(out.getListIt()
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
	 * Get web site
	 */
	public Optional<WebSite> getWebSite(
			SubscriptionResource subscriptionResource) {
		List<WebSite> entityList = null;
		In in = new In();
		in.setEntityName(WebSite.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						subscriptionResource.getWebSiteId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSite.fromValues(out.getListIt()
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
	 * Get product subscription resources
	 */
	public List<ProductSubscriptionResource> getProductSubscriptionResources(
			SubscriptionResource subscriptionResource, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductSubscriptionResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductSubscriptionResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("subscriptionResourceId",
						EntityOperator.EQUALS, subscriptionResource
								.getSubscriptionResourceId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductSubscriptionResource.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get subscriptions
	 */
	public List<Subscription> getSubscriptions(
			SubscriptionResource subscriptionResource, Integer start,
			Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("subscriptionResourceId",
						EntityOperator.EQUALS, subscriptionResource
								.getSubscriptionResourceId())),
				EntityOperator.AND));
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
	 * Get child subscription resources
	 */
	public List<SubscriptionResource> getChildSubscriptionResources(
			SubscriptionResource subscriptionResource, Integer start,
			Integer number, List<String> orderBy) {
		List<SubscriptionResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SubscriptionResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentResourceId",
						EntityOperator.EQUALS, subscriptionResource
								.getSubscriptionResourceId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SubscriptionResource.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}