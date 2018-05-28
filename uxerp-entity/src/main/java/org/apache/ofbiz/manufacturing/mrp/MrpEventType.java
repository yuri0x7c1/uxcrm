package org.apache.ofbiz.manufacturing.mrp;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Mrp Event Type
 */
public class MrpEventType implements Serializable {

	public static final long serialVersionUID = 767228216900957184L;
	public static final String NAME = "MrpEventType";
	/**
	 * Mrp Event Type Id
	 */
	@Getter
	@Setter
	private String mrpEventTypeId;
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
		mrpEventTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public MrpEventType(GenericValue value) {
		mrpEventTypeId = (String) value.get(Fields.mrpEventTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static MrpEventType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MrpEventType(value);
	}

	public static List<MrpEventType> fromValues(List<GenericValue> values) {
		List<MrpEventType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MrpEventType(value));
		}
		return entities;
	}
}