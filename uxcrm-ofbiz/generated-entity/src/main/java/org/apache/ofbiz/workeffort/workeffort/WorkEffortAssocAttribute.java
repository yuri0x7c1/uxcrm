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
 * Work Effort Assoc Attribute
 */
@FieldNameConstants
public class WorkEffortAssocAttribute implements Serializable {

	public static final long serialVersionUID = 68635032771309568L;
	public static final String NAME = "WorkEffortAssocAttribute";
	/**
	 * Work Effort Id From
	 */
	@Getter
	@Setter
	private String workEffortIdFrom;
	/**
	 * Work Effort Id To
	 */
	@Getter
	@Setter
	private String workEffortIdTo;
	/**
	 * Work Effort Assoc Type Id
	 */
	@Getter
	@Setter
	private String workEffortAssocTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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

	public WorkEffortAssocAttribute(GenericValue value) {
		workEffortIdFrom = (String) value.get(FIELD_WORK_EFFORT_ID_FROM);
		workEffortIdTo = (String) value.get(FIELD_WORK_EFFORT_ID_TO);
		workEffortAssocTypeId = (String) value
				.get(FIELD_WORK_EFFORT_ASSOC_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		attrValue = (String) value.get(FIELD_ATTR_VALUE);
		attrDescription = (String) value.get(FIELD_ATTR_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortAssocAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAssocAttribute(value);
	}

	public static List<WorkEffortAssocAttribute> fromValues(
			List<GenericValue> values) {
		List<WorkEffortAssocAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAssocAttribute(value));
		}
		return entities;
	}
}