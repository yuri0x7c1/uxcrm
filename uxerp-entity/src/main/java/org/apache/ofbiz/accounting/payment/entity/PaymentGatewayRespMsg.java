package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway Resp Msg
 */
public class PaymentGatewayRespMsg implements Serializable {

	public static final long serialVersionUID = 9057332671051086848L;
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

	public enum Fields {
		paymentGatewayRespMsgId, paymentGatewayResponseId, pgrMessage
	}

	public PaymentGatewayRespMsg(GenericValue value) {
		paymentGatewayRespMsgId = (String) value
				.get(Fields.paymentGatewayRespMsgId.name());
		paymentGatewayResponseId = (String) value
				.get(Fields.paymentGatewayResponseId.name());
		pgrMessage = (String) value.get(Fields.pgrMessage.name());
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