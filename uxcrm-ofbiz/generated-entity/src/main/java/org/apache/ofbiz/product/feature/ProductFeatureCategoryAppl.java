package org.apache.ofbiz.product.feature;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Category Appl
 */
public class ProductFeatureCategoryAppl implements Serializable {

	public static final long serialVersionUID = 9125038547152804864L;
	public static final String NAME = "ProductFeatureCategoryAppl";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Product Feature Category Id
	 */
	@Getter
	@Setter
	private String productFeatureCategoryId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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
		productCategoryId, productFeatureCategoryId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFeatureCategoryAppl(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		productFeatureCategoryId = (String) value
				.get(Fields.productFeatureCategoryId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductFeatureCategoryAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureCategoryAppl(value);
	}

	public static List<ProductFeatureCategoryAppl> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureCategoryAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureCategoryAppl(value));
		}
		return entities;
	}
}