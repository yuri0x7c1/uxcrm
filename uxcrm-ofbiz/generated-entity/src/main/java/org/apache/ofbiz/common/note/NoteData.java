package org.apache.ofbiz.common.note;

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
public class NoteData implements Serializable {

	public static final long serialVersionUID = 2578391861276226560L;
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

	public enum Fields {
		noteId, noteName, noteInfo, noteDateTime, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp, noteParty, moreInfoUrl, moreInfoItemId, moreInfoItemName
	}

	public NoteData(GenericValue value) {
		noteId = (String) value.get(Fields.noteId.name());
		noteName = (String) value.get(Fields.noteName.name());
		noteInfo = (String) value.get(Fields.noteInfo.name());
		noteDateTime = (Timestamp) value.get(Fields.noteDateTime.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
		noteParty = (String) value.get(Fields.noteParty.name());
		moreInfoUrl = (String) value.get(Fields.moreInfoUrl.name());
		moreInfoItemId = (String) value.get(Fields.moreInfoItemId.name());
		moreInfoItemName = (String) value.get(Fields.moreInfoItemName.name());
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