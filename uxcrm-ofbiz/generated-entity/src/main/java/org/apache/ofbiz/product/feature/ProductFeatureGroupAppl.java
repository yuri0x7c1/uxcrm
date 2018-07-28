package org.apache.ofbiz.product.feature;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Group Appl
 */
public class ProductFeatureGroupAppl implements Serializable {

	public static final long serialVersionUID = 6537584676196835328L;
	public static final String NAME = "ProductFeatureGroupAppl";
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
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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
		productFeatureGroupId, productFeatureId, fromDate, thruDate, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFeatureGroupAppl(GenericValue value) {
		productFeatureGroupId = (String) value.get(Fields.productFeatureGroupId
				.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductFeatureGroupAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureGroupAppl(value);
	}

	public static List<ProductFeatureGroupAppl> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureGroupAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureGroupAppl(value));
		}
		return entities;
	}
}