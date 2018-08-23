package org.apache.ofbiz.humanres.position;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position Class Type
 */
@FieldNameConstants
public class EmplPositionClassType implements Serializable {

	public static final long serialVersionUID = 1788789121615955968L;
	public static final String NAME = "EmplPositionClassType";
	/**
	 * Empl Position Class Type Id
	 */
	@Getter
	@Setter
	private String emplPositionClassTypeId;
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

	public EmplPositionClassType(GenericValue value) {
		emplPositionClassTypeId = (String) value
				.get(FIELD_EMPL_POSITION_CLASS_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EmplPositionClassType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionClassType(value);
	}

	public static List<EmplPositionClassType> fromValues(
			List<GenericValue> values) {
		List<EmplPositionClassType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionClassType(value));
		}
		return entities;
	}
}