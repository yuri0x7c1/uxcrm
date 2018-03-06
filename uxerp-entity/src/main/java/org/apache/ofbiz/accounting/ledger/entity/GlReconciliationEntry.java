package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Reconciliation Entry
 */
public class GlReconciliationEntry implements Serializable {

	public static final long serialVersionUID = 2898688478066131968L;
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

	public enum Fields {
		glReconciliationId, acctgTransId, acctgTransEntrySeqId, reconciledAmount
	}

	public GlReconciliationEntry(GenericValue value) {
		glReconciliationId = (String) value.get(Fields.glReconciliationId
				.name());
		acctgTransId = (String) value.get(Fields.acctgTransId.name());
		acctgTransEntrySeqId = (String) value.get(Fields.acctgTransEntrySeqId
				.name());
		reconciledAmount = (BigDecimal) value.get(Fields.reconciledAmount
				.name());
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