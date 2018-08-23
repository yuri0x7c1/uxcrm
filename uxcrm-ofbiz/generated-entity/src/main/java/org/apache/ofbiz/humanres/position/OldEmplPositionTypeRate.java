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
 * Old Empl Position Type Rate
 */
@FieldNameConstants
public class OldEmplPositionTypeRate implements Serializable {

	public static final long serialVersionUID = 5090650820058470400L;
	public static final String NAME = "OldEmplPositionTypeRate";
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
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
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
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
	 * Rate
	 */
	@Getter
	@Setter
	private String rate;
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

	public OldEmplPositionTypeRate(GenericValue value) {
		emplPositionTypeId = (String) value.get(FIELD_EMPL_POSITION_TYPE_ID);
		periodTypeId = (String) value.get(FIELD_PERIOD_TYPE_ID);
		payGradeId = (String) value.get(FIELD_PAY_GRADE_ID);
		salaryStepSeqId = (String) value.get(FIELD_SALARY_STEP_SEQ_ID);
		rateTypeId = (String) value.get(FIELD_RATE_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		rate = (String) value.get(FIELD_RATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OldEmplPositionTypeRate fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldEmplPositionTypeRate(value);
	}

	public static List<OldEmplPositionTypeRate> fromValues(
			List<GenericValue> values) {
		List<OldEmplPositionTypeRate> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldEmplPositionTypeRate(value));
		}
		return entities;
	}
}