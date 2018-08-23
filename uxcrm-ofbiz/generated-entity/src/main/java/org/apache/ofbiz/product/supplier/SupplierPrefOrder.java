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
 * Supplier Pref Order
 */
@FieldNameConstants
public class SupplierPrefOrder implements Serializable {

	public static final long serialVersionUID = 3766312099821806592L;
	public static final String NAME = "SupplierPrefOrder";
	/**
	 * Supplier Pref Order Id
	 */
	@Getter
	@Setter
	private String supplierPrefOrderId;
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

	public SupplierPrefOrder(GenericValue value) {
		supplierPrefOrderId = (String) value.get(FIELD_SUPPLIER_PREF_ORDER_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SupplierPrefOrder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SupplierPrefOrder(value);
	}

	public static List<SupplierPrefOrder> fromValues(List<GenericValue> values) {
		List<SupplierPrefOrder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SupplierPrefOrder(value));
		}
		return entities;
	}
}