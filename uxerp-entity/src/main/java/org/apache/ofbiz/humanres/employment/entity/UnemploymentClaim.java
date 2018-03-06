package org.apache.ofbiz.humanres.employment.entity;

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

	public static final long serialVersionUID = 2039180694721811456L;
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

	public enum Fields {
		unemploymentClaimId, unemploymentClaimDate, description, statusId, partyIdFrom, partyIdTo, roleTypeIdFrom, roleTypeIdTo, fromDate, thruDate
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