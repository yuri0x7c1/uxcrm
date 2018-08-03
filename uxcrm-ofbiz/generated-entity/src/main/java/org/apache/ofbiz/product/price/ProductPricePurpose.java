package org.apache.ofbiz.product.price;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Price Purpose
 */
public class ProductPricePurpose implements Serializable {

	public static final long serialVersionUID = 7482075945181784064L;
	public static final String NAME = "ProductPricePurpose";
	/**
	 * Product Price Purpose Id
	 */
	@Getter
	@Setter
	private String productPricePurposeId;
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
		productPricePurposeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPricePurpose(GenericValue value) {
		productPricePurposeId = (String) value.get(Fields.productPricePurposeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductPricePurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPricePurpose(value);
	}

	public static List<ProductPricePurpose> fromValues(List<GenericValue> values) {
		List<ProductPricePurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPricePurpose(value));
		}
		return entities;
	}
}