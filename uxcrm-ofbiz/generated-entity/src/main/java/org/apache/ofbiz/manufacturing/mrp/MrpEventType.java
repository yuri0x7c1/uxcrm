package org.apache.ofbiz.manufacturing.mrp;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class MrpEventType implements Serializable {

	public static final long serialVersionUID = 4221363232803232768L;
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

	public MrpEventType(GenericValue value) {
		mrpEventTypeId = (String) value.get(FIELD_MRP_EVENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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