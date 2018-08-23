package org.apache.ofbiz.humanres.employment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Unemployment Claim
 */
@FieldNameConstants
public class UnemploymentClaim implements Serializable {

	public static final long serialVersionUID = 6925457659401151488L;
	public static final String NAME = "UnemploymentClaim";
	/**
	 * Unemployment Claim Id
	 */
	@Getter
	@Setter
	private String unemploymentClaimId;
	/**
	 * Unemployment Claim Date
	 */
	@Getter
	@Setter
	private Timestamp unemploymentClaimDate;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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

	public UnemploymentClaim(GenericValue value) {
		unemploymentClaimId = (String) value.get(FIELD_UNEMPLOYMENT_CLAIM_ID);
		unemploymentClaimDate = (Timestamp) value
				.get(FIELD_UNEMPLOYMENT_CLAIM_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		statusId = (String) value.get(FIELD_STATUS_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static UnemploymentClaim fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UnemploymentClaim(value);
	}

	public static List<UnemploymentClaim> fromValues(List<GenericValue> values) {
		List<UnemploymentClaim> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UnemploymentClaim(value));
		}
		return entities;
	}
}