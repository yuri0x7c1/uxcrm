package org.apache.ofbiz.party.party;

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
public class OldPartyTaxInfo implements Serializable {

	public static final long serialVersionUID = 5611324672154314752L;
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

	public enum Fields {
		partyId, geoId, fromDate, thruDate, partyTaxId, isExempt, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldPartyTaxInfo(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		geoId = (String) value.get(Fields.geoId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		partyTaxId = (String) value.get(Fields.partyTaxId.name());
		isExempt = (String) value.get(Fields.isExempt.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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