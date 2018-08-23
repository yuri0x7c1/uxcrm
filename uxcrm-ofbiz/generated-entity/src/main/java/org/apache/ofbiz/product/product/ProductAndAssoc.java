package org.apache.ofbiz.product.product;

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
 * Product And Assoc
 */
@FieldNameConstants
public class ProductAndAssoc implements Serializable {

	public static final long serialVersionUID = 2864100522040650752L;
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

	public ProductAndAssoc(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		productIdTo = (String) value.get(FIELD_PRODUCT_ID_TO);
		productAssocTypeId = (String) value.get(FIELD_PRODUCT_ASSOC_TYPE_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
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