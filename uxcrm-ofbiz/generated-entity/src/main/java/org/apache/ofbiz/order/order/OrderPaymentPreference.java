package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Payment Preference
 */
@FieldNameConstants
public class OrderPaymentPreference implements Serializable {

	public static final long serialVersionUID = 187647480788398080L;
	public static final String NAME = "OrderPaymentPreference";
	/**
	 * Order Payment Preference Id
	 */
	@Getter
	@Setter
	private String orderPaymentPreferenceId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Product Price Purpose Id
	 */
	@Getter
	@Setter
	private String productPricePurposeId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Security Code
	 */
	@Getter
	@Setter
	private String securityCode;
	/**
	 * Track 2
	 */
	@Getter
	@Setter
	private String track2;
	/**
	 * Present Flag
	 */
	@Getter
	@Setter
	private String presentFlag;
	/**
	 * Swiped Flag
	 */
	@Getter
	@Setter
	private String swipedFlag;
	/**
	 * Overflow Flag
	 */
	@Getter
	@Setter
	private String overflowFlag;
	/**
	 * Max Amount
	 */
	@Getter
	@Setter
	private BigDecimal maxAmount;
	/**
	 * Process Attempt
	 */
	@Getter
	@Setter
	private Long processAttempt;
	/**
	 * Billing Postal Code
	 */
	@Getter
	@Setter
	private String billingPostalCode;
	/**
	 * Manual Auth Code
	 */
	@Getter
	@Setter
	private String manualAuthCode;
	/**
	 * Manual Ref Num
	 */
	@Getter
	@Setter
	private String manualRefNum;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Needs Nsf Retry
	 */
	@Getter
	@Setter
	private String needsNsfRetry;
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

	public OrderPaymentPreference(GenericValue value) {
		orderPaymentPreferenceId = (String) value
				.get(FIELD_ORDER_PAYMENT_PREFERENCE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		productPricePurposeId = (String) value
				.get(FIELD_PRODUCT_PRICE_PURPOSE_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		finAccountId = (String) value.get(FIELD_FIN_ACCOUNT_ID);
		securityCode = (String) value.get(FIELD_SECURITY_CODE);
		track2 = (String) value.get(FIELD_TRACK2);
		presentFlag = (String) value.get(FIELD_PRESENT_FLAG);
		swipedFlag = (String) value.get(FIELD_SWIPED_FLAG);
		overflowFlag = (String) value.get(FIELD_OVERFLOW_FLAG);
		maxAmount = (BigDecimal) value.get(FIELD_MAX_AMOUNT);
		processAttempt = (Long) value.get(FIELD_PROCESS_ATTEMPT);
		billingPostalCode = (String) value.get(FIELD_BILLING_POSTAL_CODE);
		manualAuthCode = (String) value.get(FIELD_MANUAL_AUTH_CODE);
		manualRefNum = (String) value.get(FIELD_MANUAL_REF_NUM);
		statusId = (String) value.get(FIELD_STATUS_ID);
		needsNsfRetry = (String) value.get(FIELD_NEEDS_NSF_RETRY);
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

	public static OrderPaymentPreference fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderPaymentPreference(value);
	}

	public static List<OrderPaymentPreference> fromValues(
			List<GenericValue> values) {
		List<OrderPaymentPreference> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderPaymentPreference(value));
		}
		return entities;
	}
}