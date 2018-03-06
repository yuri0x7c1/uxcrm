package org.apache.ofbiz.order._return.entity;

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
public class ReturnItemResponse implements Serializable {

	public static final long serialVersionUID = 8678016374327929856L;
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

	public enum Fields {
		returnItemResponseId, orderPaymentPreferenceId, replacementOrderId, paymentId, billingAccountId, finAccountTransId, responseAmount, responseDate
	}

	public ReturnItemResponse(GenericValue value) {
		returnItemResponseId = (String) value.get(Fields.returnItemResponseId
				.name());
		orderPaymentPreferenceId = (String) value
				.get(Fields.orderPaymentPreferenceId.name());
		replacementOrderId = (String) value.get(Fields.replacementOrderId
				.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		responseAmount = (BigDecimal) value.get(Fields.responseAmount.name());
		responseDate = (Timestamp) value.get(Fields.responseDate.name());
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