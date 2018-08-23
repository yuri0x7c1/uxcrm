package org.apache.ofbiz.humanres.position;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class EmplPosition implements Serializable {

	public static final long serialVersionUID = 2964832998624530432L;
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

	public EmplPosition(GenericValue value) {
		emplPositionId = (String) value.get(FIELD_EMPL_POSITION_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		budgetItemSeqId = (String) value.get(FIELD_BUDGET_ITEM_SEQ_ID);
		emplPositionTypeId = (String) value.get(FIELD_EMPL_POSITION_TYPE_ID);
		estimatedFromDate = (Timestamp) value.get(FIELD_ESTIMATED_FROM_DATE);
		estimatedThruDate = (Timestamp) value.get(FIELD_ESTIMATED_THRU_DATE);
		salaryFlag = (String) value.get(FIELD_SALARY_FLAG);
		exemptFlag = (String) value.get(FIELD_EXEMPT_FLAG);
		fulltimeFlag = (String) value.get(FIELD_FULLTIME_FLAG);
		temporaryFlag = (String) value.get(FIELD_TEMPORARY_FLAG);
		actualFromDate = (Timestamp) value.get(FIELD_ACTUAL_FROM_DATE);
		actualThruDate = (Timestamp) value.get(FIELD_ACTUAL_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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