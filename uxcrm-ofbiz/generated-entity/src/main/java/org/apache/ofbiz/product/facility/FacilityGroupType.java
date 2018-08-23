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
 * Facility Group Type
 */
@FieldNameConstants
public class FacilityGroupType implements Serializable {

	public static final long serialVersionUID = 3261787242529819648L;
	public static final String NAME = "FacilityGroupType";
	/**
	 * Facility Group Type Id
	 */
	@Getter
	@Setter
	private String facilityGroupTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public FacilityGroupType(GenericValue value) {
		facilityGroupTypeId = (String) value.get(FIELD_FACILITY_GROUP_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FacilityGroupType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityGroupType(value);
	}

	public static List<FacilityGroupType> fromValues(List<GenericValue> values) {
		List<FacilityGroupType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityGroupType(value));
		}
		return entities;
	}
}