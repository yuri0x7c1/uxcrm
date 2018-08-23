package org.apache.ofbiz.order._return;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Item Response
 */
@FieldNameConstants
public class ReturnItemResponse implements Serializable {

	public static final long serialVersionUID = 6899061729697036288L;
	public static final String NAME = "ReturnItemResponse";
	/**
	 * Return Item Response Id
	 */
	@Getter
	@Setter
	private String returnItemResponseId;
	/**
	 * Order Payment Preference Id
	 */
	@Getter
	@Setter
	private String orderPaymentPreferenceId;
	/**
	 * Replacement Order Id
	 */
	@Getter
	@Setter
	private String replacementOrderId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Fin Account Trans Id
	 */
	@Getter
	@Setter
	private String finAccountTransId;
	/**
	 * Response Amount
	 */
	@Getter
	@Setter
	private BigDecimal responseAmount;
	/**
	 * Response Date
	 */
	@Getter
	@Setter
	private Timestamp responseDate;
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

	public ReturnItemResponse(GenericValue value) {
		returnItemResponseId = (String) value
				.get(FIELD_RETURN_ITEM_RESPONSE_ID);
		orderPaymentPreferenceId = (String) value
				.get(FIELD_ORDER_PAYMENT_PREFERENCE_ID);
		replacementOrderId = (String) value.get(FIELD_REPLACEMENT_ORDER_ID);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		finAccountTransId = (String) value.get(FIELD_FIN_ACCOUNT_TRANS_ID);
		responseAmount = (BigDecimal) value.get(FIELD_RESPONSE_AMOUNT);
		responseDate = (Timestamp) value.get(FIELD_RESPONSE_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReturnItemResponse fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnItemResponse(value);
	}

	public static List<ReturnItemResponse> fromValues(List<GenericValue> values) {
		List<ReturnItemResponse> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnItemResponse(value));
		}
		return entities;
	}
}