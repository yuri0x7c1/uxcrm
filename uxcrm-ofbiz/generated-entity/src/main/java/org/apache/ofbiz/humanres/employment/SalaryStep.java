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
 * Salary Step
 */
@FieldNameConstants
public class SalaryStep implements Serializable {

	public static final long serialVersionUID = 6324458496990386176L;
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

	public SalaryStep(GenericValue value) {
		salaryStepSeqId = (String) value.get(FIELD_SALARY_STEP_SEQ_ID);
		payGradeId = (String) value.get(FIELD_PAY_GRADE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		dateModified = (Timestamp) value.get(FIELD_DATE_MODIFIED);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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