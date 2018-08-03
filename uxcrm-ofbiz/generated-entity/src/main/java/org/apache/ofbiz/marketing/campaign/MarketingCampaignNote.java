package org.apache.ofbiz.marketing.campaign;

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
public class MarketingCampaignNote implements Serializable {

	public static final long serialVersionUID = 5762596336249102336L;
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

	public enum Fields {
		marketingCampaignId, noteId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public MarketingCampaignNote(GenericValue value) {
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		noteId = (String) value.get(Fields.noteId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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