package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Application
 */
public class PaymentApplication implements Serializable {

	public static final long serialVersionUID = 4381934142615779328L;
	public static final String NAME = "PaymentApplication";
	/**
	 * Payment Application Id
	 */
	@Getter
	@Setter
	private String paymentApplicationId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
	/**
	 * To Payment Id
	 */
	@Getter
	@Setter
	private String toPaymentId;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Amount Applied
	 */
	@Getter
	@Setter
	private BigDecimal amountApplied;
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
		paymentApplicationId, paymentId, invoiceId, invoiceItemSeqId, billingAccountId, overrideGlAccountId, toPaymentId, taxAuthGeoId, amountApplied, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentApplication(GenericValue value) {
		paymentApplicationId = (String) value.get(Fields.paymentApplicationId
				.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		toPaymentId = (String) value.get(Fields.toPaymentId.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		amountApplied = (BigDecimal) value.get(Fields.amountApplied.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PaymentApplication fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentApplication(value);
	}

	public static List<PaymentApplication> fromValues(List<GenericValue> values) {
		List<PaymentApplication> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentApplication(value));
		}
		return entities;
	}
}