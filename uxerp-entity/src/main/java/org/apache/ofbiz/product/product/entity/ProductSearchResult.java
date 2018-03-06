package org.apache.ofbiz.product.product.entity;

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

	public static final long serialVersionUID = 2436585428511578112L;
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

	public enum Fields {
		productSearchResultId, visitId, orderByName, isAscending, numResults, secondsTotal, searchDate
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