package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Work Eff
 */
public class CommunicationEventWorkEff implements Serializable {

	public static final long serialVersionUID = 1996943881481313280L;
	public static final String NAME = "CommunicationEventWorkEff";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
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
		workEffortId, communicationEventId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CommunicationEventWorkEff(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CommunicationEventWorkEff fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventWorkEff(value);
	}

	public static List<CommunicationEventWorkEff> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventWorkEff> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventWorkEff(value));
		}
		return entities;
	}
}