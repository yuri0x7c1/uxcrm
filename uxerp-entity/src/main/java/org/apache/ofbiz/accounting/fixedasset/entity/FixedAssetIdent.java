package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Ident
 */
public class FixedAssetIdent implements Serializable {

	public static final long serialVersionUID = 2590809611875307520L;
	public static final String NAME = "FixedAssetIdent";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Fixed Asset Ident Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetIdentTypeId;
	/**
	 * Id Value
	 */
	@Getter
	@Setter
	private String idValue;

	public enum Fields {
		fixedAssetId, fixedAssetIdentTypeId, idValue
	}

	public FixedAssetIdent(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		fixedAssetIdentTypeId = (String) value.get(Fields.fixedAssetIdentTypeId
				.name());
		idValue = (String) value.get(Fields.idValue.name());
	}

	public static FixedAssetIdent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetIdent(value);
	}

	public static List<FixedAssetIdent> fromValues(List<GenericValue> values) {
		List<FixedAssetIdent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetIdent(value));
		}
		return entities;
	}
}