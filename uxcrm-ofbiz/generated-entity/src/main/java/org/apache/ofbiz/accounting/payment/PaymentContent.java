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
 * Payment Content
 */
@FieldNameConstants
public class PaymentContent implements Serializable {

	public static final long serialVersionUID = 2477438645742174208L;
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

	public PaymentContent(GenericValue value) {
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		paymentContentTypeId = (String) value
				.get(FIELD_PAYMENT_CONTENT_TYPE_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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