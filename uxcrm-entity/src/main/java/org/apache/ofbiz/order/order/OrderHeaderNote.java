package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header Note
 */
public class OrderHeaderNote implements Serializable {

	public static final long serialVersionUID = 7418983940120029184L;
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

	public enum Fields {
		orderId, noteId, internalNote, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderHeaderNote(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		noteId = (String) value.get(Fields.noteId.name());
		internalNote = (String) value.get(Fields.internalNote.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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