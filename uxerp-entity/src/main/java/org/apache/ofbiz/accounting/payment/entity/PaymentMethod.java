package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Method
 */
public class PaymentMethod implements Serializable {

	public static final long serialVersionUID = 2717741019372273664L;
	public static final String NAME = "PaymentMethod";
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		paymentMethodId, paymentMethodTypeId, partyId, glAccountId, finAccountId, description, fromDate, thruDate
	}

	public PaymentMethod(GenericValue value) {
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		finAccountId = (String) value.get(Fields.finAccountId.name());
		description = (String) value.get(Fields.description.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static PaymentMethod fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentMethod(value);
	}

	public static List<PaymentMethod> fromValues(List<GenericValue> values) {
		List<PaymentMethod> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentMethod(value));
		}
		return entities;
	}
}