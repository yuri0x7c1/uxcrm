package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Ident Type
 */
public class FixedAssetIdentType implements Serializable {

	public static final long serialVersionUID = 4395057296914230272L;
	public static final String NAME = "FixedAssetIdentType";
	/**
	 * Fixed Asset Ident Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetIdentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		fixedAssetIdentTypeId, description
	}

	public FixedAssetIdentType(GenericValue value) {
		fixedAssetIdentTypeId = (String) value.get(Fields.fixedAssetIdentTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FixedAssetIdentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetIdentType(value);
	}

	public static List<FixedAssetIdentType> fromValues(List<GenericValue> values) {
		List<FixedAssetIdentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetIdentType(value));
		}
		return entities;
	}
}