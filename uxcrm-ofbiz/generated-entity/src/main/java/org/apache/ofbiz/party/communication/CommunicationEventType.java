package org.apache.ofbiz.party.communication;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Type
 */
public class CommunicationEventType implements Serializable {

	public static final long serialVersionUID = 6013052003719933952L;
	public static final String NAME = "CommunicationEventType";
	/**
	 * Communication Event Type Id
	 */
	@Getter
	@Setter
	private String communicationEventTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
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
		communicationEventTypeId, parentTypeId, hasTable, description, contactMechTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CommunicationEventType(GenericValue value) {
		communicationEventTypeId = (String) value
				.get(Fields.communicationEventTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CommunicationEventType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventType(value);
	}

	public static List<CommunicationEventType> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventType(value));
		}
		return entities;
	}
}