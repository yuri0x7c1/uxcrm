package org.apache.ofbiz.common.note;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Note Data
 */
@FieldNameConstants
public class NoteData implements Serializable {

	public static final long serialVersionUID = 5057595158141935616L;
	public static final String NAME = "NoteData";
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;
	/**
	 * Note Name
	 */
	@Getter
	@Setter
	private String noteName;
	/**
	 * Note Info
	 */
	@Getter
	@Setter
	private String noteInfo;
	/**
	 * Note Date Time
	 */
	@Getter
	@Setter
	private Timestamp noteDateTime;
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
	/**
	 * Note Party
	 */
	@Getter
	@Setter
	private String noteParty;
	/**
	 * More Info Url
	 */
	@Getter
	@Setter
	private String moreInfoUrl;
	/**
	 * More Info Item Id
	 */
	@Getter
	@Setter
	private String moreInfoItemId;
	/**
	 * More Info Item Name
	 */
	@Getter
	@Setter
	private String moreInfoItemName;

	public NoteData(GenericValue value) {
		noteId = (String) value.get(FIELD_NOTE_ID);
		noteName = (String) value.get(FIELD_NOTE_NAME);
		noteInfo = (String) value.get(FIELD_NOTE_INFO);
		noteDateTime = (Timestamp) value.get(FIELD_NOTE_DATE_TIME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		noteParty = (String) value.get(FIELD_NOTE_PARTY);
		moreInfoUrl = (String) value.get(FIELD_MORE_INFO_URL);
		moreInfoItemId = (String) value.get(FIELD_MORE_INFO_ITEM_ID);
		moreInfoItemName = (String) value.get(FIELD_MORE_INFO_ITEM_NAME);
	}

	public static NoteData fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new NoteData(value);
	}

	public static List<NoteData> fromValues(List<GenericValue> values) {
		List<NoteData> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new NoteData(value));
		}
		return entities;
	}
}