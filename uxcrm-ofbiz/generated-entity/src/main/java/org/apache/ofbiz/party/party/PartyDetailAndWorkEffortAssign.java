package org.apache.ofbiz.party.party;

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
public class PartyDetailAndWorkEffortAssign implements Serializable {

	public static final long serialVersionUID = 5521764023622141952L;
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

	public enum Fields {
		partyId, partyTypeId, partyStatusId, workEffortTypeId, workEffortId, fromDate, thruDate, roleTypeId, statusId, firstName, middleName, lastName, groupName
	}

	public PartyDetailAndWorkEffortAssign(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		partyStatusId = (String) value.get(Fields.partyStatusId.name());
		workEffortTypeId = (String) value.get(Fields.workEffortTypeId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		firstName = (String) value.get(Fields.firstName.name());
		middleName = (String) value.get(Fields.middleName.name());
		lastName = (String) value.get(Fields.lastName.name());
		groupName = (String) value.get(Fields.groupName.name());
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