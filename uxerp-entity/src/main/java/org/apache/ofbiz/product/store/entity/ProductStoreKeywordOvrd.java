package org.apache.ofbiz.product.store.entity;

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

	public static final long serialVersionUID = 9200681818355702784L;
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

	public enum Fields {
		productStoreId, keyword, fromDate, thruDate, target, targetTypeEnumId
	}

	public ProductStoreKeywordOvrd(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		keyword = (String) value.get(Fields.keyword.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		target = (String) value.get(Fields.target.name());
		targetTypeEnumId = (String) value.get(Fields.targetTypeEnumId.name());
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