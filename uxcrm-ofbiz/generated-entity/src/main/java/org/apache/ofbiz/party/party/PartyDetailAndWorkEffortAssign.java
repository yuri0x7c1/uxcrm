package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Detail And Work Effort Assign
 */
@FieldNameConstants
public class PartyDetailAndWorkEffortAssign implements Serializable {

	public static final long serialVersionUID = 5758576093640517632L;
	public static final String NAME = "PartyDetailAndWorkEffortAssign";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * Party Status Id
	 */
	@Getter
	@Setter
	private String partyStatusId;
	/**
	 * Work Effort Type Id
	 */
	@Getter
	@Setter
	private String workEffortTypeId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
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
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Middle Name
	 */
	@Getter
	@Setter
	private String middleName;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;

	public PartyDetailAndWorkEffortAssign(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		partyStatusId = (String) value.get(FIELD_PARTY_STATUS_ID);
		workEffortTypeId = (String) value.get(FIELD_WORK_EFFORT_TYPE_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		firstName = (String) value.get(FIELD_FIRST_NAME);
		middleName = (String) value.get(FIELD_MIDDLE_NAME);
		lastName = (String) value.get(FIELD_LAST_NAME);
		groupName = (String) value.get(FIELD_GROUP_NAME);
	}

	public static PartyDetailAndWorkEffortAssign fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyDetailAndWorkEffortAssign(value);
	}

	public static List<PartyDetailAndWorkEffortAssign> fromValues(
			List<GenericValue> values) {
		List<PartyDetailAndWorkEffortAssign> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyDetailAndWorkEffortAssign(value));
		}
		return entities;
	}
}