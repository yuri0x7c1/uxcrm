package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Settlement Term
 */
public class SettlementTerm implements Serializable {

	public static final long serialVersionUID = 5629520214356361216L;
	public static final String NAME = "SettlementTerm";
	/**
	 * Settlement Term Id
	 */
	@Getter
	@Setter
	private String settlementTermId;
	/**
	 * Term Name
	 */
	@Getter
	@Setter
	private String termName;
	/**
	 * Term Value
	 */
	@Getter
	@Setter
	private Long termValue;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
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
		settlementTermId, termName, termValue, uomId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SettlementTerm(GenericValue value) {
		settlementTermId = (String) value.get(Fields.settlementTermId.name());
		termName = (String) value.get(Fields.termName.name());
		termValue = (Long) value.get(Fields.termValue.name());
		uomId = (String) value.get(Fields.uomId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static SettlementTerm fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SettlementTerm(value);
	}

	public static List<SettlementTerm> fromValues(List<GenericValue> values) {
		List<SettlementTerm> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SettlementTerm(value));
		}
		return entities;
	}
}