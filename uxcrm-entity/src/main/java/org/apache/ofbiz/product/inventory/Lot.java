package org.apache.ofbiz.product.inventory;

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

	public static final long serialVersionUID = 4875445162979859456L;
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
		lotId, creationDate, quantity, expirationDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Lot(GenericValue value) {
		lotId = (String) value.get(Fields.lotId.name());
		creationDate = (Timestamp) value.get(Fields.creationDate.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		expirationDate = (Timestamp) value.get(Fields.expirationDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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