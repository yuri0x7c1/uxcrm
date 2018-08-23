package org.apache.ofbiz.product.catalog;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProdCatalogCategory implements Serializable {

	public static final long serialVersionUID = 5372816749804621824L;
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

	public ProdCatalogCategory(GenericValue value) {
		prodCatalogId = (String) value.get(FIELD_PROD_CATALOG_ID);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		prodCatalogCategoryTypeId = (String) value
				.get(FIELD_PROD_CATALOG_CATEGORY_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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