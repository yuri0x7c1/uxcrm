package org.apache.ofbiz.product.product;

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
public class ProductSearchResult implements Serializable {

	public static final long serialVersionUID = 4765644668700812288L;
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

	public enum Fields {
		productSearchResultId, visitId, orderByName, isAscending, numResults, secondsTotal, searchDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductSearchResult(GenericValue value) {
		productSearchResultId = (String) value.get(Fields.productSearchResultId
				.name());
		visitId = (String) value.get(Fields.visitId.name());
		orderByName = (String) value.get(Fields.orderByName.name());
		isAscending = (String) value.get(Fields.isAscending.name());
		numResults = (Long) value.get(Fields.numResults.name());
		secondsTotal = (Double) value.get(Fields.secondsTotal.name());
		searchDate = (Timestamp) value.get(Fields.searchDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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