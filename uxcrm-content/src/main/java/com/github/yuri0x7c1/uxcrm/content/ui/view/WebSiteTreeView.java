package com.github.yuri0x7c1.uxcrm.content.ui.view;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.content.content.service.ContentAssocDataResourceViewFromService;
import org.apache.ofbiz.content.content.service.ContentService;
import org.apache.ofbiz.content.website.service.WebSiteContentService;
import org.apache.ofbiz.webapp.website.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;

import com.github.yuri0x7c1.uxcrm.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxcrm.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxcrm.content.data.WebSiteTreeDataProvider;
import com.github.yuri0x7c1.uxcrm.content.data.WebSiteTreeNode;
import com.github.yuri0x7c1.uxcrm.content.ui.component.WebSiteTree;
import com.github.yuri0x7c1.uxcrm.content.ui.menu.category.ContentCategories;
import com.vaadin.data.TreeData;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Tree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MenuItem(parentId = ContentCategories.CONTENT, caption=WebSiteTreeView.NAME, icon=VaadinIcons.FILE_TREE, order = 1)
@UIScope
@SpringView(name =  WebSiteTreeView.NAME)
public class WebSiteTreeView extends CommonView implements View {

	public static final String NAME = "Web Site Tree";

	@Autowired
	I18N i18n;

	@Autowired
	WebSiteTree tree;

	@PostConstruct
	public void init() {

		setHeaderText(WebSiteTreeView.NAME);

		addComponent(tree);
	}

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
