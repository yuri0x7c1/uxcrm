package org.apache.ofbiz.marketing.opportunity.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity Role
 */
public class SalesOpportunityRole implements Serializable {

	public static final long serialVersionUID = 7909591829158197248L;
	public static final String NAME = "SalesOpportunityRole";
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;

	public enum Fields {
		salesOpportunityId, partyId, roleTypeId
	}

	public SalesOpportunityRole(GenericValue value) {
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static SalesOpportunityRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOpportunityRole(value);
	}

	public static List<SalesOpportunityRole> fromValues(
			List<GenericValue> values) {
		List<SalesOpportunityRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOpportunityRole(value));
		}
		return entities;
	}
}