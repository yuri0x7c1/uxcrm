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
 * Work Effort And Product
 */
public class WorkEffortAndProduct implements Serializable {

	public static final long serialVersionUID = 8567439256697909248L;
	public static final String NAME = "WorkEffortAndProduct";
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
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Type Id
	 */
	@Getter
	@Setter
	private String productTypeId;
	/**
	 * Primary Product Category Id
	 */
	@Getter
	@Setter
	private String primaryProductCategoryId;
	/**
	 * Manufacturer Party Id
	 */
	@Getter
	@Setter
	private String manufacturerPartyId;
	/**
	 * Introduction Date
	 */
	@Getter
	@Setter
	private Timestamp introductionDate;
	/**
	 * Release Date
	 */
	@Getter
	@Setter
	private Timestamp releaseDate;
	/**
	 * Support Discontinuation Date
	 */
	@Getter
	@Setter
	private Timestamp supportDiscontinuationDate;
	/**
	 * Sales Discontinuation Date
	 */
	@Getter
	@Setter
	private Timestamp salesDiscontinuationDate;
	/**
	 * Sales Disc When Not Avail
	 */
	@Getter
	@Setter
	private String salesDiscWhenNotAvail;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
	/**
	 * Brand Name
	 */
	@Getter
	@Setter
	private String brandName;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Product Name
	 */
	@Getter
	@Setter
	private String productName;
	/**
	 * Long Description
	 */
	@Getter
	@Setter
	private String longDescription;
	/**
	 * Price Detail Text
	 */
	@Getter
	@Setter
	private String priceDetailText;
	/**
	 * Small Image Url
	 */
	@Getter
	@Setter
	private String smallImageUrl;
	/**
	 * Medium Image Url
	 */
	@Getter
	@Setter
	private String mediumImageUrl;
	/**
	 * Large Image Url
	 */
	@Getter
	@Setter
	private String largeImageUrl;
	/**
	 * Detail Image Url
	 */
	@Getter
	@Setter
	private String detailImageUrl;
	/**
	 * Original Image Url
	 */
	@Getter
	@Setter
	private String originalImageUrl;
	/**
	 * Detail Screen
	 */
	@Getter
	@Setter
	private String detailScreen;
	/**
	 * Inventory Message
	 */
	@Getter
	@Setter
	private String inventoryMessage;
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Require Inventory
	 */
	@Getter
	@Setter
	private String requireInventory;
	/**
	 * Quantity Uom Id
	 */
	@Getter
	@Setter
	private String quantityUomId;
	/**
	 * Quantity Included
	 */
	@Getter
	@Setter
	private BigDecimal quantityIncluded;
	/**
	 * Pieces Included
	 */
	@Getter
	@Setter
	private Long piecesIncluded;
	/**
	 * Require Amount
	 */
	@Getter
	@Setter
	private String requireAmount;
	/**
	 * Fixed Amount
	 */
	@Getter
	@Setter
	private BigDecimal fixedAmount;
	/**
	 * Amount Uom Type Id
	 */
	@Getter
	@Setter
	private String amountUomTypeId;
	/**
	 * Weight Uom Id
	 */
	@Getter
	@Setter
	private String weightUomId;
	/**
	 * Shipping Weight
	 */
	@Getter
	@Setter
	private BigDecimal shippingWeight;
	/**
	 * Product Weight
	 */
	@Getter
	@Setter
	private BigDecimal productWeight;
	/**
	 * Height Uom Id
	 */
	@Getter
	@Setter
	private String heightUomId;
	/**
	 * Product Height
	 */
	@Getter
	@Setter
	private BigDecimal productHeight;
	/**
	 * Shipping Height
	 */
	@Getter
	@Setter
	private BigDecimal shippingHeight;
	/**
	 * Width Uom Id
	 */
	@Getter
	@Setter
	private String widthUomId;
	/**
	 * Product Width
	 */
	@Getter
	@Setter
	private BigDecimal productWidth;
	/**
	 * Shipping Width
	 */
	@Getter
	@Setter
	private BigDecimal shippingWidth;
	/**
	 * Depth Uom Id
	 */
	@Getter
	@Setter
	private String depthUomId;
	/**
	 * Product Depth
	 */
	@Getter
	@Setter
	private BigDecimal productDepth;
	/**
	 * Shipping Depth
	 */
	@Getter
	@Setter
	private BigDecimal shippingDepth;
	/**
	 * Diameter Uom Id
	 */
	@Getter
	@Setter
	private String diameterUomId;
	/**
	 * Product Diameter
	 */
	@Getter
	@Setter
	private BigDecimal productDiameter;
	/**
	 * Product Rating
	 */
	@Getter
	@Setter
	private BigDecimal productRating;
	/**
	 * Rating Type Enum
	 */
	@Getter
	@Setter
	private String ratingTypeEnum;
	/**
	 * Returnable
	 */
	@Getter
	@Setter
	private String returnable;
	/**
	 * Taxable
	 */
	@Getter
	@Setter
	private String taxable;
	/**
	 * Charge Shipping
	 */
	@Getter
	@Setter
	private String chargeShipping;
	/**
	 * Auto Create Keywords
	 */
	@Getter
	@Setter
	private String autoCreateKeywords;
	/**
	 * Include In Promotions
	 */
	@Getter
	@Setter
	private String includeInPromotions;
	/**
	 * Is Virtual
	 */
	@Getter
	@Setter
	private String isVirtual;
	/**
	 * Is Variant
	 */
	@Getter
	@Setter
	private String isVariant;
	/**
	 * Virtual Variant Method Enum
	 */
	@Getter
	@Setter
	private String virtualVariantMethodEnum;
	/**
	 * Origin Geo Id
	 */
	@Getter
	@Setter
	private String originGeoId;
	/**
	 * Requirement Method Enum Id
	 */
	@Getter
	@Setter
	private String requirementMethodEnumId;
	/**
	 * Bill Of Material Level
	 */
	@Getter
	@Setter
	private Long billOfMaterialLevel;
	/**
	 * Reserv Max Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservMaxPersons;
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * In Shipping Box
	 */
	@Getter
	@Setter
	private String inShippingBox;
	/**
	 * Default Shipment Box Type Id
	 */
	@Getter
	@Setter
	private String defaultShipmentBoxTypeId;
	/**
	 * Lot Id Filled In
	 */
	@Getter
	@Setter
	private String lotIdFilledIn;
	/**
	 * Order Decimal Quantity
	 */
	@Getter
	@Setter
	private String orderDecimalQuantity;

