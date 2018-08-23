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
 * Product Maint Type
 */
@FieldNameConstants
public class ProductMaintType implements Serializable {

	public static final long serialVersionUID = 6721203108705379328L;
	public static final String NAME = "ProductMaintType";
	/**
	 * Product Maint Type Id
	 */
	@Getter
	@Setter
	private String productMaintTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
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

	public ProductMaintType(GenericValue value) {
		productMaintTypeId = (String) value.get(FIELD_PRODUCT_MAINT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductMaintType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductMaintType(value);
	}

	public static List<ProductMaintType> fromValues(List<GenericValue> values) {
		List<ProductMaintType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductMaintType(value));
		}
		return entities;
	}
}