package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Keyword
 */
@FieldNameConstants
public class ProductKeyword implements Serializable {

	public static final long serialVersionUID = 3312636271833472000L;
	public static final String NAME = "ProductKeyword";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Keyword
	 */
	@Getter
	@Setter
	private String keyword;
	/**
	 * Keyword Type Id
	 */
	@Getter
	@Setter
	private String keywordTypeId;
	/**
	 * Relevancy Weight
	 */
	@Getter
	@Setter
	private Long relevancyWeight;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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

	public ProductKeyword(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		keyword = (String) value.get(FIELD_KEYWORD);
		keywordTypeId = (String) value.get(FIELD_KEYWORD_TYPE_ID);
		relevancyWeight = (Long) value.get(FIELD_RELEVANCY_WEIGHT);
		statusId = (String) value.get(FIELD_STATUS_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductKeyword fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductKeyword(value);
	}

	public static List<ProductKeyword> fromValues(List<GenericValue> values) {
		List<ProductKeyword> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductKeyword(value));
		}
		return entities;
	}
}