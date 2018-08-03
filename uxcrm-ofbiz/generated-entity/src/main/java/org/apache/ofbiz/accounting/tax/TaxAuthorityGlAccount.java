package org.apache.ofbiz.accounting.tax;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Gl Account
 */
public class TaxAuthorityGlAccount implements Serializable {

	public static final long serialVersionUID = 1056293630128558080L;
	public static final String NAME = "TaxAuthorityGlAccount";
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
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
		taxAuthGeoId, taxAuthPartyId, organizationPartyId, glAccountId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TaxAuthorityGlAccount(GenericValue value) {
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TaxAuthorityGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityGlAccount(value);
	}

	public static List<TaxAuthorityGlAccount> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityGlAccount(value));
		}
		return entities;
	}
}