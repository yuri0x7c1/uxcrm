package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Attribute
 */
public class FacilityAttribute implements Serializable {

	public static final long serialVersionUID = 146260855647243264L;
	public static final String NAME = "FacilityAttribute";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		facilityId, attrName, attrValue, attrDescription
	}

	public FacilityAttribute(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static FacilityAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityAttribute(value);
	}

	public static List<FacilityAttribute> fromValues(List<GenericValue> values) {
		List<FacilityAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityAttribute(value));
		}
		return entities;
	}
}