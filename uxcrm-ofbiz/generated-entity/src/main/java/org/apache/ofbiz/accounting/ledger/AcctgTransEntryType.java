package org.apache.ofbiz.accounting.ledger;

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
public class AcctgTransEntryType implements Serializable {

	public static final long serialVersionUID = 8388068922181657600L;
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

	public enum Fields {
		acctgTransEntryTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AcctgTransEntryType(GenericValue value) {
		acctgTransEntryTypeId = (String) value.get(Fields.acctgTransEntryTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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