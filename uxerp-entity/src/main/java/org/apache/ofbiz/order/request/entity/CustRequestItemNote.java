package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Item Note
 */
public class CustRequestItemNote implements Serializable {

	public static final long serialVersionUID = 8274703089122093056L;
	public static final String NAME = "CustRequestItemNote";
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

	public enum Fields {
		custRequestId, custRequestItemSeqId, noteId
	}

	public CustRequestItemNote(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestItemSeqId = (String) value.get(Fields.custRequestItemSeqId
				.name());
		noteId = (String) value.get(Fields.noteId.name());
	}

	public static CustRequestItemNote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestItemNote(value);
	}

	public static List<CustRequestItemNote> fromValues(List<GenericValue> values) {
		List<CustRequestItemNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestItemNote(value));
		}
		return entities;
	}
}