package org.apache.ofbiz.accounting.finaccount;

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
public class PmtGrpMembrPaymentAndFinAcctTrans implements Serializable {

	public static final long serialVersionUID = 5237764627050360832L;
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

	public enum Fields {
		finAccountId, partyId, finAccountTransStatusId, finAccountTransAmount, glReconciliationId, paymentGroupId, fromDate, sequenceNum, paymentId, thruDate, roleTypeIdTo, finAccountTransId, partyIdFrom, amount, paymentPreferenceId, comments, actualCurrencyAmount, overrideGlAccountId, paymentMethodTypeId, actualCurrencyUomId, paymentTypeId, currencyUomId, statusId, paymentMethodId, paymentGatewayResponseId, paymentRefNum, partyIdTo, effectiveDate
	}

	public PmtGrpMembrPaymentAndFinAcctTrans(GenericValue value) {
		finAccountId = (String) value.get(Fields.finAccountId.name());
		partyId = (String) value.get(Fields.partyId.name());
		finAccountTransStatusId = (String) value
				.get(Fields.finAccountTransStatusId.name());
		finAccountTransAmount = (BigDecimal) value
				.get(Fields.finAccountTransAmount.name());
		glReconciliationId = (String) value.get(Fields.glReconciliationId
				.name());
		paymentGroupId = (String) value.get(Fields.paymentGroupId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		paymentPreferenceId = (String) value.get(Fields.paymentPreferenceId
				.name());
		comments = (String) value.get(Fields.comments.name());
		actualCurrencyAmount = (BigDecimal) value
				.get(Fields.actualCurrencyAmount.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		actualCurrencyUomId = (String) value.get(Fields.actualCurrencyUomId
				.name());
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		statusId = (String) value.get(Fields.statusId.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		paymentGatewayResponseId = (String) value
				.get(Fields.paymentGatewayResponseId.name());
		paymentRefNum = (String) value.get(Fields.paymentRefNum.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		effectiveDate = (Timestamp) value.get(Fields.effectiveDate.name());
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