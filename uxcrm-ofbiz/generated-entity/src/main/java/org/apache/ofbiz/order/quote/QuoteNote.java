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
 * Quote Note
 */
@FieldNameConstants
public class QuoteNote implements Serializable {

	public static final long serialVersionUID = 6908351512249358336L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public QuoteNote(GenericValue value) {
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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