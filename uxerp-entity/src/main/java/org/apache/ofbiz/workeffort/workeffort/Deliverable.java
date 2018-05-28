package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Deliverable
 */
public class Deliverable implements Serializable {

	public static final long serialVersionUID = 1036428184421454848L;
	public static final String NAME = "Deliverable";
	/**
	 * Deliverable Id
	 */
	@Getter
	@Setter
	private String deliverableId;
	/**
	 * Deliverable Type Id
	 */
	@Getter
	@Setter
	private String deliverableTypeId;
	/**
	 * Deliverable Name
	 */
	@Getter
	@Setter
	private String deliverableName;
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
		deliverableId, deliverableTypeId, deliverableName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Deliverable(GenericValue value) {
		deliverableId = (String) value.get(Fields.deliverableId.name());
		deliverableTypeId = (String) value.get(Fields.deliverableTypeId.name());
		deliverableName = (String) value.get(Fields.deliverableName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static Deliverable fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new Deliverable(value);
	}

	public static List<Deliverable> fromValues(List<GenericValue> values) {
		List<Deliverable> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Deliverable(value));
		}
		return entities;
	}
}