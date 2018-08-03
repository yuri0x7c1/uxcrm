package org.apache.ofbiz.humanres.position;

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
public class EmplPositionTypeRate implements Serializable {

	public static final long serialVersionUID = 3910659595807503360L;
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

	public enum Fields {
		emplPositionTypeId, rateTypeId, payGradeId, salaryStepSeqId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EmplPositionTypeRate(GenericValue value) {
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		payGradeId = (String) value.get(Fields.payGradeId.name());
		salaryStepSeqId = (String) value.get(Fields.salaryStepSeqId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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