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
 * Acctg Trans Entry Type
 */
@FieldNameConstants
public class AcctgTransEntryType implements Serializable {

	public static final long serialVersionUID = 1169467721757233152L;
	public static final String NAME = "AcctgTransEntryType";
	/**
	 * Acctg Trans Entry Type Id
	 */
	@Getter
	@Setter
	private String acctgTransEntryTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public AcctgTransEntryType(GenericValue value) {
		acctgTransEntryTypeId = (String) value
				.get(FIELD_ACCTG_TRANS_ENTRY_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AcctgTransEntryType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AcctgTransEntryType(value);
	}

	public static List<AcctgTransEntryType> fromValues(List<GenericValue> values) {
		List<AcctgTransEntryType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AcctgTransEntryType(value));
		}
		return entities;
	}
}