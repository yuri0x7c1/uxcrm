package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Attribute
 */
public class PaymentAttribute implements Serializable {

	public static final long serialVersionUID = 2767711929777826816L;
	public static final String NAME = "PaymentAttribute";
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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
		paymentId, attrName, attrValue, attrDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentAttribute(GenericValue value) {
		paymentId = (String) value.get(Fields.paymentId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PaymentAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentAttribute(value);
	}

	public static List<PaymentAttribute> fromValues(List<GenericValue> values) {
		List<PaymentAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentAttribute(value));
		}
		return entities;
	}
}