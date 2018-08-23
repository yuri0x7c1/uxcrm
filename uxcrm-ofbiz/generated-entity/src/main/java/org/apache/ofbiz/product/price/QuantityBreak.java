package org.apache.ofbiz.product.price;

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
 * Quantity Break
 */
@FieldNameConstants
public class QuantityBreak implements Serializable {

	public static final long serialVersionUID = 8715354424456027136L;
	public static final String NAME = "QuantityBreak";
	/**
	 * Quantity Break Id
	 */
	@Getter
	@Setter
	private String quantityBreakId;
	/**
	 * Quantity Break Type Id
	 */
	@Getter
	@Setter
	private String quantityBreakTypeId;
	/**
	 * From Quantity
	 */
	@Getter
	@Setter
	private BigDecimal fromQuantity;
	/**
	 * Thru Quantity
	 */
	@Getter
	@Setter
	private BigDecimal thruQuantity;
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

	public QuantityBreak(GenericValue value) {
		quantityBreakId = (String) value.get(FIELD_QUANTITY_BREAK_ID);
		quantityBreakTypeId = (String) value.get(FIELD_QUANTITY_BREAK_TYPE_ID);
		fromQuantity = (BigDecimal) value.get(FIELD_FROM_QUANTITY);
		thruQuantity = (BigDecimal) value.get(FIELD_THRU_QUANTITY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static QuantityBreak fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuantityBreak(value);
	}

	public static List<QuantityBreak> fromValues(List<GenericValue> values) {
		List<QuantityBreak> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuantityBreak(value));
		}
		return entities;
	}
}