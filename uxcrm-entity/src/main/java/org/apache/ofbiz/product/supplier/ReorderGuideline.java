package org.apache.ofbiz.product.supplier;

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
public class ReorderGuideline implements Serializable {

	public static final long serialVersionUID = 455397515576913920L;
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

	public enum Fields {
		reorderGuidelineId, productId, partyId, roleTypeId, facilityId, geoId, fromDate, thruDate, reorderQuantity, reorderLevel, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ReorderGuideline(GenericValue value) {
		reorderGuidelineId = (String) value.get(Fields.reorderGuidelineId
				.name());
		productId = (String) value.get(Fields.productId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		geoId = (String) value.get(Fields.geoId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		reorderQuantity = (BigDecimal) value.get(Fields.reorderQuantity.name());
		reorderLevel = (BigDecimal) value.get(Fields.reorderLevel.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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