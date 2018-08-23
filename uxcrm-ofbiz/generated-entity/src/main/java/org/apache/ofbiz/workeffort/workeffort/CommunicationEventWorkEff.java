package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class CommunicationEventWorkEff implements Serializable {

	public static final long serialVersionUID = 8229914411256632320L;
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

	public CommunicationEventWorkEff(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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