package org.apache.ofbiz.product.price;

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
public class QuantityBreakType implements Serializable {

	public static final long serialVersionUID = 5508498178767050752L;
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

	public enum Fields {
		quantityBreakTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public QuantityBreakType(GenericValue value) {
		quantityBreakTypeId = (String) value.get(Fields.quantityBreakTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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