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
 * Order Header Note
 */
@FieldNameConstants
public class OrderHeaderNote implements Serializable {

	public static final long serialVersionUID = 6598206342103218176L;
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

	public OrderHeaderNote(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		internalNote = (String) value.get(FIELD_INTERNAL_NOTE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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