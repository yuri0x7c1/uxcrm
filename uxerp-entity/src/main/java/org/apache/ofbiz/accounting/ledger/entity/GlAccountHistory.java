package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account History
 */
public class GlAccountHistory implements Serializable {

	public static final long serialVersionUID = 2494615411154241536L;
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

	public enum Fields {
		glAccountId, organizationPartyId, customTimePeriodId, openingBalance, postedDebits, postedCredits, endingBalance
	}

	public GlAccountHistory(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		customTimePeriodId = (String) value.get(Fields.customTimePeriodId
				.name());
		openingBalance = (BigDecimal) value.get(Fields.openingBalance.name());
		postedDebits = (BigDecimal) value.get(Fields.postedDebits.name());
		postedCredits = (BigDecimal) value.get(Fields.postedCredits.name());
		endingBalance = (BigDecimal) value.get(Fields.endingBalance.name());
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