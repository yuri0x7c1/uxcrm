package org.apache.ofbiz.accounting.ledger;

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
 * Gl Account History
 */
@FieldNameConstants
public class GlAccountHistory implements Serializable {

	public static final long serialVersionUID = 8372861174917598208L;
	public static final String NAME = "GlAccountHistory";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Custom Time Period Id
	 */
	@Getter
	@Setter
	private String customTimePeriodId;
	/**
	 * Opening Balance
	 */
	@Getter
	@Setter
	private BigDecimal openingBalance;
	/**
	 * Posted Debits
	 */
	@Getter
	@Setter
	private BigDecimal postedDebits;
	/**
	 * Posted Credits
	 */
	@Getter
	@Setter
	private BigDecimal postedCredits;
	/**
	 * Ending Balance
	 */
	@Getter
	@Setter
	private BigDecimal endingBalance;
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

	public GlAccountHistory(GenericValue value) {
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		customTimePeriodId = (String) value.get(FIELD_CUSTOM_TIME_PERIOD_ID);
		openingBalance = (BigDecimal) value.get(FIELD_OPENING_BALANCE);
		postedDebits = (BigDecimal) value.get(FIELD_POSTED_DEBITS);
		postedCredits = (BigDecimal) value.get(FIELD_POSTED_CREDITS);
		endingBalance = (BigDecimal) value.get(FIELD_ENDING_BALANCE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GlAccountHistory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountHistory(value);
	}

	public static List<GlAccountHistory> fromValues(List<GenericValue> values) {
		List<GlAccountHistory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountHistory(value));
		}
		return entities;
	}
}