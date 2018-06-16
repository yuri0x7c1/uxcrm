package org.apache.ofbiz.order.request;

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
public class CustRequestItemNoteView implements Serializable {

	public static final long serialVersionUID = 9051073560275857408L;
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

	public enum Fields {
		custRequestId, custRequestItemSeqId, noteId, noteName, noteInfo, noteDateTime, partyId, firstName, lastName
	}

	public CustRequestItemNoteView(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestItemSeqId = (String) value.get(Fields.custRequestItemSeqId
				.name());
		noteId = (String) value.get(Fields.noteId.name());
		noteName = (String) value.get(Fields.noteName.name());
		noteInfo = (String) value.get(Fields.noteInfo.name());
		noteDateTime = (Timestamp) value.get(Fields.noteDateTime.name());
		partyId = (String) value.get(Fields.partyId.name());
		firstName = (String) value.get(Fields.firstName.name());
		lastName = (String) value.get(Fields.lastName.name());
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