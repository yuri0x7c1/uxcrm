package org.apache.ofbiz.marketing.campaign;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Marketing Campaign Role
 */
public class MarketingCampaignRole implements Serializable {

	public static final long serialVersionUID = 5202167174456565760L;
	public static final String NAME = "MarketingCampaignRole";
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;
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
		marketingCampaignId, partyId, roleTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public MarketingCampaignRole(GenericValue value) {
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
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

	public static MarketingCampaignRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MarketingCampaignRole(value);
	}

	public static List<MarketingCampaignRole> fromValues(
			List<GenericValue> values) {
		List<MarketingCampaignRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MarketingCampaignRole(value));
		}
		return entities;
	}
}