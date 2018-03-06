package org.apache.ofbiz.marketing.reports.entity.view;

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
public class MarketingCampaignAndOrderHeader implements Serializable {

	public static final long serialVersionUID = 6177220549741195264L;
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
	private String orderId;
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

	public enum Fields {
		grandTotal, orderId, orderDate, marketingCampaignId
	}

	public MarketingCampaignAndOrderHeader(GenericValue value) {
		grandTotal = (BigDecimal) value.get(Fields.grandTotal.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
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