package org.apache.ofbiz.product.category;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Content Type
 */
@FieldNameConstants
public class ProductCategoryContentType implements Serializable {

	public static final long serialVersionUID = 4423232946417474560L;
	public static final String NAME = "ProductCategoryContentType";
	/**
	 * Prod Cat Content Type Id
	 */
	@Getter
	@Setter
	private String prodCatContentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
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

	public ProductCategoryContentType(GenericValue value) {
		prodCatContentTypeId = (String) value
				.get(FIELD_PROD_CAT_CONTENT_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductCategoryContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryContentType(value);
	}

	public static List<ProductCategoryContentType> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryContentType(value));
		}
		return entities;
	}
}