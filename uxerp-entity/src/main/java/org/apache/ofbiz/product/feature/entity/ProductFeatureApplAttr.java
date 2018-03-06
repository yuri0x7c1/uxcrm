package org.apache.ofbiz.product.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Appl Attr
 */
public class ProductFeatureApplAttr implements Serializable {

	public static final long serialVersionUID = 3780510518651566080L;
	public static final String NAME = "ProductFeatureApplAttr";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
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

	public enum Fields {
		productId, productFeatureId, fromDate, attrName, attrValue
	}

	public ProductFeatureApplAttr(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
	}

	public static ProductFeatureApplAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureApplAttr(value);
	}

	public static List<ProductFeatureApplAttr> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureApplAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureApplAttr(value));
		}
		return entities;
	}
}