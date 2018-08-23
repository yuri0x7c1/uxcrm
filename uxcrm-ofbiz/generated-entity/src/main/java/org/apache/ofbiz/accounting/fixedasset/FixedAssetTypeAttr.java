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
 * Fixed Asset Type Attr
 */
@FieldNameConstants
public class FixedAssetTypeAttr implements Serializable {

	public static final long serialVersionUID = 8252572039850822656L;
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

	public FixedAssetTypeAttr(GenericValue value) {
		fixedAssetTypeId = (String) value.get(FIELD_FIXED_ASSET_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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