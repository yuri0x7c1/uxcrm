package org.apache.ofbiz.marketing.campaign.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Marketing Campaign Promo
 */
public class MarketingCampaignPromo implements Serializable {

	public static final long serialVersionUID = 574053431820171264L;
	public static final String NAME = "MarketingCampaignPromo";
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;

	public enum Fields {
		marketingCampaignId, productPromoId
	}

	public MarketingCampaignPromo(GenericValue value) {
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
	}

	public static MarketingCampaignPromo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MarketingCampaignPromo(value);
	}

	public static List<MarketingCampaignPromo> fromValues(
			List<GenericValue> values) {
		List<MarketingCampaignPromo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MarketingCampaignPromo(value));
		}
		return entities;
	}
}