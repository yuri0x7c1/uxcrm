package org.apache.ofbiz.accounting.tax;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Assoc
 */
@FieldNameConstants
public class TaxAuthorityAssoc implements Serializable {

	public static final long serialVersionUID = 1773098894964141056L;
	public static final String NAME = "TaxAuthorityAssoc";
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
	 * To Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String toTaxAuthGeoId;
	/**
	 * To Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String toTaxAuthPartyId;
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
	 * Tax Authority Assoc Type Id
	 */
	@Getter
	@Setter
	private String taxAuthorityAssocTypeId;
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

	public TaxAuthorityAssoc(GenericValue value) {
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		toTaxAuthGeoId = (String) value.get(FIELD_TO_TAX_AUTH_GEO_ID);
		toTaxAuthPartyId = (String) value.get(FIELD_TO_TAX_AUTH_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		taxAuthorityAssocTypeId = (String) value
				.get(FIELD_TAX_AUTHORITY_ASSOC_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TaxAuthorityAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityAssoc(value);
	}

	public static List<TaxAuthorityAssoc> fromValues(List<GenericValue> values) {
		List<TaxAuthorityAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityAssoc(value));
		}
		return entities;
	}
}