package org.apache.ofbiz.content.data;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class CharacterSet implements Serializable {

	public static final long serialVersionUID = 6180293622270857216L;
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

	public CharacterSet(GenericValue value) {
		characterSetId = (String) value.get(FIELD_CHARACTER_SET_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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