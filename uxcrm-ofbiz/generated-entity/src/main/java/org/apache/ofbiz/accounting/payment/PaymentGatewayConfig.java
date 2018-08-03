package org.apache.ofbiz.accounting.payment;

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
public class PaymentGatewayConfig implements Serializable {

	public static final long serialVersionUID = 4225447940444313600L;
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

	public enum Fields {
		paymentGatewayConfigId, paymentGatewayConfigTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewayConfig(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		paymentGatewayConfigTypeId = (String) value
				.get(Fields.paymentGatewayConfigTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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