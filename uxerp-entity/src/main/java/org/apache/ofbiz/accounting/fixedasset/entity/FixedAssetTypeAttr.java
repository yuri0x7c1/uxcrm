package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Type Attr
 */
public class FixedAssetTypeAttr implements Serializable {

	public static final long serialVersionUID = 3457946144825862144L;
	public static final String NAME = "FixedAssetTypeAttr";
	/**
	 * Fixed Asset Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetTypeId;
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
		fixedAssetTypeId, attrName, description
	}

	public FixedAssetTypeAttr(GenericValue value) {
		fixedAssetTypeId = (String) value.get(Fields.fixedAssetTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FixedAssetTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetTypeAttr(value);
	}

	public static List<FixedAssetTypeAttr> fromValues(List<GenericValue> values) {
		List<FixedAssetTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetTypeAttr(value));
		}
		return entities;
	}
}