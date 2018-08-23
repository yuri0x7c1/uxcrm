package org.apache.ofbiz.product.supplier;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Supplier Product Feature
 */
@FieldNameConstants
public class SupplierProductFeature implements Serializable {

	public static final long serialVersionUID = 534341761152565248L;
	public static final String NAME = "SupplierProductFeature";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Id Code
	 */
	@Getter
	@Setter
	private String idCode;
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

	public SupplierProductFeature(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		uomId = (String) value.get(FIELD_UOM_ID);
		idCode = (String) value.get(FIELD_ID_CODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SupplierProductFeature fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SupplierProductFeature(value);
	}

	public static List<SupplierProductFeature> fromValues(
			List<GenericValue> values) {
		List<SupplierProductFeature> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SupplierProductFeature(value));
		}
		return entities;
	}
}