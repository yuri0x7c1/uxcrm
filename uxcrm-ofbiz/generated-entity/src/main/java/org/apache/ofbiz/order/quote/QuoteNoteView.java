package org.apache.ofbiz.order.quote;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class QuoteNoteView implements Serializable {

	public static final long serialVersionUID = 1785129554070132736L;
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

	public QuoteNoteView(GenericValue value) {
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		noteName = (String) value.get(FIELD_NOTE_NAME);
		noteInfo = (String) value.get(FIELD_NOTE_INFO);
		noteDateTime = (Timestamp) value.get(FIELD_NOTE_DATE_TIME);
		noteParty = (String) value.get(FIELD_NOTE_PARTY);
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