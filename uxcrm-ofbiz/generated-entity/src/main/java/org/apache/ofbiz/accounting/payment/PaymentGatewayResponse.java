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
 * Payment Gateway Response
 */
@FieldNameConstants
public class PaymentGatewayResponse implements Serializable {

	public static final long serialVersionUID = 7004250602688033792L;
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

	public PaymentGatewayResponse(GenericValue value) {
		paymentGatewayResponseId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_RESPONSE_ID);
		paymentServiceTypeEnumId = (String) value
				.get(FIELD_PAYMENT_SERVICE_TYPE_ENUM_ID);
		orderPaymentPreferenceId = (String) value
				.get(FIELD_ORDER_PAYMENT_PREFERENCE_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		transCodeEnumId = (String) value.get(FIELD_TRANS_CODE_ENUM_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		referenceNum = (String) value.get(FIELD_REFERENCE_NUM);
		altReference = (String) value.get(FIELD_ALT_REFERENCE);
		subReference = (String) value.get(FIELD_SUB_REFERENCE);
		gatewayCode = (String) value.get(FIELD_GATEWAY_CODE);
		gatewayFlag = (String) value.get(FIELD_GATEWAY_FLAG);
		gatewayAvsResult = (String) value.get(FIELD_GATEWAY_AVS_RESULT);
		gatewayCvResult = (String) value.get(FIELD_GATEWAY_CV_RESULT);
		gatewayScoreResult = (String) value.get(FIELD_GATEWAY_SCORE_RESULT);
		gatewayMessage = (String) value.get(FIELD_GATEWAY_MESSAGE);
		transactionDate = (Timestamp) value.get(FIELD_TRANSACTION_DATE);
		resultDeclined = (String) value.get(FIELD_RESULT_DECLINED);
		resultNsf = (String) value.get(FIELD_RESULT_NSF);
		resultBadExpire = (String) value.get(FIELD_RESULT_BAD_EXPIRE);
		resultBadCardNumber = (String) value.get(FIELD_RESULT_BAD_CARD_NUMBER);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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