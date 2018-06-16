package com.github.yuri0x7c1.uxcrm.party.ui.view;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.PartyGroup;
import org.apache.ofbiz.party.party.Person;
import org.apache.ofbiz.party.party.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.LazyList;
import org.vaadin.viritinv7.fields.MTable;

import com.github.yuri0x7c1.uxcrm.party.ui.menu.category.PartyCategories;
import com.github.yuri0x7c1.uxcrm.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxcrm.common.ui.view.CommonView;
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

	public static final String PARTY_TYPE_ID_PARTY_GROUP = "PARTY_GROUP";

	public static final String PARTY_TYPE_ID_PERSON = "PERSON";

	@Autowired
	private PartyService partyService;

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
				List<Party> parties = partyService.find(
						Integer.valueOf(firstRow),
						Integer.valueOf(LazyList.DEFAULT_PAGE_SIZE),
						property != null ? Collections.singletonList(property + " " + (sortAscending ? "ASC" : "DESC")) : null,
						null);

				return parties;
			},
			() -> {
				return partyService.count(null);
			}
		)
		.withGeneratedColumn("Party Name", party -> {
			if (PARTY_TYPE_ID_PARTY_GROUP.equals(party.getPartyTypeId())) {
				PartyGroup partyGroup = partyService.getPartyGroup(party);
				if (partyGroup != null) {
					return partyGroup.getGroupName();
				}
			}
			else if (PARTY_TYPE_ID_PERSON.equals(party.getPartyTypeId())) {
				Person person = partyService.getPerson(party);
				if (person != null) {
					return person.getFirstName() + " " + person.getLastName();
				}
			}
			return "";
		})
		.sort(new Object[] {"partyId"}, new boolean[] {true});
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
