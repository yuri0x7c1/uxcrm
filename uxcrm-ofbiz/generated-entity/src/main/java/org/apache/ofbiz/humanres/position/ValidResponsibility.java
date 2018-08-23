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
 * Valid Responsibility
 */
@FieldNameConstants
public class ValidResponsibility implements Serializable {

	public static final long serialVersionUID = 3434362691565696000L;
	public static final String NAME = "ValidResponsibility";
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Responsibility Type Id
	 */
	@Getter
	@Setter
	private String responsibilityTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public ValidResponsibility(GenericValue value) {
		emplPositionTypeId = (String) value.get(FIELD_EMPL_POSITION_TYPE_ID);
		responsibilityTypeId = (String) value.get(FIELD_RESPONSIBILITY_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ValidResponsibility fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ValidResponsibility(value);
	}

	public static List<ValidResponsibility> fromValues(List<GenericValue> values) {
		List<ValidResponsibility> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ValidResponsibility(value));
		}
		return entities;
	}
}