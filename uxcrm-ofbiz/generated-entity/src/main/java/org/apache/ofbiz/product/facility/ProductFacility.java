package org.apache.ofbiz.product.facility;

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
 * Product Facility
 */
@FieldNameConstants
public class ProductFacility implements Serializable {

	public static final long serialVersionUID = 1013103034650829824L;
	public static final String NAME = "ProductFacility";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Minimum Stock
	 */
	@Getter
	@Setter
	private BigDecimal minimumStock;
	/**
	 * Reorder Quantity
	 */
	@Getter
	@Setter
	private BigDecimal reorderQuantity;
	/**
	 * Days To Ship
	 */
	@Getter
	@Setter
	private Long daysToShip;
	/**
	 * Last Inventory Count
	 */
	@Getter
	@Setter
	private BigDecimal lastInventoryCount;
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

	public ProductFacility(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		minimumStock = (BigDecimal) value.get(FIELD_MINIMUM_STOCK);
		reorderQuantity = (BigDecimal) value.get(FIELD_REORDER_QUANTITY);
		daysToShip = (Long) value.get(FIELD_DAYS_TO_SHIP);
		lastInventoryCount = (BigDecimal) value.get(FIELD_LAST_INVENTORY_COUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductFacility fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFacility(value);
	}

	public static List<ProductFacility> fromValues(List<GenericValue> values) {
		List<ProductFacility> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFacility(value));
		}
		return entities;
	}
}