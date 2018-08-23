package org.apache.ofbiz.order.request;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class CustRequestAndNote implements Serializable {

	public static final long serialVersionUID = 2386607886988902400L;
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

	public CustRequestAndNote(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		noteName = (String) value.get(FIELD_NOTE_NAME);
		noteDateTime = (Timestamp) value.get(FIELD_NOTE_DATE_TIME);
		moreInfoItemName = (String) value.get(FIELD_MORE_INFO_ITEM_NAME);
		noteInfo = (String) value.get(FIELD_NOTE_INFO);
		moreInfoUrl = (String) value.get(FIELD_MORE_INFO_URL);
		noteId = (String) value.get(FIELD_NOTE_ID);
		moreInfoItemId = (String) value.get(FIELD_MORE_INFO_ITEM_ID);
		noteParty = (String) value.get(FIELD_NOTE_PARTY);
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