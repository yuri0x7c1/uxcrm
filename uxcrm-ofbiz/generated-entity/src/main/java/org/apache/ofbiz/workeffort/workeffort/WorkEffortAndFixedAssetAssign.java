package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.sql.Date;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort And Fixed Asset Assign
 */
public class WorkEffortAndFixedAssetAssign implements Serializable {

	public static final long serialVersionUID = 7385797294995150848L;
	public static final String NAME = "WorkEffortAndFixedAssetAssign";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Allocated Cost
	 */
	@Getter
	@Setter
	private BigDecimal allocatedCost;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Availability Status Id
	 */
	@Getter
	@Setter
	private String availabilityStatusId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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

	public enum Fields {
		workEffortId, fromDate, comments, statusId, allocatedCost, fixedAssetId, availabilityStatusId, thruDate, recurrenceInfoId, workEffortTypeId, reservPersons, revisionNumber, tempExprId, showAsEnumId, infoUrl, universalId, locationDesc, createdByUserLogin, actualMilliSeconds, quantityToProduce, workEffortPurposeTypeId, serviceLoaderName, accommodationSpotId, estimatedStartDate, sendNotificationEmail, noteId, quantityRejected, priority, currentStatusId, runtimeDataId, estimatedMilliSeconds, specialTerms, timeTransparency, actualCompletionDate, reserv2ndPPPerc, totalMoneyAllowed, estimateCalcMethod, workEffortParentId, description, moneyUomId, reservNthPPPerc, workEffortName, lastModifiedByUserLogin, accommodationMapId, actualStartDate, scopeEnumId, quantityProduced, facilityId, estimatedSetupMillis, lastModifiedDate, sourceReferenceId, lastStatusUpdate, percentComplete, totalMilliSecondsAllowed, createdDate, actualSetupMillis, estimatedCompletionDate, dateNextService, purchaseCostUomId, productionCapacity, acquireOrderId, locatedAtLocationSeqId, actualEndOfLife, dateLastServiced, acquireOrderItemSeqId, partyId, locatedAtFacilityId, depreciation, roleTypeId, dateAcquired, purchaseCost, serialNumber, fixedAssetTypeId, classEnumId, fixedAssetName, uomId, calendarId, salvageValue, parentFixedAssetId, expectedEndOfLife, instanceOfProductId
	}

