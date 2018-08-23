package org.apache.ofbiz.humanres.ability;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Training Class Type
 */
@FieldNameConstants
public class TrainingClassType implements Serializable {

	public static final long serialVersionUID = 4892565339457404928L;
	public static final String NAME = "TrainingClassType";
	/**
	 * Training Class Type Id
	 */
	@Getter
	@Setter
	private String trainingClassTypeId;
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

	public TrainingClassType(GenericValue value) {
		trainingClassTypeId = (String) value.get(FIELD_TRAINING_CLASS_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TrainingClassType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrainingClassType(value);
	}

	public static List<TrainingClassType> fromValues(List<GenericValue> values) {
		List<TrainingClassType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrainingClassType(value));
		}
		return entities;
	}
}