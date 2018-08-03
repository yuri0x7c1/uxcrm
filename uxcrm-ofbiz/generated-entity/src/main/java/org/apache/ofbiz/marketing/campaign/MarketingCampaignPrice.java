package org.apache.ofbiz.marketing.campaign;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Marketing Campaign Price
 */
public class MarketingCampaignPrice implements Serializable {

	public static final long serialVersionUID = 6875284839656206336L;
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
		marketingCampaignId, productPriceRuleId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public MarketingCampaignPrice(GenericValue value) {
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		productPriceRuleId = (String) value.get(Fields.productPriceRuleId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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