package org.apache.ofbiz.order._return;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Item Type Map
 */
@FieldNameConstants
public class ReturnItemTypeMap implements Serializable {

	public static final long serialVersionUID = 81599287643777024L;
	public static final String NAME = "ReturnItemTypeMap";
	/**
	 * Return Item Map Key
	 */
	@Getter
	@Setter
	private String returnItemMapKey;
	/**
	 * Return Header Type Id
	 */
	@Getter
	@Setter
	private String returnHeaderTypeId;
	/**
	 * Return Item Type Id
	 */
	@Getter
	@Setter
	private String returnItemTypeId;
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

	public ReturnItemTypeMap(GenericValue value) {
		returnItemMapKey = (String) value.get(FIELD_RETURN_ITEM_MAP_KEY);
		returnHeaderTypeId = (String) value.get(FIELD_RETURN_HEADER_TYPE_ID);
		returnItemTypeId = (String) value.get(FIELD_RETURN_ITEM_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReturnItemTypeMap fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnItemTypeMap(value);
	}

	public static List<ReturnItemTypeMap> fromValues(List<GenericValue> values) {
		List<ReturnItemTypeMap> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnItemTypeMap(value));
		}
		return entities;
	}
}