package org.apache.ofbiz.common.uom;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom Group
 */
@FieldNameConstants
public class UomGroup implements Serializable {

	public static final long serialVersionUID = 3953536565455869952L;
	public static final String NAME = "UomGroup";
	/**
	 * Uom Group Id
	 */
	@Getter
	@Setter
	private String uomGroupId;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
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

	public UomGroup(GenericValue value) {
		uomGroupId = (String) value.get(FIELD_UOM_GROUP_ID);
		uomId = (String) value.get(FIELD_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static UomGroup fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new UomGroup(value);
	}

	public static List<UomGroup> fromValues(List<GenericValue> values) {
		List<UomGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UomGroup(value));
		}
		return entities;
	}
}