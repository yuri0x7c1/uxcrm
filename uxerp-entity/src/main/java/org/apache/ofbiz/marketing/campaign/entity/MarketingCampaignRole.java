package org.apache.ofbiz.marketing.campaign.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Marketing Campaign Role
 */
public class MarketingCampaignRole implements Serializable {

	public static final long serialVersionUID = 5524715096230443008L;
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

	public enum Fields {
		marketingCampaignId, partyId, roleTypeId
	}

	public MarketingCampaignRole(GenericValue value) {
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
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