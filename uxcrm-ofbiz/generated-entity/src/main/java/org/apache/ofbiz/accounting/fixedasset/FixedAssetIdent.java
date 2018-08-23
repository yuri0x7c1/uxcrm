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
 * Fixed Asset Ident
 */
@FieldNameConstants
public class FixedAssetIdent implements Serializable {

	public static final long serialVersionUID = 8709914280218161152L;
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

	public FixedAssetIdent(GenericValue value) {
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		fixedAssetIdentTypeId = (String) value
				.get(FIELD_FIXED_ASSET_IDENT_TYPE_ID);
		idValue = (String) value.get(FIELD_ID_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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