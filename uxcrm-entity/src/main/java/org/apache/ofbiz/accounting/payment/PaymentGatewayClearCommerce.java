package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway Clear Commerce
 */
public class PaymentGatewayClearCommerce implements Serializable {

	public static final long serialVersionUID = 4883090753044124672L;
	public static final String NAME = "PaymentGatewayClearCommerce";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Source Id
	 */
	@Getter
	@Setter
	private String sourceId;
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
	/**
	 * Client Id
	 */
	@Getter
	@Setter
	private String clientId;
	/**
	 * Username
	 */
	@Getter
	@Setter
	private String username;
	/**
	 * Pwd
	 */
	@Getter
	@Setter
	private String pwd;
	/**
	 * User Alias
	 */
	@Getter
	@Setter
	private String userAlias;
	/**
	 * Effective Alias
	 */
	@Getter
	@Setter
	private String effectiveAlias;
	/**
	 * Process Mode
	 */
	@Getter
	@Setter
	private String processMode;
	/**
	 * Server Url
	 */
	@Getter
	@Setter
	private String serverURL;
	/**
	 * Enable Cvm
	 */
	@Getter
	@Setter
	private String enableCVM;
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
		paymentGatewayConfigId, sourceId, groupId, clientId, username, pwd, userAlias, effectiveAlias, processMode, serverURL, enableCVM, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewayClearCommerce(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		sourceId = (String) value.get(Fields.sourceId.name());
		groupId = (String) value.get(Fields.groupId.name());
		clientId = (String) value.get(Fields.clientId.name());
		username = (String) value.get(Fields.username.name());
		pwd = (String) value.get(Fields.pwd.name());
		userAlias = (String) value.get(Fields.userAlias.name());
		effectiveAlias = (String) value.get(Fields.effectiveAlias.name());
		processMode = (String) value.get(Fields.processMode.name());
		serverURL = (String) value.get(Fields.serverURL.name());
		enableCVM = (String) value.get(Fields.enableCVM.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PaymentGatewayClearCommerce fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayClearCommerce(value);
	}

	public static List<PaymentGatewayClearCommerce> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayClearCommerce> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayClearCommerce(value));
		}
		return entities;
	}
}