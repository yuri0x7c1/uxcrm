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
 * Deliverable Type
 */
@FieldNameConstants
public class DeliverableType implements Serializable {

	public static final long serialVersionUID = 5249417247827252224L;
	public static final String NAME = "DeliverableType";
	/**
	 * Deliverable Type Id
	 */
	@Getter
	@Setter
	private String deliverableTypeId;
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

	public DeliverableType(GenericValue value) {
		deliverableTypeId = (String) value.get(FIELD_DELIVERABLE_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static DeliverableType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DeliverableType(value);
	}

	public static List<DeliverableType> fromValues(List<GenericValue> values) {
		List<DeliverableType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DeliverableType(value));
		}
		return entities;
	}
}