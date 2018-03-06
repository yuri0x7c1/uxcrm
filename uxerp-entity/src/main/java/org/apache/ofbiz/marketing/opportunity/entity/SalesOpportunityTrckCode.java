package org.apache.ofbiz.marketing.opportunity.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity Trck Code
 */
public class SalesOpportunityTrckCode implements Serializable {

	public static final long serialVersionUID = 4754202519942036480L;
	public static final String NAME = "SalesOpportunityTrckCode";
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;
	/**
	 * Tracking Code Id
	 */
	@Getter
	@Setter
	private String trackingCodeId;
	/**
	 * Received Date
	 */
	@Getter
	@Setter
	private Timestamp receivedDate;

	public enum Fields {
		salesOpportunityId, trackingCodeId, receivedDate
	}

	public SalesOpportunityTrckCode(GenericValue value) {
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		trackingCodeId = (String) value.get(Fields.trackingCodeId.name());
		receivedDate = (Timestamp) value.get(Fields.receivedDate.name());
	}

	public static SalesOpportunityTrckCode fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOpportunityTrckCode(value);
	}

	public static List<SalesOpportunityTrckCode> fromValues(
			List<GenericValue> values) {
		List<SalesOpportunityTrckCode> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOpportunityTrckCode(value));
		}
		return entities;
	}
}