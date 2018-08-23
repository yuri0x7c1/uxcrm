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
 * Facility Group Role
 */
@FieldNameConstants
public class FacilityGroupRole implements Serializable {

	public static final long serialVersionUID = 1431029140490544128L;
	public static final String NAME = "FacilityGroupRole";
	/**
	 * Facility Group Id
	 */
	@Getter
	@Setter
	private String facilityGroupId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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

	public FacilityGroupRole(GenericValue value) {
		facilityGroupId = (String) value.get(FIELD_FACILITY_GROUP_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FacilityGroupRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityGroupRole(value);
	}

	public static List<FacilityGroupRole> fromValues(List<GenericValue> values) {
		List<FacilityGroupRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityGroupRole(value));
		}
		return entities;
	}
}