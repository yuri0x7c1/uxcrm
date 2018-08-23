package org.apache.ofbiz.humanres.recruitment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position Fulfillment And Reporting Struct
 */
@FieldNameConstants
public class EmplPositionFulfillmentAndReportingStruct implements Serializable {

	public static final long serialVersionUID = 7708227434650064896L;
	public static final String NAME = "EmplPositionFulfillmentAndReportingStruct";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Empl Position Id
	 */
	@Getter
	@Setter
	private String emplPositionId;
	/**
	 * Empl Position Id Reporting To
	 */
	@Getter
	@Setter
	private String emplPositionIdReportingTo;
	/**
	 * Internal Organisation
	 */
	@Getter
	@Setter
	private String internalOrganisation;
	/**
	 * Reporting Date
	 */
	@Getter
	@Setter
	private Timestamp reportingDate;

	public EmplPositionFulfillmentAndReportingStruct(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		emplPositionId = (String) value.get(FIELD_EMPL_POSITION_ID);
		emplPositionIdReportingTo = (String) value
				.get(FIELD_EMPL_POSITION_ID_REPORTING_TO);
		internalOrganisation = (String) value.get(FIELD_INTERNAL_ORGANISATION);
		reportingDate = (Timestamp) value.get(FIELD_REPORTING_DATE);
	}

	public static EmplPositionFulfillmentAndReportingStruct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionFulfillmentAndReportingStruct(value);
	}

	public static List<EmplPositionFulfillmentAndReportingStruct> fromValues(
			List<GenericValue> values) {
		List<EmplPositionFulfillmentAndReportingStruct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionFulfillmentAndReportingStruct(value));
		}
		return entities;
	}
}