package org.apache.ofbiz.humanres.employment.entity;

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

	public static final long serialVersionUID = 7634893289418599424L;
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

	public enum Fields {
		salaryStepSeqId, payGradeId, fromDate, thruDate, dateModified, amount, createdByUserLogin, lastModifiedByUserLogin
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