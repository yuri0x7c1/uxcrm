package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Credit Card Type Gl Account
 */
@FieldNameConstants
public class CreditCardTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 715332966186368000L;
	public static final String NAME = "CreditCardTypeGlAccount";
	/**
	 * Card Type
	 */
	@Getter
	@Setter
	private String cardType;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
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

	public CreditCardTypeGlAccount(GenericValue value) {
		cardType = (String) value.get(FIELD_CARD_TYPE);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CreditCardTypeGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CreditCardTypeGlAccount(value);
	}

	public static List<CreditCardTypeGlAccount> fromValues(
			List<GenericValue> values) {
		List<CreditCardTypeGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CreditCardTypeGlAccount(value));
		}
		return entities;
	}
}