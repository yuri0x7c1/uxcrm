package org.apache.ofbiz.marketing.opportunity;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class SalesOpportunityRole implements Serializable {

	public static final long serialVersionUID = 4337147054589075456L;
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

	public SalesOpportunityRole(GenericValue value) {
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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