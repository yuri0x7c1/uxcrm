package org.apache.ofbiz.product.facility;

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
 * Facility And Contact Mech
 */
@FieldNameConstants
public class FacilityAndContactMech implements Serializable {

	public static final long serialVersionUID = 570726629911262208L;
	public static final String NAME = "FacilityAndContactMech";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Default Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String defaultInventoryItemTypeId;
	/**
	 * Parent Facility Id
	 */
	@Getter
	@Setter
	private String parentFacilityId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Default Weight Uom Id
	 */
	@Getter
	@Setter
	private String defaultWeightUomId;
	/**
	 * Primary Facility Group Id
	 */
	@Getter
	@Setter
	private String primaryFacilityGroupId;
	/**
	 * Opened Date
	 */
	@Getter
	@Setter
	private Timestamp openedDate;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
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
	 * Closed Date
	 */
	@Getter
	@Setter
	private Timestamp closedDate;
	/**
	 * Facility Type Id
	 */
	@Getter
	@Setter
	private String facilityTypeId;
	/**
	 * Default Days To Ship
	 */
	@Getter
	@Setter
	private Long defaultDaysToShip;
	/**
	 * Default Dimension Uom Id
	 */
	@Getter
	@Setter
	private String defaultDimensionUomId;
	/**
	 * Facility Name
	 */
	@Getter
	@Setter
	private String facilityName;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;
	/**
	 * Old Square Footage
	 */
	@Getter
	@Setter
	private Long oldSquareFootage;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Info String
	 */
	@Getter
	@Setter
	private String infoString;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;

	public FacilityAndContactMech(GenericValue value) {
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		defaultInventoryItemTypeId = (String) value
				.get(FIELD_DEFAULT_INVENTORY_ITEM_TYPE_ID);
		parentFacilityId = (String) value.get(FIELD_PARENT_FACILITY_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		defaultWeightUomId = (String) value.get(FIELD_DEFAULT_WEIGHT_UOM_ID);
		primaryFacilityGroupId = (String) value
				.get(FIELD_PRIMARY_FACILITY_GROUP_ID);
		openedDate = (Timestamp) value.get(FIELD_OPENED_DATE);
		ownerPartyId = (String) value.get(FIELD_OWNER_PARTY_ID);
		facilitySize = (BigDecimal) value.get(FIELD_FACILITY_SIZE);
		facilitySizeUomId = (String) value.get(FIELD_FACILITY_SIZE_UOM_ID);
		closedDate = (Timestamp) value.get(FIELD_CLOSED_DATE);
		facilityTypeId = (String) value.get(FIELD_FACILITY_TYPE_ID);
		defaultDaysToShip = (Long) value.get(FIELD_DEFAULT_DAYS_TO_SHIP);
		defaultDimensionUomId = (String) value
				.get(FIELD_DEFAULT_DIMENSION_UOM_ID);
		facilityName = (String) value.get(FIELD_FACILITY_NAME);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		oldSquareFootage = (Long) value.get(FIELD_OLD_SQUARE_FOOTAGE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		extension = (String) value.get(FIELD_EXTENSION);
		comments = (String) value.get(FIELD_COMMENTS);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		infoString = (String) value.get(FIELD_INFO_STRING);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
	}

	public static FacilityAndContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityAndContactMech(value);
	}

	public static List<FacilityAndContactMech> fromValues(
			List<GenericValue> values) {
		List<FacilityAndContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityAndContactMech(value));
		}
		return entities;
	}
}