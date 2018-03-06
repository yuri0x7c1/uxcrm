package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Search Result
 */
public class ContentSearchResult implements Serializable {

	public static final long serialVersionUID = 1992405219926897664L;
	public static final String NAME = "ContentSearchResult";
	/**
	 * Content Search Result Id
	 */
	@Getter
	@Setter
	private String contentSearchResultId;
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
		contentSearchResultId, visitId, orderByName, isAscending, numResults, secondsTotal, searchDate
	}

	public ContentSearchResult(GenericValue value) {
		contentSearchResultId = (String) value.get(Fields.contentSearchResultId
				.name());
		visitId = (String) value.get(Fields.visitId.name());
		orderByName = (String) value.get(Fields.orderByName.name());
		isAscending = (String) value.get(Fields.isAscending.name());
		numResults = (Long) value.get(Fields.numResults.name());
		secondsTotal = (Double) value.get(Fields.secondsTotal.name());
		searchDate = (Timestamp) value.get(Fields.searchDate.name());
	}

	public static ContentSearchResult fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentSearchResult(value);
	}

	public static List<ContentSearchResult> fromValues(List<GenericValue> values) {
		List<ContentSearchResult> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentSearchResult(value));
		}
		return entities;
	}
}