package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account And History Totals
 */
public class GlAccountAndHistoryTotals implements Serializable {

	public static final long serialVersionUID = 4944478603298711552L;
	public static final String NAME = "GlAccountAndHistoryTotals";
	/**
	 * Total Posted Debits
	 */
	@Getter
	@Setter
	private BigDecimal totalPostedDebits;
	/**
	 * Total Posted Credits
	 */
	@Getter
	@Setter
	private BigDecimal totalPostedCredits;
	/**
	 * Total Ending Balance
	 */
	@Getter
	@Setter
	private BigDecimal totalEndingBalance;
	/**
	 * Account Code
	 */
	@Getter
	@Setter
	private String accountCode;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Account Name
	 */
	@Getter
	@Setter
	private String accountName;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Gl Resource Type Id
	 */
	@Getter
	@Setter
	private String glResourceTypeId;
	/**
	 * Parent Gl Account Id
	 */
	@Getter
	@Setter
	private String parentGlAccountId;
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Gl Xbrl Class Id
	 */
	@Getter
	@Setter
	private String glXbrlClassId;
	/**
	 * Posted Credits
	 */
	@Getter
	@Setter
	private BigDecimal postedCredits;
	/**
	 * Posted Debits
	 */
	@Getter
	@Setter
	private BigDecimal postedDebits;
	/**
	 * Ending Balance
	 */
	@Getter
	@Setter
	private BigDecimal endingBalance;
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

	public enum Fields {
		totalPostedDebits, totalPostedCredits, totalEndingBalance, accountCode, productId, accountName, glAccountId, description, externalId, glAccountTypeId, glResourceTypeId, parentGlAccountId, glAccountClassId, glXbrlClassId, postedCredits, postedDebits, endingBalance, organizationPartyId, customTimePeriodId, openingBalance
	}

	public GlAccountAndHistoryTotals(GenericValue value) {
		totalPostedDebits = (BigDecimal) value.get(Fields.totalPostedDebits
				.name());
		totalPostedCredits = (BigDecimal) value.get(Fields.totalPostedCredits
				.name());
		totalEndingBalance = (BigDecimal) value.get(Fields.totalEndingBalance
				.name());
		accountCode = (String) value.get(Fields.accountCode.name());
		productId = (String) value.get(Fields.productId.name());
		accountName = (String) value.get(Fields.accountName.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		description = (String) value.get(Fields.description.name());
		externalId = (String) value.get(Fields.externalId.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		glResourceTypeId = (String) value.get(Fields.glResourceTypeId.name());
		parentGlAccountId = (String) value.get(Fields.parentGlAccountId.name());
		glAccountClassId = (String) value.get(Fields.glAccountClassId.name());
		glXbrlClassId = (String) value.get(Fields.glXbrlClassId.name());
		postedCredits = (BigDecimal) value.get(Fields.postedCredits.name());
		postedDebits = (BigDecimal) value.get(Fields.postedDebits.name());
		endingBalance = (BigDecimal) value.get(Fields.endingBalance.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		customTimePeriodId = (String) value.get(Fields.customTimePeriodId
				.name());
		openingBalance = (BigDecimal) value.get(Fields.openingBalance.name());
	}

	public static GlAccountAndHistoryTotals fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountAndHistoryTotals(value);
	}

	public static List<GlAccountAndHistoryTotals> fromValues(
			List<GenericValue> values) {
		List<GlAccountAndHistoryTotals> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountAndHistoryTotals(value));
		}
		return entities;
	}
}