	public enum Fields {
		workEffortId, workEffortTypeId, currentStatusId, lastStatusUpdate, workEffortPurposeTypeId, workEffortParentId, scopeEnumId, priority, percentComplete, workEffortName, showAsEnumId, sendNotificationEmail, description, locationDesc, estimatedStartDate, estimatedCompletionDate, actualStartDate, actualCompletionDate, estimatedMilliSeconds, estimatedSetupMillis, estimateCalcMethod, actualMilliSeconds, actualSetupMillis, totalMilliSecondsAllowed, totalMoneyAllowed, moneyUomId, specialTerms, timeTransparency, universalId, sourceReferenceId, fixedAssetId, facilityId, infoUrl, recurrenceInfoId, tempExprId, runtimeDataId, noteId, serviceLoaderName, quantityToProduce, quantityProduced, quantityRejected, reservPersons, reserv2ndPPPerc, reservNthPPPerc, accommodationMapId, accommodationSpotId, revisionNumber, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, productId, productTypeId, primaryProductCategoryId, manufacturerPartyId, introductionDate, releaseDate, supportDiscontinuationDate, salesDiscontinuationDate, salesDiscWhenNotAvail, internalName, brandName, comments, productName, longDescription, priceDetailText, smallImageUrl, mediumImageUrl, largeImageUrl, detailImageUrl, originalImageUrl, detailScreen, inventoryMessage, inventoryItemTypeId, requireInventory, quantityUomId, quantityIncluded, piecesIncluded, requireAmount, fixedAmount, amountUomTypeId, weightUomId, shippingWeight, productWeight, heightUomId, productHeight, shippingHeight, widthUomId, productWidth, shippingWidth, depthUomId, productDepth, shippingDepth, diameterUomId, productDiameter, productRating, ratingTypeEnum, returnable, taxable, chargeShipping, autoCreateKeywords, includeInPromotions, isVirtual, isVariant, virtualVariantMethodEnum, originGeoId, requirementMethodEnumId, billOfMaterialLevel, reservMaxPersons, configId, inShippingBox, defaultShipmentBoxTypeId, lotIdFilledIn, orderDecimalQuantity
	}

