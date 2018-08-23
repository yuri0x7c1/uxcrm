package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment
 */
@FieldNameConstants
public class Payment implements Serializable {

	public static final long serialVersionUID = 5942911621882327040L;
	public static final String NAME = "Payment";
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
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
	 * Payment Gateway Response Id
	 */
	@Getter
	@Setter
	private String paymentGatewayResponseId;
	/**
	 * Payment Preference Id
	 */
	@Getter
	@Setter
	private String paymentPreferenceId;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Effective Date
	 */
	@Getter
	@Setter
	private Timestamp effectiveDate;
	/**
	 * Payment Ref Num
	 */
	@Getter
	@Setter
	private String paymentRefNum;
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Fin Account Trans Id
	 */
	@Getter
	@Setter
	private String finAccountTransId;
	/**
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
	/**
	 * Actual Currency Amount
	 */
	@Getter
	@Setter
	private BigDecimal actualCurrencyAmount;
	/**
	 * Actual Currency Uom Id
	 */
	@Getter
	@Setter
	private String actualCurrencyUomId;
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

	public Payment(GenericValue value) {
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		paymentTypeId = (String) value.get(FIELD_PAYMENT_TYPE_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		paymentGatewayResponseId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_RESPONSE_ID);
		paymentPreferenceId = (String) value.get(FIELD_PAYMENT_PREFERENCE_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		statusId = (String) value.get(FIELD_STATUS_ID);
		effectiveDate = (Timestamp) value.get(FIELD_EFFECTIVE_DATE);
		paymentRefNum = (String) value.get(FIELD_PAYMENT_REF_NUM);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		finAccountTransId = (String) value.get(FIELD_FIN_ACCOUNT_TRANS_ID);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		actualCurrencyAmount = (BigDecimal) value
				.get(FIELD_ACTUAL_CURRENCY_AMOUNT);
		actualCurrencyUomId = (String) value.get(FIELD_ACTUAL_CURRENCY_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Payment fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Payment(value);
	}

	public static List<Payment> fromValues(List<GenericValue> values) {
		List<Payment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Payment(value));
		}
		return entities;
	}
}