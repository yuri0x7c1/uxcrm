package org.apache.ofbiz.webapp.website.service.base;

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
import org.apache.ofbiz.webapp.website.WebSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.theme.VisualThemeSet;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.product.subscription.SubscriptionResource;
import org.apache.ofbiz.content.website.WebAnalyticsConfig;
import org.apache.ofbiz.webapp.website.WebPage;
import org.apache.ofbiz.marketing.contact.WebSiteContactList;
import org.apache.ofbiz.content.website.WebSiteContent;
import org.apache.ofbiz.content.website.WebSitePathAlias;
import org.apache.ofbiz.party.party.WebSiteRole;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WebSiteBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WebSiteBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WebSites
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WebSite.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WebSites
	 */
	public List<WebSite> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<WebSite> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebSite.NAME);
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
				entityList = WebSite.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one WebSite
	 */
	public Optional<WebSite> findOne(Object webSiteId) {
		List<WebSite> entityList = null;
		In in = new In();
		in.setEntityName(WebSite.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSiteId)), EntityOperator.AND));
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
	 * Get visual theme set
	 */
	public Optional<VisualThemeSet> getVisualThemeSet(WebSite webSite) {
		List<VisualThemeSet> entityList = null;
		In in = new In();
		in.setEntityName(VisualThemeSet.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("visualThemeSetId",
						EntityOperator.EQUALS, webSite.getVisualThemeSetId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VisualThemeSet.fromValues(out.getListIt()
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
	 * Get product store
	 */
	public Optional<ProductStore> getProductStore(WebSite webSite) {
		List<ProductStore> entityList = null;
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreId", EntityOperator.EQUALS,
						webSite.getProductStoreId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
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
	 * Get subscription resources
	 */
	public List<SubscriptionResource> getSubscriptionResources(WebSite webSite,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSite.getWebSiteId())), EntityOperator.AND));
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
	 * Get web analytics configs
	 */
	public List<WebAnalyticsConfig> getWebAnalyticsConfigs(WebSite webSite,
			Integer start, Integer number, List<String> orderBy) {
		List<WebAnalyticsConfig> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebAnalyticsConfig.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSite.getWebSiteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebAnalyticsConfig.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web pages
	 */
	public List<WebPage> getWebPages(WebSite webSite, Integer start,
			Integer number, List<String> orderBy) {
		List<WebPage> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebPage.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSite.getWebSiteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebPage.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web site contact lists
	 */
	public List<WebSiteContactList> getWebSiteContactLists(WebSite webSite,
			Integer start, Integer number, List<String> orderBy) {
		List<WebSiteContactList> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebSiteContactList.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSite.getWebSiteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSiteContactList.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web site contents
	 */
	public List<WebSiteContent> getWebSiteContents(WebSite webSite,
			Integer start, Integer number, List<String> orderBy) {
		List<WebSiteContent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebSiteContent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSite.getWebSiteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSiteContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web site path aliases
	 */
	public List<WebSitePathAlias> getWebSitePathAliases(WebSite webSite,
			Integer start, Integer number, List<String> orderBy) {
		List<WebSitePathAlias> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebSitePathAlias.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSite.getWebSiteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSitePathAlias.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web site roles
	 */
	public List<WebSiteRole> getWebSiteRoles(WebSite webSite, Integer start,
			Integer number, List<String> orderBy) {
		List<WebSiteRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebSiteRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSite.getWebSiteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSiteRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}