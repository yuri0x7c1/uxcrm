package org.apache.ofbiz.product.facility;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Contact Mech Purpose
 */
public class FacilityContactMechPurpose implements Serializable {

	public static final long serialVersionUID = 1631026137019055104L;
	public static final String NAME = "FacilityContactMechPurpose";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
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
		facilityId, contactMechId, contactMechPurposeTypeId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FacilityContactMechPurpose(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FacilityContactMechPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityContactMechPurpose(value);
	}

	public static List<FacilityContactMechPurpose> fromValues(
			List<GenericValue> values) {
		List<FacilityContactMechPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityContactMechPurpose(value));
		}
		return entities;
	}
}