package org.apache.ofbiz.party.party.ui.form;

import org.apache.ofbiz.party.party.CreatePartyGroupService;
import org.apache.ofbiz.party.party.CreatePartyGroupService.In;

import com.jarektoro.responsivelayout.ResponsiveLayout;
import com.vaadin.data.Binder;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatePartyGroupServiceForm extends ResponsiveLayout {
	@Getter
	private In bean;
	
	private Binder<CreatePartyGroupService.In> binder = new Binder<>();
	
	@Getter
	private TextField annualRevenueField = new TextField("annualRevenue");
	@Getter
	private TextField commentsField = new TextField("comments");
	@Getter
	private TextField descriptionField = new TextField("description");
	@Getter
	private TextField externalIdField = new TextField("externalId");
	@Getter
	private TextField groupNameField = new TextField("groupName");
	@Getter
	private TextField groupNameLocalField = new TextField("groupNameLocal");
	@Getter
	private TextField logoImageUrlField = new TextField("logoImageUrl");
	@Getter
	private TextField numEmployeesField = new TextField("numEmployees");
	@Getter
	private TextField officeSiteNameField = new TextField("officeSiteName");
	@Getter
	private TextField partyIdField = new TextField("partyId");
	@Getter
	private TextField partyTypeIdField = new TextField("partyTypeId");
	@Getter
	private TextField preferredCurrencyUomIdField = new TextField("preferredCurrencyUomId");
	@Getter
	private TextField statusIdField = new TextField("statusId");
	@Getter
	private TextField tickerSymbolField = new TextField("tickerSymbol");
	@Getter
	private Button saveButton = new Button("Save");

	public void setBean(In bean) {
		this.bean = bean;
		binder.setBean(bean);
	}

	public CreatePartyGroupServiceForm() {
		/*
		binder.forField(annualRevenueField).bind(CreatePartyGroupService.In::getAnnualRevenue,
				CreatePartyGroupService.In::setAnnualRevenue);
		*/
		binder.forField(commentsField).bind(CreatePartyGroupService.In::getComments,
				CreatePartyGroupService.In::setComments);
		binder.forField(descriptionField).bind(CreatePartyGroupService.In::getDescription,
				CreatePartyGroupService.In::setDescription);
		binder.forField(externalIdField).bind(CreatePartyGroupService.In::getExternalId,
				CreatePartyGroupService.In::setExternalId);
		binder.forField(groupNameField).bind(CreatePartyGroupService.In::getGroupName,
				CreatePartyGroupService.In::setGroupName);
		binder.forField(groupNameLocalField).bind(CreatePartyGroupService.In::getGroupNameLocal,
				CreatePartyGroupService.In::setGroupNameLocal);
		binder.forField(logoImageUrlField).bind(CreatePartyGroupService.In::getLogoImageUrl,
				CreatePartyGroupService.In::setLogoImageUrl);
		/*
		binder.forField(numEmployeesField).bind(CreatePartyGroupService.In::getNumEmployees,
				CreatePartyGroupService.In::setNumEmployees);
		*/
		binder.forField(officeSiteNameField).bind(CreatePartyGroupService.In::getOfficeSiteName,
				CreatePartyGroupService.In::setOfficeSiteName);
		binder.forField(partyIdField).bind(CreatePartyGroupService.In::getPartyId,
				CreatePartyGroupService.In::setPartyId);
		binder.forField(partyTypeIdField).bind(CreatePartyGroupService.In::getPartyTypeId,
				CreatePartyGroupService.In::setPartyTypeId);
		binder.forField(preferredCurrencyUomIdField).bind(CreatePartyGroupService.In::getPreferredCurrencyUomId,
				CreatePartyGroupService.In::setPreferredCurrencyUomId);
		binder.forField(statusIdField).bind(CreatePartyGroupService.In::getStatusId,
				CreatePartyGroupService.In::setStatusId);
		binder.forField(tickerSymbolField).bind(CreatePartyGroupService.In::getTickerSymbol,
				CreatePartyGroupService.In::setTickerSymbol);
		
		setStyleName("common-form");
		setDefaultRules(12, 6, 6, 4);
		addRow().addColumn().withComponent(annualRevenueField);
		addRow().addColumn().withComponent(commentsField);
		addRow().addColumn().withComponent(descriptionField);
		addRow().addColumn().withComponent(externalIdField);
		addRow().addColumn().withComponent(groupNameField);
		addRow().addColumn().withComponent(groupNameLocalField);
		addRow().addColumn().withComponent(logoImageUrlField);
		addRow().addColumn().withComponent(numEmployeesField);
		addRow().addColumn().withComponent(officeSiteNameField);
		addRow().addColumn().withComponent(partyIdField);
		addRow().addColumn().withComponent(partyTypeIdField);
		addRow().addColumn().withComponent(preferredCurrencyUomIdField);
		addRow().addColumn().withComponent(statusIdField);
		addRow().addColumn().withComponent(tickerSymbolField);
		addRow().addColumn().withComponent(saveButton);
	}
}