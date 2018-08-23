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
 * Return Type
 */
@FieldNameConstants
public class ReturnType implements Serializable {

	public static final long serialVersionUID = 5250335094003406848L;
	public static final String NAME = "ReturnType";
	/**
	 * Return Type Id
	 */
	@Getter
	@Setter
	private String returnTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
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

	public ReturnType(GenericValue value) {
		returnTypeId = (String) value.get(FIELD_RETURN_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		sequenceId = (String) value.get(FIELD_SEQUENCE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReturnType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnType(value);
	}

	public static List<ReturnType> fromValues(List<GenericValue> values) {
		List<ReturnType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnType(value));
		}
		return entities;
	}
}