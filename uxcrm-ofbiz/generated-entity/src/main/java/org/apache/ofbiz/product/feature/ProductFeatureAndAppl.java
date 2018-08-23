package org.apache.ofbiz.product.feature;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature And Appl
 */
@FieldNameConstants
public class ProductFeatureAndAppl implements Serializable {

	public static final long serialVersionUID = 8735782757578171392L;
	public static final String NAME = "ProductFeatureAndAppl";
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
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
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Feature Appl Type Id
	 */
	@Getter
	@Setter
	private String productFeatureApplTypeId;
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
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Recurring Amount
	 */
	@Getter
	@Setter
	private BigDecimal recurringAmount;

	public ProductFeatureAndAppl(GenericValue value) {
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		productFeatureTypeId = (String) value
				.get(FIELD_PRODUCT_FEATURE_TYPE_ID);
		productFeatureCategoryId = (String) value
				.get(FIELD_PRODUCT_FEATURE_CATEGORY_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		uomId = (String) value.get(FIELD_UOM_ID);
		numberSpecified = (BigDecimal) value.get(FIELD_NUMBER_SPECIFIED);
		defaultAmount = (BigDecimal) value.get(FIELD_DEFAULT_AMOUNT);
		defaultSequenceNum = (Long) value.get(FIELD_DEFAULT_SEQUENCE_NUM);
		abbrev = (String) value.get(FIELD_ABBREV);
		idCode = (String) value.get(FIELD_ID_CODE);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productFeatureApplTypeId = (String) value
				.get(FIELD_PRODUCT_FEATURE_APPL_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		recurringAmount = (BigDecimal) value.get(FIELD_RECURRING_AMOUNT);
	}

	public static ProductFeatureAndAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureAndAppl(value);
	}

	public static List<ProductFeatureAndAppl> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureAndAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureAndAppl(value));
		}
		return entities;
	}
}