package org.apache.ofbiz.accounting.fixedasset;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Registration
 */
@FieldNameConstants
public class FixedAssetRegistration implements Serializable {

	public static final long serialVersionUID = 1744849258412200960L;
	public static final String NAME = "FixedAssetRegistration";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
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
	 * Registration Date
	 */
	@Getter
	@Setter
	private Timestamp registrationDate;
	/**
	 * Gov Agency Party Id
	 */
	@Getter
	@Setter
	private String govAgencyPartyId;
	/**
	 * Registration Number
	 */
	@Getter
	@Setter
	private String registrationNumber;
	/**
	 * License Number
	 */
	@Getter
	@Setter
	private String licenseNumber;
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

	public FixedAssetRegistration(GenericValue value) {
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		registrationDate = (Timestamp) value.get(FIELD_REGISTRATION_DATE);
		govAgencyPartyId = (String) value.get(FIELD_GOV_AGENCY_PARTY_ID);
		registrationNumber = (String) value.get(FIELD_REGISTRATION_NUMBER);
		licenseNumber = (String) value.get(FIELD_LICENSE_NUMBER);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FixedAssetRegistration fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetRegistration(value);
	}

	public static List<FixedAssetRegistration> fromValues(
			List<GenericValue> values) {
		List<FixedAssetRegistration> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetRegistration(value));
		}
		return entities;
	}
}