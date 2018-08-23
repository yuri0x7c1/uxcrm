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
 * Facility Group
 */
@FieldNameConstants
public class FacilityGroup implements Serializable {

	public static final long serialVersionUID = 1036476497256489984L;
	public static final String NAME = "FacilityGroup";
	/**
	 * Facility Group Id
	 */
	@Getter
	@Setter
	private String facilityGroupId;
	/**
	 * Facility Group Type Id
	 */
	@Getter
	@Setter
	private String facilityGroupTypeId;
	/**
	 * Primary Parent Group Id
	 */
	@Getter
	@Setter
	private String primaryParentGroupId;
	/**
	 * Facility Group Name
	 */
	@Getter
	@Setter
	private String facilityGroupName;
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

	public FacilityGroup(GenericValue value) {
		facilityGroupId = (String) value.get(FIELD_FACILITY_GROUP_ID);
		facilityGroupTypeId = (String) value.get(FIELD_FACILITY_GROUP_TYPE_ID);
		primaryParentGroupId = (String) value
				.get(FIELD_PRIMARY_PARENT_GROUP_ID);
		facilityGroupName = (String) value.get(FIELD_FACILITY_GROUP_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FacilityGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityGroup(value);
	}

	public static List<FacilityGroup> fromValues(List<GenericValue> values) {
		List<FacilityGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityGroup(value));
		}
		return entities;
	}
}