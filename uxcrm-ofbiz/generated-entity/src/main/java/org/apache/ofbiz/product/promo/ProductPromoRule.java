package org.apache.ofbiz.product.promo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Rule
 */
public class ProductPromoRule implements Serializable {

	public static final long serialVersionUID = 1464442153925369856L;
	public static final String NAME = "ProductPromoRule";
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * Product Promo Rule Id
	 */
	@Getter
	@Setter
	private String productPromoRuleId;
	/**
	 * Rule Name
	 */
	@Getter
	@Setter
	private String ruleName;
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
		productPromoId, productPromoRuleId, ruleName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPromoRule(GenericValue value) {
		productPromoId = (String) value.get(Fields.productPromoId.name());
		productPromoRuleId = (String) value.get(Fields.productPromoRuleId
				.name());
		ruleName = (String) value.get(Fields.ruleName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductPromoRule fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoRule(value);
	}

	public static List<ProductPromoRule> fromValues(List<GenericValue> values) {
		List<ProductPromoRule> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoRule(value));
		}
		return entities;
	}
}