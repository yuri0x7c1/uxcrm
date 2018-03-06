package org.apache.ofbiz.party.party.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party And Group
 */
public class PartyAndGroup implements Serializable {

	public static final long serialVersionUID = 8067863233292451840L;
	public static final String NAME = "PartyAndGroup";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Preferred Currency Uom Id
	 */
	@Getter
	@Setter
	private String preferredCurrencyUomId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Is Unread
	 */
	@Getter
	@Setter
	private String isUnread;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Group Name Local
	 */
	@Getter
	@Setter
	private String groupNameLocal;
	/**
	 * Office Site Name
	 */
	@Getter
	@Setter
	private String officeSiteName;
	/**
	 * Annual Revenue
	 */
	@Getter
	@Setter
	private BigDecimal annualRevenue;
	/**
	 * Num Employees
	 */
	@Getter
	@Setter
	private Long numEmployees;
	/**
	 * Ticker Symbol
	 */
	@Getter
	@Setter
	private String tickerSymbol;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Logo Image Url
	 */
	@Getter
	@Setter
	private String logoImageUrl;

	public enum Fields {
		partyId, partyTypeId, externalId, preferredCurrencyUomId, description, statusId, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, dataSourceId, isUnread, groupName, groupNameLocal, officeSiteName, annualRevenue, numEmployees, tickerSymbol, comments, logoImageUrl
	}

	public PartyAndGroup(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		externalId = (String) value.get(Fields.externalId.name());
		preferredCurrencyUomId = (String) value
				.get(Fields.preferredCurrencyUomId.name());
		description = (String) value.get(Fields.description.name());
		statusId = (String) value.get(Fields.statusId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		isUnread = (String) value.get(Fields.isUnread.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		officeSiteName = (String) value.get(Fields.officeSiteName.name());
		annualRevenue = (BigDecimal) value.get(Fields.annualRevenue.name());
		numEmployees = (Long) value.get(Fields.numEmployees.name());
		tickerSymbol = (String) value.get(Fields.tickerSymbol.name());
		comments = (String) value.get(Fields.comments.name());
		logoImageUrl = (String) value.get(Fields.logoImageUrl.name());
	}

	public static PartyAndGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAndGroup(value);
	}

	public static List<PartyAndGroup> fromValues(List<GenericValue> values) {
		List<PartyAndGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAndGroup(value));
		}
		return entities;
	}
}