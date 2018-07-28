package org.apache.ofbiz.entity.tenant;

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
public class Component implements Serializable {

	public static final long serialVersionUID = 4217344513642634240L;
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

	public enum Fields {
		componentName, rootLocation, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Component(GenericValue value) {
		componentName = (String) value.get(Fields.componentName.name());
		rootLocation = (String) value.get(Fields.rootLocation.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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