package org.apache.ofbiz.accounting.payment;

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
 * Gift Card Fulfillment
 */
@FieldNameConstants
public class GiftCardFulfillment implements Serializable {

	public static final long serialVersionUID = 3804788092166774784L;
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

	public GiftCardFulfillment(GenericValue value) {
		fulfillmentId = (String) value.get(FIELD_FULFILLMENT_ID);
		typeEnumId = (String) value.get(FIELD_TYPE_ENUM_ID);
		merchantId = (String) value.get(FIELD_MERCHANT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		surveyResponseId = (String) value.get(FIELD_SURVEY_RESPONSE_ID);
		cardNumber = (String) value.get(FIELD_CARD_NUMBER);
		pinNumber = (String) value.get(FIELD_PIN_NUMBER);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		responseCode = (String) value.get(FIELD_RESPONSE_CODE);
		referenceNum = (String) value.get(FIELD_REFERENCE_NUM);
		authCode = (String) value.get(FIELD_AUTH_CODE);
		fulfillmentDate = (Timestamp) value.get(FIELD_FULFILLMENT_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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