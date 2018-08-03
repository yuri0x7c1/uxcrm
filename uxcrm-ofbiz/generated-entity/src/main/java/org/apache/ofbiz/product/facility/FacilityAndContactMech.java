package org.apache.ofbiz.product.facility;

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
public class FacilityAndContactMech implements Serializable {

	public static final long serialVersionUID = 8231343129684483072L;
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

	public enum Fields {
		facilityId, defaultInventoryItemTypeId, parentFacilityId, description, defaultWeightUomId, primaryFacilityGroupId, openedDate, ownerPartyId, facilitySize, facilitySizeUomId, closedDate, facilityTypeId, defaultDaysToShip, defaultDimensionUomId, facilityName, productStoreId, geoPointId, oldSquareFootage, fromDate, extension, comments, contactMechId, thruDate, infoString, contactMechTypeId
	}

	public FacilityAndContactMech(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		defaultInventoryItemTypeId = (String) value
				.get(Fields.defaultInventoryItemTypeId.name());
		parentFacilityId = (String) value.get(Fields.parentFacilityId.name());
		description = (String) value.get(Fields.description.name());
		defaultWeightUomId = (String) value.get(Fields.defaultWeightUomId
				.name());
		primaryFacilityGroupId = (String) value
				.get(Fields.primaryFacilityGroupId.name());
		openedDate = (Timestamp) value.get(Fields.openedDate.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		facilitySize = (BigDecimal) value.get(Fields.facilitySize.name());
		facilitySizeUomId = (String) value.get(Fields.facilitySizeUomId.name());
		closedDate = (Timestamp) value.get(Fields.closedDate.name());
		facilityTypeId = (String) value.get(Fields.facilityTypeId.name());
		defaultDaysToShip = (Long) value.get(Fields.defaultDaysToShip.name());
		defaultDimensionUomId = (String) value.get(Fields.defaultDimensionUomId
				.name());
		facilityName = (String) value.get(Fields.facilityName.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		oldSquareFootage = (Long) value.get(Fields.oldSquareFootage.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		extension = (String) value.get(Fields.extension.name());
		comments = (String) value.get(Fields.comments.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		infoString = (String) value.get(Fields.infoString.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
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