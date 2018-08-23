package org.apache.ofbiz.product.category;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Type Attr
 */
@FieldNameConstants
public class ProductCategoryTypeAttr implements Serializable {

	public static final long serialVersionUID = 6675829982983532544L;
	public static final String NAME = "ProductCategoryTypeAttr";
	/**
	 * Product Category Type Id
	 */
	@Getter
	@Setter
	private String productCategoryTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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

	public ProductCategoryTypeAttr(GenericValue value) {
		productCategoryTypeId = (String) value
				.get(FIELD_PRODUCT_CATEGORY_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductCategoryTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryTypeAttr(value);
	}

	public static List<ProductCategoryTypeAttr> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryTypeAttr(value));
		}
		return entities;
	}
}