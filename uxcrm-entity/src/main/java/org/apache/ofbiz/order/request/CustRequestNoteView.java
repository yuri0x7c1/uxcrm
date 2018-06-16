package org.apache.ofbiz.order.request;

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
public class CustRequestNoteView implements Serializable {

	public static final long serialVersionUID = 405418257835384832L;
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

	public enum Fields {
		custRequestId, noteId, noteName, noteInfo, noteDateTime, noteParty, firstName, lastName
	}

	public CustRequestNoteView(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		noteId = (String) value.get(Fields.noteId.name());
		noteName = (String) value.get(Fields.noteName.name());
		noteInfo = (String) value.get(Fields.noteInfo.name());
		noteDateTime = (Timestamp) value.get(Fields.noteDateTime.name());
		noteParty = (String) value.get(Fields.noteParty.name());
		firstName = (String) value.get(Fields.firstName.name());
		lastName = (String) value.get(Fields.lastName.name());
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