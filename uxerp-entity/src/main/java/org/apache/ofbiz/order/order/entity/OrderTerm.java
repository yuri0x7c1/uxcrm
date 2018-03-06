package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Term
 */
public class OrderTerm implements Serializable {

	public static final long serialVersionUID = 394677705485070336L;
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

	public enum Fields {
		termTypeId, orderId, orderItemSeqId, termValue, termDays, textValue, description, uomId
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