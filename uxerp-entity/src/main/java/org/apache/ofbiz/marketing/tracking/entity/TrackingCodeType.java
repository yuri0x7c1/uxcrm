package org.apache.ofbiz.marketing.tracking.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tracking Code Type
 */
public class TrackingCodeType implements Serializable {

	public static final long serialVersionUID = 6912549869814424576L;
	public static final String NAME = "TrackingCodeType";
	/**
	 * Tracking Code Type Id
	 */
	@Getter
	@Setter
	private String trackingCodeTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		trackingCodeTypeId, description
	}

	public TrackingCodeType(GenericValue value) {
		trackingCodeTypeId = (String) value.get(Fields.trackingCodeTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static TrackingCodeType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrackingCodeType(value);
	}

	public static List<TrackingCodeType> fromValues(List<GenericValue> values) {
		List<TrackingCodeType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrackingCodeType(value));
		}
		return entities;
	}
}