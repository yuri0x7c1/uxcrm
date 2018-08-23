package org.apache.ofbiz.marketing.campaign;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class MarketingCampaignPrice implements Serializable {

	public static final long serialVersionUID = 3550174797090716672L;
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

	public MarketingCampaignPrice(GenericValue value) {
		marketingCampaignId = (String) value.get(FIELD_MARKETING_CAMPAIGN_ID);
		productPriceRuleId = (String) value.get(FIELD_PRODUCT_PRICE_RULE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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