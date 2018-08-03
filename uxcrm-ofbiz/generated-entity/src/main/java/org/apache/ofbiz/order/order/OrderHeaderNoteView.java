package org.apache.ofbiz.order.order;

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
public class OrderHeaderNoteView implements Serializable {

	public static final long serialVersionUID = 7767165150771889152L;
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

	public enum Fields {
		orderId, internalNote, noteId, noteName, noteInfo, noteDateTime, noteParty
	}

	public OrderHeaderNoteView(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		internalNote = (String) value.get(Fields.internalNote.name());
		noteId = (String) value.get(Fields.noteId.name());
		noteName = (String) value.get(Fields.noteName.name());
		noteInfo = (String) value.get(Fields.noteInfo.name());
		noteDateTime = (Timestamp) value.get(Fields.noteDateTime.name());
		noteParty = (String) value.get(Fields.noteParty.name());
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