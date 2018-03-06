package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Average Cost
 */
public class ProductAverageCost implements Serializable {

	public static final long serialVersionUID = 249473739885984768L;
	public static final String NAME = "ProductAverageCost";
	/**
	 * Product Average Cost Type Id
	 */
	@Getter
	@Setter
	private String productAverageCostTypeId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Average Cost
	 */
	@Getter
	@Setter
	private BigDecimal averageCost;

	public enum Fields {
		productAverageCostTypeId, organizationPartyId, productId, facilityId, fromDate, thruDate, averageCost
	}

	public ProductAverageCost(GenericValue value) {
		productAverageCostTypeId = (String) value
				.get(Fields.productAverageCostTypeId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		averageCost = (BigDecimal) value.get(Fields.averageCost.name());
	}

	public static ProductAverageCost fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductAverageCost(value);
	}

	public static List<ProductAverageCost> fromValues(List<GenericValue> values) {
		List<ProductAverageCost> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductAverageCost(value));
		}
		return entities;
	}
}