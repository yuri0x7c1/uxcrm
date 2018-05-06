package com.github.yuri0x7c1.uxerp.content.ui.component;

import java.util.HashMap;
import java.util.List;

import org.apache.ofbiz.common.service.PerformFindListService;
import org.apache.ofbiz.common.service.PerformFindListService.In;
import org.apache.ofbiz.common.service.PerformFindListService.Out;
import org.apache.ofbiz.content.data.entity.DataResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.LazyList;
import org.vaadin.viritin.layouts.MVerticalLayout;
import org.vaadin.viritinv7.fields.MTable;

import com.github.yuri0x7c1.uxerp.common.test.Constants;
import com.github.yuri0x7c1.uxerp.common.ui.component.search.CommonSearchForm;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@UIScope
@SpringComponent
public class DataResourceList extends MVerticalLayout {

	private final I18N i18n;

	private final PerformFindListService performFindListService;

	private final In in = new In().builder()
		.entityName(DataResource.NAME)
		.noConditionFind("Y")
		.inputFields(new HashMap<>())
		.build();

	private final CommonSearchForm<DataResource> searchForm;

	private MTable<DataResource> dataResourceTable = new MTable<>(DataResource.class)
			.withFullWidth()
			.withFullHeight();

	@Autowired
	public DataResourceList(PerformFindListService performFindListService, I18N i18n) {
		super();
		this.performFindListService = performFindListService;
		this.i18n = i18n;

		setMargin(false);
		withFullWidth();
		withFullHeight();

		searchForm = new CommonSearchForm<>(DataResource.class, i18n, "dataResourceName")
			.addClickListener(event -> search());

		search();

		addComponents(searchForm, dataResourceTable);
		setExpandRatio(dataResourceTable, 1.0f);
	}

	private void search() {
		dataResourceTable.lazyLoadFrom(
			(firstRow, sortAscending, property) -> {
				in.setViewSize(LazyList.DEFAULT_PAGE_SIZE);
				in.setViewIndex(firstRow / LazyList.DEFAULT_PAGE_SIZE);

				searchForm.readInputFields(in.getInputFields());

				if (property != null) {
					String sortField = property + " " + (sortAscending ? "ASC" : "DESC");
					in.setOrderBy(sortField);
				}
				else {
					in.setOrderBy(null);
				}

				Out out = performFindListService.runSync(in);
				List<DataResource> dataResources = DataResource.fromValues(out.getList());

				return dataResources;
			},
			() -> {
				in.setViewSize(1);
				in.setViewIndex(1);

				searchForm.readInputFields(in.getInputFields());

				Out out = performFindListService.runSync(in);
				return out.getListSize();
			}
		)
		.sort(new Object[] {"dataResourceName"}, new boolean[] {true});
	}
}
