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
 * Agreement Party Applic
 */
@FieldNameConstants
public class AgreementPartyApplic implements Serializable {

	public static final long serialVersionUID = 241914576469498880L;
	public static final String NAME = "AgreementPartyApplic";
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
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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

	public AgreementPartyApplic(GenericValue value) {
		agreementId = (String) value.get(FIELD_AGREEMENT_ID);
		agreementItemSeqId = (String) value.get(FIELD_AGREEMENT_ITEM_SEQ_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AgreementPartyApplic fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementPartyApplic(value);
	}

	public static List<AgreementPartyApplic> fromValues(
			List<GenericValue> values) {
		List<AgreementPartyApplic> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementPartyApplic(value));
		}
		return entities;
	}
}