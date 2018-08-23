package org.apache.ofbiz.content.content;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ContentSearchResult implements Serializable {

	public static final long serialVersionUID = 5153438611871368192L;
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

	public ContentSearchResult(GenericValue value) {
		contentSearchResultId = (String) value
				.get(FIELD_CONTENT_SEARCH_RESULT_ID);
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