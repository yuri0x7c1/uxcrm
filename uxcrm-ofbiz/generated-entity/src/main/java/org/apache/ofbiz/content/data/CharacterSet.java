package org.apache.ofbiz.content.data;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Character Set
 */
public class CharacterSet implements Serializable {

	public static final long serialVersionUID = 9031018546303021056L;
	public static final String NAME = "CharacterSet";
	/**
	 * Character Set Id
	 */
	@Getter
	@Setter
	private String characterSetId;
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
		characterSetId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CharacterSet(GenericValue value) {
		characterSetId = (String) value.get(Fields.characterSetId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CharacterSet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CharacterSet(value);
	}

	public static List<CharacterSet> fromValues(List<GenericValue> values) {
		List<CharacterSet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CharacterSet(value));
		}
		return entities;
	}
}