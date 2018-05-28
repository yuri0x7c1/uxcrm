package org.apache.ofbiz.product.price;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Price Action Type
 */
public class ProductPriceActionType implements Serializable {

	public static final long serialVersionUID = 793192448005389312L;
	public static final String NAME = "ProductPriceActionType";
	/**
	 * Product Price Action Type Id
	 */
	@Getter
	@Setter
	private String productPriceActionTypeId;
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
		productPriceActionTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPriceActionType(GenericValue value) {
		productPriceActionTypeId = (String) value
				.get(Fields.productPriceActionTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductPriceActionType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPriceActionType(value);
	}

	public static List<ProductPriceActionType> fromValues(
			List<GenericValue> values) {
		List<ProductPriceActionType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPriceActionType(value));
		}
		return entities;
	}
}