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
 * Product Facility Location
 */
public class ProductFacilityLocation implements Serializable {

	public static final long serialVersionUID = 7035081371209710592L;
	public static final String NAME = "ProductFacilityLocation";
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
	 * Location Seq Id
	 */
	@Getter
	@Setter
	private String locationSeqId;
	/**
	 * Minimum Stock
	 */
	@Getter
	@Setter
	private BigDecimal minimumStock;
	/**
	 * Move Quantity
	 */
	@Getter
	@Setter
	private BigDecimal moveQuantity;
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
		productId, facilityId, locationSeqId, minimumStock, moveQuantity, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFacilityLocation(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		minimumStock = (BigDecimal) value.get(Fields.minimumStock.name());
		moveQuantity = (BigDecimal) value.get(Fields.moveQuantity.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductFacilityLocation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFacilityLocation(value);
	}

	public static List<ProductFacilityLocation> fromValues(
			List<GenericValue> values) {
		List<ProductFacilityLocation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFacilityLocation(value));
		}
		return entities;
	}
}