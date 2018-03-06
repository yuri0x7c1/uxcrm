package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Method Type Gl Account
 */
public class PaymentMethodTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 8439059203604283392L;
	public static final String NAME = "PaymentMethodTypeGlAccount";
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
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
		paymentMethodTypeId, organizationPartyId, glAccountId
	}

	public PaymentMethodTypeGlAccount(GenericValue value) {
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
	}

	public static PaymentMethodTypeGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentMethodTypeGlAccount(value);
	}

	public static List<PaymentMethodTypeGlAccount> fromValues(
			List<GenericValue> values) {
		List<PaymentMethodTypeGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentMethodTypeGlAccount(value));
		}
		return entities;
	}
}