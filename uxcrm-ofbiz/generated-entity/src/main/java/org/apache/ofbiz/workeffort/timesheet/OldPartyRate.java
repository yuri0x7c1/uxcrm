package org.apache.ofbiz.workeffort.timesheet;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class OldPartyRate implements Serializable {

	public static final long serialVersionUID = 912299106170025984L;
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

	public OldPartyRate(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		rateTypeId = (String) value.get(FIELD_RATE_TYPE_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		defaultRate = (String) value.get(FIELD_DEFAULT_RATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		rate = (BigDecimal) value.get(FIELD_RATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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