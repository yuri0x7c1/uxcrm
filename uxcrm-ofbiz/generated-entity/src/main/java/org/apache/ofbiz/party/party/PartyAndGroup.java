package org.apache.ofbiz.party.party;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party And Group
 */
public class PartyAndGroup implements Serializable {

	public static final long serialVersionUID = 6800181000869233664L;
	public static final String NAME = "PartyAndGroup";
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Is Unread
	 */
	@Getter
	@Setter
	private String isUnread;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
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
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Preferred Currency Uom Id
	 */
	@Getter
	@Setter
	private String preferredCurrencyUomId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Ticker Symbol
	 */
	@Getter
	@Setter
	private String tickerSymbol;
	/**
	 * Logo Image Url
	 */
	@Getter
	@Setter
	private String logoImageUrl;
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
	 * Num Employees
	 */
	@Getter
	@Setter
	private Long numEmployees;
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

	public enum Fields {
		lastModifiedDate, externalId, description, isUnread, partyTypeId, lastModifiedByUserLogin, dataSourceId, createdDate, statusId, preferredCurrencyUomId, partyId, createdByUserLogin, comments, tickerSymbol, logoImageUrl, groupName, groupNameLocal, numEmployees, officeSiteName, annualRevenue
	}

	public PartyAndGroup(GenericValue value) {
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		externalId = (String) value.get(Fields.externalId.name());
		description = (String) value.get(Fields.description.name());
		isUnread = (String) value.get(Fields.isUnread.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		preferredCurrencyUomId = (String) value
				.get(Fields.preferredCurrencyUomId.name());
		partyId = (String) value.get(Fields.partyId.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		comments = (String) value.get(Fields.comments.name());
		tickerSymbol = (String) value.get(Fields.tickerSymbol.name());
		logoImageUrl = (String) value.get(Fields.logoImageUrl.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		numEmployees = (Long) value.get(Fields.numEmployees.name());
		officeSiteName = (String) value.get(Fields.officeSiteName.name());
		annualRevenue = (BigDecimal) value.get(Fields.annualRevenue.name());
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