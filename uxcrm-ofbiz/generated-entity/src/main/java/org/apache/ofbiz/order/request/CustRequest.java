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
 * Cust Request
 */
@FieldNameConstants
public class CustRequest implements Serializable {

	public static final long serialVersionUID = 5164556249856316416L;
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

	public CustRequest(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		custRequestTypeId = (String) value.get(FIELD_CUST_REQUEST_TYPE_ID);
		custRequestCategoryId = (String) value
				.get(FIELD_CUST_REQUEST_CATEGORY_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		fromPartyId = (String) value.get(FIELD_FROM_PARTY_ID);
		priority = (Long) value.get(FIELD_PRIORITY);
		custRequestDate = (Timestamp) value.get(FIELD_CUST_REQUEST_DATE);
		responseRequiredDate = (Timestamp) value
				.get(FIELD_RESPONSE_REQUIRED_DATE);
		custRequestName = (String) value.get(FIELD_CUST_REQUEST_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		maximumAmountUomId = (String) value.get(FIELD_MAXIMUM_AMOUNT_UOM_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		salesChannelEnumId = (String) value.get(FIELD_SALES_CHANNEL_ENUM_ID);
		fulfillContactMechId = (String) value
				.get(FIELD_FULFILL_CONTACT_MECH_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		openDateTime = (Timestamp) value.get(FIELD_OPEN_DATE_TIME);
		closedDateTime = (Timestamp) value.get(FIELD_CLOSED_DATE_TIME);
		internalComment = (String) value.get(FIELD_INTERNAL_COMMENT);
		reason = (String) value.get(FIELD_REASON);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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