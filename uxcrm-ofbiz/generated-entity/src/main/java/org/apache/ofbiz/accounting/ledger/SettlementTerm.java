package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class SettlementTerm implements Serializable {

	public static final long serialVersionUID = 5957822134102412288L;
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

	public SettlementTerm(GenericValue value) {
		settlementTermId = (String) value.get(FIELD_SETTLEMENT_TERM_ID);
		termName = (String) value.get(FIELD_TERM_NAME);
		termValue = (Long) value.get(FIELD_TERM_VALUE);
		uomId = (String) value.get(FIELD_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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