package org.apache.ofbiz.content.content;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Purpose
 */
public class ContentPurpose implements Serializable {

	public static final long serialVersionUID = 7170588792775951360L;
	public static final String NAME = "ContentPurpose";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Content Purpose Type Id
	 */
	@Getter
	@Setter
	private String contentPurposeTypeId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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
		contentId, contentPurposeTypeId, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentPurpose(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		contentPurposeTypeId = (String) value.get(Fields.contentPurposeTypeId
				.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContentPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentPurpose(value);
	}

	public static List<ContentPurpose> fromValues(List<GenericValue> values) {
		List<ContentPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentPurpose(value));
		}
		return entities;
	}
}