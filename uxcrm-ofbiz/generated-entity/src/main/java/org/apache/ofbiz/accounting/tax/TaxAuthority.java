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
 * Tax Authority
 */
@FieldNameConstants
public class TaxAuthority implements Serializable {

	public static final long serialVersionUID = 6062581478276068352L;
	public static final String NAME = "TaxAuthority";
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
	 * Require Tax Id For Exemption
	 */
	@Getter
	@Setter
	private String requireTaxIdForExemption;
	/**
	 * Tax Id Format Pattern
	 */
	@Getter
	@Setter
	private String taxIdFormatPattern;
	/**
	 * Include Tax In Price
	 */
	@Getter
	@Setter
	private String includeTaxInPrice;
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

	public TaxAuthority(GenericValue value) {
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		requireTaxIdForExemption = (String) value
				.get(FIELD_REQUIRE_TAX_ID_FOR_EXEMPTION);
		taxIdFormatPattern = (String) value.get(FIELD_TAX_ID_FORMAT_PATTERN);
		includeTaxInPrice = (String) value.get(FIELD_INCLUDE_TAX_IN_PRICE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TaxAuthority fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthority(value);
	}

	public static List<TaxAuthority> fromValues(List<GenericValue> values) {
		List<TaxAuthority> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthority(value));
		}
		return entities;
	}
}