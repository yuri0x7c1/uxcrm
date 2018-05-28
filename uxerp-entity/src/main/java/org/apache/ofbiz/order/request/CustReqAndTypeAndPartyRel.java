package org.apache.ofbiz.order.request;

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
public class CustReqAndTypeAndPartyRel implements Serializable {

	public static final long serialVersionUID = 6337691813984651264L;
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

	public enum Fields {
		typeDescription, partyIdFrom, roleTypeIdFrom, partyIdTo, roleTypeIdTo, fromDate, thruDate, relStatusId, partyRelationshipTypeId, reason, fromPartyId, salesChannelEnumId, fulfillContactMechId, description, custRequestDate, internalComment, lastModifiedByUserLogin, custRequestId, productStoreId, createdByUserLogin, closedDateTime, custRequestName, responseRequiredDate, lastModifiedDate, priority, maximumAmountUomId, openDateTime, currencyUomId, createdDate, statusId, custRequestTypeId, custRequestCategoryId
	}

	public CustReqAndTypeAndPartyRel(GenericValue value) {
		typeDescription = (String) value.get(Fields.typeDescription.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		relStatusId = (String) value.get(Fields.relStatusId.name());
		partyRelationshipTypeId = (String) value
				.get(Fields.partyRelationshipTypeId.name());
		reason = (String) value.get(Fields.reason.name());
		fromPartyId = (String) value.get(Fields.fromPartyId.name());
		salesChannelEnumId = (String) value.get(Fields.salesChannelEnumId
				.name());
		fulfillContactMechId = (String) value.get(Fields.fulfillContactMechId
				.name());
		description = (String) value.get(Fields.description.name());
		custRequestDate = (Timestamp) value.get(Fields.custRequestDate.name());
		internalComment = (String) value.get(Fields.internalComment.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		custRequestId = (String) value.get(Fields.custRequestId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		closedDateTime = (Timestamp) value.get(Fields.closedDateTime.name());
		custRequestName = (String) value.get(Fields.custRequestName.name());
		responseRequiredDate = (Timestamp) value
				.get(Fields.responseRequiredDate.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		priority = (Long) value.get(Fields.priority.name());
		maximumAmountUomId = (String) value.get(Fields.maximumAmountUomId
				.name());
		openDateTime = (Timestamp) value.get(Fields.openDateTime.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		custRequestCategoryId = (String) value.get(Fields.custRequestCategoryId
				.name());
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