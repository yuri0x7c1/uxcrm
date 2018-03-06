package org.apache.ofbiz.product.feature.entity.view;

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

	public static final long serialVersionUID = 5819645843181111296L;
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
		productFeatureGroupId, productFeatureId, fromDate, thruDate, productId, productFeatureApplTypeId, sequenceNum, amount, recurringAmount
	}

	public ProdFeaGrpAppAndProdFeaApp(GenericValue value) {
		productFeatureGroupId = (String) value.get(Fields.productFeatureGroupId
				.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		productId = (String) value.get(Fields.productId.name());
		productFeatureApplTypeId = (String) value
				.get(Fields.productFeatureApplTypeId.name());
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