package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gift Card Fulfillment
 */
public class GiftCardFulfillment implements Serializable {

	public static final long serialVersionUID = 6071310847086650368L;
	public static final String NAME = "GiftCardFulfillment";
	/**
	 * Fulfillment Id
	 */
	@Getter
	@Setter
	private String fulfillmentId;
	/**
	 * Type Enum Id
	 */
	@Getter
	@Setter
	private String typeEnumId;
	/**
	 * Merchant Id
	 */
	@Getter
	@Setter
	private String merchantId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Survey Response Id
	 */
	@Getter
	@Setter
	private String surveyResponseId;
	/**
	 * Card Number
	 */
	@Getter
	@Setter
	private String cardNumber;
	/**
	 * Pin Number
	 */
	@Getter
	@Setter
	private String pinNumber;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Response Code
	 */
	@Getter
	@Setter
	private String responseCode;
	/**
	 * Reference Num
	 */
	@Getter
	@Setter
	private String referenceNum;
	/**
	 * Auth Code
	 */
	@Getter
	@Setter
	private String authCode;
	/**
	 * Fulfillment Date
	 */
	@Getter
	@Setter
	private Timestamp fulfillmentDate;
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

	public enum Fields {
		fulfillmentId, typeEnumId, merchantId, partyId, orderId, orderItemSeqId, surveyResponseId, cardNumber, pinNumber, amount, responseCode, referenceNum, authCode, fulfillmentDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GiftCardFulfillment(GenericValue value) {
		fulfillmentId = (String) value.get(Fields.fulfillmentId.name());
		typeEnumId = (String) value.get(Fields.typeEnumId.name());
		merchantId = (String) value.get(Fields.merchantId.name());
		partyId = (String) value.get(Fields.partyId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
		cardNumber = (String) value.get(Fields.cardNumber.name());
		pinNumber = (String) value.get(Fields.pinNumber.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		responseCode = (String) value.get(Fields.responseCode.name());
		referenceNum = (String) value.get(Fields.referenceNum.name());
		authCode = (String) value.get(Fields.authCode.name());
		fulfillmentDate = (Timestamp) value.get(Fields.fulfillmentDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static GiftCardFulfillment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GiftCardFulfillment(value);
	}

	public static List<GiftCardFulfillment> fromValues(List<GenericValue> values) {
		List<GiftCardFulfillment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GiftCardFulfillment(value));
		}
		return entities;
	}
}