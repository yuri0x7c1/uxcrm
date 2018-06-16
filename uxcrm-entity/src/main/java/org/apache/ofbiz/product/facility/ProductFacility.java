package org.apache.ofbiz.product.facility;

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
public class ProductFacility implements Serializable {

	public static final long serialVersionUID = 3083629556581360640L;
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

	public enum Fields {
		productId, facilityId, minimumStock, reorderQuantity, daysToShip, lastInventoryCount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFacility(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		minimumStock = (BigDecimal) value.get(Fields.minimumStock.name());
		reorderQuantity = (BigDecimal) value.get(Fields.reorderQuantity.name());
		daysToShip = (Long) value.get(Fields.daysToShip.name());
		lastInventoryCount = (BigDecimal) value.get(Fields.lastInventoryCount
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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