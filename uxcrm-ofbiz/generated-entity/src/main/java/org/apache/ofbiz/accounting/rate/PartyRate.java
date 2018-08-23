package org.apache.ofbiz.accounting.rate;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Rate
 */
@FieldNameConstants
public class PartyRate implements Serializable {

	public static final long serialVersionUID = 2895755930472176640L;
	public static final String NAME = "PartyRate";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Default Rate
	 */
	@Getter
	@Setter
	private String defaultRate;
	/**
	 * Percentage Used
	 */
	@Getter
	@Setter
	private Double percentageUsed;
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

	public PartyRate(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		rateTypeId = (String) value.get(FIELD_RATE_TYPE_ID);
		defaultRate = (String) value.get(FIELD_DEFAULT_RATE);
		percentageUsed = (Double) value.get(FIELD_PERCENTAGE_USED);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyRate fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRate(value);
	}

	public static List<PartyRate> fromValues(List<GenericValue> values) {
		List<PartyRate> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRate(value));
		}
		return entities;
	}
}