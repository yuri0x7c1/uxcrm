package org.apache.ofbiz.accounting.payment;

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
public class PaymentGatewayRespMsg implements Serializable {

	public static final long serialVersionUID = 7579282431157732352L;
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

	public enum Fields {
		paymentGatewayRespMsgId, paymentGatewayResponseId, pgrMessage, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewayRespMsg(GenericValue value) {
		paymentGatewayRespMsgId = (String) value
				.get(Fields.paymentGatewayRespMsgId.name());
		paymentGatewayResponseId = (String) value
				.get(Fields.paymentGatewayResponseId.name());
		pgrMessage = (String) value.get(Fields.pgrMessage.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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