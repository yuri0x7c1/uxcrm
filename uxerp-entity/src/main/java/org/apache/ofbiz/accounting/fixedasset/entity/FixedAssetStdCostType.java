package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Std Cost Type
 */
public class FixedAssetStdCostType implements Serializable {

	public static final long serialVersionUID = 4388235144652819456L;
	public static final String NAME = "FixedAssetStdCostType";
	/**
	 * Fixed Asset Std Cost Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetStdCostTypeId;
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
		fixedAssetStdCostTypeId, parentTypeId, hasTable, description
	}

	public FixedAssetStdCostType(GenericValue value) {
		fixedAssetStdCostTypeId = (String) value
				.get(Fields.fixedAssetStdCostTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FixedAssetStdCostType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetStdCostType(value);
	}

	public static List<FixedAssetStdCostType> fromValues(
			List<GenericValue> values) {
		List<FixedAssetStdCostType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetStdCostType(value));
		}
		return entities;
	}
}