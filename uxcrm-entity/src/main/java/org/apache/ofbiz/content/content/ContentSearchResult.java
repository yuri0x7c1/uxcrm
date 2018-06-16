package org.apache.ofbiz.content.content;

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

	public static final long serialVersionUID = 8488574638002693120L;
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
		contentSearchResultId, visitId, orderByName, isAscending, numResults, secondsTotal, searchDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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