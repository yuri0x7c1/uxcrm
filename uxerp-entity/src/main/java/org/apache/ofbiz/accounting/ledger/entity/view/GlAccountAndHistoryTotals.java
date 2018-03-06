package org.apache.ofbiz.accounting.ledger.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account And History Totals
 */
public class GlAccountAndHistoryTotals implements Serializable {

	public static final long serialVersionUID = 4485909454344775680L;
	public static final String NAME = "GlAccountAndHistoryTotals";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Gl Resource Type Id
	 */
	@Getter
	@Setter
	private String glResourceTypeId;
	/**
	 * Gl Xbrl Class Id
	 */
	@Getter
	@Setter
	private String glXbrlClassId;
	/**
	 * Parent Gl Account Id
	 */
	@Getter
	@Setter
	private String parentGlAccountId;
	/**
	 * Account Code
	 */
	@Getter
	@Setter
	private String accountCode;
	/**
	 * Account Name
	 */
	@Getter
	@Setter
	private String accountName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
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
		glAccountId, glAccountTypeId, glAccountClassId, glResourceTypeId, glXbrlClassId, parentGlAccountId, accountCode, accountName, description, productId, externalId, organizationPartyId, customTimePeriodId, openingBalance, postedDebits, postedCredits, endingBalance
	}

	public GlAccountAndHistoryTotals(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		glAccountClassId = (String) value.get(Fields.glAccountClassId.name());
		glResourceTypeId = (String) value.get(Fields.glResourceTypeId.name());
		glXbrlClassId = (String) value.get(Fields.glXbrlClassId.name());
		parentGlAccountId = (String) value.get(Fields.parentGlAccountId.name());
		accountCode = (String) value.get(Fields.accountCode.name());
		accountName = (String) value.get(Fields.accountName.name());
		description = (String) value.get(Fields.description.name());
		productId = (String) value.get(Fields.productId.name());
		externalId = (String) value.get(Fields.externalId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		customTimePeriodId = (String) value.get(Fields.customTimePeriodId
				.name());
		openingBalance = (BigDecimal) value.get(Fields.openingBalance.name());
		postedDebits = (BigDecimal) value.get(Fields.postedDebits.name());
		postedCredits = (BigDecimal) value.get(Fields.postedCredits.name());
		endingBalance = (BigDecimal) value.get(Fields.endingBalance.name());
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