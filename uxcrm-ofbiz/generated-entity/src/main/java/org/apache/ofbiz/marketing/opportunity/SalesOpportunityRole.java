package org.apache.ofbiz.marketing.opportunity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity Role
 */
public class SalesOpportunityRole implements Serializable {

	public static final long serialVersionUID = 8319002071564397568L;
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
		salesOpportunityId, partyId, roleTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SalesOpportunityRole(GenericValue value) {
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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