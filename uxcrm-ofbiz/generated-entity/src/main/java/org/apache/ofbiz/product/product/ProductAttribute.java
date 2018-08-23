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
 * Product Attribute
 */
@FieldNameConstants
public class ProductAttribute implements Serializable {

	public static final long serialVersionUID = 9135446619775442944L;
	public static final String NAME = "ProductAttribute";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Type
	 */
	@Getter
	@Setter
	private String attrType;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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

	public ProductAttribute(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		attrValue = (String) value.get(FIELD_ATTR_VALUE);
		attrType = (String) value.get(FIELD_ATTR_TYPE);
		attrDescription = (String) value.get(FIELD_ATTR_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductAttribute(value);
	}

	public static List<ProductAttribute> fromValues(List<GenericValue> values) {
		List<ProductAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductAttribute(value));
		}
		return entities;
	}
}