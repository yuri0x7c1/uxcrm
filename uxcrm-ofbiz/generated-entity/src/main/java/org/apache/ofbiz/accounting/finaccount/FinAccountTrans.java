package org.apache.ofbiz.accounting.finaccount;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class FinAccountTrans implements Serializable {

	public static final long serialVersionUID = 628594345463884800L;
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

	public FinAccountTrans(GenericValue value) {
		finAccountTransId = (String) value.get(FIELD_FIN_ACCOUNT_TRANS_ID);
		finAccountTransTypeId = (String) value
				.get(FIELD_FIN_ACCOUNT_TRANS_TYPE_ID);
		finAccountId = (String) value.get(FIELD_FIN_ACCOUNT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		glReconciliationId = (String) value.get(FIELD_GL_RECONCILIATION_ID);
		transactionDate = (Timestamp) value.get(FIELD_TRANSACTION_DATE);
		entryDate = (Timestamp) value.get(FIELD_ENTRY_DATE);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		performedByPartyId = (String) value.get(FIELD_PERFORMED_BY_PARTY_ID);
		reasonEnumId = (String) value.get(FIELD_REASON_ENUM_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		statusId = (String) value.get(FIELD_STATUS_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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