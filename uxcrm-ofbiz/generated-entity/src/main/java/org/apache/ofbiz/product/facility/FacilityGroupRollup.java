package org.apache.ofbiz.product.facility;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class FacilityGroupRollup implements Serializable {

	public static final long serialVersionUID = 628345696441245696L;
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

	public FacilityGroupRollup(GenericValue value) {
		facilityGroupId = (String) value.get(FIELD_FACILITY_GROUP_ID);
		parentFacilityGroupId = (String) value
				.get(FIELD_PARENT_FACILITY_GROUP_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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