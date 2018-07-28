package org.apache.ofbiz.common.screen;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Custom Screen
 */
public class CustomScreen implements Serializable {

	public static final long serialVersionUID = 4556797101435548672L;
	public static final String NAME = "CustomScreen";
	/**
	 * Custom Screen Id
	 */
	@Getter
	@Setter
	private String customScreenId;
	/**
	 * Custom Screen Type Id
	 */
	@Getter
	@Setter
	private String customScreenTypeId;
	/**
	 * Custom Screen Name
	 */
	@Getter
	@Setter
	private String customScreenName;
	/**
	 * Custom Screen Location
	 */
	@Getter
	@Setter
	private String customScreenLocation;
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
		customScreenId, customScreenTypeId, customScreenName, customScreenLocation, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustomScreen(GenericValue value) {
		customScreenId = (String) value.get(Fields.customScreenId.name());
		customScreenTypeId = (String) value.get(Fields.customScreenTypeId
				.name());
		customScreenName = (String) value.get(Fields.customScreenName.name());
		customScreenLocation = (String) value.get(Fields.customScreenLocation
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CustomScreen fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustomScreen(value);
	}

	public static List<CustomScreen> fromValues(List<GenericValue> values) {
		List<CustomScreen> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustomScreen(value));
		}
		return entities;
	}
}