package org.apache.ofbiz.accounting.rate;

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
 * Rate Amount
 */
@FieldNameConstants
public class RateAmount implements Serializable {

	public static final long serialVersionUID = 5505156008852110336L;
	public static final String NAME = "RateAmount";
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Rate Currency Uom Id
	 */
	@Getter
	@Setter
	private String rateCurrencyUomId;
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
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
	 * Rate Amount
	 */
	@Getter
	@Setter
	private BigDecimal rateAmount;
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

	public RateAmount(GenericValue value) {
		rateTypeId = (String) value.get(FIELD_RATE_TYPE_ID);
		rateCurrencyUomId = (String) value.get(FIELD_RATE_CURRENCY_UOM_ID);
		periodTypeId = (String) value.get(FIELD_PERIOD_TYPE_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		emplPositionTypeId = (String) value.get(FIELD_EMPL_POSITION_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		rateAmount = (BigDecimal) value.get(FIELD_RATE_AMOUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static RateAmount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RateAmount(value);
	}

	public static List<RateAmount> fromValues(List<GenericValue> values) {
		List<RateAmount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RateAmount(value));
		}
		return entities;
	}
}