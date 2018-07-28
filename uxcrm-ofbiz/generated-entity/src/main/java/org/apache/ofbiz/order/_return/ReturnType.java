package org.apache.ofbiz.order._return;

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
public class ReturnType implements Serializable {

	public static final long serialVersionUID = 5354361713560542208L;
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

	public enum Fields {
		returnTypeId, description, sequenceId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ReturnType(GenericValue value) {
		returnTypeId = (String) value.get(Fields.returnTypeId.name());
		description = (String) value.get(Fields.description.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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