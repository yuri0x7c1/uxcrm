package com.github.yuri0x7c1.uxcrm.content.ui.component;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.content.content.service.ContentAssocDataResourceViewFromService;
import org.apache.ofbiz.content.content.service.ContentService;
import org.apache.ofbiz.content.website.service.WebSiteContentService;
import org.apache.ofbiz.webapp.website.WebSite;
import org.apache.ofbiz.webapp.website.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.button.MButton;

import com.github.yuri0x7c1.uxcrm.content.data.WebSiteTreeDataProvider;
import com.github.yuri0x7c1.uxcrm.content.data.WebSiteTreeNode;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TreeGrid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@UIScope
@SpringComponent
public class WebSiteTree extends VerticalLayout {
	@Autowired
	I18N i18n;

	@Autowired
	WebSiteService webSiteService;

	@Autowired
	WebSiteContentService webSiteContentService;

	@Autowired
	ContentService contentService;

	@Autowired
	ContentAssocDataResourceViewFromService contentAssocDataResourceViewFromService;

	ComboBox<WebSite> select = new ComboBox<>();

	TreeGrid<WebSiteTreeNode> tree = new TreeGrid<>();

	@PostConstruct
	private void init() {
		tree.addColumn(WebSiteTreeNode::getContentId).setCaption("Id");
		tree.addColumn(WebSiteTreeNode::getContentName).setCaption("Name");
		tree.addComponentColumn(node -> {
		    MButton button = new MButton(VaadinIcons.PLUS,
		    	event -> Notification.show("Clicked: " + node.toString())
		    ).withStyleName(ValoTheme.BUTTON_TINY);
		    return button;
		});

		select.setWidthUndefined();
		select.setItemCaptionGenerator(webSite -> webSite.getSiteName() + "[" + webSite.getWebSiteId() + "]");

		select.setItems(webSiteService.find(0, 1000, Arrays.asList(new String[]{WebSite.Fields.webSiteId.name()}), null));

		select.addSelectionListener(event -> {
			if (event.getValue() != null) {
				tree.setDataProvider(new WebSiteTreeDataProvider(
					event.getValue(),
					webSiteService,
					contentService,
					contentAssocDataResourceViewFromService
				));
			}
		});

		addComponent(select);

		addComponent(tree);
	}
}
