package org.apache.ofbiz.product.price;

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
 * Product Price Action
 */
@FieldNameConstants
public class ProductPriceAction implements Serializable {

	public static final long serialVersionUID = 2332187367417019392L;
	public static final String NAME = "ProductPriceAction";
	/**
	 * Product Price Rule Id
	 */
	@Getter
	@Setter
	private String productPriceRuleId;
	/**
	 * Product Price Action Seq Id
	 */
	@Getter
	@Setter
	private String productPriceActionSeqId;
	/**
	 * Product Price Action Type Id
	 */
	@Getter
	@Setter
	private String productPriceActionTypeId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Rate Code
	 */
	@Getter
	@Setter
	private String rateCode;
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

	public ProductPriceAction(GenericValue value) {
		productPriceRuleId = (String) value.get(FIELD_PRODUCT_PRICE_RULE_ID);
		productPriceActionSeqId = (String) value
				.get(FIELD_PRODUCT_PRICE_ACTION_SEQ_ID);
		productPriceActionTypeId = (String) value
				.get(FIELD_PRODUCT_PRICE_ACTION_TYPE_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		rateCode = (String) value.get(FIELD_RATE_CODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductPriceAction fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPriceAction(value);
	}

	public static List<ProductPriceAction> fromValues(List<GenericValue> values) {
		List<ProductPriceAction> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPriceAction(value));
		}
		return entities;
	}
}