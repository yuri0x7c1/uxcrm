package com.github.yuri0x7c1.uxerp.party.ui.view;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.entity.GenericDelegator;
import org.apache.ofbiz.party.party.FindPartyService;
import org.apache.ofbiz.service.LocalDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.LazyList;
import org.vaadin.viritinv7.fields.MTable;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.party.entity.FindPartyDynamicViewEntity;
import com.github.yuri0x7c1.uxerp.party.ui.PartyCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MenuItem(categoryId = PartyCategories.PARTY, caption=PartyView.NAME, icon=VaadinIcons.GROUP, order = 1)
@UIScope
@SpringView(name =  PartyView.NAME)
public class PartyView extends CommonView implements View {

	public static final String NAME = "Parties";

	@Autowired
	GenericDelegator delegator;

	@Autowired
	LocalDispatcher dispatcher;

	@Autowired
	FindPartyService service;

	private MTable<FindPartyDynamicViewEntity> partyTable = new MTable<>(FindPartyDynamicViewEntity.class).withProperties("partyId")
		.withFullWidth()
		.withFullHeight();

	public PartyView() {
		setHeaderText(NAME);
		setHeight(100, Unit.PERCENTAGE);
		addComponent(partyTable);
		setExpandRatio(partyTable, 1.0f);
	}

	@PostConstruct
    public void init() throws Exception {
		FindPartyService.In in = FindPartyService.In.builder()
				.lookupFlag("Y")
				.showAll("Y")
				.VIEW_SIZE(Integer.valueOf(LazyList.DEFAULT_PAGE_SIZE).toString())
				.build();

		partyTable.lazyLoadFrom(
			(firstRow, sortAscending, property) -> {
				in.setVIEW_SIZE(Integer.valueOf(LazyList.DEFAULT_PAGE_SIZE).toString());
				in.setVIEW_INDEX(Integer.valueOf(firstRow / LazyList.DEFAULT_PAGE_SIZE).toString());

				if (property != null) {
					String sortField = property + " " + (sortAscending ? "ASC" : "DESC");
					in.setSortField(sortField);
				}
				else {
					in.setSortField(null);
				}

				FindPartyService.Out out = service.runSync(in);
				List<FindPartyDynamicViewEntity> parties = FindPartyDynamicViewEntity.fromValues(out.getPartyList());

				return parties;
			},
			() -> {
				in.setVIEW_SIZE("1");
				in.setVIEW_INDEX("1");
				FindPartyService.Out out = service.runSync(in);
				return out.getPartyListSize();
			}
		)
		.sort(new Object[] {"partyId"}, new boolean[] {true});
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
