package org.apache.ofbiz.accounting.fixedasset;

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
public class PartyFixedAssetAssignAndRole implements Serializable {

	public static final long serialVersionUID = 8343268786676862976L;
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

	public enum Fields {
		fromDate, roleTypeId, comments, allocatedDate, statusId, fixedAssetId, partyId, thruDate, parentTypeId, hasTable, description
	}

	public PartyFixedAssetAssignAndRole(GenericValue value) {
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		comments = (String) value.get(Fields.comments.name());
		allocatedDate = (Timestamp) value.get(Fields.allocatedDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		partyId = (String) value.get(Fields.partyId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
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