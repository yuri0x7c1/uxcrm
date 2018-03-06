package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header Note
 */
public class OrderHeaderNote implements Serializable {

	public static final long serialVersionUID = 8175574600631885824L;
	public static final String NAME = "OrderHeaderNote";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;
	/**
	 * Internal Note
	 */
	@Getter
	@Setter
	private String internalNote;

	public enum Fields {
		orderId, noteId, internalNote
	}

	public OrderHeaderNote(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		noteId = (String) value.get(Fields.noteId.name());
		internalNote = (String) value.get(Fields.internalNote.name());
	}

	public static OrderHeaderNote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderNote(value);
	}

	public static List<OrderHeaderNote> fromValues(List<GenericValue> values) {
		List<OrderHeaderNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderNote(value));
		}
		return entities;
	}
}