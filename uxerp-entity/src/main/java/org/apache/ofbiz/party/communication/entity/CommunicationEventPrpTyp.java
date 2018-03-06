package org.apache.ofbiz.party.communication.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Prp Typ
 */
public class CommunicationEventPrpTyp implements Serializable {

	public static final long serialVersionUID = 8820563894706875392L;
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

	public enum Fields {
		communicationEventPrpTypId, parentTypeId, hasTable, description
	}

	public CommunicationEventPrpTyp(GenericValue value) {
		communicationEventPrpTypId = (String) value
				.get(Fields.communicationEventPrpTypId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
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