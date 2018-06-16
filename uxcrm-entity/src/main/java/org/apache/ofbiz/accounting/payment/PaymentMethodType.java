package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Method Type
 */
public class PaymentMethodType implements Serializable {

	public static final long serialVersionUID = 1014732904666300416L;
	public static final String NAME = "PaymentMethodType";
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Default Gl Account Id
	 */
	@Getter
	@Setter
	private String defaultGlAccountId;
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
		paymentMethodTypeId, description, defaultGlAccountId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentMethodType(GenericValue value) {
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		defaultGlAccountId = (String) value.get(Fields.defaultGlAccountId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PaymentMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentMethodType(value);
	}

	public static List<PaymentMethodType> fromValues(List<GenericValue> values) {
		List<PaymentMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentMethodType(value));
		}
		return entities;
	}
}