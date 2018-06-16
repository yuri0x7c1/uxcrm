package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway Eway
 */
public class PaymentGatewayEway implements Serializable {

	public static final long serialVersionUID = 7220342921009335296L;
	public static final String NAME = "PaymentGatewayEway";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Customer Id
	 */
	@Getter
	@Setter
	private String customerId;
	/**
	 * Refund Pwd
	 */
	@Getter
	@Setter
	private String refundPwd;
	/**
	 * Test Mode
	 */
	@Getter
	@Setter
	private String testMode;
	/**
	 * Enable Cvn
	 */
	@Getter
	@Setter
	private String enableCvn;
	/**
	 * Enable Beagle
	 */
	@Getter
	@Setter
	private String enableBeagle;
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
		paymentGatewayConfigId, customerId, refundPwd, testMode, enableCvn, enableBeagle, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewayEway(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		customerId = (String) value.get(Fields.customerId.name());
		refundPwd = (String) value.get(Fields.refundPwd.name());
		testMode = (String) value.get(Fields.testMode.name());
		enableCvn = (String) value.get(Fields.enableCvn.name());
		enableBeagle = (String) value.get(Fields.enableBeagle.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PaymentGatewayEway fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayEway(value);
	}

	public static List<PaymentGatewayEway> fromValues(List<GenericValue> values) {
		List<PaymentGatewayEway> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayEway(value));
		}
		return entities;
	}
}