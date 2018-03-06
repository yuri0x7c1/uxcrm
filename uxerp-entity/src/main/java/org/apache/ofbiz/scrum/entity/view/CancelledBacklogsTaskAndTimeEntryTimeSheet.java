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
 * Cancelled Backlogs Task And Time Entry Time Sheet
 */
public class CancelledBacklogsTaskAndTimeEntryTimeSheet implements Serializable {

	public static final long serialVersionUID = 1583392519321408512L;
	public static final String NAME = "CancelledBacklogsTaskAndTimeEntryTimeSheet";
	/**
	 * Time Entry Id
	 */
	@Getter
	@Setter
	private String timeEntryId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Timesheet Id
	 */
	@Getter
	@Setter
	private String timesheetId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
	/**
	 * Hours
	 */
	@Getter
	@Setter
	private Double hours;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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
	 * Cust Request Category Id
	 */
	@Getter
	@Setter
	private String custRequestCategoryId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * From Party Id
	 */
	@Getter
	@Setter
	private String fromPartyId;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;
	/**
	 * Cust Request Date
	 */
	@Getter
	@Setter
	private Timestamp custRequestDate;
	/**
	 * Response Required Date
	 */
	@Getter
	@Setter
	private Timestamp responseRequiredDate;
	/**
	 * Cust Request Name
	 */
	@Getter
	@Setter
	private String custRequestName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Maximum Amount Uom Id
	 */
	@Getter
	@Setter
	private String maximumAmountUomId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String salesChannelEnumId;
	/**
	 * Fulfill Contact Mech Id
	 */
	@Getter
	@Setter
	private String fulfillContactMechId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Open Date Time
	 */
	@Getter
	@Setter
	private Timestamp openDateTime;
	/**
	 * Closed Date Time
	 */
	@Getter
	@Setter
	private Timestamp closedDateTime;
	/**
	 * Internal Comment
	 */
	@Getter
	@Setter
	private String internalComment;
	/**
	 * Reason
	 */
	@Getter
	@Setter
	private String reason;
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
	 * Cust Request Item Seq Id
	 */
	@Getter
	@Setter
	private String custRequestItemSeqId;
	/**
	 * Cust Request Resolution Id
	 */
	@Getter
	@Setter
	private String custRequestResolutionId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Required By Date
	 */
	@Getter
	@Setter
	private Timestamp requiredByDate;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Selected Amount
	 */
	@Getter
	@Setter
	private BigDecimal selectedAmount;
	/**
	 * Maximum Amount
	 */
	@Getter
	@Setter
	private BigDecimal maximumAmount;
	/**
	 * Reserv Start
	 */
	@Getter
	@Setter
	private Timestamp reservStart;
	/**
	 * Reserv Length
	 */
	@Getter
	@Setter
	private BigDecimal reservLength;
	/**
	 * Reserv Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservPersons;
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Story
	 */
	@Getter
	@Setter
	private String story;
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

	public enum Fields {
		timeEntryId, partyId, fromDate, thruDate, rateTypeId, workEffortId, timesheetId, invoiceId, invoiceItemSeqId, hours, comments, custRequestId, custRequestTypeId, custRequestCategoryId, statusId, fromPartyId, priority, custRequestDate, responseRequiredDate, custRequestName, description, maximumAmountUomId, productStoreId, salesChannelEnumId, fulfillContactMechId, currencyUomId, openDateTime, closedDateTime, internalComment, reason, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, custRequestItemSeqId, custRequestResolutionId, sequenceNum, requiredByDate, productId, quantity, selectedAmount, maximumAmount, reservStart, reservLength, reservPersons, configId, story, workEffortTypeId, currentStatusId, lastStatusUpdate, workEffortPurposeTypeId, workEffortParentId, scopeEnumId, percentComplete, workEffortName, showAsEnumId, sendNotificationEmail, locationDesc, estimatedStartDate, estimatedCompletionDate, actualStartDate, actualCompletionDate, estimatedMilliSeconds, estimatedSetupMillis, estimateCalcMethod, actualMilliSeconds, actualSetupMillis, totalMilliSecondsAllowed, totalMoneyAllowed, moneyUomId, specialTerms, timeTransparency, universalId, sourceReferenceId, fixedAssetId, facilityId, infoUrl, recurrenceInfoId, tempExprId, runtimeDataId, noteId, serviceLoaderName, quantityToProduce, quantityProduced, quantityRejected, reserv2ndPPPerc, reservNthPPPerc, accommodationMapId, accommodationSpotId, revisionNumber
	}

