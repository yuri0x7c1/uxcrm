package org.apache.ofbiz.common.status;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Status Item
 */
@FieldNameConstants
public class StatusItem implements Serializable {

	public static final long serialVersionUID = 7061115034317615104L;
	public static final String NAME = "StatusItem";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Type Id
	 */
	@Getter
	@Setter
	private String statusTypeId;
	/**
	 * Status Code
	 */
	@Getter
	@Setter
	private String statusCode;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
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

	public StatusItem(GenericValue value) {
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusTypeId = (String) value.get(FIELD_STATUS_TYPE_ID);
		statusCode = (String) value.get(FIELD_STATUS_CODE);
		sequenceId = (String) value.get(FIELD_SEQUENCE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static StatusItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new StatusItem(value);
	}

	public static List<StatusItem> fromValues(List<GenericValue> values) {
		List<StatusItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new StatusItem(value));
		}
		return entities;
	}
}