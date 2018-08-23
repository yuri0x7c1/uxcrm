package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Old Party Tax Info
 */
@FieldNameConstants
public class OldPartyTaxInfo implements Serializable {

	public static final long serialVersionUID = 6842952927887058944L;
	public static final String NAME = "OldPartyTaxInfo";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Party Tax Id
	 */
	@Getter
	@Setter
	private String partyTaxId;
	/**
	 * Is Exempt
	 */
	@Getter
	@Setter
	private String isExempt;
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

	public OldPartyTaxInfo(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		partyTaxId = (String) value.get(FIELD_PARTY_TAX_ID);
		isExempt = (String) value.get(FIELD_IS_EXEMPT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OldPartyTaxInfo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldPartyTaxInfo(value);
	}

	public static List<OldPartyTaxInfo> fromValues(List<GenericValue> values) {
		List<OldPartyTaxInfo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldPartyTaxInfo(value));
		}
		return entities;
	}
}