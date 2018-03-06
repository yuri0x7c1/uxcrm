package org.apache.ofbiz.common.period.entity;

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
public class CustomTimePeriod implements Serializable {

	public static final long serialVersionUID = 2522783703863170048L;
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

	public enum Fields {
		customTimePeriodId, parentPeriodId, periodTypeId, periodNum, periodName, fromDate, thruDate, isClosed
	}

	public CustomTimePeriod(GenericValue value) {
		customTimePeriodId = (String) value.get(Fields.customTimePeriodId
				.name());
		parentPeriodId = (String) value.get(Fields.parentPeriodId.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		periodNum = (Long) value.get(Fields.periodNum.name());
		periodName = (String) value.get(Fields.periodName.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		isClosed = (String) value.get(Fields.isClosed.name());
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