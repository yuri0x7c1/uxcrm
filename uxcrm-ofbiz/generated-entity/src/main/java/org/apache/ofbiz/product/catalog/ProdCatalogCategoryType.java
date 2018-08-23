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
 * Prod Catalog Category Type
 */
@FieldNameConstants
public class ProdCatalogCategoryType implements Serializable {

	public static final long serialVersionUID = 8938378114506635264L;
	public static final String NAME = "ProdCatalogCategoryType";
	/**
	 * Prod Catalog Category Type Id
	 */
	@Getter
	@Setter
	private String prodCatalogCategoryTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public ProdCatalogCategoryType(GenericValue value) {
		prodCatalogCategoryTypeId = (String) value
				.get(FIELD_PROD_CATALOG_CATEGORY_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProdCatalogCategoryType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdCatalogCategoryType(value);
	}

	public static List<ProdCatalogCategoryType> fromValues(
			List<GenericValue> values) {
		List<ProdCatalogCategoryType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdCatalogCategoryType(value));
		}
		return entities;
	}
}