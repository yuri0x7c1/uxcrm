package org.apache.ofbiz.product.supplier;

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
public class SupplierPrefOrder implements Serializable {

	public static final long serialVersionUID = 5591437624237814784L;
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

	public enum Fields {
		supplierPrefOrderId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SupplierPrefOrder(GenericValue value) {
		supplierPrefOrderId = (String) value.get(Fields.supplierPrefOrderId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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