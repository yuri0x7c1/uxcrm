package org.apache.ofbiz.workeffort.timesheet;

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
 * Old Work Effort Assignment Rate
 */
@FieldNameConstants
public class OldWorkEffortAssignmentRate implements Serializable {

	public static final long serialVersionUID = 6352295836995505152L;
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

	public OldWorkEffortAssignmentRate(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		rateTypeId = (String) value.get(FIELD_RATE_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		rate = (BigDecimal) value.get(FIELD_RATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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