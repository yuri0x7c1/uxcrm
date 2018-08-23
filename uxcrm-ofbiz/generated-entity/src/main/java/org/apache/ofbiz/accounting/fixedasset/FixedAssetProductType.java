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
 * Fixed Asset Product Type
 */
@FieldNameConstants
public class FixedAssetProductType implements Serializable {

	public static final long serialVersionUID = 9174191225386426368L;
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

	public FixedAssetProductType(GenericValue value) {
		fixedAssetProductTypeId = (String) value
				.get(FIELD_FIXED_ASSET_PRODUCT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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