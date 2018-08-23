package org.apache.ofbiz.accounting.fixedasset;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Date;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Maint Work Effort
 */
@FieldNameConstants
public class FixedAssetMaintWorkEffort implements Serializable {

	public static final long serialVersionUID = 6682643651475077120L;
	public static final String NAME = "FixedAssetMaintWorkEffort";
	/**
	 * Date Next Service
	 */
	@Getter
	@Setter
	private Timestamp dateNextService;
	/**
	 * Purchase Cost Uom Id
	 */
	@Getter
	@Setter
	private String purchaseCostUomId;
	/**
	 * Production Capacity
	 */
	@Getter
	@Setter
	private BigDecimal productionCapacity;
	/**
	 * Acquire Order Id
	 */
	@Getter
	@Setter
	private String acquireOrderId;
	/**
	 * Located At Location Seq Id
	 */
	@Getter
	@Setter
	private String locatedAtLocationSeqId;
	/**
	 * Actual End Of Life
	 */
	@Getter
	@Setter
	private Date actualEndOfLife;
	/**
	 * Date Last Serviced
	 */
	@Getter
	@Setter
	private Timestamp dateLastServiced;
	/**
	 * Acquire Order Item Seq Id
	 */
	@Getter
	@Setter
	private String acquireOrderItemSeqId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Located At Facility Id
	 */
	@Getter
	@Setter
	private String locatedAtFacilityId;
	/**
	 * Depreciation
	 */
	@Getter
	@Setter
	private BigDecimal depreciation;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Date Acquired
	 */
	@Getter
	@Setter
	private Timestamp dateAcquired;
	/**
	 * Purchase Cost
	 */
	@Getter
	@Setter
	private BigDecimal purchaseCost;
	/**
	 * Serial Number
	 */
	@Getter
	@Setter
	private String serialNumber;
	/**
	 * Fixed Asset Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetTypeId;
	/**
	 * Class Enum Id
	 */
	@Getter
	@Setter
	private String classEnumId;
	/**
	 * Fixed Asset Name
	 */
	@Getter
	@Setter
	private String fixedAssetName;
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
	 * Salvage Value
	 */
	@Getter
	@Setter
	private BigDecimal salvageValue;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Parent Fixed Asset Id
	 */
	@Getter
	@Setter
	private String parentFixedAssetId;
	/**
	 * Expected End Of Life
	 */
	@Getter
	@Setter
	private Date expectedEndOfLife;
	/**
	 * Instance Of Product Id
	 */
	@Getter
	@Setter
	private String instanceOfProductId;
	/**
	 * Schedule Work Effort Id
	 */
	@Getter
	@Setter
	private String scheduleWorkEffortId;
	/**
	 * Maint Hist Seq Id
	 */
	@Getter
	@Setter
	private String maintHistSeqId;
	/**
	 * Product Maint Type Id
	 */
	@Getter
	@Setter
	private String productMaintTypeId;
	/**
	 * Interval Meter Type Id
	 */
	@Getter
	@Setter
	private String intervalMeterTypeId;
	/**
	 * Product Maint Seq Id
	 */
	@Getter
	@Setter
	private String productMaintSeqId;
	/**
	 * Interval Uom Id
	 */
	@Getter
	@Setter
	private String intervalUomId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Purchase Order Id
	 */
	@Getter
	@Setter
	private String purchaseOrderId;
	/**
	 * Interval Quantity
	 */
	@Getter
	@Setter
	private BigDecimal intervalQuantity;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
	/**
	 * Work Effort Type Id
	 */
	@Getter
	@Setter
	private String workEffortTypeId;
	/**
	 * Reserv Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservPersons;
	/**
	 * Revision Number
	 */
	@Getter
	@Setter
	private Long revisionNumber;
	/**
	 * Temp Expr Id
	 */
	@Getter
	@Setter
	private String tempExprId;
	/**
	 * Show As Enum Id
	 */
	@Getter
	@Setter
	private String showAsEnumId;
	/**
	 * Info Url
	 */
	@Getter
	@Setter
	private String infoUrl;
	/**
	 * Universal Id
	 */
	@Getter
	@Setter
	private String universalId;
	/**
	 * Location Desc
	 */
	@Getter
	@Setter
	private String locationDesc;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Actual Milli Seconds
	 */
	@Getter
	@Setter
	private Double actualMilliSeconds;
	/**
	 * Quantity To Produce
	 */
	@Getter
	@Setter
	private BigDecimal quantityToProduce;
	/**
	 * Work Effort Purpose Type Id
	 */
	@Getter
	@Setter
	private String workEffortPurposeTypeId;
	/**
	 * Service Loader Name
	 */
	@Getter
	@Setter
	private String serviceLoaderName;
	/**
	 * Accommodation Spot Id
	 */
	@Getter
	@Setter
	private String accommodationSpotId;
	/**
	 * Estimated Start Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedStartDate;
	/**
	 * Send Notification Email
	 */
	@Getter
	@Setter
	private String sendNotificationEmail;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;
	/**
	 * Quantity Rejected
	 */
	@Getter
	@Setter
	private BigDecimal quantityRejected;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;
	/**
	 * Current Status Id
	 */
	@Getter
	@Setter
	private String currentStatusId;
	/**
	 * Runtime Data Id
	 */
	@Getter
	@Setter
	private String runtimeDataId;
	/**
	 * Estimated Milli Seconds
	 */
	@Getter
	@Setter
	private Double estimatedMilliSeconds;
	/**
	 * Special Terms
	 */
	@Getter
	@Setter
	private String specialTerms;
	/**
	 * Time Transparency
	 */
	@Getter
	@Setter
	private Long timeTransparency;
	/**
	 * Actual Completion Date
	 */
	@Getter
	@Setter
	private Timestamp actualCompletionDate;
	/**
	 * Reserv 2 Nd Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reserv2ndPPPerc;
	/**
	 * Total Money Allowed
	 */
	@Getter
	@Setter
	private BigDecimal totalMoneyAllowed;
	/**
	 * Estimate Calc Method
	 */
	@Getter
	@Setter
	private String estimateCalcMethod;
	/**
	 * Work Effort Parent Id
	 */
	@Getter
	@Setter
	private String workEffortParentId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Money Uom Id
	 */
	@Getter
	@Setter
	private String moneyUomId;
	/**
	 * Reserv Nth Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reservNthPPPerc;
	/**
	 * Work Effort Name
	 */
	@Getter
	@Setter
	private String workEffortName;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Accommodation Map Id
	 */
	@Getter
	@Setter
	private String accommodationMapId;
	/**
	 * Actual Start Date
	 */
	@Getter
	@Setter
	private Timestamp actualStartDate;
	/**
	 * Scope Enum Id
	 */
	@Getter
	@Setter
	private String scopeEnumId;
	/**
	 * Quantity Produced
	 */
	@Getter
	@Setter
	private BigDecimal quantityProduced;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Estimated Setup Millis
	 */
	@Getter
	@Setter
	private Double estimatedSetupMillis;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Source Reference Id
	 */
	@Getter
	@Setter
	private String sourceReferenceId;
	/**
	 * Last Status Update
	 */
	@Getter
	@Setter
	private Timestamp lastStatusUpdate;
	/**
	 * Percent Complete
	 */
	@Getter
	@Setter
	private Long percentComplete;
	/**
	 * Total Milli Seconds Allowed
	 */
	@Getter
	@Setter
	private Double totalMilliSecondsAllowed;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Actual Setup Millis
	 */
	@Getter
	@Setter
	private Double actualSetupMillis;
	/**
	 * Estimated Completion Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedCompletionDate;

	public FixedAssetMaintWorkEffort(GenericValue value) {
		dateNextService = (Timestamp) value.get(FIELD_DATE_NEXT_SERVICE);
		purchaseCostUomId = (String) value.get(FIELD_PURCHASE_COST_UOM_ID);
		productionCapacity = (BigDecimal) value.get(FIELD_PRODUCTION_CAPACITY);
		acquireOrderId = (String) value.get(FIELD_ACQUIRE_ORDER_ID);
		locatedAtLocationSeqId = (String) value
				.get(FIELD_LOCATED_AT_LOCATION_SEQ_ID);
		actualEndOfLife = (Date) value.get(FIELD_ACTUAL_END_OF_LIFE);
		dateLastServiced = (Timestamp) value.get(FIELD_DATE_LAST_SERVICED);
		acquireOrderItemSeqId = (String) value
				.get(FIELD_ACQUIRE_ORDER_ITEM_SEQ_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		locatedAtFacilityId = (String) value.get(FIELD_LOCATED_AT_FACILITY_ID);
		depreciation = (BigDecimal) value.get(FIELD_DEPRECIATION);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		dateAcquired = (Timestamp) value.get(FIELD_DATE_ACQUIRED);
		purchaseCost = (BigDecimal) value.get(FIELD_PURCHASE_COST);
		serialNumber = (String) value.get(FIELD_SERIAL_NUMBER);
		fixedAssetTypeId = (String) value.get(FIELD_FIXED_ASSET_TYPE_ID);
		classEnumId = (String) value.get(FIELD_CLASS_ENUM_ID);
		fixedAssetName = (String) value.get(FIELD_FIXED_ASSET_NAME);
		uomId = (String) value.get(FIELD_UOM_ID);
		calendarId = (String) value.get(FIELD_CALENDAR_ID);
		salvageValue = (BigDecimal) value.get(FIELD_SALVAGE_VALUE);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		parentFixedAssetId = (String) value.get(FIELD_PARENT_FIXED_ASSET_ID);
		expectedEndOfLife = (Date) value.get(FIELD_EXPECTED_END_OF_LIFE);
		instanceOfProductId = (String) value.get(FIELD_INSTANCE_OF_PRODUCT_ID);
		scheduleWorkEffortId = (String) value
				.get(FIELD_SCHEDULE_WORK_EFFORT_ID);
		maintHistSeqId = (String) value.get(FIELD_MAINT_HIST_SEQ_ID);
		productMaintTypeId = (String) value.get(FIELD_PRODUCT_MAINT_TYPE_ID);
		intervalMeterTypeId = (String) value.get(FIELD_INTERVAL_METER_TYPE_ID);
		productMaintSeqId = (String) value.get(FIELD_PRODUCT_MAINT_SEQ_ID);
		intervalUomId = (String) value.get(FIELD_INTERVAL_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		purchaseOrderId = (String) value.get(FIELD_PURCHASE_ORDER_ID);
		intervalQuantity = (BigDecimal) value.get(FIELD_INTERVAL_QUANTITY);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		recurrenceInfoId = (String) value.get(FIELD_RECURRENCE_INFO_ID);
		workEffortTypeId = (String) value.get(FIELD_WORK_EFFORT_TYPE_ID);
		reservPersons = (BigDecimal) value.get(FIELD_RESERV_PERSONS);
		revisionNumber = (Long) value.get(FIELD_REVISION_NUMBER);
		tempExprId = (String) value.get(FIELD_TEMP_EXPR_ID);
		showAsEnumId = (String) value.get(FIELD_SHOW_AS_ENUM_ID);
		infoUrl = (String) value.get(FIELD_INFO_URL);
		universalId = (String) value.get(FIELD_UNIVERSAL_ID);
		locationDesc = (String) value.get(FIELD_LOCATION_DESC);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		actualMilliSeconds = (Double) value.get(FIELD_ACTUAL_MILLI_SECONDS);
		quantityToProduce = (BigDecimal) value.get(FIELD_QUANTITY_TO_PRODUCE);
		workEffortPurposeTypeId = (String) value
				.get(FIELD_WORK_EFFORT_PURPOSE_TYPE_ID);
		serviceLoaderName = (String) value.get(FIELD_SERVICE_LOADER_NAME);
		accommodationSpotId = (String) value.get(FIELD_ACCOMMODATION_SPOT_ID);
		estimatedStartDate = (Timestamp) value.get(FIELD_ESTIMATED_START_DATE);
		sendNotificationEmail = (String) value
				.get(FIELD_SEND_NOTIFICATION_EMAIL);
		noteId = (String) value.get(FIELD_NOTE_ID);
		quantityRejected = (BigDecimal) value.get(FIELD_QUANTITY_REJECTED);
		priority = (Long) value.get(FIELD_PRIORITY);
		currentStatusId = (String) value.get(FIELD_CURRENT_STATUS_ID);
		runtimeDataId = (String) value.get(FIELD_RUNTIME_DATA_ID);
		estimatedMilliSeconds = (Double) value
				.get(FIELD_ESTIMATED_MILLI_SECONDS);
		specialTerms = (String) value.get(FIELD_SPECIAL_TERMS);
		timeTransparency = (Long) value.get(FIELD_TIME_TRANSPARENCY);
		actualCompletionDate = (Timestamp) value
				.get(FIELD_ACTUAL_COMPLETION_DATE);
		reserv2ndPPPerc = (BigDecimal) value.get(FIELD_RESERV2ND_P_P_PERC);
		totalMoneyAllowed = (BigDecimal) value.get(FIELD_TOTAL_MONEY_ALLOWED);
		estimateCalcMethod = (String) value.get(FIELD_ESTIMATE_CALC_METHOD);
		workEffortParentId = (String) value.get(FIELD_WORK_EFFORT_PARENT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		moneyUomId = (String) value.get(FIELD_MONEY_UOM_ID);
		reservNthPPPerc = (BigDecimal) value.get(FIELD_RESERV_NTH_P_P_PERC);
		workEffortName = (String) value.get(FIELD_WORK_EFFORT_NAME);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		accommodationMapId = (String) value.get(FIELD_ACCOMMODATION_MAP_ID);
		actualStartDate = (Timestamp) value.get(FIELD_ACTUAL_START_DATE);
		scopeEnumId = (String) value.get(FIELD_SCOPE_ENUM_ID);
		quantityProduced = (BigDecimal) value.get(FIELD_QUANTITY_PRODUCED);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		estimatedSetupMillis = (Double) value.get(FIELD_ESTIMATED_SETUP_MILLIS);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		sourceReferenceId = (String) value.get(FIELD_SOURCE_REFERENCE_ID);
		lastStatusUpdate = (Timestamp) value.get(FIELD_LAST_STATUS_UPDATE);
		percentComplete = (Long) value.get(FIELD_PERCENT_COMPLETE);
		totalMilliSecondsAllowed = (Double) value
				.get(FIELD_TOTAL_MILLI_SECONDS_ALLOWED);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		actualSetupMillis = (Double) value.get(FIELD_ACTUAL_SETUP_MILLIS);
		estimatedCompletionDate = (Timestamp) value
				.get(FIELD_ESTIMATED_COMPLETION_DATE);
	}

	public static FixedAssetMaintWorkEffort fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetMaintWorkEffort(value);
	}

	public static List<FixedAssetMaintWorkEffort> fromValues(
			List<GenericValue> values) {
		List<FixedAssetMaintWorkEffort> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetMaintWorkEffort(value));
		}
		return entities;
	}
}