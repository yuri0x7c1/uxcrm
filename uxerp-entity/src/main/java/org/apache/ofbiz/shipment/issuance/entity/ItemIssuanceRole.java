package org.apache.ofbiz.shipment.issuance.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Item Issuance Role
 */
public class ItemIssuanceRole implements Serializable {

	public static final long serialVersionUID = 7328719078946624512L;
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

	public enum Fields {
		itemIssuanceId, partyId, roleTypeId
	}

	public ItemIssuanceRole(GenericValue value) {
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
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