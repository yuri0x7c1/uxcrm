package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header Note View
 */
@FieldNameConstants
public class OrderHeaderNoteView implements Serializable {

	public static final long serialVersionUID = 3933694928665364480L;
	public static final String NAME = "OrderHeaderNoteView";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Internal Note
	 */
	@Getter
	@Setter
	private String internalNote;
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

	public OrderHeaderNoteView(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		internalNote = (String) value.get(FIELD_INTERNAL_NOTE);
		noteId = (String) value.get(FIELD_NOTE_ID);
		noteName = (String) value.get(FIELD_NOTE_NAME);
		noteInfo = (String) value.get(FIELD_NOTE_INFO);
		noteDateTime = (Timestamp) value.get(FIELD_NOTE_DATE_TIME);
		noteParty = (String) value.get(FIELD_NOTE_PARTY);
	}

	public static OrderHeaderNoteView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderNoteView(value);
	}

	public static List<OrderHeaderNoteView> fromValues(List<GenericValue> values) {
		List<OrderHeaderNoteView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderNoteView(value));
		}
		return entities;
	}
}