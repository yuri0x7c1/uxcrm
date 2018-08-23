package org.apache.ofbiz.order._return;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ReturnAdjustmentType implements Serializable {

	public static final long serialVersionUID = 3706825214167245824L;
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

	public ReturnAdjustmentType(GenericValue value) {
		returnAdjustmentTypeId = (String) value
				.get(FIELD_RETURN_ADJUSTMENT_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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