package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Reconciliation Entry
 */
@FieldNameConstants
public class GlReconciliationEntry implements Serializable {

	public static final long serialVersionUID = 680714385488674816L;
	public static final String NAME = "GlReconciliationEntry";
	/**
	 * Gl Reconciliation Id
	 */
	@Getter
	@Setter
	private String glReconciliationId;
	/**
	 * Acctg Trans Id
	 */
	@Getter
	@Setter
	private String acctgTransId;
	/**
	 * Acctg Trans Entry Seq Id
	 */
	@Getter
	@Setter
	private String acctgTransEntrySeqId;
	/**
	 * Reconciled Amount
	 */
	@Getter
	@Setter
	private BigDecimal reconciledAmount;
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

	public GlReconciliationEntry(GenericValue value) {
		glReconciliationId = (String) value.get(FIELD_GL_RECONCILIATION_ID);
		acctgTransId = (String) value.get(FIELD_ACCTG_TRANS_ID);
		acctgTransEntrySeqId = (String) value
				.get(FIELD_ACCTG_TRANS_ENTRY_SEQ_ID);
		reconciledAmount = (BigDecimal) value.get(FIELD_RECONCILED_AMOUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GlReconciliationEntry fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlReconciliationEntry(value);
	}

	public static List<GlReconciliationEntry> fromValues(
			List<GenericValue> values) {
		List<GlReconciliationEntry> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlReconciliationEntry(value));
		}
		return entities;
	}
}