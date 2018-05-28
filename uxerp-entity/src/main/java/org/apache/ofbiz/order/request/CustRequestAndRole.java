package org.apache.ofbiz.order.request;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request And Role
 */
public class CustRequestAndRole implements Serializable {

	public static final long serialVersionUID = 1034924915975982080L;
	public static final String NAME = "CustRequestAndRole";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Cust Request Type Id
	 */
	@Getter
	@Setter
	private String custRequestTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * From Party Id
	 */
	@Getter
	@Setter
	private String fromPartyId;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;
	/**
	 * Cust Request Date
	 */
	@Getter
	@Setter
	private Timestamp custRequestDate;
	/**
	 * Response Required Date
	 */
	@Getter
	@Setter
	private Timestamp responseRequiredDate;
	/**
	 * Cust Request Name
	 */
	@Getter
	@Setter
	private String custRequestName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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

	public enum Fields {
		custRequestId, custRequestTypeId, statusId, fromPartyId, priority, custRequestDate, responseRequiredDate, custRequestName, description, createdDate, lastModifiedDate, lastModifiedByUserLogin, partyId, roleTypeId, fromDate, thruDate
	}

	public CustRequestAndRole(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		fromPartyId = (String) value.get(Fields.fromPartyId.name());
		priority = (Long) value.get(Fields.priority.name());
		custRequestDate = (Timestamp) value.get(Fields.custRequestDate.name());
		responseRequiredDate = (Timestamp) value
				.get(Fields.responseRequiredDate.name());
		custRequestName = (String) value.get(Fields.custRequestName.name());
		description = (String) value.get(Fields.description.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static CustRequestAndRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestAndRole(value);
	}

	public static List<CustRequestAndRole> fromValues(List<GenericValue> values) {
		List<CustRequestAndRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestAndRole(value));
		}
		return entities;
	}
}