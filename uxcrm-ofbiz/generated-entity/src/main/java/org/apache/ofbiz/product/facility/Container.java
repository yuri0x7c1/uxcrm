package org.apache.ofbiz.product.facility;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Container
 */
@FieldNameConstants
public class Container implements Serializable {

	public static final long serialVersionUID = 6769656061496009728L;
	public static final String NAME = "Container";
	/**
	 * Container Id
	 */
	@Getter
	@Setter
	private String containerId;
	/**
	 * Container Type Id
	 */
	@Getter
	@Setter
	private String containerTypeId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
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

	public Container(GenericValue value) {
		containerId = (String) value.get(FIELD_CONTAINER_ID);
		containerTypeId = (String) value.get(FIELD_CONTAINER_TYPE_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Container fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Container(value);
	}

	public static List<Container> fromValues(List<GenericValue> values) {
		List<Container> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Container(value));
		}
		return entities;
	}
}