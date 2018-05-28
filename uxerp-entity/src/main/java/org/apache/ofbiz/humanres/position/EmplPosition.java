package org.apache.ofbiz.humanres.position;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position
 */
public class EmplPosition implements Serializable {

	public static final long serialVersionUID = 949456352019653632L;
	public static final String NAME = "EmplPosition";
	/**
	 * Empl Position Id
	 */
	@Getter
	@Setter
	private String emplPositionId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Budget Item Seq Id
	 */
	@Getter
	@Setter
	private String budgetItemSeqId;
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Estimated From Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedFromDate;
	/**
	 * Estimated Thru Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedThruDate;
	/**
	 * Salary Flag
	 */
	@Getter
	@Setter
	private String salaryFlag;
	/**
	 * Exempt Flag
	 */
	@Getter
	@Setter
	private String exemptFlag;
	/**
	 * Fulltime Flag
	 */
	@Getter
	@Setter
	private String fulltimeFlag;
	/**
	 * Temporary Flag
	 */
	@Getter
	@Setter
	private String temporaryFlag;
	/**
	 * Actual From Date
	 */
	@Getter
	@Setter
	private Timestamp actualFromDate;
	/**
	 * Actual Thru Date
	 */
	@Getter
	@Setter
	private Timestamp actualThruDate;
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
		emplPositionId, statusId, partyId, budgetId, budgetItemSeqId, emplPositionTypeId, estimatedFromDate, estimatedThruDate, salaryFlag, exemptFlag, fulltimeFlag, temporaryFlag, actualFromDate, actualThruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EmplPosition(GenericValue value) {
		emplPositionId = (String) value.get(Fields.emplPositionId.name());
		statusId = (String) value.get(Fields.statusId.name());
		partyId = (String) value.get(Fields.partyId.name());
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		estimatedFromDate = (Timestamp) value.get(Fields.estimatedFromDate
				.name());
		estimatedThruDate = (Timestamp) value.get(Fields.estimatedThruDate
				.name());
		salaryFlag = (String) value.get(Fields.salaryFlag.name());
		exemptFlag = (String) value.get(Fields.exemptFlag.name());
		fulltimeFlag = (String) value.get(Fields.fulltimeFlag.name());
		temporaryFlag = (String) value.get(Fields.temporaryFlag.name());
		actualFromDate = (Timestamp) value.get(Fields.actualFromDate.name());
		actualThruDate = (Timestamp) value.get(Fields.actualThruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static EmplPosition fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPosition(value);
	}

	public static List<EmplPosition> fromValues(List<GenericValue> values) {
		List<EmplPosition> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPosition(value));
		}
		return entities;
	}
}