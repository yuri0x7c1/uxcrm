package org.apache.ofbiz.product.price.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Price Rule
 */
public class ProductPriceRule implements Serializable {

	public static final long serialVersionUID = 6377326946337753088L;
	public static final String NAME = "ProductPriceRule";
	/**
	 * Product Price Rule Id
	 */
	@Getter
	@Setter
	private String productPriceRuleId;
	/**
	 * Rule Name
	 */
	@Getter
	@Setter
	private String ruleName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Is Sale
	 */
	@Getter
	@Setter
	private String isSale;
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

	public enum Fields {
		productPriceRuleId, ruleName, description, isSale, fromDate, thruDate
	}

	public ProductPriceRule(GenericValue value) {
		productPriceRuleId = (String) value.get(Fields.productPriceRuleId
				.name());
		ruleName = (String) value.get(Fields.ruleName.name());
		description = (String) value.get(Fields.description.name());
		isSale = (String) value.get(Fields.isSale.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static ProductPriceRule fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPriceRule(value);
	}

	public static List<ProductPriceRule> fromValues(List<GenericValue> values) {
		List<ProductPriceRule> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPriceRule(value));
		}
		return entities;
	}
}