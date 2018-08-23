package org.apache.ofbiz.product.price;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductPriceRule implements Serializable {

	public static final long serialVersionUID = 7000847435463804928L;
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

	public ProductPriceRule(GenericValue value) {
		productPriceRuleId = (String) value.get(FIELD_PRODUCT_PRICE_RULE_ID);
		ruleName = (String) value.get(FIELD_RULE_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		isSale = (String) value.get(FIELD_IS_SALE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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