package org.apache.ofbiz.product.feature.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Group And Appl
 */
public class ProductFeatureGroupAndAppl implements Serializable {

	public static final long serialVersionUID = 8505109331567681536L;
	public static final String NAME = "ProductFeatureGroupAndAppl";
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
	/**
	 * Product Feature Type Id
	 */
	@Getter
	@Setter
	private String productFeatureTypeId;
	/**
	 * Product Feature Category Id
	 */
	@Getter
	@Setter
	private String productFeatureCategoryId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Number Specified
	 */
	@Getter
	@Setter
	private BigDecimal numberSpecified;
	/**
	 * Default Amount
	 */
	@Getter
	@Setter
	private BigDecimal defaultAmount;
	/**
	 * Default Sequence Num
	 */
	@Getter
	@Setter
	private Long defaultSequenceNum;
	/**
	 * Abbrev
	 */
	@Getter
	@Setter
	private String abbrev;
	/**
	 * Id Code
	 */
	@Getter
	@Setter
	private String idCode;

	public enum Fields {
		productFeatureGroupId, productFeatureId, fromDate, thruDate, sequenceNum, productFeatureTypeId, productFeatureCategoryId, description, uomId, numberSpecified, defaultAmount, defaultSequenceNum, abbrev, idCode
	}

	public ProductFeatureGroupAndAppl(GenericValue value) {
		productFeatureGroupId = (String) value.get(Fields.productFeatureGroupId
				.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		productFeatureTypeId = (String) value.get(Fields.productFeatureTypeId
				.name());
		productFeatureCategoryId = (String) value
				.get(Fields.productFeatureCategoryId.name());
		description = (String) value.get(Fields.description.name());
		uomId = (String) value.get(Fields.uomId.name());
		numberSpecified = (BigDecimal) value.get(Fields.numberSpecified.name());
		defaultAmount = (BigDecimal) value.get(Fields.defaultAmount.name());
		defaultSequenceNum = (Long) value.get(Fields.defaultSequenceNum.name());
		abbrev = (String) value.get(Fields.abbrev.name());
		idCode = (String) value.get(Fields.idCode.name());
	}

	public static ProductFeatureGroupAndAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureGroupAndAppl(value);
	}

	public static List<ProductFeatureGroupAndAppl> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureGroupAndAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureGroupAndAppl(value));
		}
		return entities;
	}
}