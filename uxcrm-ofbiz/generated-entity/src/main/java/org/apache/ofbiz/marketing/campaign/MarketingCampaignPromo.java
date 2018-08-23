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
 * Marketing Campaign Promo
 */
@FieldNameConstants
public class MarketingCampaignPromo implements Serializable {

	public static final long serialVersionUID = 5259202556448260096L;
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

	public MarketingCampaignPromo(GenericValue value) {
		marketingCampaignId = (String) value.get(FIELD_MARKETING_CAMPAIGN_ID);
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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