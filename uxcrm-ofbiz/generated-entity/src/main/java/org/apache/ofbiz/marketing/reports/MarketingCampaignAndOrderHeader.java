package org.apache.ofbiz.marketing.reports;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Marketing Campaign And Order Header
 */
@FieldNameConstants
public class MarketingCampaignAndOrderHeader implements Serializable {

	public static final long serialVersionUID = 1953499587487226880L;
	public static final String NAME = "MarketingCampaignAndOrderHeader";
	/**
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private Long orderId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;

	public MarketingCampaignAndOrderHeader(GenericValue value) {
		grandTotal = (BigDecimal) value.get(FIELD_GRAND_TOTAL);
		orderId = (Long) value.get(FIELD_ORDER_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		marketingCampaignId = (String) value.get(FIELD_MARKETING_CAMPAIGN_ID);
	}

	public static MarketingCampaignAndOrderHeader fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MarketingCampaignAndOrderHeader(value);
	}

	public static List<MarketingCampaignAndOrderHeader> fromValues(
			List<GenericValue> values) {
		List<MarketingCampaignAndOrderHeader> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MarketingCampaignAndOrderHeader(value));
		}
		return entities;
	}
}