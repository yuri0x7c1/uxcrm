package org.apache.ofbiz.product.store;

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

	public static final long serialVersionUID = 1648249353250978816L;
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
		productStoreId, prodCatalogId, fromDate, thruDate, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStoreCatalog(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
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