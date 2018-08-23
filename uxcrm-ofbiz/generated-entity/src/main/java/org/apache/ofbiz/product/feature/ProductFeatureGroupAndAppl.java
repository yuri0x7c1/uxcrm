package org.apache.ofbiz.product.feature;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductFeatureGroupAndAppl implements Serializable {

	public static final long serialVersionUID = 8258012865865445376L;
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

	public ProductFeatureGroupAndAppl(GenericValue value) {
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		productFeatureGroupId = (String) value
				.get(FIELD_PRODUCT_FEATURE_GROUP_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		productFeatureTypeId = (String) value
				.get(FIELD_PRODUCT_FEATURE_TYPE_ID);
		idCode = (String) value.get(FIELD_ID_CODE);
		numberSpecified = (BigDecimal) value.get(FIELD_NUMBER_SPECIFIED);
		productFeatureCategoryId = (String) value
				.get(FIELD_PRODUCT_FEATURE_CATEGORY_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		uomId = (String) value.get(FIELD_UOM_ID);
		defaultSequenceNum = (Long) value.get(FIELD_DEFAULT_SEQUENCE_NUM);
		defaultAmount = (BigDecimal) value.get(FIELD_DEFAULT_AMOUNT);
		abbrev = (String) value.get(FIELD_ABBREV);
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