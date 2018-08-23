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
 * Product Search Result
 */
@FieldNameConstants
public class ProductSearchResult implements Serializable {

	public static final long serialVersionUID = 3297500027212786688L;
	public static final String NAME = "ProductSearchResult";
	/**
	 * Product Search Result Id
	 */
	@Getter
	@Setter
	private String productSearchResultId;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Order By Name
	 */
	@Getter
	@Setter
	private String orderByName;
	/**
	 * Is Ascending
	 */
	@Getter
	@Setter
	private String isAscending;
	/**
	 * Num Results
	 */
	@Getter
	@Setter
	private Long numResults;
	/**
	 * Seconds Total
	 */
	@Getter
	@Setter
	private Double secondsTotal;
	/**
	 * Search Date
	 */
	@Getter
	@Setter
	private Timestamp searchDate;
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

	public ProductSearchResult(GenericValue value) {
		productSearchResultId = (String) value
				.get(FIELD_PRODUCT_SEARCH_RESULT_ID);
		visitId = (String) value.get(FIELD_VISIT_ID);
		orderByName = (String) value.get(FIELD_ORDER_BY_NAME);
		isAscending = (String) value.get(FIELD_IS_ASCENDING);
		numResults = (Long) value.get(FIELD_NUM_RESULTS);
		secondsTotal = (Double) value.get(FIELD_SECONDS_TOTAL);
		searchDate = (Timestamp) value.get(FIELD_SEARCH_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductSearchResult fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductSearchResult(value);
	}

	public static List<ProductSearchResult> fromValues(List<GenericValue> values) {
		List<ProductSearchResult> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductSearchResult(value));
		}
		return entities;
	}
}