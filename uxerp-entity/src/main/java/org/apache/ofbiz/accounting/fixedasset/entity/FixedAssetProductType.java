package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Product Type
 */
public class FixedAssetProductType implements Serializable {

	public static final long serialVersionUID = 7260878827102721024L;
	public static final String NAME = "FixedAssetProductType";
	/**
	 * Fixed Asset Product Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetProductTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		fixedAssetProductTypeId, description
	}

	public FixedAssetProductType(GenericValue value) {
		fixedAssetProductTypeId = (String) value
				.get(Fields.fixedAssetProductTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FixedAssetProductType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetProductType(value);
	}

	public static List<FixedAssetProductType> fromValues(
			List<GenericValue> values) {
		List<FixedAssetProductType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetProductType(value));
		}
		return entities;
	}
}