package org.apache.ofbiz.order._return;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Adjustment Type
 */
public class ReturnAdjustmentType implements Serializable {

	public static final long serialVersionUID = 7039833516087417856L;
	public static final String NAME = "ReturnAdjustmentType";
	/**
	 * Return Adjustment Type Id
	 */
	@Getter
	@Setter
	private String returnAdjustmentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
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
		returnAdjustmentTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ReturnAdjustmentType(GenericValue value) {
		returnAdjustmentTypeId = (String) value
				.get(Fields.returnAdjustmentTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ReturnAdjustmentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnAdjustmentType(value);
	}

	public static List<ReturnAdjustmentType> fromValues(
			List<GenericValue> values) {
		List<ReturnAdjustmentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnAdjustmentType(value));
		}
		return entities;
	}
}