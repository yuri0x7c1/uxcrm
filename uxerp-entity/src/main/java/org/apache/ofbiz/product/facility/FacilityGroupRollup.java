package org.apache.ofbiz.product.facility;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Group Rollup
 */
public class FacilityGroupRollup implements Serializable {

	public static final long serialVersionUID = 5389624016353931264L;
	public static final String NAME = "FacilityGroupRollup";
	/**
	 * Facility Group Id
	 */
	@Getter
	@Setter
	private String facilityGroupId;
	/**
	 * Parent Facility Group Id
	 */
	@Getter
	@Setter
	private String parentFacilityGroupId;
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
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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
		facilityGroupId, parentFacilityGroupId, fromDate, thruDate, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FacilityGroupRollup(GenericValue value) {
		facilityGroupId = (String) value.get(Fields.facilityGroupId.name());
		parentFacilityGroupId = (String) value.get(Fields.parentFacilityGroupId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FacilityGroupRollup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityGroupRollup(value);
	}

	public static List<FacilityGroupRollup> fromValues(List<GenericValue> values) {
		List<FacilityGroupRollup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityGroupRollup(value));
		}
		return entities;
	}
}