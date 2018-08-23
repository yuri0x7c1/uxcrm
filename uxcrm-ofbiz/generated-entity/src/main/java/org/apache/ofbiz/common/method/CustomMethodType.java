package org.apache.ofbiz.common.method;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Custom Method Type
 */
@FieldNameConstants
public class CustomMethodType implements Serializable {

	public static final long serialVersionUID = 8066102615749453824L;
	public static final String NAME = "CustomMethodType";
	/**
	 * Custom Method Type Id
	 */
	@Getter
	@Setter
	private String customMethodTypeId;
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

	public CustomMethodType(GenericValue value) {
		customMethodTypeId = (String) value.get(FIELD_CUSTOM_METHOD_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CustomMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustomMethodType(value);
	}

	public static List<CustomMethodType> fromValues(List<GenericValue> values) {
		List<CustomMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustomMethodType(value));
		}
		return entities;
	}
}