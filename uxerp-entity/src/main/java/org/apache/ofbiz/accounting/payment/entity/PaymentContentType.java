package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Content Type
 */
public class PaymentContentType implements Serializable {

	public static final long serialVersionUID = 2401569182466929664L;
	public static final String NAME = "PaymentContentType";
	/**
	 * Payment Content Type Id
	 */
	@Getter
	@Setter
	private String paymentContentTypeId;
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
		paymentContentTypeId, parentTypeId, hasTable, description
	}

	public PaymentContentType(GenericValue value) {
		paymentContentTypeId = (String) value.get(Fields.paymentContentTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PaymentContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentContentType(value);
	}

	public static List<PaymentContentType> fromValues(List<GenericValue> values) {
		List<PaymentContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentContentType(value));
		}
		return entities;
	}
}