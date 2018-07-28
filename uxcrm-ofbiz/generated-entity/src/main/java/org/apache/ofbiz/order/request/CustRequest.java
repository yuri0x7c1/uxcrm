package org.apache.ofbiz.order.request;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request
 */
public class CustRequest implements Serializable {

	public static final long serialVersionUID = 3107244351510526976L;
	public static final String NAME = "CustRequest";
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
	 * Cust Request Category Id
	 */
	@Getter
	@Setter
	private String custRequestCategoryId;
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
	 * Maximum Amount Uom Id
	 */
	@Getter
	@Setter
	private String maximumAmountUomId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
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
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Open Date Time
	 */
	@Getter
	@Setter
	private Timestamp openDateTime;
	/**
	 * Closed Date Time
	 */
	@Getter
	@Setter
	private Timestamp closedDateTime;
	/**
	 * Internal Comment
	 */
	@Getter
	@Setter
	private String internalComment;
	/**
	 * Reason
	 */
	@Getter
	@Setter
	private String reason;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
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
		custRequestId, custRequestTypeId, custRequestCategoryId, statusId, fromPartyId, priority, custRequestDate, responseRequiredDate, custRequestName, description, maximumAmountUomId, productStoreId, salesChannelEnumId, fulfillContactMechId, currencyUomId, openDateTime, closedDateTime, internalComment, reason, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustRequest(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		custRequestCategoryId = (String) value.get(Fields.custRequestCategoryId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		fromPartyId = (String) value.get(Fields.fromPartyId.name());
		priority = (Long) value.get(Fields.priority.name());
		custRequestDate = (Timestamp) value.get(Fields.custRequestDate.name());
		responseRequiredDate = (Timestamp) value
				.get(Fields.responseRequiredDate.name());
		custRequestName = (String) value.get(Fields.custRequestName.name());
		description = (String) value.get(Fields.description.name());
		maximumAmountUomId = (String) value.get(Fields.maximumAmountUomId
				.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		salesChannelEnumId = (String) value.get(Fields.salesChannelEnumId
				.name());
		fulfillContactMechId = (String) value.get(Fields.fulfillContactMechId
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		openDateTime = (Timestamp) value.get(Fields.openDateTime.name());
		closedDateTime = (Timestamp) value.get(Fields.closedDateTime.name());
		internalComment = (String) value.get(Fields.internalComment.name());
		reason = (String) value.get(Fields.reason.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CustRequest fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequest(value);
	}

	public static List<CustRequest> fromValues(List<GenericValue> values) {
		List<CustRequest> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequest(value));
		}
		return entities;
	}
}