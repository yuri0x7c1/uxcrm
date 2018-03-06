package org.apache.ofbiz.humanres.recruitment.entity.view;

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
public class EmplPositionFulfillmentAndReportingStruct implements Serializable {

	public static final long serialVersionUID = 2777219542400483328L;
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
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;

	public enum Fields {
		partyId, emplPositionId, emplPositionIdReportingTo, fromDate
	}

	public EmplPositionFulfillmentAndReportingStruct(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		emplPositionId = (String) value.get(Fields.emplPositionId.name());
		emplPositionIdReportingTo = (String) value
				.get(Fields.emplPositionIdReportingTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
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