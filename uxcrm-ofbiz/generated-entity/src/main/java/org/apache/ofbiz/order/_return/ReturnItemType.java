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
 * Return Item Type
 */
@FieldNameConstants
public class ReturnItemType implements Serializable {

	public static final long serialVersionUID = 2476249367697951744L;
	public static final String NAME = "ReturnItemType";
	/**
	 * Return Item Type Id
	 */
	@Getter
	@Setter
	private String returnItemTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
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

	public ReturnItemType(GenericValue value) {
		returnItemTypeId = (String) value.get(FIELD_RETURN_ITEM_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReturnItemType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnItemType(value);
	}

	public static List<ReturnItemType> fromValues(List<GenericValue> values) {
		List<ReturnItemType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnItemType(value));
		}
		return entities;
	}
}