	public WorkEffortAndFixedAssetAssign(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		comments = (String) value.get(Fields.comments.name());
		statusId = (String) value.get(Fields.statusId.name());
		allocatedCost = (BigDecimal) value.get(Fields.allocatedCost.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		availabilityStatusId = (String) value.get(Fields.availabilityStatusId
				.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		recurrenceInfoId = (String) value.get(Fields.recurrenceInfoId.name());
		workEffortTypeId = (String) value.get(Fields.workEffortTypeId.name());
		reservPersons = (BigDecimal) value.get(Fields.reservPersons.name());
		revisionNumber = (Long) value.get(Fields.revisionNumber.name());
		tempExprId = (String) value.get(Fields.tempExprId.name());
		showAsEnumId = (String) value.get(Fields.showAsEnumId.name());
		infoUrl = (String) value.get(Fields.infoUrl.name());
		universalId = (String) value.get(Fields.universalId.name());
		locationDesc = (String) value.get(Fields.locationDesc.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		actualMilliSeconds = (Double) value.get(Fields.actualMilliSeconds
				.name());
		quantityToProduce = (BigDecimal) value.get(Fields.quantityToProduce
				.name());
		workEffortPurposeTypeId = (String) value
				.get(Fields.workEffortPurposeTypeId.name());
		serviceLoaderName = (String) value.get(Fields.serviceLoaderName.name());
		accommodationSpotId = (String) value.get(Fields.accommodationSpotId
				.name());
		estimatedStartDate = (Timestamp) value.get(Fields.estimatedStartDate
				.name());
		sendNotificationEmail = (String) value.get(Fields.sendNotificationEmail
				.name());
		noteId = (String) value.get(Fields.noteId.name());
		quantityRejected = (BigDecimal) value.get(Fields.quantityRejected
				.name());
		priority = (Long) value.get(Fields.priority.name());
		currentStatusId = (String) value.get(Fields.currentStatusId.name());
		runtimeDataId = (String) value.get(Fields.runtimeDataId.name());
		estimatedMilliSeconds = (Double) value.get(Fields.estimatedMilliSeconds
				.name());
		specialTerms = (String) value.get(Fields.specialTerms.name());
		timeTransparency = (Long) value.get(Fields.timeTransparency.name());
		actualCompletionDate = (Timestamp) value
				.get(Fields.actualCompletionDate.name());
		reserv2ndPPPerc = (BigDecimal) value.get(Fields.reserv2ndPPPerc.name());
		totalMoneyAllowed = (BigDecimal) value.get(Fields.totalMoneyAllowed
				.name());
		estimateCalcMethod = (String) value.get(Fields.estimateCalcMethod
				.name());
		workEffortParentId = (String) value.get(Fields.workEffortParentId
				.name());
		description = (String) value.get(Fields.description.name());
		moneyUomId = (String) value.get(Fields.moneyUomId.name());
		reservNthPPPerc = (BigDecimal) value.get(Fields.reservNthPPPerc.name());
		workEffortName = (String) value.get(Fields.workEffortName.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		accommodationMapId = (String) value.get(Fields.accommodationMapId
				.name());
		actualStartDate = (Timestamp) value.get(Fields.actualStartDate.name());
		scopeEnumId = (String) value.get(Fields.scopeEnumId.name());
		quantityProduced = (BigDecimal) value.get(Fields.quantityProduced
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		estimatedSetupMillis = (Double) value.get(Fields.estimatedSetupMillis
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		sourceReferenceId = (String) value.get(Fields.sourceReferenceId.name());
		lastStatusUpdate = (Timestamp) value
				.get(Fields.lastStatusUpdate.name());
		percentComplete = (Long) value.get(Fields.percentComplete.name());
		totalMilliSecondsAllowed = (Double) value
				.get(Fields.totalMilliSecondsAllowed.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		actualSetupMillis = (Double) value.get(Fields.actualSetupMillis.name());
		estimatedCompletionDate = (Timestamp) value
				.get(Fields.estimatedCompletionDate.name());
		dateNextService = (Timestamp) value.get(Fields.dateNextService.name());
		purchaseCostUomId = (String) value.get(Fields.purchaseCostUomId.name());
		productionCapacity = (BigDecimal) value.get(Fields.productionCapacity
				.name());
		acquireOrderId = (String) value.get(Fields.acquireOrderId.name());
		locatedAtLocationSeqId = (String) value
				.get(Fields.locatedAtLocationSeqId.name());
		actualEndOfLife = (Date) value.get(Fields.actualEndOfLife.name());
		dateLastServiced = (Timestamp) value
				.get(Fields.dateLastServiced.name());
		acquireOrderItemSeqId = (String) value.get(Fields.acquireOrderItemSeqId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		locatedAtFacilityId = (String) value.get(Fields.locatedAtFacilityId
				.name());
		depreciation = (BigDecimal) value.get(Fields.depreciation.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		dateAcquired = (Timestamp) value.get(Fields.dateAcquired.name());
		purchaseCost = (BigDecimal) value.get(Fields.purchaseCost.name());
		serialNumber = (String) value.get(Fields.serialNumber.name());
		fixedAssetTypeId = (String) value.get(Fields.fixedAssetTypeId.name());
		classEnumId = (String) value.get(Fields.classEnumId.name());
		fixedAssetName = (String) value.get(Fields.fixedAssetName.name());
		uomId = (String) value.get(Fields.uomId.name());
		calendarId = (String) value.get(Fields.calendarId.name());
		salvageValue = (BigDecimal) value.get(Fields.salvageValue.name());
		parentFixedAssetId = (String) value.get(Fields.parentFixedAssetId
				.name());
		expectedEndOfLife = (Date) value.get(Fields.expectedEndOfLife.name());
		instanceOfProductId = (String) value.get(Fields.instanceOfProductId
				.name());
	}

	public static WorkEffortAndFixedAssetAssign fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAndFixedAssetAssign(value);
	}

	public static List<WorkEffortAndFixedAssetAssign> fromValues(
			List<GenericValue> values) {
		List<WorkEffortAndFixedAssetAssign> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAndFixedAssetAssign(value));
		}
		return entities;
	}
}