package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Deliverable Type
 */
public class DeliverableType implements Serializable {

	public static final long serialVersionUID = 7375246245022328832L;
	public static final String NAME = "DeliverableType";
	/**
	 * Deliverable Type Id
	 */
	@Getter
	@Setter
	private String deliverableTypeId;
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
		deliverableTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DeliverableType(GenericValue value) {
		deliverableTypeId = (String) value.get(Fields.deliverableTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static DeliverableType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DeliverableType(value);
	}

	public static List<DeliverableType> fromValues(List<GenericValue> values) {
		List<DeliverableType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DeliverableType(value));
		}
		return entities;
	}
}