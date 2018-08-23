package org.apache.ofbiz.common._enum;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Enumeration
 */
@FieldNameConstants
public class Enumeration implements Serializable {

	public static final long serialVersionUID = 4692486788067855360L;
	public static final String NAME = "Enumeration";
	/**
	 * Enum Id
	 */
	@Getter
	@Setter
	private String enumId;
	/**
	 * Enum Type Id
	 */
	@Getter
	@Setter
	private String enumTypeId;
	/**
	 * Enum Code
	 */
	@Getter
	@Setter
	private String enumCode;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
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

	public Enumeration(GenericValue value) {
		enumId = (String) value.get(FIELD_ENUM_ID);
		enumTypeId = (String) value.get(FIELD_ENUM_TYPE_ID);
		enumCode = (String) value.get(FIELD_ENUM_CODE);
		sequenceId = (String) value.get(FIELD_SEQUENCE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Enumeration fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new Enumeration(value);
	}

	public static List<Enumeration> fromValues(List<GenericValue> values) {
		List<Enumeration> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Enumeration(value));
		}
		return entities;
	}
}