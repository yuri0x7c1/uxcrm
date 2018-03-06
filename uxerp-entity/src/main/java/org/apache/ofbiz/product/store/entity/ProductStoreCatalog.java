package org.apache.ofbiz.product.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Catalog
 */
public class ProductStoreCatalog implements Serializable {

	public static final long serialVersionUID = 1589234107473184768L;
	public static final String NAME = "ProductStoreCatalog";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Prod Catalog Id
	 */
	@Getter
	@Setter
	private String prodCatalogId;
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

	public enum Fields {
		productStoreId, prodCatalogId, fromDate, thruDate, sequenceNum
	}

	public ProductStoreCatalog(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProductStoreCatalog fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreCatalog(value);
	}

	public static List<ProductStoreCatalog> fromValues(List<GenericValue> values) {
		List<ProductStoreCatalog> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreCatalog(value));
		}
		return entities;
	}
}