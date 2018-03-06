package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Credit Card Type Gl Account
 */
public class CreditCardTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 4837265471965260800L;
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

	public enum Fields {
		cardType, organizationPartyId, glAccountId
	}

	public CreditCardTypeGlAccount(GenericValue value) {
		cardType = (String) value.get(Fields.cardType.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
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