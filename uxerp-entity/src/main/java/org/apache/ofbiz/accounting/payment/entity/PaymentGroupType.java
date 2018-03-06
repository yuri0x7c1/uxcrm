package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Group Type
 */
public class PaymentGroupType implements Serializable {

	public static final long serialVersionUID = 4969414929410884608L;
	public static final String NAME = "PaymentGroupType";
	/**
	 * Payment Group Type Id
	 */
	@Getter
	@Setter
	private String paymentGroupTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		paymentGroupTypeId, parentTypeId, hasTable, description
	}

	public PaymentGroupType(GenericValue value) {
		paymentGroupTypeId = (String) value.get(Fields.paymentGroupTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PaymentGroupType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGroupType(value);
	}

	public static List<PaymentGroupType> fromValues(List<GenericValue> values) {
		List<PaymentGroupType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGroupType(value));
		}
		return entities;
	}
}