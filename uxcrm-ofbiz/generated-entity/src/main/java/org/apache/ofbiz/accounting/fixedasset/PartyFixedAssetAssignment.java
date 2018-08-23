package org.apache.ofbiz.accounting.fixedasset;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Fixed Asset Assignment
 */
@FieldNameConstants
public class PartyFixedAssetAssignment implements Serializable {

	public static final long serialVersionUID = 4574163861113239552L;
	public static final String NAME = "PartyFixedAssetAssignment";
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
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public PartyFixedAssetAssignment(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		allocatedDate = (Timestamp) value.get(FIELD_ALLOCATED_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyFixedAssetAssignment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyFixedAssetAssignment(value);
	}

	public static List<PartyFixedAssetAssignment> fromValues(
			List<GenericValue> values) {
		List<PartyFixedAssetAssignment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyFixedAssetAssignment(value));
		}
		return entities;
	}
}