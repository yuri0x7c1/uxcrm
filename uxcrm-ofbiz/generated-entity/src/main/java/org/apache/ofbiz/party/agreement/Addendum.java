package org.apache.ofbiz.party.agreement;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class Addendum implements Serializable {

	public static final long serialVersionUID = 2210005708325559296L;
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

	public Addendum(GenericValue value) {
		addendumId = (String) value.get(FIELD_ADDENDUM_ID);
		agreementId = (String) value.get(FIELD_AGREEMENT_ID);
		agreementItemSeqId = (String) value.get(FIELD_AGREEMENT_ITEM_SEQ_ID);
		addendumCreationDate = (Timestamp) value
				.get(FIELD_ADDENDUM_CREATION_DATE);
		addendumEffectiveDate = (Timestamp) value
				.get(FIELD_ADDENDUM_EFFECTIVE_DATE);
		addendumText = (String) value.get(FIELD_ADDENDUM_TEXT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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