package org.apache.ofbiz.product.facility;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility
 */
public class Facility implements Serializable {

	public static final long serialVersionUID = 46220735801729024L;
	public static final String NAME = "Facility";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Facility Type Id
	 */
	@Getter
	@Setter
	private String facilityTypeId;
	/**
	 * Parent Facility Id
	 */
	@Getter
	@Setter
	private String parentFacilityId;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
	/**
	 * Default Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String defaultInventoryItemTypeId;
	/**
	 * Facility Name
	 */
	@Getter
	@Setter
	private String facilityName;
	/**
	 * Primary Facility Group Id
	 */
	@Getter
	@Setter
	private String primaryFacilityGroupId;
	/**
	 * Old Square Footage
	 */
	@Getter
	@Setter
	private Long oldSquareFootage;
	/**
	 * Facility Size
	 */
	@Getter
	@Setter
	private BigDecimal facilitySize;
	/**
	 * Facility Size Uom Id
	 */
	@Getter
	@Setter
	private String facilitySizeUomId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Default Days To Ship
	 */
	@Getter
	@Setter
	private Long defaultDaysToShip;
	/**
	 * Opened Date
	 */
	@Getter
	@Setter
	private Timestamp openedDate;
	/**
	 * Closed Date
	 */
	@Getter
	@Setter
	private Timestamp closedDate;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Default Dimension Uom Id
	 */
	@Getter
	@Setter
	private String defaultDimensionUomId;
	/**
	 * Default Weight Uom Id
	 */
	@Getter
	@Setter
	private String defaultWeightUomId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;
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
		facilityId, facilityTypeId, parentFacilityId, ownerPartyId, defaultInventoryItemTypeId, facilityName, primaryFacilityGroupId, oldSquareFootage, facilitySize, facilitySizeUomId, productStoreId, defaultDaysToShip, openedDate, closedDate, description, defaultDimensionUomId, defaultWeightUomId, geoPointId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Facility(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		facilityTypeId = (String) value.get(Fields.facilityTypeId.name());
		parentFacilityId = (String) value.get(Fields.parentFacilityId.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		defaultInventoryItemTypeId = (String) value
				.get(Fields.defaultInventoryItemTypeId.name());
		facilityName = (String) value.get(Fields.facilityName.name());
		primaryFacilityGroupId = (String) value
				.get(Fields.primaryFacilityGroupId.name());
		oldSquareFootage = (Long) value.get(Fields.oldSquareFootage.name());
		facilitySize = (BigDecimal) value.get(Fields.facilitySize.name());
		facilitySizeUomId = (String) value.get(Fields.facilitySizeUomId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		defaultDaysToShip = (Long) value.get(Fields.defaultDaysToShip.name());
		openedDate = (Timestamp) value.get(Fields.openedDate.name());
		closedDate = (Timestamp) value.get(Fields.closedDate.name());
		description = (String) value.get(Fields.description.name());
		defaultDimensionUomId = (String) value.get(Fields.defaultDimensionUomId
				.name());
		defaultWeightUomId = (String) value.get(Fields.defaultWeightUomId
				.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static Facility fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Facility(value);
	}

	public static List<Facility> fromValues(List<GenericValue> values) {
		List<Facility> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Facility(value));
		}
		return entities;
	}
}