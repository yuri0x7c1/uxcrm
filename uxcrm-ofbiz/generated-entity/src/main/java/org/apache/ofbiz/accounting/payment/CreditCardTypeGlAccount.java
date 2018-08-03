package org.apache.ofbiz.accounting.payment;

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
public class CreditCardTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 956953203732491264L;
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

	public enum Fields {
		cardType, organizationPartyId, glAccountId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CreditCardTypeGlAccount(GenericValue value) {
		cardType = (String) value.get(Fields.cardType.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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