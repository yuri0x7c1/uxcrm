package org.apache.ofbiz.marketing.opportunity;

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

	public static final long serialVersionUID = 6733912424351124480L;
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
		salesOpportunityId, trackingCodeId, receivedDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SalesOpportunityTrckCode(GenericValue value) {
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		trackingCodeId = (String) value.get(Fields.trackingCodeId.name());
		receivedDate = (Timestamp) value.get(Fields.receivedDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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