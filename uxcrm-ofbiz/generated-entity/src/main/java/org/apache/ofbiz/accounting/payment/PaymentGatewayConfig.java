package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway Config
 */
@FieldNameConstants
public class PaymentGatewayConfig implements Serializable {

	public static final long serialVersionUID = 6576720088051077120L;
	public static final String NAME = "PaymentGatewayConfig";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Payment Gateway Config Type Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public PaymentGatewayConfig(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		paymentGatewayConfigTypeId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGatewayConfig fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayConfig(value);
	}

	public static List<PaymentGatewayConfig> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayConfig> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayConfig(value));
		}
		return entities;
	}
}