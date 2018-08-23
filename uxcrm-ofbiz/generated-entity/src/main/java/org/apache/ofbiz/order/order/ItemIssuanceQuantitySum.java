package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Item Issuance Quantity Sum
 */
@FieldNameConstants
public class ItemIssuanceQuantitySum implements Serializable {

	public static final long serialVersionUID = 3342036606461381632L;
	public static final String NAME = "ItemIssuanceQuantitySum";
	/**
	 * Issued Quantity Sum
	 */
	@Getter
	@Setter
	private BigDecimal issuedQuantitySum;
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

	public ItemIssuanceQuantitySum(GenericValue value) {
		issuedQuantitySum = (BigDecimal) value.get(FIELD_ISSUED_QUANTITY_SUM);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
	}

	public static ItemIssuanceQuantitySum fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ItemIssuanceQuantitySum(value);
	}

	public static List<ItemIssuanceQuantitySum> fromValues(
			List<GenericValue> values) {
		List<ItemIssuanceQuantitySum> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ItemIssuanceQuantitySum(value));
		}
		return entities;
	}
}