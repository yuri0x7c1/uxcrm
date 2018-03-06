package org.apache.ofbiz.order.quote.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Note
 */
public class QuoteNote implements Serializable {

	public static final long serialVersionUID = 8504926972131067904L;
	public static final String NAME = "QuoteNote";
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

	public enum Fields {
		quoteId, noteId
	}

	public QuoteNote(GenericValue value) {
		quoteId = (String) value.get(Fields.quoteId.name());
		noteId = (String) value.get(Fields.noteId.name());
	}

	public static QuoteNote fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteNote(value);
	}

	public static List<QuoteNote> fromValues(List<GenericValue> values) {
		List<QuoteNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteNote(value));
		}
		return entities;
	}
}