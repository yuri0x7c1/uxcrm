package org.apache.ofbiz.marketing.opportunity;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class SalesOpportunityTrckCode implements Serializable {

	public static final long serialVersionUID = 4288843974294855680L;
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

	public SalesOpportunityTrckCode(GenericValue value) {
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		trackingCodeId = (String) value.get(FIELD_TRACKING_CODE_ID);
		receivedDate = (Timestamp) value.get(FIELD_RECEIVED_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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