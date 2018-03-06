package org.apache.ofbiz.accounting.rate.entity;

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
public class PartyRate implements Serializable {

	public static final long serialVersionUID = 8025312185709068288L;
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

	public enum Fields {
		partyId, rateTypeId, defaultRate, percentageUsed, fromDate, thruDate
	}

	public PartyRate(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		defaultRate = (String) value.get(Fields.defaultRate.name());
		percentageUsed = (Double) value.get(Fields.percentageUsed.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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