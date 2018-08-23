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
 * Content Keyword
 */
@FieldNameConstants
public class ContentKeyword implements Serializable {

	public static final long serialVersionUID = 1263094670718086144L;
	public static final String NAME = "ContentKeyword";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Keyword
	 */
	@Getter
	@Setter
	private String keyword;
	/**
	 * Relevancy Weight
	 */
	@Getter
	@Setter
	private Long relevancyWeight;
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

	public ContentKeyword(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		keyword = (String) value.get(FIELD_KEYWORD);
		relevancyWeight = (Long) value.get(FIELD_RELEVANCY_WEIGHT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContentKeyword fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentKeyword(value);
	}

	public static List<ContentKeyword> fromValues(List<GenericValue> values) {
		List<ContentKeyword> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentKeyword(value));
		}
		return entities;
	}
}