package org.apache.ofbiz.product.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Group Appl
 */
public class ProductFeatureGroupAppl implements Serializable {

	public static final long serialVersionUID = 3065266669635408896L;
	public static final String NAME = "ProductFeatureGroupAppl";
	/**
	 * Product Feature Group Id
	 */
	@Getter
	@Setter
	private String productFeatureGroupId;
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
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		productFeatureGroupId, productFeatureId, fromDate, thruDate, sequenceNum
	}

	public ProductFeatureGroupAppl(GenericValue value) {
		productFeatureGroupId = (String) value.get(Fields.productFeatureGroupId
				.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProductFeatureGroupAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureGroupAppl(value);
	}

	public static List<ProductFeatureGroupAppl> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureGroupAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureGroupAppl(value));
		}
		return entities;
	}
}