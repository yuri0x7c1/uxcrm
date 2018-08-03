package org.apache.ofbiz.product.feature;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Group And Appl
 */
public class ProductFeatureGroupAndAppl implements Serializable {

	public static final long serialVersionUID = 8852506600140498944L;
	public static final String NAME = "ProductFeatureGroupAndAppl";
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Product Feature Group Id
	 */
	@Getter
	@Setter
	private String productFeatureGroupId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Product Feature Type Id
	 */
	@Getter
	@Setter
	private String productFeatureTypeId;
	/**
	 * Id Code
	 */
	@Getter
	@Setter
	private String idCode;
	/**
	 * Number Specified
	 */
	@Getter
	@Setter
	private BigDecimal numberSpecified;
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
	 * Default Sequence Num
	 */
	@Getter
	@Setter
	private Long defaultSequenceNum;
	/**
	 * Default Amount
	 */
	@Getter
	@Setter
	private BigDecimal defaultAmount;
	/**
	 * Abbrev
	 */
	@Getter
	@Setter
	private String abbrev;

	public enum Fields {
		fromDate, sequenceNum, productFeatureId, productFeatureGroupId, thruDate, productFeatureTypeId, idCode, numberSpecified, productFeatureCategoryId, description, uomId, defaultSequenceNum, defaultAmount, abbrev
	}

	public ProductFeatureGroupAndAppl(GenericValue value) {
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		productFeatureGroupId = (String) value.get(Fields.productFeatureGroupId
				.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		productFeatureTypeId = (String) value.get(Fields.productFeatureTypeId
				.name());
		idCode = (String) value.get(Fields.idCode.name());
		numberSpecified = (BigDecimal) value.get(Fields.numberSpecified.name());
		productFeatureCategoryId = (String) value
				.get(Fields.productFeatureCategoryId.name());
		description = (String) value.get(Fields.description.name());
		uomId = (String) value.get(Fields.uomId.name());
		defaultSequenceNum = (Long) value.get(Fields.defaultSequenceNum.name());
		defaultAmount = (BigDecimal) value.get(Fields.defaultAmount.name());
		abbrev = (String) value.get(Fields.abbrev.name());
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