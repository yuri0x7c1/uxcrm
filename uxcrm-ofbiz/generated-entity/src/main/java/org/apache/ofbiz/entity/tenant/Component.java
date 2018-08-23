package org.apache.ofbiz.entity.tenant;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Component
 */
@FieldNameConstants
public class Component implements Serializable {

	public static final long serialVersionUID = 8185224786537667584L;
	public static final String NAME = "Component";
	/**
	 * Component Name
	 */
	@Getter
	@Setter
	private String componentName;
	/**
	 * Root Location
	 */
	@Getter
	@Setter
	private String rootLocation;
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

	public Component(GenericValue value) {
		componentName = (String) value.get(FIELD_COMPONENT_NAME);
		rootLocation = (String) value.get(FIELD_ROOT_LOCATION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Component fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Component(value);
	}

	public static List<Component> fromValues(List<GenericValue> values) {
		List<Component> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Component(value));
		}
		return entities;
	}
}