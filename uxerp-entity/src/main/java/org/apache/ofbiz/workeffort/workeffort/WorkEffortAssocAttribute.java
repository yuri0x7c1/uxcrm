package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortAssocAttribute implements Serializable {

	public static final long serialVersionUID = 1048764927200553984L;
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

	public enum Fields {
		workEffortIdFrom, workEffortIdTo, workEffortAssocTypeId, fromDate, attrName, attrValue, attrDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortAssocAttribute(GenericValue value) {
		workEffortIdFrom = (String) value.get(Fields.workEffortIdFrom.name());
		workEffortIdTo = (String) value.get(Fields.workEffortIdTo.name());
		workEffortAssocTypeId = (String) value.get(Fields.workEffortAssocTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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