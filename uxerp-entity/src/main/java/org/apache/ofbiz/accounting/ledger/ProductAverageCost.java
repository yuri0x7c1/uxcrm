package org.apache.ofbiz.accounting.ledger;

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

	public static final long serialVersionUID = 1841779214505540608L;
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
		productAverageCostTypeId, organizationPartyId, productId, facilityId, fromDate, thruDate, averageCost, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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