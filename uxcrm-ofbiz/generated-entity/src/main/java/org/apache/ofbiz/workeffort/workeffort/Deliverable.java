package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Deliverable
 */
@FieldNameConstants
public class Deliverable implements Serializable {

	public static final long serialVersionUID = 6278867543587778560L;
	public static final String NAME = "Deliverable";
	/**
	 * Deliverable Id
	 */
	@Getter
	@Setter
	private String deliverableId;
	/**
	 * Deliverable Type Id
	 */
	@Getter
	@Setter
	private String deliverableTypeId;
	/**
	 * Deliverable Name
	 */
	@Getter
	@Setter
	private String deliverableName;
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

	public Deliverable(GenericValue value) {
		deliverableId = (String) value.get(FIELD_DELIVERABLE_ID);
		deliverableTypeId = (String) value.get(FIELD_DELIVERABLE_TYPE_ID);
		deliverableName = (String) value.get(FIELD_DELIVERABLE_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Deliverable fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new Deliverable(value);
	}

	public static List<Deliverable> fromValues(List<GenericValue> values) {
		List<Deliverable> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Deliverable(value));
		}
		return entities;
	}
}