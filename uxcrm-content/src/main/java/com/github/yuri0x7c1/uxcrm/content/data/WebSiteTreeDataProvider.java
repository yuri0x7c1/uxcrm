package com.github.yuri0x7c1.uxcrm.content.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.content.content.ContentAssocDataResourceViewFrom;
import org.apache.ofbiz.content.content.service.ContentAssocDataResourceViewFromService;
import org.apache.ofbiz.content.content.service.ContentService;
import org.apache.ofbiz.content.website.WebSiteContent;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.apache.ofbiz.webapp.website.WebSite;
import org.apache.ofbiz.webapp.website.service.WebSiteService;

import com.vaadin.data.provider.AbstractBackEndHierarchicalDataProvider;
import com.vaadin.data.provider.HierarchicalQuery;

public class WebSiteTreeDataProvider extends AbstractBackEndHierarchicalDataProvider<WebSiteTreeNode, WebSiteTreeFilter> {
	private final WebSite webSite;

	private final WebSiteService webSiteService;

	private final ContentService contentService;

	private final ContentAssocDataResourceViewFromService contentAssocDataResourceViewFromService;

	public WebSiteTreeDataProvider(
			WebSite webSite,
			WebSiteService webSiteService,
			ContentService contentService,
			ContentAssocDataResourceViewFromService contentAssocDataResourceViewFromService) {
		super();
		this.webSite = webSite;
		this.webSiteService = webSiteService;
		this.contentService = contentService;
		this.contentAssocDataResourceViewFromService = contentAssocDataResourceViewFromService;
	}

	@Override
	public int getChildCount(HierarchicalQuery<WebSiteTreeNode, WebSiteTreeFilter> query) {
		return (int) fetchChildren(query).count();
	}

	@Override
	public Stream<WebSiteTreeNode> fetchChildrenFromBackEnd(HierarchicalQuery<WebSiteTreeNode, WebSiteTreeFilter> query) {
		final WebSiteTreeNode parent = query.getParent();
		List<WebSiteTreeNode> nodes = new ArrayList<>();

		if (parent == null) {
			List<WebSiteContent> webSiteContents = webSiteService.getWebSiteContents(webSite, 0, 1000, null);
			for (WebSiteContent webSiteContent : webSiteContents) {
				Content content = contentService.findOne(webSiteContent.getContentId());

				nodes.add(WebSiteTreeNode.builder()
					.contentId(content.getContentId())
					.contentName(content.getContentName())
					.contentTypeId(content.getContentTypeId())
					.build()
				);
			}
		}
		else {
			List<ContentAssocDataResourceViewFrom> views = findChildContent(parent);

			views.forEach(view -> {
				nodes.add(WebSiteTreeNode.builder()
					.contentId(view.getContentId())
					.contentName(view.getContentName())
					.build()
				);
			});
		}
		return nodes.stream();
	}

	@Override
	public boolean hasChildren(WebSiteTreeNode item) {
		return !findChildContent(item).isEmpty();
	}

	/**
	 * Find child content
	 * @param parent
	 * @return
	 * TODO: move to service
	 */
	private List<ContentAssocDataResourceViewFrom> findChildContent(WebSiteTreeNode parent) {
		return contentAssocDataResourceViewFromService.find(
			0,
			1000,
			Arrays.asList(
				ContentAssocDataResourceViewFrom.Fields.caSequenceNum.name(),
				ContentAssocDataResourceViewFrom.Fields.caFromDate.name(),
				ContentAssocDataResourceViewFrom.Fields.createdDate.name()
			),
			new EntityConditionList<EntityCondition>(
				Arrays.asList(
					new EntityExpr(ContentAssocDataResourceViewFrom.Fields.caContentIdTo, EntityOperator.EQUALS, parent.getContentId()),
					new EntityExpr(ContentAssocDataResourceViewFrom.Fields.caContentAssocTypeId, EntityOperator.EQUALS, "SUB_CONTENT"),
					new EntityExpr(ContentAssocDataResourceViewFrom.Fields.caThruDate, EntityOperator.EQUALS, null)
				),
				EntityOperator.AND
			)
		);
	}
}