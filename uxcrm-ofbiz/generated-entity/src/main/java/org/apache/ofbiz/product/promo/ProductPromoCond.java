package org.apache.ofbiz.product.promo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Cond
 */
public class ProductPromoCond implements Serializable {

	public static final long serialVersionUID = 4079940335348332544L;
	public static final String NAME = "ProductPromoCond";
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
	 * Product Promo Cond Seq Id
	 */
	@Getter
	@Setter
	private String productPromoCondSeqId;
	/**
	 * Input Param Enum Id
	 */
	@Getter
	@Setter
	private String inputParamEnumId;
	/**
	 * Operator Enum Id
	 */
	@Getter
	@Setter
	private String operatorEnumId;
	/**
	 * Cond Value
	 */
	@Getter
	@Setter
	private String condValue;
	/**
	 * Other Value
	 */
	@Getter
	@Setter
	private String otherValue;
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
		productPromoId, productPromoRuleId, productPromoCondSeqId, inputParamEnumId, operatorEnumId, condValue, otherValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPromoCond(GenericValue value) {
		productPromoId = (String) value.get(Fields.productPromoId.name());
		productPromoRuleId = (String) value.get(Fields.productPromoRuleId
				.name());
		productPromoCondSeqId = (String) value.get(Fields.productPromoCondSeqId
				.name());
		inputParamEnumId = (String) value.get(Fields.inputParamEnumId.name());
		operatorEnumId = (String) value.get(Fields.operatorEnumId.name());
		condValue = (String) value.get(Fields.condValue.name());
		otherValue = (String) value.get(Fields.otherValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductPromoCond fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCond(value);
	}

	public static List<ProductPromoCond> fromValues(List<GenericValue> values) {
		List<ProductPromoCond> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCond(value));
		}
		return entities;
	}
}