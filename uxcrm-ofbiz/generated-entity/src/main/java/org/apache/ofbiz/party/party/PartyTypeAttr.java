package org.apache.ofbiz.party.party;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ofbiz.entity.GenericValue;

import com.google.common.collect.ImmutableList;

import lombok.Getter;
import lombok.Setter;

/**
 * Party Type Attr
 */
public class PartyTypeAttr implements Serializable {

	public static final long serialVersionUID = 7134273942455534592L;
	public static final String NAME = "PartyTypeAttr";
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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
		partyTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyTypeAttr(GenericValue value) {
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PartyTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyTypeAttr(value);
	}

	public static List<PartyTypeAttr> fromValues(List<GenericValue> values) {
		return Collections.unmodifiableList(values.stream()
			.map(value -> fromValue(value))
			.collect(Collectors.toList())
		);
	}
}