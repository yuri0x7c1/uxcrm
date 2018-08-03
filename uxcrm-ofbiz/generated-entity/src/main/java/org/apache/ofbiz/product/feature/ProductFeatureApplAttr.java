package org.apache.ofbiz.product.feature;

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

	public static final long serialVersionUID = 6063365898065932288L;
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
		productId, productFeatureId, fromDate, attrName, attrValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFeatureApplAttr(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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