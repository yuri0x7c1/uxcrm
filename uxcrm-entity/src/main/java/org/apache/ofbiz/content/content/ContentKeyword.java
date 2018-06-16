package org.apache.ofbiz.content.content;

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
public class ContentKeyword implements Serializable {

	public static final long serialVersionUID = 2112685404546552832L;
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

	public enum Fields {
		contentId, keyword, relevancyWeight, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentKeyword(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		keyword = (String) value.get(Fields.keyword.name());
		relevancyWeight = (Long) value.get(Fields.relevancyWeight.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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