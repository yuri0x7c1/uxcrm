package org.apache.ofbiz.product.category;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Content
 */
@FieldNameConstants
public class ProductCategoryContent implements Serializable {

	public static final long serialVersionUID = 3463879293137138688L;
	public static final String NAME = "ProductCategoryContent";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Prod Cat Content Type Id
	 */
	@Getter
	@Setter
	private String prodCatContentTypeId;
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
	 * Purchase From Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseFromDate;
	/**
	 * Purchase Thru Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseThruDate;
	/**
	 * Use Count Limit
	 */
	@Getter
	@Setter
	private Long useCountLimit;
	/**
	 * Use Days Limit
	 */
	@Getter
	@Setter
	private BigDecimal useDaysLimit;
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

	public ProductCategoryContent(GenericValue value) {
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		prodCatContentTypeId = (String) value
				.get(FIELD_PROD_CAT_CONTENT_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		purchaseFromDate = (Timestamp) value.get(FIELD_PURCHASE_FROM_DATE);
		purchaseThruDate = (Timestamp) value.get(FIELD_PURCHASE_THRU_DATE);
		useCountLimit = (Long) value.get(FIELD_USE_COUNT_LIMIT);
		useDaysLimit = (BigDecimal) value.get(FIELD_USE_DAYS_LIMIT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductCategoryContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryContent(value);
	}

	public static List<ProductCategoryContent> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryContent(value));
		}
		return entities;
	}
}