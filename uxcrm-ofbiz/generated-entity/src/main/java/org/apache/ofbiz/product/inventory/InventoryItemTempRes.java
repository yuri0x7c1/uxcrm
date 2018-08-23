package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Temp Res
 */
@FieldNameConstants
public class InventoryItemTempRes implements Serializable {

	public static final long serialVersionUID = 2494586316957362176L;
	public static final String NAME = "InventoryItemTempRes";
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Reserved Date
	 */
	@Getter
	@Setter
	private Timestamp reservedDate;
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

	public InventoryItemTempRes(GenericValue value) {
		visitId = (String) value.get(FIELD_VISIT_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		reservedDate = (Timestamp) value.get(FIELD_RESERVED_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InventoryItemTempRes fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemTempRes(value);
	}

	public static List<InventoryItemTempRes> fromValues(
			List<GenericValue> values) {
		List<InventoryItemTempRes> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemTempRes(value));
		}
		return entities;
	}
}