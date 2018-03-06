package com.github.yuri0x7c1.uxerp.party.party.party.ui.form;

import javax.annotation.PostConstruct;

import com.github.yuri0x7c1.uxerp.party.party.party.service.FindPartyService;
import com.github.yuri0x7c1.uxerp.party.party.party.service.FindPartyService.In;
import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringComponent
@UIScope
public class FindPartyServiceForm extends VerticalLayout {

	@Getter
	private In bean;
	private Binder<FindPartyService.In> binder = new Binder<>();
	@Getter
	private TextField extInfoField = new TextField("extInfo");
	@Getter
	private TextField roleTypeIdField = new TextField("roleTypeId");
	@Getter
	private TextField VIEW_INDEXField = new TextField("VIEW_INDEX");
	@Getter
	private TextField VIEW_SIZEField = new TextField("VIEW_SIZE");
	@Getter
	private TextField lookupFlagField = new TextField("lookupFlag");
	@Getter
	private TextField showAllField = new TextField("showAll");
	@Getter
	private TextField partyIdField = new TextField("partyId");
	@Getter
	private TextField partyTypeIdField = new TextField("partyTypeId");
	@Getter
	private TextField userLoginIdField = new TextField("userLoginId");
	@Getter
	private TextField groupNameField = new TextField("groupName");
	@Getter
	private TextField firstNameField = new TextField("firstName");
	@Getter
	private TextField lastNameField = new TextField("lastName");
	@Getter
	private TextField address1Field = new TextField("address1");
	@Getter
	private TextField address2Field = new TextField("address2");
	@Getter
	private TextField cityField = new TextField("city");
	@Getter
	private TextField stateProvinceGeoIdField = new TextField(
			"stateProvinceGeoId");
	@Getter
	private TextField postalCodeField = new TextField("postalCode");
	@Getter
	private TextField infoStringField = new TextField("infoString");
	@Getter
	private TextField countryCodeField = new TextField("countryCode");
	@Getter
	private TextField areaCodeField = new TextField("areaCode");
	@Getter
	private TextField contactNumberField = new TextField("contactNumber");
	@Getter
	private TextField inventoryItemIdField = new TextField("inventoryItemId");
	@Getter
	private TextField serialNumberField = new TextField("serialNumber");
	@Getter
	private TextField softIdentifierField = new TextField("softIdentifier");
	@Getter
	private TextField partyRelationshipTypeIdField = new TextField(
			"partyRelationshipTypeId");
	@Getter
	private int ownerPartyIdsField;
	@Getter
	private TextField sortFieldField = new TextField("sortField");
	@Getter
	private Button runButton = new Button("Run");

	public void setBean(In bean) {
		this.bean = bean;
		binder.setBean(bean);
	}

	@PostConstruct
	private void init() {
		binder.forField(extInfoField).bind(FindPartyService.In::getExtInfo,
				FindPartyService.In::setExtInfo);
		binder.forField(roleTypeIdField).bind(
				FindPartyService.In::getRoleTypeId,
				FindPartyService.In::setRoleTypeId);
		binder.forField(VIEW_INDEXField).bind(
				FindPartyService.In::getVIEW_INDEX,
				FindPartyService.In::setVIEW_INDEX);
		binder.forField(VIEW_SIZEField).bind(FindPartyService.In::getVIEW_SIZE,
				FindPartyService.In::setVIEW_SIZE);
		binder.forField(lookupFlagField).bind(
				FindPartyService.In::getLookupFlag,
				FindPartyService.In::setLookupFlag);
		binder.forField(showAllField).bind(FindPartyService.In::getShowAll,
				FindPartyService.In::setShowAll);
		binder.forField(partyIdField).bind(FindPartyService.In::getPartyId,
				FindPartyService.In::setPartyId);
		binder.forField(partyTypeIdField).bind(
				FindPartyService.In::getPartyTypeId,
				FindPartyService.In::setPartyTypeId);
		binder.forField(userLoginIdField).bind(
				FindPartyService.In::getUserLoginId,
				FindPartyService.In::setUserLoginId);
		binder.forField(groupNameField).bind(FindPartyService.In::getGroupName,
				FindPartyService.In::setGroupName);
		binder.forField(firstNameField).bind(FindPartyService.In::getFirstName,
				FindPartyService.In::setFirstName);
		binder.forField(lastNameField).bind(FindPartyService.In::getLastName,
				FindPartyService.In::setLastName);
		binder.forField(address1Field).bind(FindPartyService.In::getAddress1,
				FindPartyService.In::setAddress1);
		binder.forField(address2Field).bind(FindPartyService.In::getAddress2,
				FindPartyService.In::setAddress2);
		binder.forField(cityField).bind(FindPartyService.In::getCity,
				FindPartyService.In::setCity);
		binder.forField(stateProvinceGeoIdField).bind(
				FindPartyService.In::getStateProvinceGeoId,
				FindPartyService.In::setStateProvinceGeoId);
		binder.forField(postalCodeField).bind(
				FindPartyService.In::getPostalCode,
				FindPartyService.In::setPostalCode);
		binder.forField(infoStringField).bind(
				FindPartyService.In::getInfoString,
				FindPartyService.In::setInfoString);
		binder.forField(countryCodeField).bind(
				FindPartyService.In::getCountryCode,
				FindPartyService.In::setCountryCode);
		binder.forField(areaCodeField).bind(FindPartyService.In::getAreaCode,
				FindPartyService.In::setAreaCode);
		binder.forField(contactNumberField).bind(
				FindPartyService.In::getContactNumber,
				FindPartyService.In::setContactNumber);
		binder.forField(inventoryItemIdField).bind(
				FindPartyService.In::getInventoryItemId,
				FindPartyService.In::setInventoryItemId);
		binder.forField(serialNumberField).bind(
				FindPartyService.In::getSerialNumber,
				FindPartyService.In::setSerialNumber);
		binder.forField(softIdentifierField).bind(
				FindPartyService.In::getSoftIdentifier,
				FindPartyService.In::setSoftIdentifier);
		binder.forField(partyRelationshipTypeIdField).bind(
				FindPartyService.In::getPartyRelationshipTypeId,
				FindPartyService.In::setPartyRelationshipTypeId);
		/*
		binder.forField(ownerPartyIdsField).bind(
				FindPartyService.In::getOwnerPartyIds,
				FindPartyService.In::setOwnerPartyIds);
		*/
		binder.forField(sortFieldField).bind(FindPartyService.In::getSortField,
				FindPartyService.In::setSortField);
		addComponent(extInfoField);
		addComponent(roleTypeIdField);
		addComponent(VIEW_INDEXField);
		addComponent(VIEW_SIZEField);
		addComponent(lookupFlagField);
		addComponent(showAllField);
		addComponent(partyIdField);
		addComponent(partyTypeIdField);
		addComponent(userLoginIdField);
		addComponent(groupNameField);
		addComponent(firstNameField);
		addComponent(lastNameField);
		addComponent(address1Field);
		addComponent(address2Field);
		addComponent(cityField);
		addComponent(stateProvinceGeoIdField);
		addComponent(postalCodeField);
		addComponent(infoStringField);
		addComponent(countryCodeField);
		addComponent(areaCodeField);
		addComponent(contactNumberField);
		addComponent(inventoryItemIdField);
		addComponent(serialNumberField);
		addComponent(softIdentifierField);
		addComponent(partyRelationshipTypeIdField);
		// addComponent(ownerPartyIdsField);
		addComponent(sortFieldField);
		addComponent(runButton);
	}
}