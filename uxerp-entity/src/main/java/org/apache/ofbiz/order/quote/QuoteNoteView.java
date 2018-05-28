package org.apache.ofbiz.order.quote;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Note View
 */
public class QuoteNoteView implements Serializable {

	public static final long serialVersionUID = 563687081428344832L;
	public static final String NAME = "QuoteNoteView";
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
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

	public enum Fields {
		quoteId, noteId, noteName, noteInfo, noteDateTime, noteParty
	}

	public QuoteNoteView(GenericValue value) {
		quoteId = (String) value.get(Fields.quoteId.name());
		noteId = (String) value.get(Fields.noteId.name());
		noteName = (String) value.get(Fields.noteName.name());
		noteInfo = (String) value.get(Fields.noteInfo.name());
		noteDateTime = (Timestamp) value.get(Fields.noteDateTime.name());
		noteParty = (String) value.get(Fields.noteParty.name());
	}

	public static QuoteNoteView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteNoteView(value);
	}

	public static List<QuoteNoteView> fromValues(List<GenericValue> values) {
		List<QuoteNoteView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteNoteView(value));
		}
		return entities;
	}
}