package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Group
 */
public class PaymentGroup implements Serializable {

	public static final long serialVersionUID = 2267314408171915264L;
	public static final String NAME = "PaymentGroup";
	/**
	 * Payment Group Id
	 */
	@Getter
	@Setter
	private String paymentGroupId;
	/**
	 * Payment Group Type Id
	 */
	@Getter
	@Setter
	private String paymentGroupTypeId;
	/**
	 * Payment Group Name
	 */
	@Getter
	@Setter
	private String paymentGroupName;

	public enum Fields {
		paymentGroupId, paymentGroupTypeId, paymentGroupName
	}

	public PaymentGroup(GenericValue value) {
		paymentGroupId = (String) value.get(Fields.paymentGroupId.name());
		paymentGroupTypeId = (String) value.get(Fields.paymentGroupTypeId
				.name());
		paymentGroupName = (String) value.get(Fields.paymentGroupName.name());
	}

	public static PaymentGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGroup(value);
	}

	public static List<PaymentGroup> fromValues(List<GenericValue> values) {
		List<PaymentGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGroup(value));
		}
		return entities;
	}
}