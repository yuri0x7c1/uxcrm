package org.apache.ofbiz.scrum.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Project Sprint Backlog And Task
 */
public class ProjectSprintBacklogAndTask implements Serializable {

	public static final long serialVersionUID = 1967674376187948032L;
	public static final String NAME = "ProjectSprintBacklogAndTask";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Work Effort Type Id
	 */
	@Getter
	@Setter
	private String workEffortTypeId;
	/**
	 * Current Status Id
	 */
	@Getter
	@Setter
	private String currentStatusId;
	/**
	 * Last Status Update
	 */
	@Getter
	@Setter
	private Timestamp lastStatusUpdate;
	/**
	 * Work Effort Purpose Type Id
	 */
	@Getter
	@Setter
	private String workEffortPurposeTypeId;
	/**
	 * Work Effort Parent Id
	 */
	@Getter
	@Setter
	private String workEffortParentId;
	/**
	 * Scope Enum Id
	 */
	@Getter
	@Setter
	private String scopeEnumId;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;
	/**
	 * Percent Complete
	 */
	@Getter
	@Setter
	private Long percentComplete;
	/**
	 * Work Effort Name
	 */
	@Getter
	@Setter
	private String workEffortName;
	/**
	 * Show As Enum Id
	 */
	@Getter
	@Setter
	private String showAsEnumId;
	/**
	 * Send Notification Email
	 */
	@Getter
	@Setter
	private String sendNotificationEmail;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Location Desc
	 */
	@Getter
	@Setter
	private String locationDesc;
	/**
	 * Estimated Start Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedStartDate;
	/**
	 * Estimated Completion Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedCompletionDate;
	/**
	 * Actual Start Date
	 */
	@Getter
	@Setter
	private Timestamp actualStartDate;
	/**
	 * Actual Completion Date
	 */
	@Getter
	@Setter
	private Timestamp actualCompletionDate;
	/**
	 * Estimated Milli Seconds
	 */
	@Getter
	@Setter
	private Double estimatedMilliSeconds;
	/**
	 * Estimated Setup Millis
	 */
	@Getter
	@Setter
	private Double estimatedSetupMillis;
	/**
	 * Estimate Calc Method
	 */
	@Getter
	@Setter
	private String estimateCalcMethod;
	/**
	 * Actual Milli Seconds
	 */
	@Getter
	@Setter
	private Double actualMilliSeconds;
	/**
	 * Actual Setup Millis
	 */
	@Getter
	@Setter
	private Double actualSetupMillis;
	/**
	 * Total Milli Seconds Allowed
	 */
	@Getter
	@Setter
	private Double totalMilliSecondsAllowed;
	/**
	 * Total Money Allowed
	 */
	@Getter
	@Setter
	private BigDecimal totalMoneyAllowed;
	/**
	 * Money Uom Id
	 */
	@Getter
	@Setter
	private String moneyUomId;
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
	 * Universal Id
	 */
	@Getter
	@Setter
	private String universalId;
	/**
	 * Source Reference Id
	 */
	@Getter
	@Setter
	private String sourceReferenceId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Info Url
	 */
	@Getter
	@Setter
	private String infoUrl;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
	/**
	 * Temp Expr Id
	 */
	@Getter
	@Setter
	private String tempExprId;
	/**
	 * Runtime Data Id
	 */
	@Getter
	@Setter
	private String runtimeDataId;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;
	/**
	 * Service Loader Name
	 */
	@Getter
	@Setter
	private String serviceLoaderName;
	/**
	 * Quantity To Produce
	 */
	@Getter
	@Setter
	private BigDecimal quantityToProduce;
	/**
	 * Quantity Produced
	 */
	@Getter
	@Setter
	private BigDecimal quantityProduced;
	/**
	 * Quantity Rejected
	 */
	@Getter
	@Setter
	private BigDecimal quantityRejected;
	/**
	 * Reserv Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservPersons;
	/**
	 * Reserv 2 Nd Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reserv2ndPPPerc;
	/**
	 * Reserv Nth Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reservNthPPPerc;
	/**
	 * Accommodation Map Id
	 */
	@Getter
	@Setter
	private String accommodationMapId;
	/**
	 * Accommodation Spot Id
	 */
	@Getter
	@Setter
	private String accommodationSpotId;
	/**
	 * Revision Number
	 */
	@Getter
	@Setter
	private Long revisionNumber;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Cust Request Type Id
	 */
	@Getter
	@Setter
	private String custRequestTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;

