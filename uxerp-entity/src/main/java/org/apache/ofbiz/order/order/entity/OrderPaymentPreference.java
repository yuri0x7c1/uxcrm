package org.apache.ofbiz.order.order.entity;

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
public class OrderPaymentPreference implements Serializable {

	public static final long serialVersionUID = 5631823243263098880L;
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

	public enum Fields {
		orderPaymentPreferenceId, orderId, orderItemSeqId, shipGroupSeqId, productPricePurposeId, paymentMethodTypeId, paymentMethodId, finAccountId, securityCode, track2, presentFlag, swipedFlag, overflowFlag, maxAmount, processAttempt, billingPostalCode, manualAuthCode, manualRefNum, statusId, needsNsfRetry, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin
	}

	public OrderPaymentPreference(GenericValue value) {
		orderPaymentPreferenceId = (String) value
				.get(Fields.orderPaymentPreferenceId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		productPricePurposeId = (String) value.get(Fields.productPricePurposeId
				.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		finAccountId = (String) value.get(Fields.finAccountId.name());
		securityCode = (String) value.get(Fields.securityCode.name());
		track2 = (String) value.get(Fields.track2.name());
		presentFlag = (String) value.get(Fields.presentFlag.name());
		swipedFlag = (String) value.get(Fields.swipedFlag.name());
		overflowFlag = (String) value.get(Fields.overflowFlag.name());
		maxAmount = (BigDecimal) value.get(Fields.maxAmount.name());
		processAttempt = (Long) value.get(Fields.processAttempt.name());
		billingPostalCode = (String) value.get(Fields.billingPostalCode.name());
		manualAuthCode = (String) value.get(Fields.manualAuthCode.name());
		manualRefNum = (String) value.get(Fields.manualRefNum.name());
		statusId = (String) value.get(Fields.statusId.name());
		needsNsfRetry = (String) value.get(Fields.needsNsfRetry.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
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