package org.apache.ofbiz.party.party;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ofbiz.service.LocalDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FindPartyService {

	public static final String NAME = "findParty";
	@Autowired
	private LocalDispatcher dispatcher;

	@Builder
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class In {
		@Getter
		@Setter
		private String extInfo;
		@Getter
		@Setter
		private String roleTypeId;
		@Getter
		@Setter
		private String VIEW_INDEX;
		@Getter
		@Setter
		private String VIEW_SIZE;
		@Getter
		@Setter
		private String lookupFlag;
		@Getter
		@Setter
		private String showAll;
		@Getter
		@Setter
		private String partyId;
		@Getter
		@Setter
		private String partyTypeId;
		@Getter
		@Setter
		private String userLoginId;
		@Getter
		@Setter
		private String groupName;
		@Getter
		@Setter
		private String firstName;
		@Getter
		@Setter
		private String lastName;
		@Getter
		@Setter
		private String address1;
		@Getter
		@Setter
		private String address2;
		@Getter
		@Setter
		private String city;
		@Getter
		@Setter
		private String stateProvinceGeoId;
		@Getter
		@Setter
		private String postalCode;
		@Getter
		@Setter
		private String infoString;
		@Getter
		@Setter
		private String countryCode;
		@Getter
		@Setter
		private String areaCode;
		@Getter
		@Setter
		private String contactNumber;
		@Getter
		@Setter
		private String inventoryItemId;
		@Getter
		@Setter
		private String serialNumber;
		@Getter
		@Setter
		private String softIdentifier;
		@Getter
		@Setter
		private String partyRelationshipTypeId;
		@Getter
		@Setter
		private List ownerPartyIds;
		@Getter
		@Setter
		private String sortField;
		@Getter
		@Setter
		private Object locale;
		@Getter
		@Setter
		private String password;
		@Getter
		@Setter
		private String username;
		@Getter
		@Setter
		private Object timeZone;
		@Getter
		@Setter
		private Object userLogin;

		public Map toMap() {
			Map map = new HashMap();
			map.put("extInfo", extInfo);
			map.put("roleTypeId", roleTypeId);
			map.put("VIEW_INDEX", VIEW_INDEX);
			map.put("VIEW_SIZE", VIEW_SIZE);
			map.put("lookupFlag", lookupFlag);
			map.put("showAll", showAll);
			map.put("partyId", partyId);
			map.put("partyTypeId", partyTypeId);
			map.put("userLoginId", userLoginId);
			map.put("groupName", groupName);
			map.put("firstName", firstName);
			map.put("lastName", lastName);
			map.put("address1", address1);
			map.put("address2", address2);
			map.put("city", city);
			map.put("stateProvinceGeoId", stateProvinceGeoId);
			map.put("postalCode", postalCode);
			map.put("infoString", infoString);
			map.put("countryCode", countryCode);
			map.put("areaCode", areaCode);
			map.put("contactNumber", contactNumber);
			map.put("inventoryItemId", inventoryItemId);
			map.put("serialNumber", serialNumber);
			map.put("softIdentifier", softIdentifier);
			map.put("partyRelationshipTypeId", partyRelationshipTypeId);
			map.put("ownerPartyIds", ownerPartyIds);
			map.put("sortField", sortField);
			map.put("locale", locale);
			map.put("login.password", password);
			map.put("login.username", username);
			map.put("timeZone", timeZone);
			map.put("userLogin", userLogin);
			return map;
		}

		public void fromMap(java.util.Map map) {
			In result = new In();
			extInfo = (String) map.get("extInfo");
			roleTypeId = (String) map.get("roleTypeId");
			VIEW_INDEX = (String) map.get("VIEW_INDEX");
			VIEW_SIZE = (String) map.get("VIEW_SIZE");
			lookupFlag = (String) map.get("lookupFlag");
			showAll = (String) map.get("showAll");
			partyId = (String) map.get("partyId");
			partyTypeId = (String) map.get("partyTypeId");
			userLoginId = (String) map.get("userLoginId");
			groupName = (String) map.get("groupName");
			firstName = (String) map.get("firstName");
			lastName = (String) map.get("lastName");
			address1 = (String) map.get("address1");
			address2 = (String) map.get("address2");
			city = (String) map.get("city");
			stateProvinceGeoId = (String) map.get("stateProvinceGeoId");
			postalCode = (String) map.get("postalCode");
			infoString = (String) map.get("infoString");
			countryCode = (String) map.get("countryCode");
			areaCode = (String) map.get("areaCode");
			contactNumber = (String) map.get("contactNumber");
			inventoryItemId = (String) map.get("inventoryItemId");
			serialNumber = (String) map.get("serialNumber");
			softIdentifier = (String) map.get("softIdentifier");
			partyRelationshipTypeId = (String) map
					.get("partyRelationshipTypeId");
			ownerPartyIds = (List) map.get("ownerPartyIds");
			sortField = (String) map.get("sortField");
			locale = (Object) map.get("locale");
			password = (String) map.get("login.password");
			username = (String) map.get("login.username");
			timeZone = (Object) map.get("timeZone");
			userLogin = (Object) map.get("userLogin");
		}

		public In(java.util.Map map) {
			fromMap(map);
		}
	}

	@ToString
	@NoArgsConstructor
	public static class Out {
		@Getter
		@Setter
		private List roleTypes;
		@Getter
		@Setter
		private List partyTypes;
		@Getter
		@Setter
		private Object currentRole;
		@Getter
		@Setter
		private Object currentPartyType;
		@Getter
		@Setter
		private Object currentStateGeo;
		@Getter
		@Setter
		private Integer viewIndex;
		@Getter
		@Setter
		private Integer viewSize;
		@Getter
		@Setter
		private List partyList;
		@Getter
		@Setter
		private Integer partyListSize;
		@Getter
		@Setter
		private String paramList;
		@Getter
		@Setter
		private Integer highIndex;
		@Getter
		@Setter
		private Integer lowIndex;
		@Getter
		@Setter
		private String sortField;
		@Getter
		@Setter
		private String errorMessage;
		@Getter
		@Setter
		private List errorMessageList;
		@Getter
		@Setter
		private String responseMessage;
		@Getter
		@Setter
		private String successMessage;
		@Getter
		@Setter
		private List successMessageList;

		public Map toMap() {
			Map map = new HashMap();
			map.put("roleTypes", roleTypes);
			map.put("partyTypes", partyTypes);
			map.put("currentRole", currentRole);
			map.put("currentPartyType", currentPartyType);
			map.put("currentStateGeo", currentStateGeo);
			map.put("viewIndex", viewIndex);
			map.put("viewSize", viewSize);
			map.put("partyList", partyList);
			map.put("partyListSize", partyListSize);
			map.put("paramList", paramList);
			map.put("highIndex", highIndex);
			map.put("lowIndex", lowIndex);
			map.put("sortField", sortField);
			map.put("errorMessage", errorMessage);
			map.put("errorMessageList", errorMessageList);
			map.put("responseMessage", responseMessage);
			map.put("successMessage", successMessage);
			map.put("successMessageList", successMessageList);
			return map;
		}

		public void fromMap(java.util.Map map) {
			Out result = new Out();
			roleTypes = (List) map.get("roleTypes");
			partyTypes = (List) map.get("partyTypes");
			currentRole = (Object) map.get("currentRole");
			currentPartyType = (Object) map.get("currentPartyType");
			currentStateGeo = (Object) map.get("currentStateGeo");
			viewIndex = (Integer) map.get("viewIndex");
			viewSize = (Integer) map.get("viewSize");
			partyList = (List) map.get("partyList");
			partyListSize = (Integer) map.get("partyListSize");
			paramList = (String) map.get("paramList");
			highIndex = (Integer) map.get("highIndex");
			lowIndex = (Integer) map.get("lowIndex");
			sortField = (String) map.get("sortField");
			errorMessage = (String) map.get("errorMessage");
			errorMessageList = (List) map.get("errorMessageList");
			responseMessage = (String) map.get("responseMessage");
			successMessage = (String) map.get("successMessage");
			successMessageList = (List) map.get("successMessageList");
		}

		public Out(java.util.Map map) {
			fromMap(map);
		}
	}

	public Out runSync(In in) {
		Map result = null;
		try {
			result = dispatcher.runSync(NAME, in.toMap());
		} catch (Exception e) {
			log.error("Error", e);
		}
		return new Out(result);
	}
}