package org.apache.ofbiz.party.party;

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
public class PartyGroup implements Serializable {

	public static final long serialVersionUID = 8731367510437168128L;
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

	public enum Fields {
		partyId, groupName, groupNameLocal, officeSiteName, annualRevenue, numEmployees, tickerSymbol, comments, logoImageUrl, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyGroup(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		officeSiteName = (String) value.get(Fields.officeSiteName.name());
		annualRevenue = (BigDecimal) value.get(Fields.annualRevenue.name());
		numEmployees = (Long) value.get(Fields.numEmployees.name());
		tickerSymbol = (String) value.get(Fields.tickerSymbol.name());
		comments = (String) value.get(Fields.comments.name());
		logoImageUrl = (String) value.get(Fields.logoImageUrl.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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