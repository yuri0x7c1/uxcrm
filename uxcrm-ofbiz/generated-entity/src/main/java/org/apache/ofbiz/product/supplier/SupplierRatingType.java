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
 * Supplier Rating Type
 */
@FieldNameConstants
public class SupplierRatingType implements Serializable {

	public static final long serialVersionUID = 3374470810091672576L;
	public static final String NAME = "SupplierRatingType";
	/**
	 * Supplier Rating Type Id
	 */
	@Getter
	@Setter
	private String supplierRatingTypeId;
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

	public SupplierRatingType(GenericValue value) {
		supplierRatingTypeId = (String) value
				.get(FIELD_SUPPLIER_RATING_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SupplierRatingType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SupplierRatingType(value);
	}

	public static List<SupplierRatingType> fromValues(List<GenericValue> values) {
		List<SupplierRatingType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SupplierRatingType(value));
		}
		return entities;
	}
}