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
 * Agreement Geographical Applic
 */
@FieldNameConstants
public class AgreementGeographicalApplic implements Serializable {

	public static final long serialVersionUID = 203545091447993344L;
	public static final String NAME = "AgreementGeographicalApplic";
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
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
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

	public AgreementGeographicalApplic(GenericValue value) {
		agreementId = (String) value.get(FIELD_AGREEMENT_ID);
		agreementItemSeqId = (String) value.get(FIELD_AGREEMENT_ITEM_SEQ_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AgreementGeographicalApplic fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementGeographicalApplic(value);
	}

	public static List<AgreementGeographicalApplic> fromValues(
			List<GenericValue> values) {
		List<AgreementGeographicalApplic> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementGeographicalApplic(value));
		}
		return entities;
	}
}