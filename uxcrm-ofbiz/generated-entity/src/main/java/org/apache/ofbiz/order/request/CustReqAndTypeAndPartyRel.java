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
 * Cust Req And Type And Party Rel
 */
@FieldNameConstants
public class CustReqAndTypeAndPartyRel implements Serializable {

	public static final long serialVersionUID = 9174898693960742912L;
	public static final String NAME = "CustReqAndTypeAndPartyRel";
	/**
	 * Type Description
	 */
	@Getter
	@Setter
	private String typeDescription;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
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
	 * Rel Status Id
	 */
	@Getter
	@Setter
	private String relStatusId;
	/**
	 * Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String partyRelationshipTypeId;
	/**
	 * Reason
	 */
	@Getter
	@Setter
	private String reason;
	/**
	 * From Party Id
	 */
	@Getter
	@Setter
	private String fromPartyId;
	/**
	 * Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String salesChannelEnumId;
	/**
	 * Fulfill Contact Mech Id
	 */
	@Getter
	@Setter
	private String fulfillContactMechId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Cust Request Date
	 */
	@Getter
	@Setter
	private Timestamp custRequestDate;
	/**
	 * Internal Comment
	 */
	@Getter
	@Setter
	private String internalComment;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Closed Date Time
	 */
	@Getter
	@Setter
	private Timestamp closedDateTime;
	/**
	 * Cust Request Name
	 */
	@Getter
	@Setter
	private String custRequestName;
	/**
	 * Response Required Date
	 */
	@Getter
	@Setter
	private Timestamp responseRequiredDate;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;
	/**
	 * Maximum Amount Uom Id
	 */
	@Getter
	@Setter
	private String maximumAmountUomId;
	/**
	 * Open Date Time
	 */
	@Getter
	@Setter
	private Timestamp openDateTime;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Cust Request Type Id
	 */
	@Getter
	@Setter
	private String custRequestTypeId;
	/**
	 * Cust Request Category Id
	 */
	@Getter
	@Setter
	private String custRequestCategoryId;

	public CustReqAndTypeAndPartyRel(GenericValue value) {
		typeDescription = (String) value.get(FIELD_TYPE_DESCRIPTION);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		relStatusId = (String) value.get(FIELD_REL_STATUS_ID);
		partyRelationshipTypeId = (String) value
				.get(FIELD_PARTY_RELATIONSHIP_TYPE_ID);
		reason = (String) value.get(FIELD_REASON);
		fromPartyId = (String) value.get(FIELD_FROM_PARTY_ID);
		salesChannelEnumId = (String) value.get(FIELD_SALES_CHANNEL_ENUM_ID);
		fulfillContactMechId = (String) value
				.get(FIELD_FULFILL_CONTACT_MECH_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		custRequestDate = (Timestamp) value.get(FIELD_CUST_REQUEST_DATE);
		internalComment = (String) value.get(FIELD_INTERNAL_COMMENT);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		closedDateTime = (Timestamp) value.get(FIELD_CLOSED_DATE_TIME);
		custRequestName = (String) value.get(FIELD_CUST_REQUEST_NAME);
		responseRequiredDate = (Timestamp) value
				.get(FIELD_RESPONSE_REQUIRED_DATE);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		priority = (Long) value.get(FIELD_PRIORITY);
		maximumAmountUomId = (String) value.get(FIELD_MAXIMUM_AMOUNT_UOM_ID);
		openDateTime = (Timestamp) value.get(FIELD_OPEN_DATE_TIME);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		custRequestTypeId = (String) value.get(FIELD_CUST_REQUEST_TYPE_ID);
		custRequestCategoryId = (String) value
				.get(FIELD_CUST_REQUEST_CATEGORY_ID);
	}

	public static CustReqAndTypeAndPartyRel fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustReqAndTypeAndPartyRel(value);
	}

	public static List<CustReqAndTypeAndPartyRel> fromValues(
			List<GenericValue> values) {
		List<CustReqAndTypeAndPartyRel> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustReqAndTypeAndPartyRel(value));
		}
		return entities;
	}
}