package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Dep Method
 */
public class FixedAssetDepMethod implements Serializable {

	public static final long serialVersionUID = 7836378840176845824L;
	public static final String NAME = "FixedAssetDepMethod";
	/**
	 * Depreciation Custom Method Id
	 */
	@Getter
	@Setter
	private String depreciationCustomMethodId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		depreciationCustomMethodId, fixedAssetId, fromDate, thruDate
	}

	public FixedAssetDepMethod(GenericValue value) {
		depreciationCustomMethodId = (String) value
				.get(Fields.depreciationCustomMethodId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static FixedAssetDepMethod fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetDepMethod(value);
	}

	public static List<FixedAssetDepMethod> fromValues(List<GenericValue> values) {
		List<FixedAssetDepMethod> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetDepMethod(value));
		}
		return entities;
	}
}