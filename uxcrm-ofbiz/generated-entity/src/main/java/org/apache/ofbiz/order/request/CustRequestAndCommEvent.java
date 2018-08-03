package org.apache.ofbiz.order.request;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request And Comm Event
 */
public class CustRequestAndCommEvent implements Serializable {

	public static final long serialVersionUID = 6676137903334201344L;
	public static final String NAME = "CustRequestAndCommEvent";
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
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
		communicationEventId, reason, fromPartyId, salesChannelEnumId, fulfillContactMechId, description, custRequestDate, internalComment, lastModifiedByUserLogin, custRequestId, productStoreId, createdByUserLogin, closedDateTime, custRequestName, responseRequiredDate, lastModifiedDate, priority, maximumAmountUomId, openDateTime, currencyUomId, createdDate, statusId, custRequestTypeId, custRequestCategoryId
	}

	public CustRequestAndCommEvent(GenericValue value) {
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
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

	public static CustRequestAndCommEvent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestAndCommEvent(value);
	}

	public static List<CustRequestAndCommEvent> fromValues(
			List<GenericValue> values) {
		List<CustRequestAndCommEvent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestAndCommEvent(value));
		}
		return entities;
	}
}