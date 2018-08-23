package org.apache.ofbiz.humanres.employment;

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
 * Party Benefit
 */
@FieldNameConstants
public class PartyBenefit implements Serializable {

	public static final long serialVersionUID = 1667351494936801280L;
	public static final String NAME = "PartyBenefit";
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Benefit Type Id
	 */
	@Getter
	@Setter
	private String benefitTypeId;
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
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Cost
	 */
	@Getter
	@Setter
	private BigDecimal cost;
	/**
	 * Actual Employer Paid Percent
	 */
	@Getter
	@Setter
	private Double actualEmployerPaidPercent;
	/**
	 * Available Time
	 */
	@Getter
	@Setter
	private Long availableTime;
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

	public PartyBenefit(GenericValue value) {
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		benefitTypeId = (String) value.get(FIELD_BENEFIT_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		periodTypeId = (String) value.get(FIELD_PERIOD_TYPE_ID);
		cost = (BigDecimal) value.get(FIELD_COST);
		actualEmployerPaidPercent = (Double) value
				.get(FIELD_ACTUAL_EMPLOYER_PAID_PERCENT);
		availableTime = (Long) value.get(FIELD_AVAILABLE_TIME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyBenefit fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyBenefit(value);
	}

	public static List<PartyBenefit> fromValues(List<GenericValue> values) {
		List<PartyBenefit> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyBenefit(value));
		}
		return entities;
	}
}