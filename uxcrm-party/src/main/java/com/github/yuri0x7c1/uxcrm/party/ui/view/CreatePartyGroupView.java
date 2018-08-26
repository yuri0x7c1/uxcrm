package com.github.yuri0x7c1.uxcrm.party.ui.view;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.party.party.CreatePartyGroupService;
import org.apache.ofbiz.party.party.CreatePartyGroupService.In;
import org.apache.ofbiz.party.party.ui.form.CreatePartyGroupServiceForm;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.yuri0x7c1.uxcrm.common.navigation.util.NavigationUtil;
import com.github.yuri0x7c1.uxcrm.common.ui.view.CommonView;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;

@SpringView(name=CreatePartyGroupView.NAME)
public class CreatePartyGroupView extends CommonView implements View {
	public static final String NAME = "createPartyGroup";
	
	@Autowired
	private CreatePartyGroupService createPartyGroupService;
	
	private CreatePartyGroupServiceForm form = new CreatePartyGroupServiceForm();
	
	private CreatePartyGroupService.In in;
		
	public CreatePartyGroupView() {
		setHeaderText("Create Party Group");
		form.getPartyTypeIdField().setReadOnly(true);
		addComponent(form);
	}
	
	@PostConstruct
	public void init() {
		in = new In();
		in.setPartyTypeId("PARTY_GROUP");
		form.setBean(in);
		form.getSaveButton().addClickListener(event -> {
			createPartyGroupService.runSync(in);
			NavigationUtil.back();
		});
	}
}
