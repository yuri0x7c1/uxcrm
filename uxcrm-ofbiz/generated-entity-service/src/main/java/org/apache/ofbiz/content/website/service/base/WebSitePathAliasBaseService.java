package org.apache.ofbiz.content.website.service.base;

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
import org.apache.ofbiz.content.website.WebSitePathAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.webapp.website.WebSite;
import org.apache.ofbiz.content.content.Content;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WebSitePathAliasBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WebSitePathAliasBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WebSitePathAliases
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WebSitePathAlias.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WebSitePathAliases
	 */
	public List<WebSitePathAlias> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one WebSitePathAlias
	 */
	public Optional<WebSitePathAlias> findOne(Object webSiteId,
			Object pathAlias, Object fromDate) {
		List<WebSitePathAlias> entityList = null;
		In in = new In();
		in.setEntityName(WebSitePathAlias.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("webSiteId", EntityOperator.EQUALS, webSiteId),
				new EntityExpr("pathAlias", EntityOperator.EQUALS, pathAlias),
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSitePathAlias.fromValues(out.getListIt()
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
	public Optional<WebSite> getWebSite(WebSitePathAlias webSitePathAlias) {
		List<WebSite> entityList = null;
		In in = new In();
		in.setEntityName(WebSite.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSitePathAlias.getWebSiteId())), EntityOperator.AND));
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
	 * Get content
	 */
	public Optional<Content> getContent(WebSitePathAlias webSitePathAlias) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						webSitePathAlias.getContentId())), EntityOperator.AND));
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
}