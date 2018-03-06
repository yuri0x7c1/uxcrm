package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Settlement Term
 */
public class SettlementTerm implements Serializable {

	public static final long serialVersionUID = 4223045436720518144L;
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

	public enum Fields {
		settlementTermId, termName, termValue, uomId
	}

	public SettlementTerm(GenericValue value) {
		settlementTermId = (String) value.get(Fields.settlementTermId.name());
		termName = (String) value.get(Fields.termName.name());
		termValue = (Long) value.get(Fields.termValue.name());
		uomId = (String) value.get(Fields.uomId.name());
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