package org.apache.ofbiz.product.facility;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class FacilityContactMechPurpose implements Serializable {

	public static final long serialVersionUID = 3260337939661816832L;
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

	public FacilityContactMechPurpose(GenericValue value) {
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		contactMechPurposeTypeId = (String) value
				.get(FIELD_CONTACT_MECH_PURPOSE_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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