package org.apache.ofbiz.marketing.campaign.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Marketing Campaign Price
 */
public class MarketingCampaignPrice implements Serializable {

	public static final long serialVersionUID = 7248127600125345792L;
	public static final String NAME = "MarketingCampaignPrice";
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;
	/**
	 * Product Price Rule Id
	 */
	@Getter
	@Setter
	private String productPriceRuleId;

	public enum Fields {
		marketingCampaignId, productPriceRuleId
	}

	public MarketingCampaignPrice(GenericValue value) {
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		productPriceRuleId = (String) value.get(Fields.productPriceRuleId
				.name());
	}

	public static MarketingCampaignPrice fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MarketingCampaignPrice(value);
	}

	public static List<MarketingCampaignPrice> fromValues(
			List<GenericValue> values) {
		List<MarketingCampaignPrice> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MarketingCampaignPrice(value));
		}
		return entities;
	}
}