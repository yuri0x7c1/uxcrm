package org.apache.ofbiz.party.agreement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Addendum
 */
public class Addendum implements Serializable {

	public static final long serialVersionUID = 4735297459141882880L;
	public static final String NAME = "Addendum";
	/**
	 * Addendum Id
	 */
	@Getter
	@Setter
	private String addendumId;
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Agreement Item Seq Id
	 */
	@Getter
	@Setter
	private String agreementItemSeqId;
	/**
	 * Addendum Creation Date
	 */
	@Getter
	@Setter
	private Timestamp addendumCreationDate;
	/**
	 * Addendum Effective Date
	 */
	@Getter
	@Setter
	private Timestamp addendumEffectiveDate;
	/**
	 * Addendum Text
	 */
	@Getter
	@Setter
	private String addendumText;
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
		addendumId, agreementId, agreementItemSeqId, addendumCreationDate, addendumEffectiveDate, addendumText, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Addendum(GenericValue value) {
		addendumId = (String) value.get(Fields.addendumId.name());
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		addendumCreationDate = (Timestamp) value
				.get(Fields.addendumCreationDate.name());
		addendumEffectiveDate = (Timestamp) value
				.get(Fields.addendumEffectiveDate.name());
		addendumText = (String) value.get(Fields.addendumText.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static Addendum fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Addendum(value);
	}

	public static List<Addendum> fromValues(List<GenericValue> values) {
		List<Addendum> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Addendum(value));
		}
		return entities;
	}
}