package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Term
 */
public class OrderTerm implements Serializable {

	public static final long serialVersionUID = 5576949659524528128L;
	public static final String NAME = "OrderTerm";
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Term Value
	 */
	@Getter
	@Setter
	private BigDecimal termValue;
	/**
	 * Term Days
	 */
	@Getter
	@Setter
	private Long termDays;
	/**
	 * Text Value
	 */
	@Getter
	@Setter
	private String textValue;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
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
		termTypeId, orderId, orderItemSeqId, termValue, termDays, textValue, description, uomId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderTerm(GenericValue value) {
		termTypeId = (String) value.get(Fields.termTypeId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		termValue = (BigDecimal) value.get(Fields.termValue.name());
		termDays = (Long) value.get(Fields.termDays.name());
		textValue = (String) value.get(Fields.textValue.name());
		description = (String) value.get(Fields.description.name());
		uomId = (String) value.get(Fields.uomId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OrderTerm fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new OrderTerm(value);
	}

	public static List<OrderTerm> fromValues(List<GenericValue> values) {
		List<OrderTerm> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderTerm(value));
		}
		return entities;
	}
}