package org.apache.ofbiz.product.feature;

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
public class ProdFeaGrpAppAndProdFeaApp implements Serializable {

	public static final long serialVersionUID = 6430096792693182464L;
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

	public enum Fields {
		productFeatureGroupId, productFeatureId, groupFromDate, groupThruDate, productId, productFeatureApplTypeId, fromDate, thruDate, sequenceNum, amount, recurringAmount
	}

	public ProdFeaGrpAppAndProdFeaApp(GenericValue value) {
		productFeatureGroupId = (String) value.get(Fields.productFeatureGroupId
				.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		groupFromDate = (Timestamp) value.get(Fields.groupFromDate.name());
		groupThruDate = (Timestamp) value.get(Fields.groupThruDate.name());
		productId = (String) value.get(Fields.productId.name());
		productFeatureApplTypeId = (String) value
				.get(Fields.productFeatureApplTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		recurringAmount = (BigDecimal) value.get(Fields.recurringAmount.name());
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