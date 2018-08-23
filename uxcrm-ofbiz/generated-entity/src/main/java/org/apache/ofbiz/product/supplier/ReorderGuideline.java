package org.apache.ofbiz.product.supplier;

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
 * Reorder Guideline
 */
@FieldNameConstants
public class ReorderGuideline implements Serializable {

	public static final long serialVersionUID = 5361882344205791232L;
	public static final String NAME = "ReorderGuideline";
	/**
	 * Reorder Guideline Id
	 */
	@Getter
	@Setter
	private String reorderGuidelineId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
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
	 * Reorder Quantity
	 */
	@Getter
	@Setter
	private BigDecimal reorderQuantity;
	/**
	 * Reorder Level
	 */
	@Getter
	@Setter
	private BigDecimal reorderLevel;
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

	public ReorderGuideline(GenericValue value) {
		reorderGuidelineId = (String) value.get(FIELD_REORDER_GUIDELINE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		reorderQuantity = (BigDecimal) value.get(FIELD_REORDER_QUANTITY);
		reorderLevel = (BigDecimal) value.get(FIELD_REORDER_LEVEL);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReorderGuideline fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReorderGuideline(value);
	}

	public static List<ReorderGuideline> fromValues(List<GenericValue> values) {
		List<ReorderGuideline> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReorderGuideline(value));
		}
		return entities;
	}
}