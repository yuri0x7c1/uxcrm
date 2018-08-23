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
 * Cust Request Note View
 */
@FieldNameConstants
public class CustRequestNoteView implements Serializable {

	public static final long serialVersionUID = 6577478437989500928L;
	public static final String NAME = "CustRequestNoteView";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
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
	 * Note Party
	 */
	@Getter
	@Setter
	private String noteParty;
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

	public CustRequestNoteView(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		noteName = (String) value.get(FIELD_NOTE_NAME);
		noteInfo = (String) value.get(FIELD_NOTE_INFO);
		noteDateTime = (Timestamp) value.get(FIELD_NOTE_DATE_TIME);
		noteParty = (String) value.get(FIELD_NOTE_PARTY);
		firstName = (String) value.get(FIELD_FIRST_NAME);
		lastName = (String) value.get(FIELD_LAST_NAME);
	}

	public static CustRequestNoteView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestNoteView(value);
	}

	public static List<CustRequestNoteView> fromValues(List<GenericValue> values) {
		List<CustRequestNoteView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestNoteView(value));
		}
		return entities;
	}
}