	public enum Fields {
		workEffortId, workEffortTypeId, currentStatusId, lastStatusUpdate, workEffortPurposeTypeId, workEffortParentId, scopeEnumId, priority, percentComplete, workEffortName, showAsEnumId, sendNotificationEmail, description, locationDesc, estimatedStartDate, estimatedCompletionDate, actualStartDate, actualCompletionDate, estimatedMilliSeconds, estimatedSetupMillis, estimateCalcMethod, actualMilliSeconds, actualSetupMillis, totalMilliSecondsAllowed, totalMoneyAllowed, moneyUomId, specialTerms, timeTransparency, universalId, sourceReferenceId, fixedAssetId, facilityId, infoUrl, recurrenceInfoId, tempExprId, runtimeDataId, noteId, serviceLoaderName, quantityToProduce, quantityProduced, quantityRejected, reservPersons, reserv2ndPPPerc, reservNthPPPerc, accommodationMapId, accommodationSpotId, revisionNumber, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, custRequestId, custRequestTypeId, statusId
	}

	public ProjectSprintBacklogAndTask(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		workEffortTypeId = (String) value.get(Fields.workEffortTypeId.name());
		currentStatusId = (String) value.get(Fields.currentStatusId.name());
		lastStatusUpdate = (Timestamp) value
				.get(Fields.lastStatusUpdate.name());
		workEffortPurposeTypeId = (String) value
				.get(Fields.workEffortPurposeTypeId.name());
		workEffortParentId = (String) value.get(Fields.workEffortParentId
				.name());
		scopeEnumId = (String) value.get(Fields.scopeEnumId.name());
		priority = (Long) value.get(Fields.priority.name());
		percentComplete = (Long) value.get(Fields.percentComplete.name());
		workEffortName = (String) value.get(Fields.workEffortName.name());
		showAsEnumId = (String) value.get(Fields.showAsEnumId.name());
		sendNotificationEmail = (String) value.get(Fields.sendNotificationEmail
				.name());
		description = (String) value.get(Fields.description.name());
		locationDesc = (String) value.get(Fields.locationDesc.name());
		estimatedStartDate = (Timestamp) value.get(Fields.estimatedStartDate
				.name());
		estimatedCompletionDate = (Timestamp) value
				.get(Fields.estimatedCompletionDate.name());
		actualStartDate = (Timestamp) value.get(Fields.actualStartDate.name());
		actualCompletionDate = (Timestamp) value
				.get(Fields.actualCompletionDate.name());
		estimatedMilliSeconds = (Double) value.get(Fields.estimatedMilliSeconds
				.name());
		estimatedSetupMillis = (Double) value.get(Fields.estimatedSetupMillis
				.name());
		estimateCalcMethod = (String) value.get(Fields.estimateCalcMethod
				.name());
		actualMilliSeconds = (Double) value.get(Fields.actualMilliSeconds
				.name());
		actualSetupMillis = (Double) value.get(Fields.actualSetupMillis.name());
		totalMilliSecondsAllowed = (Double) value
				.get(Fields.totalMilliSecondsAllowed.name());
		totalMoneyAllowed = (BigDecimal) value.get(Fields.totalMoneyAllowed
				.name());
		moneyUomId = (String) value.get(Fields.moneyUomId.name());
		specialTerms = (String) value.get(Fields.specialTerms.name());
		timeTransparency = (Long) value.get(Fields.timeTransparency.name());
		universalId = (String) value.get(Fields.universalId.name());
		sourceReferenceId = (String) value.get(Fields.sourceReferenceId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		infoUrl = (String) value.get(Fields.infoUrl.name());
		recurrenceInfoId = (String) value.get(Fields.recurrenceInfoId.name());
		tempExprId = (String) value.get(Fields.tempExprId.name());
		runtimeDataId = (String) value.get(Fields.runtimeDataId.name());
		noteId = (String) value.get(Fields.noteId.name());
		serviceLoaderName = (String) value.get(Fields.serviceLoaderName.name());
		quantityToProduce = (BigDecimal) value.get(Fields.quantityToProduce
				.name());
		quantityProduced = (BigDecimal) value.get(Fields.quantityProduced
				.name());
		quantityRejected = (BigDecimal) value.get(Fields.quantityRejected
				.name());
		reservPersons = (BigDecimal) value.get(Fields.reservPersons.name());
		reserv2ndPPPerc = (BigDecimal) value.get(Fields.reserv2ndPPPerc.name());
		reservNthPPPerc = (BigDecimal) value.get(Fields.reservNthPPPerc.name());
		accommodationMapId = (String) value.get(Fields.accommodationMapId
				.name());
		accommodationSpotId = (String) value.get(Fields.accommodationSpotId
				.name());
		revisionNumber = (Long) value.get(Fields.revisionNumber.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
	}

	public static ProjectSprintBacklogAndTask fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProjectSprintBacklogAndTask(value);
	}

	public static List<ProjectSprintBacklogAndTask> fromValues(
			List<GenericValue> values) {
		List<ProjectSprintBacklogAndTask> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProjectSprintBacklogAndTask(value));
		}
		return entities;
	}
}