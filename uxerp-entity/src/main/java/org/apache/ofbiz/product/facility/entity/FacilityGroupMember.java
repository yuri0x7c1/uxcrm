package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Group Member
 */
public class FacilityGroupMember implements Serializable {

	public static final long serialVersionUID = 2136943116950319104L;
	public static final String NAME = "FacilityGroupMember";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Facility Group Id
	 */
	@Getter
	@Setter
	private String facilityGroupId;
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

	public enum Fields {
		facilityId, facilityGroupId, fromDate, thruDate, sequenceNum
	}

	public FacilityGroupMember(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		facilityGroupId = (String) value.get(Fields.facilityGroupId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static FacilityGroupMember fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityGroupMember(value);
	}

	public static List<FacilityGroupMember> fromValues(List<GenericValue> values) {
		List<FacilityGroupMember> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityGroupMember(value));
		}
		return entities;
	}
}