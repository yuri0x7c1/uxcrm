package org.apache.ofbiz.accounting.fixedasset;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Fixed Asset Assign And Role
 */
@FieldNameConstants
public class PartyFixedAssetAssignAndRole implements Serializable {

	public static final long serialVersionUID = 1942294528355010560L;
	public static final String NAME = "PartyFixedAssetAssignAndRole";
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Allocated Date
	 */
	@Getter
	@Setter
	private Timestamp allocatedDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public PartyFixedAssetAssignAndRole(GenericValue value) {
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		allocatedDate = (Timestamp) value.get(FIELD_ALLOCATED_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
	}

	public static PartyFixedAssetAssignAndRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyFixedAssetAssignAndRole(value);
	}

	public static List<PartyFixedAssetAssignAndRole> fromValues(
			List<GenericValue> values) {
		List<PartyFixedAssetAssignAndRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyFixedAssetAssignAndRole(value));
		}
		return entities;
	}
}