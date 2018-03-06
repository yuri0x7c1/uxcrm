package org.apache.ofbiz.product.price.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quantity Break
 */
public class QuantityBreak implements Serializable {

	public static final long serialVersionUID = 5060139688362248192L;
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

	public enum Fields {
		quantityBreakId, quantityBreakTypeId, fromQuantity, thruQuantity
	}

	public QuantityBreak(GenericValue value) {
		quantityBreakId = (String) value.get(Fields.quantityBreakId.name());
		quantityBreakTypeId = (String) value.get(Fields.quantityBreakTypeId
				.name());
		fromQuantity = (BigDecimal) value.get(Fields.fromQuantity.name());
		thruQuantity = (BigDecimal) value.get(Fields.thruQuantity.name());
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