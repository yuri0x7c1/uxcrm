package com.github.yuri0x7c1.uxerp.content.ui.view;

import java.util.List;

import org.apache.ofbiz.content.content.entity.Content;
import org.apache.ofbiz.content.website.entity.WebSiteContent;
import org.apache.ofbiz.webapp.website.entity.WebSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;

import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;
import com.github.yuri0x7c1.uxerp.common.find.util.InputFieldBuilder;
import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.tree.StringTreeNode;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.content.service.ContentBaseService;
import com.github.yuri0x7c1.uxerp.content.service.ContentService;
import com.github.yuri0x7c1.uxerp.content.service.WebSiteBaseService;
import com.github.yuri0x7c1.uxerp.content.service.WebSiteContentBaseService;
import com.github.yuri0x7c1.uxerp.content.service.WebSiteContentService;
import com.github.yuri0x7c1.uxerp.content.ui.config.CmsSections;
import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Tree;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unchecked")
@Slf4j
// @VaadinFontIcon(VaadinIcons.EDIT)
@MenuItem(categoryId = CmsSections.CMS, caption=ContentTreeView.NAME, order = 2)
@UIScope
@SpringView(name = ContentTreeView.NAME)
public class ContentTreeView  extends CommonView implements View {
	public static final String NAME = "ContentTree";

	private Tree<StringTreeNode> tree = new Tree<>();

	private final TreeData<StringTreeNode> treeData = new TreeData<>();

	@Autowired
	public ContentTreeView(I18N i18n, WebSiteContentService webSiteContentService, ContentService contentService,
			WebSiteBaseService webSiteBaseService,
			WebSiteContentBaseService webSiteContentBaseService,
			ContentBaseService contentBaseService) {

		setHeaderText(ContentTreeView.NAME);

		List<WebSite> webSites = webSiteBaseService.find(null, null, WebSite.Fields.webSiteId.name(), null);

		for (WebSite webSite : webSites) {
			StringTreeNode webSiteNode = new StringTreeNode(webSite.getSiteName() + "[" + webSite.getWebSiteId() + "]");
			treeData.addItem(null, webSiteNode);

			// TODO: multiple service call , need to optimize
			List<WebSiteContent> webSiteContents = webSiteContentBaseService.find(null, null, null,
					new InputFieldBuilder()
						.addInputField(WebSiteContent.Fields.webSiteId.name(), FindUtil.OPTION_EQUALS, false, webSite.getWebSiteId())
						.build());

			for (WebSiteContent webSiteContent : webSiteContents) {
				Content content = webSiteContentBaseService.getContent(webSiteContent);
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
