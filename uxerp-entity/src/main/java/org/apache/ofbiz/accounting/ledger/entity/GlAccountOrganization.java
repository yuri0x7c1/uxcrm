package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Organization
 */
public class GlAccountOrganization implements Serializable {

	public static final long serialVersionUID = 9027570000953326592L;
	public static final String NAME = "GlAccountOrganization";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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
		glAccountId, organizationPartyId, roleTypeId, fromDate, thruDate
	}

	public GlAccountOrganization(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static GlAccountOrganization fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountOrganization(value);
	}

	public static List<GlAccountOrganization> fromValues(
			List<GenericValue> values) {
		List<GlAccountOrganization> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountOrganization(value));
		}
		return entities;
	}
}