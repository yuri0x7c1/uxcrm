package org.apache.ofbiz.order.requirement;

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
public class WorkReqFulfType implements Serializable {

	public static final long serialVersionUID = 4738280857586816000L;
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

	public enum Fields {
		workReqFulfTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkReqFulfType(GenericValue value) {
		workReqFulfTypeId = (String) value.get(Fields.workReqFulfTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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