package org.apache.ofbiz.humanres.position;

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
public class OldEmplPositionTypeRate implements Serializable {

	public static final long serialVersionUID = 6773422818710854656L;
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

	public enum Fields {
		emplPositionTypeId, periodTypeId, payGradeId, salaryStepSeqId, rateTypeId, fromDate, thruDate, rate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldEmplPositionTypeRate(GenericValue value) {
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		payGradeId = (String) value.get(Fields.payGradeId.name());
		salaryStepSeqId = (String) value.get(Fields.salaryStepSeqId.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		rate = (String) value.get(Fields.rate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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