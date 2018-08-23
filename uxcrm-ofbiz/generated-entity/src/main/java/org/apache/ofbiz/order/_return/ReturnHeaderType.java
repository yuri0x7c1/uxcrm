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
 * Return Header Type
 */
@FieldNameConstants
public class ReturnHeaderType implements Serializable {

	public static final long serialVersionUID = 1947094342893034496L;
	public static final String NAME = "ReturnHeaderType";
	/**
	 * Return Header Type Id
	 */
	@Getter
	@Setter
	private String returnHeaderTypeId;
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

	public ReturnHeaderType(GenericValue value) {
		returnHeaderTypeId = (String) value.get(FIELD_RETURN_HEADER_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReturnHeaderType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnHeaderType(value);
	}

	public static List<ReturnHeaderType> fromValues(List<GenericValue> values) {
		List<ReturnHeaderType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnHeaderType(value));
		}
		return entities;
	}
}