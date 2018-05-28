package org.apache.ofbiz.marketing.reports;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Marketing Campaign And Visit
 */
public class MarketingCampaignAndVisit implements Serializable {

	public static final long serialVersionUID = 2371725878920593408L;
	public static final String NAME = "MarketingCampaignAndVisit";
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private Long visitId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;

	public enum Fields {
		marketingCampaignId, visitId, fromDate
	}

	public MarketingCampaignAndVisit(GenericValue value) {
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		visitId = (Long) value.get(Fields.visitId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
	}

	public static MarketingCampaignAndVisit fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MarketingCampaignAndVisit(value);
	}

	public static List<MarketingCampaignAndVisit> fromValues(
			List<GenericValue> values) {
		List<MarketingCampaignAndVisit> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MarketingCampaignAndVisit(value));
		}
		return entities;
	}
}