package org.apache.ofbiz.product.facility;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class Facility implements Serializable {

	public static final long serialVersionUID = 3643945833796747264L;
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

	public Facility(GenericValue value) {
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		facilityTypeId = (String) value.get(FIELD_FACILITY_TYPE_ID);
		parentFacilityId = (String) value.get(FIELD_PARENT_FACILITY_ID);
		ownerPartyId = (String) value.get(FIELD_OWNER_PARTY_ID);
		defaultInventoryItemTypeId = (String) value
				.get(FIELD_DEFAULT_INVENTORY_ITEM_TYPE_ID);
		facilityName = (String) value.get(FIELD_FACILITY_NAME);
		primaryFacilityGroupId = (String) value
				.get(FIELD_PRIMARY_FACILITY_GROUP_ID);
		oldSquareFootage = (Long) value.get(FIELD_OLD_SQUARE_FOOTAGE);
		facilitySize = (BigDecimal) value.get(FIELD_FACILITY_SIZE);
		facilitySizeUomId = (String) value.get(FIELD_FACILITY_SIZE_UOM_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		defaultDaysToShip = (Long) value.get(FIELD_DEFAULT_DAYS_TO_SHIP);
		openedDate = (Timestamp) value.get(FIELD_OPENED_DATE);
		closedDate = (Timestamp) value.get(FIELD_CLOSED_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		defaultDimensionUomId = (String) value
				.get(FIELD_DEFAULT_DIMENSION_UOM_ID);
		defaultWeightUomId = (String) value.get(FIELD_DEFAULT_WEIGHT_UOM_ID);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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