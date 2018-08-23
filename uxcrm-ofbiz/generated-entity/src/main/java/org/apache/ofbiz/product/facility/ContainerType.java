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
 * Container Type
 */
@FieldNameConstants
public class ContainerType implements Serializable {

	public static final long serialVersionUID = 1912945194276984832L;
	public static final String NAME = "ContainerType";
	/**
	 * Container Type Id
	 */
	@Getter
	@Setter
	private String containerTypeId;
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

	public ContainerType(GenericValue value) {
		containerTypeId = (String) value.get(FIELD_CONTAINER_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContainerType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContainerType(value);
	}

	public static List<ContainerType> fromValues(List<GenericValue> values) {
		List<ContainerType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContainerType(value));
		}
		return entities;
	}
}