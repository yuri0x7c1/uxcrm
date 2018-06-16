package org.apache.ofbiz.product.catalog;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Catalog Category
 */
public class ProdCatalogCategory implements Serializable {

	public static final long serialVersionUID = 1253369208439211008L;
	public static final String NAME = "ProdCatalogCategory";
	/**
	 * Prod Catalog Id
	 */
	@Getter
	@Setter
	private String prodCatalogId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Prod Catalog Category Type Id
	 */
	@Getter
	@Setter
	private String prodCatalogCategoryTypeId;
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
		prodCatalogId, productCategoryId, prodCatalogCategoryTypeId, fromDate, thruDate, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProdCatalogCategory(GenericValue value) {
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		prodCatalogCategoryTypeId = (String) value
				.get(Fields.prodCatalogCategoryTypeId.name());
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

	public static ProdCatalogCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdCatalogCategory(value);
	}

	public static List<ProdCatalogCategory> fromValues(List<GenericValue> values) {
		List<ProdCatalogCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdCatalogCategory(value));
		}
		return entities;
	}
}