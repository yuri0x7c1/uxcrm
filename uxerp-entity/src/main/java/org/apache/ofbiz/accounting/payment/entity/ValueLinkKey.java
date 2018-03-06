package org.apache.ofbiz.accounting.payment.entity;

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
public class ValueLinkKey implements Serializable {

	public static final long serialVersionUID = 1537950535297472512L;
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

	public enum Fields {
		merchantId, publicKey, privateKey, exchangeKey, workingKey, workingKeyIndex, lastWorkingKey, createdDate, createdByTerminal, createdByUserLogin, lastModifiedDate, lastModifiedByTerminal, lastModifiedByUserLogin
	}

	public ValueLinkKey(GenericValue value) {
		merchantId = (String) value.get(Fields.merchantId.name());
		publicKey = (String) value.get(Fields.publicKey.name());
		privateKey = (String) value.get(Fields.privateKey.name());
		exchangeKey = (String) value.get(Fields.exchangeKey.name());
		workingKey = (String) value.get(Fields.workingKey.name());
		workingKeyIndex = (Long) value.get(Fields.workingKeyIndex.name());
		lastWorkingKey = (String) value.get(Fields.lastWorkingKey.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByTerminal = (String) value.get(Fields.createdByTerminal.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByTerminal = (String) value
				.get(Fields.lastModifiedByTerminal.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
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