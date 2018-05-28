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
 * Payment Budget Allocation
 */
public class PaymentBudgetAllocation implements Serializable {

	public static final long serialVersionUID = 6248209429761608704L;
	public static final String NAME = "PaymentBudgetAllocation";
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Budget Item Seq Id
	 */
	@Getter
	@Setter
	private String budgetItemSeqId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
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
		budgetId, budgetItemSeqId, paymentId, amount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentBudgetAllocation(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PaymentBudgetAllocation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentBudgetAllocation(value);
	}

	public static List<PaymentBudgetAllocation> fromValues(
			List<GenericValue> values) {
		List<PaymentBudgetAllocation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentBudgetAllocation(value));
		}
		return entities;
	}
}