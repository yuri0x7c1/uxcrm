package org.apache.ofbiz.product.store;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Keyword Ovrd
 */
public class ProductStoreKeywordOvrd implements Serializable {

	public static final long serialVersionUID = 1644794132419915776L;
	public static final String NAME = "ProductStoreKeywordOvrd";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Keyword
	 */
	@Getter
	@Setter
	private String keyword;
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
	 * Target
	 */
	@Getter
	@Setter
	private String target;
	/**
	 * Target Type Enum Id
	 */
	@Getter
	@Setter
	private String targetTypeEnumId;
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
		productStoreId, keyword, fromDate, thruDate, target, targetTypeEnumId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStoreKeywordOvrd(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		keyword = (String) value.get(Fields.keyword.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		target = (String) value.get(Fields.target.name());
		targetTypeEnumId = (String) value.get(Fields.targetTypeEnumId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductStoreKeywordOvrd fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreKeywordOvrd(value);
	}

	public static List<ProductStoreKeywordOvrd> fromValues(
			List<GenericValue> values) {
		List<ProductStoreKeywordOvrd> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreKeywordOvrd(value));
		}
		return entities;
	}
}