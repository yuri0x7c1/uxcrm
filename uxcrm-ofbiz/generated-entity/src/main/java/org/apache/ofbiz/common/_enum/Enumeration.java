package org.apache.ofbiz.common._enum;

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
public class Enumeration implements Serializable {

	public static final long serialVersionUID = 1328348875544300544L;
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

	public enum Fields {
		enumId, enumTypeId, enumCode, sequenceId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Enumeration(GenericValue value) {
		enumId = (String) value.get(Fields.enumId.name());
		enumTypeId = (String) value.get(Fields.enumTypeId.name());
		enumCode = (String) value.get(Fields.enumCode.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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