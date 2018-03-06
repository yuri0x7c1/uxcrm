package org.apache.ofbiz.accounting.finaccount.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Pmt Grp Membr Payment And Fin Acct Trans
 */
public class PmtGrpMembrPaymentAndFinAcctTrans implements Serializable {

	public static final long serialVersionUID = 7255426439296950272L;
	public static final String NAME = "PmtGrpMembrPaymentAndFinAcctTrans";
	/**
	 * Payment Group Id
	 */
	@Getter
	@Setter
	private String paymentGroupId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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
	 * Gl Reconciliation Id
	 */
	@Getter
	@Setter
	private String glReconciliationId;

	public enum Fields {
		paymentGroupId, paymentId, fromDate, thruDate, sequenceNum, paymentTypeId, paymentMethodTypeId, paymentMethodId, paymentGatewayResponseId, paymentPreferenceId, partyIdFrom, partyIdTo, roleTypeIdTo, statusId, effectiveDate, paymentRefNum, amount, currencyUomId, comments, finAccountTransId, overrideGlAccountId, actualCurrencyAmount, actualCurrencyUomId, finAccountId, partyId, glReconciliationId
	}

	public PmtGrpMembrPaymentAndFinAcctTrans(GenericValue value) {
		paymentGroupId = (String) value.get(Fields.paymentGroupId.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		paymentGatewayResponseId = (String) value
				.get(Fields.paymentGatewayResponseId.name());
		paymentPreferenceId = (String) value.get(Fields.paymentPreferenceId
				.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		statusId = (String) value.get(Fields.statusId.name());
		effectiveDate = (Timestamp) value.get(Fields.effectiveDate.name());
		paymentRefNum = (String) value.get(Fields.paymentRefNum.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		comments = (String) value.get(Fields.comments.name());
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		actualCurrencyAmount = (BigDecimal) value
				.get(Fields.actualCurrencyAmount.name());
		actualCurrencyUomId = (String) value.get(Fields.actualCurrencyUomId
				.name());
		finAccountId = (String) value.get(Fields.finAccountId.name());
		partyId = (String) value.get(Fields.partyId.name());
		glReconciliationId = (String) value.get(Fields.glReconciliationId
				.name());
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