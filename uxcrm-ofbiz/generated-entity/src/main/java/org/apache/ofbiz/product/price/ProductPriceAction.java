package org.apache.ofbiz.product.price;

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
public class ProductPriceAction implements Serializable {

	public static final long serialVersionUID = 6914597144452641792L;
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

	public enum Fields {
		productPriceRuleId, productPriceActionSeqId, productPriceActionTypeId, amount, rateCode, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPriceAction(GenericValue value) {
		productPriceRuleId = (String) value.get(Fields.productPriceRuleId
				.name());
		productPriceActionSeqId = (String) value
				.get(Fields.productPriceActionSeqId.name());
		productPriceActionTypeId = (String) value
				.get(Fields.productPriceActionTypeId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		rateCode = (String) value.get(Fields.rateCode.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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