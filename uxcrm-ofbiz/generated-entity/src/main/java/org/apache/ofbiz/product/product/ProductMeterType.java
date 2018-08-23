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
 * Product Meter Type
 */
@FieldNameConstants
public class ProductMeterType implements Serializable {

	public static final long serialVersionUID = 6081346662642895872L;
	public static final String NAME = "ProductMeterType";
	/**
	 * Product Meter Type Id
	 */
	@Getter
	@Setter
	private String productMeterTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Default Uom Id
	 */
	@Getter
	@Setter
	private String defaultUomId;
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

	public ProductMeterType(GenericValue value) {
		productMeterTypeId = (String) value.get(FIELD_PRODUCT_METER_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		defaultUomId = (String) value.get(FIELD_DEFAULT_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductMeterType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductMeterType(value);
	}

	public static List<ProductMeterType> fromValues(List<GenericValue> values) {
		List<ProductMeterType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductMeterType(value));
		}
		return entities;
	}
}