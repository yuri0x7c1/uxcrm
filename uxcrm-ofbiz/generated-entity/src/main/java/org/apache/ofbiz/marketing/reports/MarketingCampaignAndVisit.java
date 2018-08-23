package org.apache.ofbiz.marketing.reports;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class MarketingCampaignAndVisit implements Serializable {

	public static final long serialVersionUID = 3204997387837136896L;
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

	public MarketingCampaignAndVisit(GenericValue value) {
		marketingCampaignId = (String) value.get(FIELD_MARKETING_CAMPAIGN_ID);
		visitId = (Long) value.get(FIELD_VISIT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
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