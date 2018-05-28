package org.apache.ofbiz.common.status;

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
public class StatusItem implements Serializable {

	public static final long serialVersionUID = 3419414693372219392L;
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

	public enum Fields {
		statusId, statusTypeId, statusCode, sequenceId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public StatusItem(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		statusTypeId = (String) value.get(Fields.statusTypeId.name());
		statusCode = (String) value.get(Fields.statusCode.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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