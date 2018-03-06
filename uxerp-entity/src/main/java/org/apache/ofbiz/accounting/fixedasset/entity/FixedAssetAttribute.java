package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Attribute
 */
public class FixedAssetAttribute implements Serializable {

	public static final long serialVersionUID = 6896250895230653440L;
	public static final String NAME = "FixedAssetAttribute";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
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
		fixedAssetId, attrName, attrValue, attrDescription
	}

	public FixedAssetAttribute(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static FixedAssetAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetAttribute(value);
	}

	public static List<FixedAssetAttribute> fromValues(List<GenericValue> values) {
		List<FixedAssetAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetAttribute(value));
		}
		return entities;
	}
}