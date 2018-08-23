package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Meter
 */
@FieldNameConstants
public class ProductMeter implements Serializable {

	public static final long serialVersionUID = 4287052894752119808L;
	public static final String NAME = "ProductMeter";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Meter Type Id
	 */
	@Getter
	@Setter
	private String productMeterTypeId;
	/**
	 * Meter Uom Id
	 */
	@Getter
	@Setter
	private String meterUomId;
	/**
	 * Meter Name
	 */
	@Getter
	@Setter
	private String meterName;
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

	public ProductMeter(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productMeterTypeId = (String) value.get(FIELD_PRODUCT_METER_TYPE_ID);
		meterUomId = (String) value.get(FIELD_METER_UOM_ID);
		meterName = (String) value.get(FIELD_METER_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductMeter fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductMeter(value);
	}

	public static List<ProductMeter> fromValues(List<GenericValue> values) {
		List<ProductMeter> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductMeter(value));
		}
		return entities;
	}
}