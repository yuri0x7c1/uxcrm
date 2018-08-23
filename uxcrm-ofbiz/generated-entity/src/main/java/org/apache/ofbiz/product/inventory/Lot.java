package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class Lot implements Serializable {

	public static final long serialVersionUID = 4070389163531731968L;
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

	public Lot(GenericValue value) {
		lotId = (String) value.get(FIELD_LOT_ID);
		creationDate = (Timestamp) value.get(FIELD_CREATION_DATE);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		expirationDate = (Timestamp) value.get(FIELD_EXPIRATION_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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