package org.apache.ofbiz.product.inventory.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Lot
 */
public class Lot implements Serializable {

	public static final long serialVersionUID = 5497896386881792000L;
	public static final String NAME = "Lot";
	/**
	 * Lot Id
	 */
	@Getter
	@Setter
	private String lotId;
	/**
	 * Creation Date
	 */
	@Getter
	@Setter
	private Timestamp creationDate;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Expiration Date
	 */
	@Getter
	@Setter
	private Timestamp expirationDate;

	public enum Fields {
		lotId, creationDate, quantity, expirationDate
	}

	public Lot(GenericValue value) {
		lotId = (String) value.get(Fields.lotId.name());
		creationDate = (Timestamp) value.get(Fields.creationDate.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		expirationDate = (Timestamp) value.get(Fields.expirationDate.name());
	}

	public static Lot fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Lot(value);
	}

	public static List<Lot> fromValues(List<GenericValue> values) {
		List<Lot> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Lot(value));
		}
		return entities;
	}
}