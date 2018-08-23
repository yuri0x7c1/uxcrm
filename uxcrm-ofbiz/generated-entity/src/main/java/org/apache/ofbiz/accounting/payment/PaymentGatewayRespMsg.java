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
 * Payment Gateway Resp Msg
 */
@FieldNameConstants
public class PaymentGatewayRespMsg implements Serializable {

	public static final long serialVersionUID = 6348607848936376320L;
	public static final String NAME = "PaymentGatewayRespMsg";
	/**
	 * Payment Gateway Resp Msg Id
	 */
	@Getter
	@Setter
	private String paymentGatewayRespMsgId;
	/**
	 * Payment Gateway Response Id
	 */
	@Getter
	@Setter
	private String paymentGatewayResponseId;
	/**
	 * Pgr Message
	 */
	@Getter
	@Setter
	private String pgrMessage;
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

	public PaymentGatewayRespMsg(GenericValue value) {
		paymentGatewayRespMsgId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_RESP_MSG_ID);
		paymentGatewayResponseId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_RESPONSE_ID);
		pgrMessage = (String) value.get(FIELD_PGR_MESSAGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGatewayRespMsg fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayRespMsg(value);
	}

	public static List<PaymentGatewayRespMsg> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayRespMsg> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayRespMsg(value));
		}
		return entities;
	}
}