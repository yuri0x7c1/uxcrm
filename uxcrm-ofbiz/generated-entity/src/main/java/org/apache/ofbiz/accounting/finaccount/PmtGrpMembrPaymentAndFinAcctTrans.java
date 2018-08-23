package org.apache.ofbiz.accounting.finaccount;

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
 * Pmt Grp Membr Payment And Fin Acct Trans
 */
@FieldNameConstants
public class PmtGrpMembrPaymentAndFinAcctTrans implements Serializable {

	public static final long serialVersionUID = 260943395803637760L;
	public static final String NAME = "PmtGrpMembrPaymentAndFinAcctTrans";
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Fin Account Trans Status Id
	 */
	@Getter
	@Setter
	private String finAccountTransStatusId;
	/**
	 * Fin Account Trans Amount
	 */
	@Getter
	@Setter
	private BigDecimal finAccountTransAmount;
	/**
	 * Gl Reconciliation Id
	 */
	@Getter
	@Setter
	private String glReconciliationId;
	/**
	 * Payment Group Id
	 */
	@Getter
	@Setter
	private String paymentGroupId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Fin Account Trans Id
	 */
	@Getter
	@Setter
	private String finAccountTransId;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Payment Preference Id
	 */
	@Getter
	@Setter
	private String paymentPreferenceId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Actual Currency Amount
	 */
	@Getter
	@Setter
	private BigDecimal actualCurrencyAmount;
	/**
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Actual Currency Uom Id
	 */
	@Getter
	@Setter
	private String actualCurrencyUomId;
	/**
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * Payment Ref Num
	 */
	@Getter
	@Setter
	private String paymentRefNum;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Effective Date
	 */
	@Getter
	@Setter
	private Timestamp effectiveDate;

	public PmtGrpMembrPaymentAndFinAcctTrans(GenericValue value) {
		finAccountId = (String) value.get(FIELD_FIN_ACCOUNT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		finAccountTransStatusId = (String) value
				.get(FIELD_FIN_ACCOUNT_TRANS_STATUS_ID);
		finAccountTransAmount = (BigDecimal) value
				.get(FIELD_FIN_ACCOUNT_TRANS_AMOUNT);
		glReconciliationId = (String) value.get(FIELD_GL_RECONCILIATION_ID);
		paymentGroupId = (String) value.get(FIELD_PAYMENT_GROUP_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		finAccountTransId = (String) value.get(FIELD_FIN_ACCOUNT_TRANS_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		paymentPreferenceId = (String) value.get(FIELD_PAYMENT_PREFERENCE_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		actualCurrencyAmount = (BigDecimal) value
				.get(FIELD_ACTUAL_CURRENCY_AMOUNT);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		actualCurrencyUomId = (String) value.get(FIELD_ACTUAL_CURRENCY_UOM_ID);
		paymentTypeId = (String) value.get(FIELD_PAYMENT_TYPE_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		paymentGatewayResponseId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_RESPONSE_ID);
		paymentRefNum = (String) value.get(FIELD_PAYMENT_REF_NUM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		effectiveDate = (Timestamp) value.get(FIELD_EFFECTIVE_DATE);
	}

	public static PmtGrpMembrPaymentAndFinAcctTrans fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PmtGrpMembrPaymentAndFinAcctTrans(value);
	}

	public static List<PmtGrpMembrPaymentAndFinAcctTrans> fromValues(
			List<GenericValue> values) {
		List<PmtGrpMembrPaymentAndFinAcctTrans> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PmtGrpMembrPaymentAndFinAcctTrans(value));
		}
		return entities;
	}
}