package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PartyAndGroup implements Serializable {

	public static final long serialVersionUID = 5456665823421654016L;
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

	public PartyAndGroup(GenericValue value) {
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		isUnread = (String) value.get(FIELD_IS_UNREAD);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		preferredCurrencyUomId = (String) value
				.get(FIELD_PREFERRED_CURRENCY_UOM_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		comments = (String) value.get(FIELD_COMMENTS);
		tickerSymbol = (String) value.get(FIELD_TICKER_SYMBOL);
		logoImageUrl = (String) value.get(FIELD_LOGO_IMAGE_URL);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		groupNameLocal = (String) value.get(FIELD_GROUP_NAME_LOCAL);
		numEmployees = (Long) value.get(FIELD_NUM_EMPLOYEES);
		officeSiteName = (String) value.get(FIELD_OFFICE_SITE_NAME);
		annualRevenue = (BigDecimal) value.get(FIELD_ANNUAL_REVENUE);
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