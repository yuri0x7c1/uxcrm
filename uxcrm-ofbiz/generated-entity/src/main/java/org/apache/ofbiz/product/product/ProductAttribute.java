package org.apache.ofbiz.product.product;

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
public class ProductAttribute implements Serializable {

	public static final long serialVersionUID = 7447945713750052864L;
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

	public enum Fields {
		productId, attrName, attrValue, attrType, attrDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductAttribute(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrType = (String) value.get(Fields.attrType.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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