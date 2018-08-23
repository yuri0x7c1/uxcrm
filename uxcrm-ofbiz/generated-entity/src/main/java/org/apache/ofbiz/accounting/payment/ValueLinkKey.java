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
 * Value Link Key
 */
@FieldNameConstants
public class ValueLinkKey implements Serializable {

	public static final long serialVersionUID = 2496000964807286784L;
	public static final String NAME = "ValueLinkKey";
	/**
	 * Merchant Id
	 */
	@Getter
	@Setter
	private String merchantId;
	/**
	 * Public Key
	 */
	@Getter
	@Setter
	private String publicKey;
	/**
	 * Private Key
	 */
	@Getter
	@Setter
	private String privateKey;
	/**
	 * Exchange Key
	 */
	@Getter
	@Setter
	private String exchangeKey;
	/**
	 * Working Key
	 */
	@Getter
	@Setter
	private String workingKey;
	/**
	 * Working Key Index
	 */
	@Getter
	@Setter
	private Long workingKeyIndex;
	/**
	 * Last Working Key
	 */
	@Getter
	@Setter
	private String lastWorkingKey;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By Terminal
	 */
	@Getter
	@Setter
	private String createdByTerminal;
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
	 * Last Modified By Terminal
	 */
	@Getter
	@Setter
	private String lastModifiedByTerminal;
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

	public ValueLinkKey(GenericValue value) {
		merchantId = (String) value.get(FIELD_MERCHANT_ID);
		publicKey = (String) value.get(FIELD_PUBLIC_KEY);
		privateKey = (String) value.get(FIELD_PRIVATE_KEY);
		exchangeKey = (String) value.get(FIELD_EXCHANGE_KEY);
		workingKey = (String) value.get(FIELD_WORKING_KEY);
		workingKeyIndex = (Long) value.get(FIELD_WORKING_KEY_INDEX);
		lastWorkingKey = (String) value.get(FIELD_LAST_WORKING_KEY);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByTerminal = (String) value.get(FIELD_CREATED_BY_TERMINAL);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByTerminal = (String) value
				.get(FIELD_LAST_MODIFIED_BY_TERMINAL);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ValueLinkKey fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ValueLinkKey(value);
	}

	public static List<ValueLinkKey> fromValues(List<GenericValue> values) {
		List<ValueLinkKey> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ValueLinkKey(value));
		}
		return entities;
	}
}