	public CancelledBacklogsTaskAndTimeEntryTimeSheet(GenericValue value) {
		timeEntryId = (String) value.get(Fields.timeEntryId.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		timesheetId = (String) value.get(Fields.timesheetId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		hours = (Double) value.get(Fields.hours.name());
		comments = (String) value.get(Fields.comments.name());
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		custRequestCategoryId = (String) value.get(Fields.custRequestCategoryId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		fromPartyId = (String) value.get(Fields.fromPartyId.name());
		priority = (Long) value.get(Fields.priority.name());
		custRequestDate = (Timestamp) value.get(Fields.custRequestDate.name());
		responseRequiredDate = (Timestamp) value
				.get(Fields.responseRequiredDate.name());
		custRequestName = (String) value.get(Fields.custRequestName.name());
		description = (String) value.get(Fields.description.name());
		maximumAmountUomId = (String) value.get(Fields.maximumAmountUomId
				.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		salesChannelEnumId = (String) value.get(Fields.salesChannelEnumId
				.name());
		fulfillContactMechId = (String) value.get(Fields.fulfillContactMechId
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		openDateTime = (Timestamp) value.get(Fields.openDateTime.name());
		closedDateTime = (Timestamp) value.get(Fields.closedDateTime.name());
		internalComment = (String) value.get(Fields.internalComment.name());
		reason = (String) value.get(Fields.reason.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		custRequestItemSeqId = (String) value.get(Fields.custRequestItemSeqId
				.name());
		custRequestResolutionId = (String) value
				.get(Fields.custRequestResolutionId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		requiredByDate = (Timestamp) value.get(Fields.requiredByDate.name());
		productId = (String) value.get(Fields.productId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		selectedAmount = (BigDecimal) value.get(Fields.selectedAmount.name());
		maximumAmount = (BigDecimal) value.get(Fields.maximumAmount.name());
		reservStart = (Timestamp) value.get(Fields.reservStart.name());
		reservLength = (BigDecimal) value.get(Fields.reservLength.name());
		reservPersons = (BigDecimal) value.get(Fields.reservPersons.name());
		configId = (String) value.get(Fields.configId.name());
		story = (String) value.get(Fields.story.name());
		workEffortTypeId = (String) value.get(Fields.workEffortTypeId.name());
		currentStatusId = (String) value.get(Fields.currentStatusId.name());
		lastStatusUpdate = (Timestamp) value
				.get(Fields.lastStatusUpdate.name());
		workEffortPurposeTypeId = (String) value
				.get(Fields.workEffortPurposeTypeId.name());
		workEffortParentId = (String) value.get(Fields.workEffortParentId
				.name());
		scopeEnumId = (String) value.get(Fields.scopeEnumId.name());
		percentComplete = (Long) value.get(Fields.percentComplete.name());
		workEffortName = (String) value.get(Fields.workEffortName.name());
		showAsEnumId = (String) value.get(Fields.showAsEnumId.name());
		sendNotificationEmail = (String) value.get(Fields.sendNotificationEmail
				.name());
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
		reserv2ndPPPerc = (BigDecimal) value.get(Fields.reserv2ndPPPerc.name());
		reservNthPPPerc = (BigDecimal) value.get(Fields.reservNthPPPerc.name());
		accommodationMapId = (String) value.get(Fields.accommodationMapId
				.name());
		accommodationSpotId = (String) value.get(Fields.accommodationSpotId
				.name());
		revisionNumber = (Long) value.get(Fields.revisionNumber.name());
	}

	public static CancelledBacklogsTaskAndTimeEntryTimeSheet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CancelledBacklogsTaskAndTimeEntryTimeSheet(value);
	}

	public static List<CancelledBacklogsTaskAndTimeEntryTimeSheet> fromValues(
			List<GenericValue> values) {
		List<CancelledBacklogsTaskAndTimeEntryTimeSheet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CancelledBacklogsTaskAndTimeEntryTimeSheet(value));
		}
		return entities;
	}
}