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
 * Product Feature
 */
@FieldNameConstants
public class ProductFeature implements Serializable {

	public static final long serialVersionUID = 4089498125202863104L;
	public static final String NAME = "ProductFeature";
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

	public ProductFeature(GenericValue value) {
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
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductFeature fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeature(value);
	}

	public static List<ProductFeature> fromValues(List<GenericValue> values) {
		List<ProductFeature> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeature(value));
		}
		return entities;
	}
}