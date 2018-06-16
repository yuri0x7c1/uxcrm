package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Assoc Type Attr
 */
public class WorkEffortAssocTypeAttr implements Serializable {

	public static final long serialVersionUID = 464537505694922752L;
	public static final String NAME = "WorkEffortAssocTypeAttr";
	/**
	 * Work Effort Assoc Type Id
	 */
	@Getter
	@Setter
	private String workEffortAssocTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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
		workEffortAssocTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortAssocTypeAttr(GenericValue value) {
		workEffortAssocTypeId = (String) value.get(Fields.workEffortAssocTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static WorkEffortAssocTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAssocTypeAttr(value);
	}

	public static List<WorkEffortAssocTypeAttr> fromValues(
			List<GenericValue> values) {
		List<WorkEffortAssocTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAssocTypeAttr(value));
		}
		return entities;
	}
}