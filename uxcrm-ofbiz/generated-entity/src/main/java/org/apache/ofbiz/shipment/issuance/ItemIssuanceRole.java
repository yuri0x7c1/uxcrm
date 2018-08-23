package org.apache.ofbiz.shipment.issuance;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Item Issuance Role
 */
@FieldNameConstants
public class ItemIssuanceRole implements Serializable {

	public static final long serialVersionUID = 6762394846956740608L;
	public static final String NAME = "ItemIssuanceRole";
	/**
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
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

	public ItemIssuanceRole(GenericValue value) {
		itemIssuanceId = (String) value.get(FIELD_ITEM_ISSUANCE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ItemIssuanceRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ItemIssuanceRole(value);
	}

	public static List<ItemIssuanceRole> fromValues(List<GenericValue> values) {
		List<ItemIssuanceRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ItemIssuanceRole(value));
		}
		return entities;
	}
}