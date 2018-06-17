package com.github.yuri0x7c1.uxcrm.content.ui.view;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.content.content.service.ContentService;
import org.apache.ofbiz.content.website.WebSiteContent;
import org.apache.ofbiz.content.website.service.WebSiteContentService;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.apache.ofbiz.webapp.website.WebSite;
import org.apache.ofbiz.webapp.website.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;

import com.github.yuri0x7c1.uxcrm.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxcrm.common.ui.tree.StringTreeNode;
import com.github.yuri0x7c1.uxcrm.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxcrm.content.ui.menu.category.ContentCategories;
import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Tree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MenuItem(parentId = ContentCategories.CONTENT, caption=ContentTreeView.NAME, icon=VaadinIcons.FILE_TREE, order = 1)
@UIScope
@SpringView(name =  ContentTreeView.NAME)
public class ContentTreeView extends CommonView implements View {

	public static final String NAME = "Content Tree";

	@Autowired
	I18N i18n;

	@Autowired
	WebSiteService webSiteService;

	@Autowired
	WebSiteContentService webSiteContentService;

	@Autowired
	ContentService contentService;

	private Tree<StringTreeNode> tree = new Tree<>();

	private final TreeData<StringTreeNode> treeData = new TreeData<>();

	@PostConstruct
	public void init() {

		setHeaderText(ContentTreeView.NAME);

		List<WebSite> webSites = webSiteService.find(0, 1000, null, null);

		for (WebSite webSite : webSites) {
			StringTreeNode webSiteNode = new StringTreeNode(webSite.getSiteName() + "[" + webSite.getWebSiteId() + "]");
			treeData.addItem(null, webSiteNode);

			// TODO: multiple service call , need to optimize
			List<WebSiteContent> webSiteContents = webSiteContentService.find(
				0,
				1000,
				null,
				new EntityConditionList<EntityCondition>(
					Arrays.asList(new EntityExpr(WebSiteContent.Fields.webSiteId.name(), EntityOperator.EQUALS, webSite.getWebSiteId())),
					EntityOperator.AND
				)
			);

			for (WebSiteContent webSiteContent : webSiteContents) {
				Content content = webSiteContentService.getContent(webSiteContent);
				StringTreeNode contentNode = new StringTreeNode(content.getContentName() + "[" + content.getContentId() + "]");
				treeData.addItem(
					webSiteNode,
					contentNode
				);

				List<Content> subContents = contentService.getSubContents(content);
				for (Content subContent : subContents) {
					treeData.addItem(
						contentNode,
						new StringTreeNode(subContent.getContentName() + "[" + subContent.getContentId() + "]")
					);
				}
			}
		}

		tree.setDataProvider(new TreeDataProvider<>(treeData));
		addComponent(tree);
	}

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
