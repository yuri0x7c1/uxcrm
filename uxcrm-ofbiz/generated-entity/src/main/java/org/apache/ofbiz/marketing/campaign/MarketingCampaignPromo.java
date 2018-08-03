package org.apache.ofbiz.marketing.campaign;

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
public class MarketingCampaignPromo implements Serializable {

	public static final long serialVersionUID = 5094528690645396480L;
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

	public enum Fields {
		marketingCampaignId, productPromoId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public MarketingCampaignPromo(GenericValue value) {
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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