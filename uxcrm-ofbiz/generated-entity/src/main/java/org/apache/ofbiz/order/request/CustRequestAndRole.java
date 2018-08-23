package org.apache.ofbiz.order.request;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class CustRequestAndRole implements Serializable {

	public static final long serialVersionUID = 1789410713857165312L;
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

	public CustRequestAndRole(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		custRequestTypeId = (String) value.get(FIELD_CUST_REQUEST_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		fromPartyId = (String) value.get(FIELD_FROM_PARTY_ID);
		priority = (Long) value.get(FIELD_PRIORITY);
		custRequestDate = (Timestamp) value.get(FIELD_CUST_REQUEST_DATE);
		responseRequiredDate = (Timestamp) value
				.get(FIELD_RESPONSE_REQUIRED_DATE);
		custRequestName = (String) value.get(FIELD_CUST_REQUEST_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
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