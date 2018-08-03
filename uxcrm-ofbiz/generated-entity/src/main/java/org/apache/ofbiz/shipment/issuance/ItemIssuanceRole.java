package org.apache.ofbiz.shipment.issuance;

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
public class ItemIssuanceRole implements Serializable {

	public static final long serialVersionUID = 7545700875083556864L;
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

	public enum Fields {
		itemIssuanceId, partyId, roleTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ItemIssuanceRole(GenericValue value) {
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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