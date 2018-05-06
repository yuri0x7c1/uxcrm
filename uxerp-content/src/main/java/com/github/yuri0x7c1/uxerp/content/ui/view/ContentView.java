package com.github.yuri0x7c1.uxerp.content.ui.view;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.content.content.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.LazyList;
import org.vaadin.viritinv7.fields.MTable;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.content.service.ContentBaseService;
import com.github.yuri0x7c1.uxerp.content.ui.config.CmsSections;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @VaadinFontIcon(VaadinIcons.EDIT)
@MenuItem(sectionId = CmsSections.CMS, caption=ContentView.NAME, order = 2)
@UIScope
@SpringView(name = ContentView.NAME)
public class ContentView extends CommonView implements View {

	public static final String NAME = "Content";

	@Autowired
	public ContentBaseService contentBaseService;

	private MTable<Content> contentTable = new MTable<>(Content.class)
			.withFullWidth()
			.withFullHeight();

	public ContentView() {
		setHeaderText(NAME);
		setHeight(100, Unit.PERCENTAGE);
		addComponent(contentTable);
		setExpandRatio(contentTable, 1.0f);
	}

	@PostConstruct
	public void init() {
		contentTable.lazyLoadFrom(
			(firstRow, sortAscending, property) -> {
				return contentBaseService.find(
					firstRow / LazyList.DEFAULT_PAGE_SIZE,
					LazyList.DEFAULT_PAGE_SIZE,
					property != null ? property + " " + (sortAscending ? "ASC" : "DESC") : null,
					Collections.emptyMap()
				);
			},
			() -> {
				return contentBaseService.count(Collections.emptyMap());
			}
		)
		.sort(new Object[] {"contentId"}, new boolean[] {true});
	}

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
