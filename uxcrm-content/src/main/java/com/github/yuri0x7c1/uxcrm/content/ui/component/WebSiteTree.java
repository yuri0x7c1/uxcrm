package com.github.yuri0x7c1.uxcrm.content.ui.component;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.content.content.service.ContentAssocDataResourceViewFromService;
import org.apache.ofbiz.content.content.service.ContentService;
import org.apache.ofbiz.content.website.service.WebSiteContentService;
import org.apache.ofbiz.webapp.website.WebSite;
import org.apache.ofbiz.webapp.website.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;

import com.github.yuri0x7c1.uxcrm.content.data.WebSiteTreeDataProvider;
import com.github.yuri0x7c1.uxcrm.content.data.WebSiteTreeNode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

import edu.emory.mathcs.backport.java.util.Arrays;
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

	Tree<WebSiteTreeNode> tree = new Tree<>();

	@PostConstruct
	private void init() {
		select.setWidthUndefined();
		select.setItemCaptionGenerator(webSite -> webSite.getSiteName() + "[" + webSite.getWebSiteId() + "]");

		select.setItems(webSiteService.find(0, 1000, Arrays.asList(new String[]{WebSite.Fields.webSiteId.name()}), null));

		select.addSelectionListener(event -> {
			tree.setDataProvider(new WebSiteTreeDataProvider(
				event.getValue().getWebSiteId(),
				webSiteService,
				webSiteContentService,
				contentService,
				contentAssocDataResourceViewFromService
			));
		});

		addComponent(select);

		addComponent(tree);
	}
}
