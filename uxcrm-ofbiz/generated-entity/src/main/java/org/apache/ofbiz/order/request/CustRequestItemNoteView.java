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
 * Cust Request Item Note View
 */
@FieldNameConstants
public class CustRequestItemNoteView implements Serializable {

	public static final long serialVersionUID = 7493635393323054080L;
	public static final String NAME = "CustRequestItemNoteView";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Cust Request Item Seq Id
	 */
	@Getter
	@Setter
	private String custRequestItemSeqId;
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
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;

	public CustRequestItemNoteView(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		custRequestItemSeqId = (String) value
				.get(FIELD_CUST_REQUEST_ITEM_SEQ_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		noteName = (String) value.get(FIELD_NOTE_NAME);
		noteInfo = (String) value.get(FIELD_NOTE_INFO);
		noteDateTime = (Timestamp) value.get(FIELD_NOTE_DATE_TIME);
		partyId = (String) value.get(FIELD_PARTY_ID);
		firstName = (String) value.get(FIELD_FIRST_NAME);
		lastName = (String) value.get(FIELD_LAST_NAME);
	}

	public static CustRequestItemNoteView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestItemNoteView(value);
	}

	public static List<CustRequestItemNoteView> fromValues(
			List<GenericValue> values) {
		List<CustRequestItemNoteView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestItemNoteView(value));
		}
		return entities;
	}
}