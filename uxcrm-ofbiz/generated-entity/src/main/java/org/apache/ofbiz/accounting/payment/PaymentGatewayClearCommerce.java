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
 * Payment Gateway Clear Commerce
 */
@FieldNameConstants
public class PaymentGatewayClearCommerce implements Serializable {

	public static final long serialVersionUID = 3053912335479009280L;
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

	public PaymentGatewayClearCommerce(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		sourceId = (String) value.get(FIELD_SOURCE_ID);
		groupId = (String) value.get(FIELD_GROUP_ID);
		clientId = (String) value.get(FIELD_CLIENT_ID);
		username = (String) value.get(FIELD_USERNAME);
		pwd = (String) value.get(FIELD_PWD);
		userAlias = (String) value.get(FIELD_USER_ALIAS);
		effectiveAlias = (String) value.get(FIELD_EFFECTIVE_ALIAS);
		processMode = (String) value.get(FIELD_PROCESS_MODE);
		serverURL = (String) value.get(FIELD_SERVER_U_R_L);
		enableCVM = (String) value.get(FIELD_ENABLE_C_V_M);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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