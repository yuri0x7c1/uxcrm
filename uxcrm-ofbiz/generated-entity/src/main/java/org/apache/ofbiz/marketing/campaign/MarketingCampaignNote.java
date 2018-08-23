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
 * Marketing Campaign Note
 */
@FieldNameConstants
public class MarketingCampaignNote implements Serializable {

	public static final long serialVersionUID = 3641098626425397248L;
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

	public MarketingCampaignNote(GenericValue value) {
		marketingCampaignId = (String) value.get(FIELD_MARKETING_CAMPAIGN_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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