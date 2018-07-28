package org.apache.ofbiz.humanres.employment;

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
public class PayrollPreference implements Serializable {

	public static final long serialVersionUID = 7710589266770385920L;
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

	public enum Fields {
		partyId, roleTypeId, payrollPreferenceSeqId, deductionTypeId, paymentMethodTypeId, periodTypeId, fromDate, thruDate, percentage, flatAmount, routingNumber, accountNumber, bankName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PayrollPreference(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		payrollPreferenceSeqId = (String) value
				.get(Fields.payrollPreferenceSeqId.name());
		deductionTypeId = (String) value.get(Fields.deductionTypeId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		percentage = (Double) value.get(Fields.percentage.name());
		flatAmount = (BigDecimal) value.get(Fields.flatAmount.name());
		routingNumber = (String) value.get(Fields.routingNumber.name());
		accountNumber = (String) value.get(Fields.accountNumber.name());
		bankName = (String) value.get(Fields.bankName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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