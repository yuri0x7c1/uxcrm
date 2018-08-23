package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account And History
 */
@FieldNameConstants
public class GlAccountAndHistory implements Serializable {

	public static final long serialVersionUID = 8774873578451902464L;
	public static final String NAME = "GlAccountAndHistory";
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
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

	public GlAccountAndHistory(GenericValue value) {
		glAccountClassId = (String) value.get(FIELD_GL_ACCOUNT_CLASS_ID);
		accountCode = (String) value.get(FIELD_ACCOUNT_CODE);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		accountName = (String) value.get(FIELD_ACCOUNT_NAME);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		glAccountTypeId = (String) value.get(FIELD_GL_ACCOUNT_TYPE_ID);
		glResourceTypeId = (String) value.get(FIELD_GL_RESOURCE_TYPE_ID);
		parentGlAccountId = (String) value.get(FIELD_PARENT_GL_ACCOUNT_ID);
		glXbrlClassId = (String) value.get(FIELD_GL_XBRL_CLASS_ID);
		postedCredits = (BigDecimal) value.get(FIELD_POSTED_CREDITS);
		postedDebits = (BigDecimal) value.get(FIELD_POSTED_DEBITS);
		endingBalance = (BigDecimal) value.get(FIELD_ENDING_BALANCE);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		customTimePeriodId = (String) value.get(FIELD_CUSTOM_TIME_PERIOD_ID);
		openingBalance = (BigDecimal) value.get(FIELD_OPENING_BALANCE);
	}

	public static GlAccountAndHistory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountAndHistory(value);
	}

	public static List<GlAccountAndHistory> fromValues(List<GenericValue> values) {
		List<GlAccountAndHistory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountAndHistory(value));
		}
		return entities;
	}
}