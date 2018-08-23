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
 * Gift Card
 */
@FieldNameConstants
public class GiftCard implements Serializable {

	public static final long serialVersionUID = 7639952326812094464L;
	public static final String NAME = "GiftCard";
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
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
	 * Expire Date
	 */
	@Getter
	@Setter
	private String expireDate;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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

	public GiftCard(GenericValue value) {
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		cardNumber = (String) value.get(FIELD_CARD_NUMBER);
		pinNumber = (String) value.get(FIELD_PIN_NUMBER);
		expireDate = (String) value.get(FIELD_EXPIRE_DATE);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GiftCard fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new GiftCard(value);
	}

	public static List<GiftCard> fromValues(List<GenericValue> values) {
		List<GiftCard> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GiftCard(value));
		}
		return entities;
	}
}