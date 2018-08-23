package org.apache.ofbiz.accounting.fixedasset;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.sql.Date;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset
 */
@FieldNameConstants
public class FixedAsset implements Serializable {

	public static final long serialVersionUID = 1386733737949257728L;
	public static final String NAME = "FixedAsset";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Fixed Asset Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetTypeId;
	/**
	 * Parent Fixed Asset Id
	 */
	@Getter
	@Setter
	private String parentFixedAssetId;
	/**
	 * Instance Of Product Id
	 */
	@Getter
	@Setter
	private String instanceOfProductId;
	/**
	 * Class Enum Id
	 */
	@Getter
	@Setter
	private String classEnumId;
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
	 * Fixed Asset Name
	 */
	@Getter
	@Setter
	private String fixedAssetName;
	/**
	 * Acquire Order Id
	 */
	@Getter
	@Setter
	private String acquireOrderId;
	/**
	 * Acquire Order Item Seq Id
	 */
	@Getter
	@Setter
	private String acquireOrderItemSeqId;
	/**
	 * Date Acquired
	 */
	@Getter
	@Setter
	private Timestamp dateAcquired;
	/**
	 * Date Last Serviced
	 */
	@Getter
	@Setter
	private Timestamp dateLastServiced;
	/**
	 * Date Next Service
	 */
	@Getter
	@Setter
	private Timestamp dateNextService;
	/**
	 * Expected End Of Life
	 */
	@Getter
	@Setter
	private Date expectedEndOfLife;
	/**
	 * Actual End Of Life
	 */
	@Getter
	@Setter
	private Date actualEndOfLife;
	/**
	 * Production Capacity
	 */
	@Getter
	@Setter
	private BigDecimal productionCapacity;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Calendar Id
	 */
	@Getter
	@Setter
	private String calendarId;
	/**
	 * Serial Number
	 */
	@Getter
	@Setter
	private String serialNumber;
	/**
	 * Located At Facility Id
	 */
	@Getter
	@Setter
	private String locatedAtFacilityId;
	/**
	 * Located At Location Seq Id
	 */
	@Getter
	@Setter
	private String locatedAtLocationSeqId;
	/**
	 * Salvage Value
	 */
	@Getter
	@Setter
	private BigDecimal salvageValue;
	/**
	 * Depreciation
	 */
	@Getter
	@Setter
	private BigDecimal depreciation;
	/**
	 * Purchase Cost
	 */
	@Getter
	@Setter
	private BigDecimal purchaseCost;
	/**
	 * Purchase Cost Uom Id
	 */
	@Getter
	@Setter
	private String purchaseCostUomId;
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

	public FixedAsset(GenericValue value) {
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		fixedAssetTypeId = (String) value.get(FIELD_FIXED_ASSET_TYPE_ID);
		parentFixedAssetId = (String) value.get(FIELD_PARENT_FIXED_ASSET_ID);
		instanceOfProductId = (String) value.get(FIELD_INSTANCE_OF_PRODUCT_ID);
		classEnumId = (String) value.get(FIELD_CLASS_ENUM_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		fixedAssetName = (String) value.get(FIELD_FIXED_ASSET_NAME);
		acquireOrderId = (String) value.get(FIELD_ACQUIRE_ORDER_ID);
		acquireOrderItemSeqId = (String) value
				.get(FIELD_ACQUIRE_ORDER_ITEM_SEQ_ID);
		dateAcquired = (Timestamp) value.get(FIELD_DATE_ACQUIRED);
		dateLastServiced = (Timestamp) value.get(FIELD_DATE_LAST_SERVICED);
		dateNextService = (Timestamp) value.get(FIELD_DATE_NEXT_SERVICE);
		expectedEndOfLife = (Date) value.get(FIELD_EXPECTED_END_OF_LIFE);
		actualEndOfLife = (Date) value.get(FIELD_ACTUAL_END_OF_LIFE);
		productionCapacity = (BigDecimal) value.get(FIELD_PRODUCTION_CAPACITY);
		uomId = (String) value.get(FIELD_UOM_ID);
		calendarId = (String) value.get(FIELD_CALENDAR_ID);
		serialNumber = (String) value.get(FIELD_SERIAL_NUMBER);
		locatedAtFacilityId = (String) value.get(FIELD_LOCATED_AT_FACILITY_ID);
		locatedAtLocationSeqId = (String) value
				.get(FIELD_LOCATED_AT_LOCATION_SEQ_ID);
		salvageValue = (BigDecimal) value.get(FIELD_SALVAGE_VALUE);
		depreciation = (BigDecimal) value.get(FIELD_DEPRECIATION);
		purchaseCost = (BigDecimal) value.get(FIELD_PURCHASE_COST);
		purchaseCostUomId = (String) value.get(FIELD_PURCHASE_COST_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FixedAsset fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAsset(value);
	}

	public static List<FixedAsset> fromValues(List<GenericValue> values) {
		List<FixedAsset> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAsset(value));
		}
		return entities;
	}
}