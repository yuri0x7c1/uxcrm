package org.apache.ofbiz.marketing.campaign.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Marketing Campaign Note
 */
public class MarketingCampaignNote implements Serializable {

	public static final long serialVersionUID = 4526458486601722880L;
	public static final String NAME = "MarketingCampaignNote";
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;

	public enum Fields {
		marketingCampaignId, noteId
	}

	public MarketingCampaignNote(GenericValue value) {
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		noteId = (String) value.get(Fields.noteId.name());
	}

	public static MarketingCampaignNote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MarketingCampaignNote(value);
	}

	public static List<MarketingCampaignNote> fromValues(
			List<GenericValue> values) {
		List<MarketingCampaignNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MarketingCampaignNote(value));
		}
		return entities;
	}
}