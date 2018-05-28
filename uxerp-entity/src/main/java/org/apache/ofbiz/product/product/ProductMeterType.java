package org.apache.ofbiz.product.product;

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
public class ProductMeterType implements Serializable {

	public static final long serialVersionUID = 3112553539036692480L;
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

	public enum Fields {
		productMeterTypeId, description, defaultUomId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductMeterType(GenericValue value) {
		productMeterTypeId = (String) value.get(Fields.productMeterTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		defaultUomId = (String) value.get(Fields.defaultUomId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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