package org.apache.ofbiz.accounting.fixedasset;

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
public class FixedAssetRegistration implements Serializable {

	public static final long serialVersionUID = 4316088899725355008L;
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

	public enum Fields {
		fixedAssetId, fromDate, thruDate, registrationDate, govAgencyPartyId, registrationNumber, licenseNumber, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetRegistration(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		registrationDate = (Timestamp) value
				.get(Fields.registrationDate.name());
		govAgencyPartyId = (String) value.get(Fields.govAgencyPartyId.name());
		registrationNumber = (String) value.get(Fields.registrationNumber
				.name());
		licenseNumber = (String) value.get(Fields.licenseNumber.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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