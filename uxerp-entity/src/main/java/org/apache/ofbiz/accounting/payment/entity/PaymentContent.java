package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Content
 */
public class PaymentContent implements Serializable {

	public static final long serialVersionUID = 6846243536643026944L;
	public static final String NAME = "PaymentContent";
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Payment Content Type Id
	 */
	@Getter
	@Setter
	private String paymentContentTypeId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
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
		paymentId, paymentContentTypeId, contentId, fromDate, thruDate
	}

	public PaymentContent(GenericValue value) {
		paymentId = (String) value.get(Fields.paymentId.name());
		paymentContentTypeId = (String) value.get(Fields.paymentContentTypeId
				.name());
		contentId = (String) value.get(Fields.contentId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static PaymentContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentContent(value);
	}

	public static List<PaymentContent> fromValues(List<GenericValue> values) {
		List<PaymentContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentContent(value));
		}
		return entities;
	}
}