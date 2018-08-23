package org.apache.ofbiz.order.requirement;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Req Fulf Type
 */
@FieldNameConstants
public class WorkReqFulfType implements Serializable {

	public static final long serialVersionUID = 1879183222819713024L;
	public static final String NAME = "WorkReqFulfType";
	/**
	 * Work Req Fulf Type Id
	 */
	@Getter
	@Setter
	private String workReqFulfTypeId;
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

	public WorkReqFulfType(GenericValue value) {
		workReqFulfTypeId = (String) value.get(FIELD_WORK_REQ_FULF_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkReqFulfType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkReqFulfType(value);
	}

	public static List<WorkReqFulfType> fromValues(List<GenericValue> values) {
		List<WorkReqFulfType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkReqFulfType(value));
		}
		return entities;
	}
}