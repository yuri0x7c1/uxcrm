package org.apache.ofbiz.order.quote;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Work Effort View
 */
public class QuoteWorkEffortView implements Serializable {

	public static final long serialVersionUID = 6790575273126024192L;
	public static final String NAME = "QuoteWorkEffortView";
	/**
	 * Status Item Description
	 */
	@Getter
	@Setter
	private String statusItemDescription;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
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
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
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

	public enum Fields {
		statusItemDescription, workEffortId, quoteId, recurrenceInfoId, workEffortTypeId, reservPersons, revisionNumber, tempExprId, showAsEnumId, infoUrl, universalId, locationDesc, createdByUserLogin, actualMilliSeconds, quantityToProduce, workEffortPurposeTypeId, serviceLoaderName, accommodationSpotId, estimatedStartDate, sendNotificationEmail, noteId, quantityRejected, priority, currentStatusId, runtimeDataId, estimatedMilliSeconds, specialTerms, timeTransparency, actualCompletionDate, fixedAssetId, reserv2ndPPPerc, totalMoneyAllowed, estimateCalcMethod, workEffortParentId, description, moneyUomId, reservNthPPPerc, workEffortName, lastModifiedByUserLogin, accommodationMapId, actualStartDate, scopeEnumId, quantityProduced, facilityId, estimatedSetupMillis, lastModifiedDate, sourceReferenceId, lastStatusUpdate, percentComplete, totalMilliSecondsAllowed, createdDate, actualSetupMillis, estimatedCompletionDate
	}

	public QuoteWorkEffortView(GenericValue value) {
		statusItemDescription = (String) value.get(Fields.statusItemDescription
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		quoteId = (String) value.get(Fields.quoteId.name());
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
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
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
	}

	public static QuoteWorkEffortView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteWorkEffortView(value);
	}

	public static List<QuoteWorkEffortView> fromValues(List<GenericValue> values) {
		List<QuoteWorkEffortView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteWorkEffortView(value));
		}
		return entities;
	}
}