	public WorkEffortAndProduct(GenericValue value) {
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
		productId = (String) value.get(Fields.productId.name());
		productTypeId = (String) value.get(Fields.productTypeId.name());
		primaryProductCategoryId = (String) value
				.get(Fields.primaryProductCategoryId.name());
		manufacturerPartyId = (String) value.get(Fields.manufacturerPartyId
				.name());
		introductionDate = (Timestamp) value
				.get(Fields.introductionDate.name());
		releaseDate = (Timestamp) value.get(Fields.releaseDate.name());
		supportDiscontinuationDate = (Timestamp) value
				.get(Fields.supportDiscontinuationDate.name());
		salesDiscontinuationDate = (Timestamp) value
				.get(Fields.salesDiscontinuationDate.name());
		salesDiscWhenNotAvail = (String) value.get(Fields.salesDiscWhenNotAvail
				.name());
		internalName = (String) value.get(Fields.internalName.name());
		brandName = (String) value.get(Fields.brandName.name());
		comments = (String) value.get(Fields.comments.name());
		productName = (String) value.get(Fields.productName.name());
		longDescription = (String) value.get(Fields.longDescription.name());
		priceDetailText = (String) value.get(Fields.priceDetailText.name());
		smallImageUrl = (String) value.get(Fields.smallImageUrl.name());
		mediumImageUrl = (String) value.get(Fields.mediumImageUrl.name());
		largeImageUrl = (String) value.get(Fields.largeImageUrl.name());
		detailImageUrl = (String) value.get(Fields.detailImageUrl.name());
		originalImageUrl = (String) value.get(Fields.originalImageUrl.name());
		detailScreen = (String) value.get(Fields.detailScreen.name());
		inventoryMessage = (String) value.get(Fields.inventoryMessage.name());
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		requireInventory = (String) value.get(Fields.requireInventory.name());
		quantityUomId = (String) value.get(Fields.quantityUomId.name());
		quantityIncluded = (BigDecimal) value.get(Fields.quantityIncluded
				.name());
		piecesIncluded = (Long) value.get(Fields.piecesIncluded.name());
		requireAmount = (String) value.get(Fields.requireAmount.name());
		fixedAmount = (BigDecimal) value.get(Fields.fixedAmount.name());
		amountUomTypeId = (String) value.get(Fields.amountUomTypeId.name());
		weightUomId = (String) value.get(Fields.weightUomId.name());
		shippingWeight = (BigDecimal) value.get(Fields.shippingWeight.name());
		productWeight = (BigDecimal) value.get(Fields.productWeight.name());
		heightUomId = (String) value.get(Fields.heightUomId.name());
		productHeight = (BigDecimal) value.get(Fields.productHeight.name());
		shippingHeight = (BigDecimal) value.get(Fields.shippingHeight.name());
		widthUomId = (String) value.get(Fields.widthUomId.name());
		productWidth = (BigDecimal) value.get(Fields.productWidth.name());
		shippingWidth = (BigDecimal) value.get(Fields.shippingWidth.name());
		depthUomId = (String) value.get(Fields.depthUomId.name());
		productDepth = (BigDecimal) value.get(Fields.productDepth.name());
		shippingDepth = (BigDecimal) value.get(Fields.shippingDepth.name());
		diameterUomId = (String) value.get(Fields.diameterUomId.name());
		productDiameter = (BigDecimal) value.get(Fields.productDiameter.name());
		productRating = (BigDecimal) value.get(Fields.productRating.name());
		ratingTypeEnum = (String) value.get(Fields.ratingTypeEnum.name());
		returnable = (String) value.get(Fields.returnable.name());
		taxable = (String) value.get(Fields.taxable.name());
		chargeShipping = (String) value.get(Fields.chargeShipping.name());
		autoCreateKeywords = (String) value.get(Fields.autoCreateKeywords
				.name());
		includeInPromotions = (String) value.get(Fields.includeInPromotions
				.name());
		isVirtual = (String) value.get(Fields.isVirtual.name());
		isVariant = (String) value.get(Fields.isVariant.name());
		virtualVariantMethodEnum = (String) value
				.get(Fields.virtualVariantMethodEnum.name());
		originGeoId = (String) value.get(Fields.originGeoId.name());
		requirementMethodEnumId = (String) value
				.get(Fields.requirementMethodEnumId.name());
		billOfMaterialLevel = (Long) value.get(Fields.billOfMaterialLevel
				.name());
		reservMaxPersons = (BigDecimal) value.get(Fields.reservMaxPersons
				.name());
		configId = (String) value.get(Fields.configId.name());
		inShippingBox = (String) value.get(Fields.inShippingBox.name());
		defaultShipmentBoxTypeId = (String) value
				.get(Fields.defaultShipmentBoxTypeId.name());
		lotIdFilledIn = (String) value.get(Fields.lotIdFilledIn.name());
		orderDecimalQuantity = (String) value.get(Fields.orderDecimalQuantity
				.name());
	}

	public static WorkEffortAndProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAndProduct(value);
	}

	public static List<WorkEffortAndProduct> fromValues(
			List<GenericValue> values) {
		List<WorkEffortAndProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAndProduct(value));
		}
		return entities;
	}
}