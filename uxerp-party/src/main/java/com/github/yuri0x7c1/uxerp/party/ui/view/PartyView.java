package com.github.yuri0x7c1.uxerp.party.ui.view;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.PartyBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.LazyList;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritinv7.fields.MTable;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.party.ui.menu.category.PartyCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MenuItem(parentId = PartyCategories.PARTY, caption=PartyView.NAME, icon=VaadinIcons.GROUP, order = 1)
@UIScope
@SpringView(name =  PartyView.NAME)
public class PartyView extends CommonView implements View {

	public static final String NAME = "Parties";

	@Autowired
	private PartyBaseService partyBaseService;

	private MTable<Party> partyTable = new MTable<>(Party.class)
		.withProperties("partyId")
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
		partyTable.lazyLoadFrom(
			(firstRow, sortAscending, property) -> {
				List<Party> parties = partyBaseService.find(
						Integer.valueOf(firstRow),
						Integer.valueOf(LazyList.DEFAULT_PAGE_SIZE),
						property != null ? Collections.singletonList(property + " " + (sortAscending ? "ASC" : "DESC")) : null,
						null);

				return parties;
			},
			() -> {
				return partyBaseService.count(null);
			}
		)
		.sort(new Object[] {"partyId"}, new boolean[] {true});
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
