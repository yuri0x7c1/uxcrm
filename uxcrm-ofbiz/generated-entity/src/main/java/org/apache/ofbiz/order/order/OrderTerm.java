package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class OrderTerm implements Serializable {

	public static final long serialVersionUID = 5756346255484309504L;
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

	public OrderTerm(GenericValue value) {
		termTypeId = (String) value.get(FIELD_TERM_TYPE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		termValue = (BigDecimal) value.get(FIELD_TERM_VALUE);
		termDays = (Long) value.get(FIELD_TERM_DAYS);
		textValue = (String) value.get(FIELD_TEXT_VALUE);
		description = (String) value.get(FIELD_DESCRIPTION);
		uomId = (String) value.get(FIELD_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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