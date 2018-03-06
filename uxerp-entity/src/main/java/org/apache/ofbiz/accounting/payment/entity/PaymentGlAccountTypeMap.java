package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gl Account Type Map
 */
public class PaymentGlAccountTypeMap implements Serializable {

	public static final long serialVersionUID = 3497826241911128064L;
	public static final String NAME = "PaymentGlAccountTypeMap";
	/**
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;

	public enum Fields {
		paymentTypeId, organizationPartyId, glAccountTypeId
	}

	public PaymentGlAccountTypeMap(GenericValue value) {
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
	}

	public static PaymentGlAccountTypeMap fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGlAccountTypeMap(value);
	}

	public static List<PaymentGlAccountTypeMap> fromValues(
			List<GenericValue> values) {
		List<PaymentGlAccountTypeMap> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGlAccountTypeMap(value));
		}
		return entities;
	}
}