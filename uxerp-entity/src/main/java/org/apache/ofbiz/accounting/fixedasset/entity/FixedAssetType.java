package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Type
 */
public class FixedAssetType implements Serializable {

	public static final long serialVersionUID = 5927935873494870016L;
	public static final String NAME = "FixedAssetType";
	/**
	 * Fixed Asset Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		fixedAssetTypeId, parentTypeId, hasTable, description
	}

	public FixedAssetType(GenericValue value) {
		fixedAssetTypeId = (String) value.get(Fields.fixedAssetTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FixedAssetType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetType(value);
	}

	public static List<FixedAssetType> fromValues(List<GenericValue> values) {
		List<FixedAssetType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetType(value));
		}
		return entities;
	}
}