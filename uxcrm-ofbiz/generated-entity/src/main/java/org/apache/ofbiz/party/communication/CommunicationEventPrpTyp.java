package org.apache.ofbiz.party.communication;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Prp Typ
 */
@FieldNameConstants
public class CommunicationEventPrpTyp implements Serializable {

	public static final long serialVersionUID = 3665471562652116992L;
	public static final String NAME = "CommunicationEventPrpTyp";
	/**
	 * Communication Event Prp Typ Id
	 */
	@Getter
	@Setter
	private String communicationEventPrpTypId;
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

	public CommunicationEventPrpTyp(GenericValue value) {
		communicationEventPrpTypId = (String) value
				.get(FIELD_COMMUNICATION_EVENT_PRP_TYP_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CommunicationEventPrpTyp fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventPrpTyp(value);
	}

	public static List<CommunicationEventPrpTyp> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventPrpTyp> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventPrpTyp(value));
		}
		return entities;
	}
}