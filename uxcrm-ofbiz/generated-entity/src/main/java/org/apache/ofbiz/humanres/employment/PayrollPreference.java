package org.apache.ofbiz.humanres.employment;

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
 * Payroll Preference
 */
@FieldNameConstants
public class PayrollPreference implements Serializable {

	public static final long serialVersionUID = 3643145433676311552L;
	public static final String NAME = "PayrollPreference";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Payroll Preference Seq Id
	 */
	@Getter
	@Setter
	private String payrollPreferenceSeqId;
	/**
	 * Deduction Type Id
	 */
	@Getter
	@Setter
	private String deductionTypeId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
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
	 * Percentage
	 */
	@Getter
	@Setter
	private Double percentage;
	/**
	 * Flat Amount
	 */
	@Getter
	@Setter
	private BigDecimal flatAmount;
	/**
	 * Routing Number
	 */
	@Getter
	@Setter
	private String routingNumber;
	/**
	 * Account Number
	 */
	@Getter
	@Setter
	private String accountNumber;
	/**
	 * Bank Name
	 */
	@Getter
	@Setter
	private String bankName;
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

	public PayrollPreference(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		payrollPreferenceSeqId = (String) value
				.get(FIELD_PAYROLL_PREFERENCE_SEQ_ID);
		deductionTypeId = (String) value.get(FIELD_DEDUCTION_TYPE_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		periodTypeId = (String) value.get(FIELD_PERIOD_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		percentage = (Double) value.get(FIELD_PERCENTAGE);
		flatAmount = (BigDecimal) value.get(FIELD_FLAT_AMOUNT);
		routingNumber = (String) value.get(FIELD_ROUTING_NUMBER);
		accountNumber = (String) value.get(FIELD_ACCOUNT_NUMBER);
		bankName = (String) value.get(FIELD_BANK_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PayrollPreference fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PayrollPreference(value);
	}

	public static List<PayrollPreference> fromValues(List<GenericValue> values) {
		List<PayrollPreference> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PayrollPreference(value));
		}
		return entities;
	}
}