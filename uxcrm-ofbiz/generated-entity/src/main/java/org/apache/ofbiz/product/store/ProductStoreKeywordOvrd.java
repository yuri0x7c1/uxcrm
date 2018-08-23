package org.apache.ofbiz.product.store;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductStoreKeywordOvrd implements Serializable {

	public static final long serialVersionUID = 483712706557139968L;
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

	public ProductStoreKeywordOvrd(GenericValue value) {
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		keyword = (String) value.get(FIELD_KEYWORD);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		target = (String) value.get(FIELD_TARGET);
		targetTypeEnumId = (String) value.get(FIELD_TARGET_TYPE_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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