package org.apache.ofbiz.accounting.finaccount.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Trans
 */
public class FinAccountTrans implements Serializable {

	public static final long serialVersionUID = 3207571183644413952L;
	public static final String NAME = "FinAccountTrans";
	/**
	 * Fin Account Trans Id
	 */
	@Getter
	@Setter
	private String finAccountTransId;
	/**
	 * Fin Account Trans Type Id
	 */
	@Getter
	@Setter
	private String finAccountTransTypeId;
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Gl Reconciliation Id
	 */
	@Getter
	@Setter
	private String glReconciliationId;
	/**
	 * Transaction Date
	 */
	@Getter
	@Setter
	private Timestamp transactionDate;
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Performed By Party Id
	 */
	@Getter
	@Setter
	private String performedByPartyId;
	/**
	 * Reason Enum Id
	 */
	@Getter
	@Setter
	private String reasonEnumId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;

	public enum Fields {
		finAccountTransId, finAccountTransTypeId, finAccountId, partyId, glReconciliationId, transactionDate, entryDate, amount, paymentId, orderId, orderItemSeqId, performedByPartyId, reasonEnumId, comments, statusId
	}

	public FinAccountTrans(GenericValue value) {
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		finAccountTransTypeId = (String) value.get(Fields.finAccountTransTypeId
				.name());
		finAccountId = (String) value.get(Fields.finAccountId.name());
		partyId = (String) value.get(Fields.partyId.name());
		glReconciliationId = (String) value.get(Fields.glReconciliationId
				.name());
		transactionDate = (Timestamp) value.get(Fields.transactionDate.name());
		entryDate = (Timestamp) value.get(Fields.entryDate.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		performedByPartyId = (String) value.get(Fields.performedByPartyId
				.name());
		reasonEnumId = (String) value.get(Fields.reasonEnumId.name());
		comments = (String) value.get(Fields.comments.name());
		statusId = (String) value.get(Fields.statusId.name());
	}

	public static FinAccountTrans fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountTrans(value);
	}

	public static List<FinAccountTrans> fromValues(List<GenericValue> values) {
		List<FinAccountTrans> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountTrans(value));
		}
		return entities;
	}
}