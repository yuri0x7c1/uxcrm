package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Type Attr
 */
public class FacilityTypeAttr implements Serializable {

	public static final long serialVersionUID = 6089799044418348032L;
	public static final String NAME = "FacilityTypeAttr";
	/**
	 * Facility Type Id
	 */
	@Getter
	@Setter
	private String facilityTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		facilityTypeId, attrName, description
	}

	public FacilityTypeAttr(GenericValue value) {
		facilityTypeId = (String) value.get(Fields.facilityTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FacilityTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityTypeAttr(value);
	}

	public static List<FacilityTypeAttr> fromValues(List<GenericValue> values) {
		List<FacilityTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityTypeAttr(value));
		}
		return entities;
	}
}