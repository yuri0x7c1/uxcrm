package org.apache.ofbiz.accounting.fixedasset;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class FixedAssetDepMethod implements Serializable {

	public static final long serialVersionUID = 7904677072013270016L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public FixedAssetDepMethod(GenericValue value) {
		depreciationCustomMethodId = (String) value
				.get(FIELD_DEPRECIATION_CUSTOM_METHOD_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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