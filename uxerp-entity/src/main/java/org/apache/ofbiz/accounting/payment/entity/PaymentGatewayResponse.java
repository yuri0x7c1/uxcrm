package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway Response
 */
public class PaymentGatewayResponse implements Serializable {

	public static final long serialVersionUID = 4428014360312925184L;
	public static final String NAME = "PaymentGatewayResponse";
	/**
	 * Payment Gateway Response Id
	 */
	@Getter
	@Setter
	private String paymentGatewayResponseId;
	/**
	 * Payment Service Type Enum Id
	 */
	@Getter
	@Setter
	private String paymentServiceTypeEnumId;
	/**
	 * Order Payment Preference Id
	 */
	@Getter
	@Setter
	private String orderPaymentPreferenceId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Trans Code Enum Id
	 */
	@Getter
	@Setter
	private String transCodeEnumId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Reference Num
	 */
	@Getter
	@Setter
	private String referenceNum;
	/**
	 * Alt Reference
	 */
	@Getter
	@Setter
	private String altReference;
	/**
	 * Sub Reference
	 */
	@Getter
	@Setter
	private String subReference;
	/**
	 * Gateway Code
	 */
	@Getter
	@Setter
	private String gatewayCode;
	/**
	 * Gateway Flag
	 */
	@Getter
	@Setter
	private String gatewayFlag;
	/**
	 * Gateway Avs Result
	 */
	@Getter
	@Setter
	private String gatewayAvsResult;
	/**
	 * Gateway Cv Result
	 */
	@Getter
	@Setter
	private String gatewayCvResult;
	/**
	 * Gateway Score Result
	 */
	@Getter
	@Setter
	private String gatewayScoreResult;
	/**
	 * Gateway Message
	 */
	@Getter
	@Setter
	private String gatewayMessage;
	/**
	 * Transaction Date
	 */
	@Getter
	@Setter
	private Timestamp transactionDate;
	/**
	 * Result Declined
	 */
	@Getter
	@Setter
	private String resultDeclined;
	/**
	 * Result Nsf
	 */
	@Getter
	@Setter
	private String resultNsf;
	/**
	 * Result Bad Expire
	 */
	@Getter
	@Setter
	private String resultBadExpire;
	/**
	 * Result Bad Card Number
	 */
	@Getter
	@Setter
	private String resultBadCardNumber;

	public enum Fields {
		paymentGatewayResponseId, paymentServiceTypeEnumId, orderPaymentPreferenceId, paymentMethodTypeId, paymentMethodId, transCodeEnumId, amount, currencyUomId, referenceNum, altReference, subReference, gatewayCode, gatewayFlag, gatewayAvsResult, gatewayCvResult, gatewayScoreResult, gatewayMessage, transactionDate, resultDeclined, resultNsf, resultBadExpire, resultBadCardNumber
	}

	public PaymentGatewayResponse(GenericValue value) {
		paymentGatewayResponseId = (String) value
				.get(Fields.paymentGatewayResponseId.name());
		paymentServiceTypeEnumId = (String) value
				.get(Fields.paymentServiceTypeEnumId.name());
		orderPaymentPreferenceId = (String) value
				.get(Fields.orderPaymentPreferenceId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		transCodeEnumId = (String) value.get(Fields.transCodeEnumId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		referenceNum = (String) value.get(Fields.referenceNum.name());
		altReference = (String) value.get(Fields.altReference.name());
		subReference = (String) value.get(Fields.subReference.name());
		gatewayCode = (String) value.get(Fields.gatewayCode.name());
		gatewayFlag = (String) value.get(Fields.gatewayFlag.name());
		gatewayAvsResult = (String) value.get(Fields.gatewayAvsResult.name());
		gatewayCvResult = (String) value.get(Fields.gatewayCvResult.name());
		gatewayScoreResult = (String) value.get(Fields.gatewayScoreResult
				.name());
		gatewayMessage = (String) value.get(Fields.gatewayMessage.name());
		transactionDate = (Timestamp) value.get(Fields.transactionDate.name());
		resultDeclined = (String) value.get(Fields.resultDeclined.name());
		resultNsf = (String) value.get(Fields.resultNsf.name());
		resultBadExpire = (String) value.get(Fields.resultBadExpire.name());
		resultBadCardNumber = (String) value.get(Fields.resultBadCardNumber
				.name());
	}

	public static PaymentGatewayResponse fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayResponse(value);
	}

	public static List<PaymentGatewayResponse> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayResponse> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayResponse(value));
		}
		return entities;
	}
}