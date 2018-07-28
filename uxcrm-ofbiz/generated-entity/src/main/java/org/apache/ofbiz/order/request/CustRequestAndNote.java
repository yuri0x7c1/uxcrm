package org.apache.ofbiz.order.request;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request And Note
 */
public class CustRequestAndNote implements Serializable {

	public static final long serialVersionUID = 7264970460545961984L;
	public static final String NAME = "CustRequestAndNote";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Note Name
	 */
	@Getter
	@Setter
	private String noteName;
	/**
	 * Note Date Time
	 */
	@Getter
	@Setter
	private Timestamp noteDateTime;
	/**
	 * More Info Item Name
	 */
	@Getter
	@Setter
	private String moreInfoItemName;
	/**
	 * Note Info
	 */
	@Getter
	@Setter
	private String noteInfo;
	/**
	 * More Info Url
	 */
	@Getter
	@Setter
	private String moreInfoUrl;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;
	/**
	 * More Info Item Id
	 */
	@Getter
	@Setter
	private String moreInfoItemId;
	/**
	 * Note Party
	 */
	@Getter
	@Setter
	private String noteParty;

	public enum Fields {
		custRequestId, noteName, noteDateTime, moreInfoItemName, noteInfo, moreInfoUrl, noteId, moreInfoItemId, noteParty
	}

	public CustRequestAndNote(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		noteName = (String) value.get(Fields.noteName.name());
		noteDateTime = (Timestamp) value.get(Fields.noteDateTime.name());
		moreInfoItemName = (String) value.get(Fields.moreInfoItemName.name());
		noteInfo = (String) value.get(Fields.noteInfo.name());
		moreInfoUrl = (String) value.get(Fields.moreInfoUrl.name());
		noteId = (String) value.get(Fields.noteId.name());
		moreInfoItemId = (String) value.get(Fields.moreInfoItemId.name());
		noteParty = (String) value.get(Fields.noteParty.name());
	}

	public static CustRequestAndNote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestAndNote(value);
	}

	public static List<CustRequestAndNote> fromValues(List<GenericValue> values) {
		List<CustRequestAndNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestAndNote(value));
		}
		return entities;
	}
}