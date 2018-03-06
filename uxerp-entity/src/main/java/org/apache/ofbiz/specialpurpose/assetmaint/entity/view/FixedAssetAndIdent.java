package org.apache.ofbiz.specialpurpose.assetmaint.entity.view;

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
 * Fixed Asset And Ident
 */
public class FixedAssetAndIdent implements Serializable {

	public static final long serialVersionUID = 8851945742114010112L;
	public static final String NAME = "FixedAssetAndIdent";
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
	 * Fixed Asset Ident Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetIdentTypeId;
	/**
	 * Id Value
	 */
	@Getter
	@Setter
	private String idValue;

	public enum Fields {
		fixedAssetId, fixedAssetTypeId, parentFixedAssetId, instanceOfProductId, classEnumId, partyId, roleTypeId, fixedAssetName, acquireOrderId, acquireOrderItemSeqId, dateAcquired, dateLastServiced, dateNextService, expectedEndOfLife, actualEndOfLife, productionCapacity, uomId, calendarId, serialNumber, locatedAtFacilityId, locatedAtLocationSeqId, salvageValue, depreciation, purchaseCost, purchaseCostUomId, fixedAssetIdentTypeId, idValue
	}

	public FixedAssetAndIdent(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		fixedAssetTypeId = (String) value.get(Fields.fixedAssetTypeId.name());
		parentFixedAssetId = (String) value.get(Fields.parentFixedAssetId
				.name());
		instanceOfProductId = (String) value.get(Fields.instanceOfProductId
				.name());
		classEnumId = (String) value.get(Fields.classEnumId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fixedAssetName = (String) value.get(Fields.fixedAssetName.name());
		acquireOrderId = (String) value.get(Fields.acquireOrderId.name());
		acquireOrderItemSeqId = (String) value.get(Fields.acquireOrderItemSeqId
				.name());
		dateAcquired = (Timestamp) value.get(Fields.dateAcquired.name());
		dateLastServiced = (Timestamp) value
				.get(Fields.dateLastServiced.name());
		dateNextService = (Timestamp) value.get(Fields.dateNextService.name());
		expectedEndOfLife = (Date) value.get(Fields.expectedEndOfLife.name());
		actualEndOfLife = (Date) value.get(Fields.actualEndOfLife.name());
		productionCapacity = (BigDecimal) value.get(Fields.productionCapacity
				.name());
		uomId = (String) value.get(Fields.uomId.name());
		calendarId = (String) value.get(Fields.calendarId.name());
		serialNumber = (String) value.get(Fields.serialNumber.name());
		locatedAtFacilityId = (String) value.get(Fields.locatedAtFacilityId
				.name());
		locatedAtLocationSeqId = (String) value
				.get(Fields.locatedAtLocationSeqId.name());
		salvageValue = (BigDecimal) value.get(Fields.salvageValue.name());
		depreciation = (BigDecimal) value.get(Fields.depreciation.name());
		purchaseCost = (BigDecimal) value.get(Fields.purchaseCost.name());
		purchaseCostUomId = (String) value.get(Fields.purchaseCostUomId.name());
		fixedAssetIdentTypeId = (String) value.get(Fields.fixedAssetIdentTypeId
				.name());
		idValue = (String) value.get(Fields.idValue.name());
	}

	public static FixedAssetAndIdent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetAndIdent(value);
	}

	public static List<FixedAssetAndIdent> fromValues(List<GenericValue> values) {
		List<FixedAssetAndIdent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetAndIdent(value));
		}
		return entities;
	}
}