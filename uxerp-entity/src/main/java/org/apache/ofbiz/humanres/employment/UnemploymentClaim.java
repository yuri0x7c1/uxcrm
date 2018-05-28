package org.apache.ofbiz.humanres.employment;

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
public class UnemploymentClaim implements Serializable {

	public static final long serialVersionUID = 450427429485436928L;
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

	public enum Fields {
		unemploymentClaimId, unemploymentClaimDate, description, statusId, partyIdFrom, partyIdTo, roleTypeIdFrom, roleTypeIdTo, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public UnemploymentClaim(GenericValue value) {
		unemploymentClaimId = (String) value.get(Fields.unemploymentClaimId
				.name());
		unemploymentClaimDate = (Timestamp) value
				.get(Fields.unemploymentClaimDate.name());
		description = (String) value.get(Fields.description.name());
		statusId = (String) value.get(Fields.statusId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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