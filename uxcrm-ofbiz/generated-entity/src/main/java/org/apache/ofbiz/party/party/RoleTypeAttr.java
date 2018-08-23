package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class RoleTypeAttr implements Serializable {

	public static final long serialVersionUID = 309380986687912960L;
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

	public RoleTypeAttr(GenericValue value) {
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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