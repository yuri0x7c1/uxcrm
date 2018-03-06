package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Note
 */
public class CustRequestNote implements Serializable {

	public static final long serialVersionUID = 3448376395419181056L;
	public static final String NAME = "CustRequestNote";
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

	public enum Fields {
		custRequestId, noteId
	}

	public CustRequestNote(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		noteId = (String) value.get(Fields.noteId.name());
	}

	public static CustRequestNote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestNote(value);
	}

	public static List<CustRequestNote> fromValues(List<GenericValue> values) {
		List<CustRequestNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestNote(value));
		}
		return entities;
	}
}