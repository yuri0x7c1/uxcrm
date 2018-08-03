package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Role Type Attr
 */
public class RoleTypeAttr implements Serializable {

	public static final long serialVersionUID = 5078661384127650816L;
	public static final String NAME = "RoleTypeAttr";
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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

	public enum Fields {
		roleTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public RoleTypeAttr(GenericValue value) {
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static RoleTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RoleTypeAttr(value);
	}

	public static List<RoleTypeAttr> fromValues(List<GenericValue> values) {
		List<RoleTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RoleTypeAttr(value));
		}
		return entities;
	}
}