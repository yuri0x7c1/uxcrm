package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Content Type
 */
@FieldNameConstants
public class WorkEffortContentType implements Serializable {

	public static final long serialVersionUID = 3923666146591621120L;
	public static final String NAME = "WorkEffortContentType";
	/**
	 * Work Effort Content Type Id
	 */
	@Getter
	@Setter
	private String workEffortContentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
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

	public WorkEffortContentType(GenericValue value) {
		workEffortContentTypeId = (String) value
				.get(FIELD_WORK_EFFORT_CONTENT_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortContentType(value);
	}

	public static List<WorkEffortContentType> fromValues(
			List<GenericValue> values) {
		List<WorkEffortContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortContentType(value));
		}
		return entities;
	}
}