package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Content Type
 */
public class PartyContentType implements Serializable {

	public static final long serialVersionUID = 2864819975571657728L;
	public static final String NAME = "PartyContentType";
	/**
	 * Party Content Type Id
	 */
	@Getter
	@Setter
	private String partyContentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
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
		partyContentTypeId, parentTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyContentType(GenericValue value) {
		partyContentTypeId = (String) value.get(Fields.partyContentTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PartyContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyContentType(value);
	}

	public static List<PartyContentType> fromValues(List<GenericValue> values) {
		List<PartyContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyContentType(value));
		}
		return entities;
	}
}