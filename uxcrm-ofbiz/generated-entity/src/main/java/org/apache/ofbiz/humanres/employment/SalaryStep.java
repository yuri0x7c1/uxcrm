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
 * Salary Step
 */
public class SalaryStep implements Serializable {

	public static final long serialVersionUID = 7678359141844184064L;
	public static final String NAME = "SalaryStep";
	/**
	 * Salary Step Seq Id
	 */
	@Getter
	@Setter
	private String salaryStepSeqId;
	/**
	 * Pay Grade Id
	 */
	@Getter
	@Setter
	private String payGradeId;
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
	 * Date Modified
	 */
	@Getter
	@Setter
	private Timestamp dateModified;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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
		salaryStepSeqId, payGradeId, fromDate, thruDate, dateModified, amount, createdByUserLogin, lastModifiedByUserLogin, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SalaryStep(GenericValue value) {
		salaryStepSeqId = (String) value.get(Fields.salaryStepSeqId.name());
		payGradeId = (String) value.get(Fields.payGradeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		dateModified = (Timestamp) value.get(Fields.dateModified.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static SalaryStep fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalaryStep(value);
	}

	public static List<SalaryStep> fromValues(List<GenericValue> values) {
		List<SalaryStep> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalaryStep(value));
		}
		return entities;
	}
}