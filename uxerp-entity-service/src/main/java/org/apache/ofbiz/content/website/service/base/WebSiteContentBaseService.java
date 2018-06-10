package org.apache.ofbiz.content.website.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.common.ExecuteFindService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;
import org.apache.ofbiz.content.website.WebSiteContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.webapp.website.WebSite;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.content.website.WebSiteContentType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WebSiteContentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WebSiteContentBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WebSiteContents
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WebSiteContent.NAME);
		if (conditions == null) {
			in.setNoConditionFind(FindUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WebSiteContents
	 */
	public List<WebSiteContent> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<WebSiteContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(WebSiteContent.NAME);
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(FindUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one WebSiteContent
	 */
	public WebSiteContent findOne(Object webSiteId, Object contentId,
			Object webSiteContentTypeId, Object fromDate) {
		List<WebSiteContent> entityList = null;
		In in = new In();
		in.setEntityName(WebSiteContent.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("webSiteId", EntityOperator.EQUALS, webSiteId),
				new EntityExpr("contentId", EntityOperator.EQUALS, contentId),
				new EntityExpr("webSiteContentTypeId", EntityOperator.EQUALS,
						webSiteContentTypeId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSiteContent.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get web site
	 */
	public WebSite getWebSite(WebSiteContent webSiteContent) {
		List<WebSite> entityList = null;
		In in = new In();
		in.setEntityName(WebSite.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteId", EntityOperator.EQUALS,
						webSiteContent.getWebSiteId())), EntityOperator.AND));
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
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get content
	 */
	public Content getContent(WebSiteContent webSiteContent) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						webSiteContent.getContentId())), EntityOperator.AND));
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
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get web site content type
	 */
	public WebSiteContentType getWebSiteContentType(
			WebSiteContent webSiteContent) {
		List<WebSiteContentType> entityList = null;
		In in = new In();
		in.setEntityName(WebSiteContentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webSiteContentTypeId",
						EntityOperator.EQUALS, webSiteContent
								.getWebSiteContentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSiteContentType.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}
}