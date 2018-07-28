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
 * Product Feature And Appl
 */
public class ProductFeatureAndAppl implements Serializable {

	public static final long serialVersionUID = 2848288551005196288L;
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

	public enum Fields {
		productFeatureId, productFeatureTypeId, productFeatureCategoryId, description, uomId, numberSpecified, defaultAmount, defaultSequenceNum, abbrev, idCode, productId, productFeatureApplTypeId, fromDate, thruDate, sequenceNum, amount, recurringAmount
	}

	public ProductFeatureAndAppl(GenericValue value) {
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
		productId = (String) value.get(Fields.productId.name());
		productFeatureApplTypeId = (String) value
				.get(Fields.productFeatureApplTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		recurringAmount = (BigDecimal) value.get(Fields.recurringAmount.name());
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