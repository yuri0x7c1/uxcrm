package org.apache.ofbiz.workeffort.timesheet;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Old Work Effort Assignment Rate
 */
public class OldWorkEffortAssignmentRate implements Serializable {

	public static final long serialVersionUID = 8146431993411109888L;
	public static final String NAME = "OldWorkEffortAssignmentRate";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	private BigDecimal rate;
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
		workEffortId, rateTypeId, partyId, fromDate, thruDate, rate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldWorkEffortAssignmentRate(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		rate = (BigDecimal) value.get(Fields.rate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OldWorkEffortAssignmentRate fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldWorkEffortAssignmentRate(value);
	}

	public static List<OldWorkEffortAssignmentRate> fromValues(
			List<GenericValue> values) {
		List<OldWorkEffortAssignmentRate> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldWorkEffortAssignmentRate(value));
		}
		return entities;
	}
}