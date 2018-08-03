package org.apache.ofbiz.product.feature;

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
public class ProductFeature implements Serializable {

	public static final long serialVersionUID = 7375826022601814016L;
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

	public enum Fields {
		productFeatureId, productFeatureTypeId, productFeatureCategoryId, description, uomId, numberSpecified, defaultAmount, defaultSequenceNum, abbrev, idCode, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFeature(GenericValue value) {
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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