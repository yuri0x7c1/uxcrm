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
 * Custom Method
 */
@FieldNameConstants
public class CustomMethod implements Serializable {

	public static final long serialVersionUID = 8599882300411973632L;
	public static final String NAME = "CustomMethod";
	/**
	 * Custom Method Id
	 */
	@Getter
	@Setter
	private String customMethodId;
	/**
	 * Custom Method Type Id
	 */
	@Getter
	@Setter
	private String customMethodTypeId;
	/**
	 * Custom Method Name
	 */
	@Getter
	@Setter
	private String customMethodName;
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

	public CustomMethod(GenericValue value) {
		customMethodId = (String) value.get(FIELD_CUSTOM_METHOD_ID);
		customMethodTypeId = (String) value.get(FIELD_CUSTOM_METHOD_TYPE_ID);
		customMethodName = (String) value.get(FIELD_CUSTOM_METHOD_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CustomMethod fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustomMethod(value);
	}

	public static List<CustomMethod> fromValues(List<GenericValue> values) {
		List<CustomMethod> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustomMethod(value));
		}
		return entities;
	}
}