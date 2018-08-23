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
 * Old Salary Step
 */
@FieldNameConstants
public class OldSalaryStep implements Serializable {

	public static final long serialVersionUID = 3328326892046176256L;
	public static final String NAME = "OldSalaryStep";
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

	public OldSalaryStep(GenericValue value) {
		salaryStepSeqId = (String) value.get(FIELD_SALARY_STEP_SEQ_ID);
		payGradeId = (String) value.get(FIELD_PAY_GRADE_ID);
		dateModified = (Timestamp) value.get(FIELD_DATE_MODIFIED);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OldSalaryStep fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldSalaryStep(value);
	}

	public static List<OldSalaryStep> fromValues(List<GenericValue> values) {
		List<OldSalaryStep> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldSalaryStep(value));
		}
		return entities;
	}
}