package org.apache.ofbiz.accounting.fixedasset.entity;

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

	public static final long serialVersionUID = 9150844146282910720L;
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

	public enum Fields {
		fixedAssetId, fromDate, thruDate, registrationDate, govAgencyPartyId, registrationNumber, licenseNumber
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