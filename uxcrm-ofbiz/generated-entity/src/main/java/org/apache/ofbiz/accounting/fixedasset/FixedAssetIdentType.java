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
 * Fixed Asset Ident Type
 */
@FieldNameConstants
public class FixedAssetIdentType implements Serializable {

	public static final long serialVersionUID = 6391580971836121088L;
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

	public FixedAssetIdentType(GenericValue value) {
		fixedAssetIdentTypeId = (String) value
				.get(FIELD_FIXED_ASSET_IDENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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