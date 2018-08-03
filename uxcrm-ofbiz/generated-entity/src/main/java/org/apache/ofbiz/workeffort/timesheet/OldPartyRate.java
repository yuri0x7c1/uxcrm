package org.apache.ofbiz.workeffort.timesheet;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Old Party Rate
 */
public class OldPartyRate implements Serializable {

	public static final long serialVersionUID = 6875172213470804992L;
	public static final String NAME = "OldPartyRate";
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
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Default Rate
	 */
	@Getter
	@Setter
	private String defaultRate;
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
	 * Rate
	 */
	@Getter
	@Setter
	private BigDecimal rate;
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
		partyId, rateTypeId, currencyUomId, defaultRate, fromDate, thruDate, rate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldPartyRate(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		defaultRate = (String) value.get(Fields.defaultRate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		rate = (BigDecimal) value.get(Fields.rate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OldPartyRate fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldPartyRate(value);
	}

	public static List<OldPartyRate> fromValues(List<GenericValue> values) {
		List<OldPartyRate> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldPartyRate(value));
		}
		return entities;
	}
}