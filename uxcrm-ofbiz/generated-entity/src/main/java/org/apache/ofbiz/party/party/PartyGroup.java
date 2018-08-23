package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Group
 */
@FieldNameConstants
public class PartyGroup implements Serializable {

	public static final long serialVersionUID = 9137626889380399104L;
	public static final String NAME = "PartyGroup";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public PartyGroup(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		groupNameLocal = (String) value.get(FIELD_GROUP_NAME_LOCAL);
		officeSiteName = (String) value.get(FIELD_OFFICE_SITE_NAME);
		annualRevenue = (BigDecimal) value.get(FIELD_ANNUAL_REVENUE);
		numEmployees = (Long) value.get(FIELD_NUM_EMPLOYEES);
		tickerSymbol = (String) value.get(FIELD_TICKER_SYMBOL);
		comments = (String) value.get(FIELD_COMMENTS);
		logoImageUrl = (String) value.get(FIELD_LOGO_IMAGE_URL);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyGroup(value);
	}

	public static List<PartyGroup> fromValues(List<GenericValue> values) {
		List<PartyGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyGroup(value));
		}
		return entities;
	}
}