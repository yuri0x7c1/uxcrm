package org.apache.ofbiz.product.price;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductPriceActionType implements Serializable {

	public static final long serialVersionUID = 3207467117401046016L;
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

	public ProductPriceActionType(GenericValue value) {
		productPriceActionTypeId = (String) value
				.get(FIELD_PRODUCT_PRICE_ACTION_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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