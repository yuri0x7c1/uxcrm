package org.apache.ofbiz.product.feature;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Fea Grp App And Prod Fea App
 */
@FieldNameConstants
public class ProdFeaGrpAppAndProdFeaApp implements Serializable {

	public static final long serialVersionUID = 3840671614295091200L;
	public static final String NAME = "ProdFeaGrpAppAndProdFeaApp";
	/**
	 * Product Feature Group Id
	 */
	@Getter
	@Setter
	private String productFeatureGroupId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Group From Date
	 */
	@Getter
	@Setter
	private Timestamp groupFromDate;
	/**
	 * Group Thru Date
	 */
	@Getter
	@Setter
	private Timestamp groupThruDate;
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

	public ProdFeaGrpAppAndProdFeaApp(GenericValue value) {
		productFeatureGroupId = (String) value
				.get(FIELD_PRODUCT_FEATURE_GROUP_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		groupFromDate = (Timestamp) value.get(FIELD_GROUP_FROM_DATE);
		groupThruDate = (Timestamp) value.get(FIELD_GROUP_THRU_DATE);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productFeatureApplTypeId = (String) value
				.get(FIELD_PRODUCT_FEATURE_APPL_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		recurringAmount = (BigDecimal) value.get(FIELD_RECURRING_AMOUNT);
	}

	public static ProdFeaGrpAppAndProdFeaApp fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdFeaGrpAppAndProdFeaApp(value);
	}

	public static List<ProdFeaGrpAppAndProdFeaApp> fromValues(
			List<GenericValue> values) {
		List<ProdFeaGrpAppAndProdFeaApp> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdFeaGrpAppAndProdFeaApp(value));
		}
		return entities;
	}
}