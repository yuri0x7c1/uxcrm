package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Acctg Trans Attribute
 */
public class AcctgTransAttribute implements Serializable {

	public static final long serialVersionUID = 6250865203802513408L;
	public static final String NAME = "AcctgTransAttribute";
	/**
	 * Acctg Trans Id
	 */
	@Getter
	@Setter
	private String acctgTransId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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
		acctgTransId, attrName, attrValue, attrDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AcctgTransAttribute(GenericValue value) {
		acctgTransId = (String) value.get(Fields.acctgTransId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static AcctgTransAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AcctgTransAttribute(value);
	}

	public static List<AcctgTransAttribute> fromValues(List<GenericValue> values) {
		List<AcctgTransAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AcctgTransAttribute(value));
		}
		return entities;
	}
}