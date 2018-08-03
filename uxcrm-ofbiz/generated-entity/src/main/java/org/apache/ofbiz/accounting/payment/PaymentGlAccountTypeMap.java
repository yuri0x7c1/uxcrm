package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gl Account Type Map
 */
public class PaymentGlAccountTypeMap implements Serializable {

	public static final long serialVersionUID = 1008980523139393536L;
	public static final String NAME = "PaymentGlAccountTypeMap";
	/**
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
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
		paymentTypeId, organizationPartyId, glAccountTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGlAccountTypeMap(GenericValue value) {
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PaymentGlAccountTypeMap fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGlAccountTypeMap(value);
	}

	public static List<PaymentGlAccountTypeMap> fromValues(
			List<GenericValue> values) {
		List<PaymentGlAccountTypeMap> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGlAccountTypeMap(value));
		}
		return entities;
	}
}