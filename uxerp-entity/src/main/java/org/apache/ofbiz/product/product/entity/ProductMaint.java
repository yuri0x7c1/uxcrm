package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Maint
 */
public class ProductMaint implements Serializable {

	public static final long serialVersionUID = 1323320891635674112L;
	public static final String NAME = "ProductMaint";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Maint Seq Id
	 */
	@Getter
	@Setter
	private String productMaintSeqId;
	/**
	 * Product Maint Type Id
	 */
	@Getter
	@Setter
	private String productMaintTypeId;
	/**
	 * Maint Name
	 */
	@Getter
	@Setter
	private String maintName;
	/**
	 * Maint Template Work Effort Id
	 */
	@Getter
	@Setter
	private String maintTemplateWorkEffortId;
	/**
	 * Interval Quantity
	 */
	@Getter
	@Setter
	private BigDecimal intervalQuantity;
	/**
	 * Interval Uom Id
	 */
	@Getter
	@Setter
	private String intervalUomId;
	/**
	 * Interval Meter Type Id
	 */
	@Getter
	@Setter
	private String intervalMeterTypeId;
	/**
	 * Repeat Count
	 */
	@Getter
	@Setter
	private Long repeatCount;

	public enum Fields {
		productId, productMaintSeqId, productMaintTypeId, maintName, maintTemplateWorkEffortId, intervalQuantity, intervalUomId, intervalMeterTypeId, repeatCount
	}

	public ProductMaint(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		productMaintSeqId = (String) value.get(Fields.productMaintSeqId.name());
		productMaintTypeId = (String) value.get(Fields.productMaintTypeId
				.name());
		maintName = (String) value.get(Fields.maintName.name());
		maintTemplateWorkEffortId = (String) value
				.get(Fields.maintTemplateWorkEffortId.name());
		intervalQuantity = (BigDecimal) value.get(Fields.intervalQuantity
				.name());
		intervalUomId = (String) value.get(Fields.intervalUomId.name());
		intervalMeterTypeId = (String) value.get(Fields.intervalMeterTypeId
				.name());
		repeatCount = (Long) value.get(Fields.repeatCount.name());
	}

	public static ProductMaint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductMaint(value);
	}

	public static List<ProductMaint> fromValues(List<GenericValue> values) {
		List<ProductMaint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductMaint(value));
		}
		return entities;
	}
}