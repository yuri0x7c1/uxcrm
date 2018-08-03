package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product And Assoc
 */
public class ProductAndAssoc implements Serializable {

	public static final long serialVersionUID = 2032558868934843392L;
	public static final String NAME = "ProductAndAssoc";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
	/**
	 * Product Id To
	 */
	@Getter
	@Setter
	private String productIdTo;
	/**
	 * Product Assoc Type Id
	 */
	@Getter
	@Setter
	private String productAssocTypeId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;

	public enum Fields {
		productId, internalName, productIdTo, productAssocTypeId, quantity, fromDate
	}

	public ProductAndAssoc(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		internalName = (String) value.get(Fields.internalName.name());
		productIdTo = (String) value.get(Fields.productIdTo.name());
		productAssocTypeId = (String) value.get(Fields.productAssocTypeId
				.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
	}

	public static ProductAndAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductAndAssoc(value);
	}

	public static List<ProductAndAssoc> fromValues(List<GenericValue> values) {
		List<ProductAndAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductAndAssoc(value));
		}
		return entities;
	}
}