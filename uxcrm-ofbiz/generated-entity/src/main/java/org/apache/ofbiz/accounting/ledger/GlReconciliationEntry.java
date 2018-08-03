package org.apache.ofbiz.accounting.ledger;

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
public class GlReconciliationEntry implements Serializable {

	public static final long serialVersionUID = 5542183345332396032L;
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

	public enum Fields {
		glReconciliationId, acctgTransId, acctgTransEntrySeqId, reconciledAmount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlReconciliationEntry(GenericValue value) {
		glReconciliationId = (String) value.get(Fields.glReconciliationId
				.name());
		acctgTransId = (String) value.get(Fields.acctgTransId.name());
		acctgTransEntrySeqId = (String) value.get(Fields.acctgTransEntrySeqId
				.name());
		reconciledAmount = (BigDecimal) value.get(Fields.reconciledAmount
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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