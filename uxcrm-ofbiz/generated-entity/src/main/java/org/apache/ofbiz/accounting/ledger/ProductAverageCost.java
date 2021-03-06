package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductAverageCost implements Serializable {

	public static final long serialVersionUID = 3835340090908821504L;
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

	public ProductAverageCost(GenericValue value) {
		productAverageCostTypeId = (String) value
				.get(FIELD_PRODUCT_AVERAGE_COST_TYPE_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		averageCost = (BigDecimal) value.get(FIELD_AVERAGE_COST);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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