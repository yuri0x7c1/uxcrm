package org.apache.ofbiz.product.price;

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
public class QuantityBreak implements Serializable {

	public static final long serialVersionUID = 2812788775859743744L;
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

	public enum Fields {
		quantityBreakId, quantityBreakTypeId, fromQuantity, thruQuantity, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public QuantityBreak(GenericValue value) {
		quantityBreakId = (String) value.get(Fields.quantityBreakId.name());
		quantityBreakTypeId = (String) value.get(Fields.quantityBreakTypeId
				.name());
		fromQuantity = (BigDecimal) value.get(Fields.fromQuantity.name());
		thruQuantity = (BigDecimal) value.get(Fields.thruQuantity.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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