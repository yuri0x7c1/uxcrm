package org.apache.ofbiz.product.price;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quantity Break Type
 */
@FieldNameConstants
public class QuantityBreakType implements Serializable {

	public static final long serialVersionUID = 6980478706438721536L;
	public static final String NAME = "QuantityBreakType";
	/**
	 * Quantity Break Type Id
	 */
	@Getter
	@Setter
	private String quantityBreakTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public QuantityBreakType(GenericValue value) {
		quantityBreakTypeId = (String) value.get(FIELD_QUANTITY_BREAK_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static QuantityBreakType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuantityBreakType(value);
	}

	public static List<QuantityBreakType> fromValues(List<GenericValue> values) {
		List<QuantityBreakType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuantityBreakType(value));
		}
		return entities;
	}
}