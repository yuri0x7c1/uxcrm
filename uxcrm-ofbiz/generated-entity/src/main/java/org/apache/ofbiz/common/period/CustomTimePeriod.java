package org.apache.ofbiz.common.period;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Custom Time Period
 */
@FieldNameConstants
public class CustomTimePeriod implements Serializable {

	public static final long serialVersionUID = 8744327137400802304L;
	public static final String NAME = "CustomTimePeriod";
	/**
	 * Custom Time Period Id
	 */
	@Getter
	@Setter
	private String customTimePeriodId;
	/**
	 * Parent Period Id
	 */
	@Getter
	@Setter
	private String parentPeriodId;
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Period Num
	 */
	@Getter
	@Setter
	private Long periodNum;
	/**
	 * Period Name
	 */
	@Getter
	@Setter
	private String periodName;
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
	 * Is Closed
	 */
	@Getter
	@Setter
	private String isClosed;
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
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;

	public CustomTimePeriod(GenericValue value) {
		customTimePeriodId = (String) value.get(FIELD_CUSTOM_TIME_PERIOD_ID);
		parentPeriodId = (String) value.get(FIELD_PARENT_PERIOD_ID);
		periodTypeId = (String) value.get(FIELD_PERIOD_TYPE_ID);
		periodNum = (Long) value.get(FIELD_PERIOD_NUM);
		periodName = (String) value.get(FIELD_PERIOD_NAME);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		isClosed = (String) value.get(FIELD_IS_CLOSED);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
	}

	public static CustomTimePeriod fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustomTimePeriod(value);
	}

	public static List<CustomTimePeriod> fromValues(List<GenericValue> values) {
		List<CustomTimePeriod> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustomTimePeriod(value));
		}
		return entities;
	}
}