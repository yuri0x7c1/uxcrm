package org.apache.ofbiz.humanres.position;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position Type Rate
 */
@FieldNameConstants
public class EmplPositionTypeRate implements Serializable {

	public static final long serialVersionUID = 7699179962798824448L;
	public static final String NAME = "EmplPositionTypeRate";
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Pay Grade Id
	 */
	@Getter
	@Setter
	private String payGradeId;
	/**
	 * Salary Step Seq Id
	 */
	@Getter
	@Setter
	private String salaryStepSeqId;
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

	public EmplPositionTypeRate(GenericValue value) {
		emplPositionTypeId = (String) value.get(FIELD_EMPL_POSITION_TYPE_ID);
		rateTypeId = (String) value.get(FIELD_RATE_TYPE_ID);
		payGradeId = (String) value.get(FIELD_PAY_GRADE_ID);
		salaryStepSeqId = (String) value.get(FIELD_SALARY_STEP_SEQ_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EmplPositionTypeRate fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionTypeRate(value);
	}

	public static List<EmplPositionTypeRate> fromValues(
			List<GenericValue> values) {
		List<EmplPositionTypeRate> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionTypeRate(value));
		}
		return entities;
	}
}