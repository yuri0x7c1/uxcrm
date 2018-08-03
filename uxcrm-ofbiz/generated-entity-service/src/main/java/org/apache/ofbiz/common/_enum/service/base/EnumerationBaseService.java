package org.apache.ofbiz.common._enum.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.common.ExecuteFindService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Optional;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import com.github.yuri0x7c1.uxcrm.util.OfbizUtil;
import org.apache.ofbiz.common._enum.Enumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common._enum.EnumerationType;
import org.apache.ofbiz.party.communication.CommunicationEvent;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.content.content.ContentPurposeOperation;
import org.apache.ofbiz.order.request.CustRequest;
import org.apache.ofbiz.common.email.EmailTemplateSetting;
import org.apache.ofbiz.product.facility.FacilityLocation;
import org.apache.ofbiz.accounting.finaccount.FinAccountTrans;
import org.apache.ofbiz.accounting.finaccount.FinAccountType;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;
import org.apache.ofbiz.common.geo.GeoPoint;
import org.apache.ofbiz.accounting.payment.GiftCardFulfillment;
import org.apache.ofbiz.product.inventory.InventoryItemDetail;
import org.apache.ofbiz.humanres.recruitment.JobInterview;
import org.apache.ofbiz.service.schedule.JobManagerLock;
import org.apache.ofbiz.humanres.recruitment.JobRequisition;
import org.apache.ofbiz.common.keyword.KeywordThesaurus;
import org.apache.ofbiz.accounting.payment.OldValueLinkFulfillment;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.order.order.OrderItemChange;
import org.apache.ofbiz.order.order.OrderNotification;
import org.apache.ofbiz.accounting.ledger.PartyAcctgPreference;
import org.apache.ofbiz.accounting.payment.PaymentGatewayResponse;
import org.apache.ofbiz.party.party.Person;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.category.ProductCategoryLink;
import org.apache.ofbiz.product.product.ProductGeo;
import org.apache.ofbiz.product.product.ProductKeyword;
import org.apache.ofbiz.product.price.ProductPriceCond;
import org.apache.ofbiz.product.promo.ProductPromoAction;
import org.apache.ofbiz.product.promo.ProductPromoCategory;
import org.apache.ofbiz.product.promo.ProductPromoCond;
import org.apache.ofbiz.product.promo.ProductPromoProduct;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.product.store.ProductStoreEmailSetting;
import org.apache.ofbiz.product.store.ProductStoreFinActSetting;
import org.apache.ofbiz.product.store.ProductStoreKeywordOvrd;
import org.apache.ofbiz.product.store.ProductStorePaymentSetting;
import org.apache.ofbiz.product.store.ProductStoreVendorPayment;
import org.apache.ofbiz.order.quote.Quote;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunity;
import org.apache.ofbiz.marketing.tracking.TrackingCodeVisit;
import org.apache.ofbiz.common.uom.UomConversionDated;
import org.apache.ofbiz.security.login.UserLoginSecurityQuestion;
import org.apache.ofbiz.common.theme.VisualThemeResource;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortPartyAssignment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EnumerationBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EnumerationBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Enumerations
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Enumerations
	 */
	public List<Enumeration> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<Enumeration> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Enumeration
	 */
	public Optional<Enumeration> findOne(Object enumId) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						enumId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get enumeration type
	 */
	public Optional<EnumerationType> getEnumerationType(Enumeration enumeration) {
		List<EnumerationType> entityList = null;
		In in = new In();
		in.setEntityName(EnumerationType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumTypeId", EntityOperator.EQUALS,
						enumeration.getEnumTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EnumerationType.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get communication events
	 */
	public List<CommunicationEvent> getCommunicationEvents(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<CommunicationEvent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CommunicationEvent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("reasonEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommunicationEvent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get privilege contents
	 */
	public List<Content> getPrivilegeContents(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<Content> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Content.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("privilegeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Content.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get content purpose operations
	 */
	public List<ContentPurposeOperation> getContentPurposeOperations(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ContentPurposeOperation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentPurposeOperation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("privilegeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentPurposeOperation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales channel cust requests
	 */
	public List<CustRequest> getSalesChannelCustRequests(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<CustRequest> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequest.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("salesChannelEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequest.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get email template settings
	 */
	public List<EmailTemplateSetting> getEmailTemplateSettings(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<EmailTemplateSetting> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmailTemplateSetting.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emailType", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmailTemplateSetting.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get type facility locations
	 */
	public List<FacilityLocation> getTypeFacilityLocations(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<FacilityLocation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityLocation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("locationTypeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityLocation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get reason fin account transes
	 */
	public List<FinAccountTrans> getReasonFinAccountTranses(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<FinAccountTrans> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTrans.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("reasonEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTrans.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get replenish fin account types
	 */
	public List<FinAccountType> getReplenishFinAccountTypes(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<FinAccountType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("replenishEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get class fixed assets
	 */
	public List<FixedAsset> getClassFixedAssets(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<FixedAsset> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAsset.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("classEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAsset.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get geo point type geo points
	 */
	public List<GeoPoint> getGeoPointTypeGeoPoints(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<GeoPoint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GeoPoint.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointTypeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GeoPoint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get gift card fulfillments
	 */
	public List<GiftCardFulfillment> getGiftCardFulfillments(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<GiftCardFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GiftCardFulfillment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("typeEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GiftCardFulfillment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get reason inventory item details
	 */
	public List<InventoryItemDetail> getReasonInventoryItemDetails(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<InventoryItemDetail> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItemDetail.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("reasonEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItemDetail.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get job interviews
	 */
	public List<JobInterview> getJobInterviews(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<JobInterview> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(JobInterview.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("gradeSecuredEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = JobInterview.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get reason job manager locks
	 */
	public List<JobManagerLock> getReasonJobManagerLocks(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<JobManagerLock> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(JobManagerLock.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("reasonEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = JobManagerLock.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get exam type job requisitions
	 */
	public List<JobRequisition> getExamTypeJobRequisitions(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<JobRequisition> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(JobRequisition.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("examTypeEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = JobRequisition.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get job posting type job requisitions
	 */
	public List<JobRequisition> getJobPostingTypeJobRequisitions(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<JobRequisition> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(JobRequisition.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("jobPostingTypeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = JobRequisition.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get relationship keyword thesauri
	 */
	public List<KeywordThesaurus> getRelationshipKeywordThesauri(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<KeywordThesaurus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(KeywordThesaurus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("relationshipEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = KeywordThesaurus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get old value link fulfillments
	 */
	public List<OldValueLinkFulfillment> getOldValueLinkFulfillments(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<OldValueLinkFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldValueLinkFulfillment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("typeEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldValueLinkFulfillment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales channel order headers
	 */
	public List<OrderHeader> getSalesChannelOrderHeaders(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderHeader> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("salesChannelEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderHeader.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item changes
	 */
	public List<OrderItemChange> getOrderItemChanges(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemChange> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemChange.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeTypeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemChange.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get reason order item changes
	 */
	public List<OrderItemChange> getReasonOrderItemChanges(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemChange> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemChange.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("reasonEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemChange.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order notifications
	 */
	public List<OrderNotification> getOrderNotifications(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderNotification> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderNotification.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emailType", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderNotification.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tax form party acctg preferences
	 */
	public List<PartyAcctgPreference> getTaxFormPartyAcctgPreferences(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyAcctgPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxFormId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cogs party acctg preferences
	 */
	public List<PartyAcctgPreference> getCogsPartyAcctgPreferences(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyAcctgPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("cogsMethodId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get invoice sequence party acctg preferences
	 */
	public List<PartyAcctgPreference> getInvoiceSequencePartyAcctgPreferences(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyAcctgPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("oldInvoiceSequenceEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quote sequence party acctg preferences
	 */
	public List<PartyAcctgPreference> getQuoteSequencePartyAcctgPreferences(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyAcctgPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("oldQuoteSequenceEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order sequence party acctg preferences
	 */
	public List<PartyAcctgPreference> getOrderSequencePartyAcctgPreferences(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyAcctgPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("oldOrderSequenceEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get service type payment gateway responses
	 */
	public List<PaymentGatewayResponse> getServiceTypePaymentGatewayResponses(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<PaymentGatewayResponse> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentGatewayResponse.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentServiceTypeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayResponse.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tran code payment gateway responses
	 */
	public List<PaymentGatewayResponse> getTranCodePaymentGatewayResponses(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<PaymentGatewayResponse> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentGatewayResponse.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("transCodeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayResponse.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get employment status persons
	 */
	public List<Person> getEmploymentStatusPersons(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<Person> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Person.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("employmentStatusEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Person.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get residence status persons
	 */
	public List<Person> getResidenceStatusPersons(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<Person> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Person.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("residenceStatusEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Person.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get virtual variant method products
	 */
	public List<Product> getVirtualVariantMethodProducts(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<Product> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Product.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("virtualVariantMethodEnum",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get rating products
	 */
	public List<Product> getRatingProducts(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<Product> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Product.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("ratingTypeEnum", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get requirement method products
	 */
	public List<Product> getRequirementMethodProducts(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<Product> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Product.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementMethodEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get link type product category links
	 */
	public List<ProductCategoryLink> getLinkTypeProductCategoryLinks(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryLink> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryLink.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("linkTypeEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryLink.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product geos
	 */
	public List<ProductGeo> getProductGeos(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductGeo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductGeo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productGeoEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductGeo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product keywords
	 */
	public List<ProductKeyword> getProductKeywords(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductKeyword> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductKeyword.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("keywordTypeId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductKeyword.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get input param product price conds
	 */
	public List<ProductPriceCond> getInputParamProductPriceConds(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPriceCond> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPriceCond.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("inputParamEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPriceCond.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get operator product price conds
	 */
	public List<ProductPriceCond> getOperatorProductPriceConds(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPriceCond> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPriceCond.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("operatorEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPriceCond.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get action product promo actions
	 */
	public List<ProductPromoAction> getActionProductPromoActions(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPromoAction> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoAction.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPromoActionEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoAction.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get appl product promo categories
	 */
	public List<ProductPromoCategory> getApplProductPromoCategories(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPromoCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoCategory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPromoApplEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get input param product promo conds
	 */
	public List<ProductPromoCond> getInputParamProductPromoConds(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPromoCond> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoCond.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("inputParamEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCond.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get operator product promo conds
	 */
	public List<ProductPromoCond> getOperatorProductPromoConds(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPromoCond> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoCond.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("operatorEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCond.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get appl product promo products
	 */
	public List<ProductPromoProduct> getApplProductPromoProducts(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPromoProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPromoApplEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get reserve order product stores
	 */
	public List<ProductStore> getReserveOrderProductStores(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStore> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("reserveOrderEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get requirement method product stores
	 */
	public List<ProductStore> getRequirementMethodProductStores(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStore> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("requirementMethodEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get default sales channel product stores
	 */
	public List<ProductStore> getDefaultSalesChannelProductStores(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStore> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("defaultSalesChannelEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get store credit account product stores
	 */
	public List<ProductStore> getStoreCreditAccountProductStores(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStore> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("storeCreditAccountEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store email settings
	 */
	public List<ProductStoreEmailSetting> getProductStoreEmailSettings(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStoreEmailSetting> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreEmailSetting.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emailType", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreEmailSetting.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get replenish method product store fin act settings
	 */
	public List<ProductStoreFinActSetting> getReplenishMethodProductStoreFinActSettings(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStoreFinActSetting> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreFinActSetting.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("replenishMethodEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreFinActSetting.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store keyword ovrds
	 */
	public List<ProductStoreKeywordOvrd> getProductStoreKeywordOvrds(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStoreKeywordOvrd> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreKeywordOvrd.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("targetTypeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreKeywordOvrd.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store payment settings
	 */
	public List<ProductStorePaymentSetting> getProductStorePaymentSettings(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStorePaymentSetting> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStorePaymentSetting.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentServiceTypeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStorePaymentSetting.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get credit card product store vendor payments
	 */
	public List<ProductStoreVendorPayment> getCreditCardProductStoreVendorPayments(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStoreVendorPayment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreVendorPayment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("creditCardEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreVendorPayment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales channel quotes
	 */
	public List<Quote> getSalesChannelQuotes(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<Quote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Quote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("salesChannelEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Quote.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get type sales opportunities
	 */
	public List<SalesOpportunity> getTypeSalesOpportunities(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<SalesOpportunity> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesOpportunity.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("typeEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunity.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tracking code visits
	 */
	public List<TrackingCodeVisit> getTrackingCodeVisits(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<TrackingCodeVisit> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TrackingCodeVisit.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("sourceEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TrackingCodeVisit.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get purpose uom conversion dateds
	 */
	public List<UomConversionDated> getPurposeUomConversionDateds(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<UomConversionDated> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UomConversionDated.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("purposeEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UomConversionDated.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get user login security questions
	 */
	public List<UserLoginSecurityQuestion> getUserLoginSecurityQuestions(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<UserLoginSecurityQuestion> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UserLoginSecurityQuestion.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("questionEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLoginSecurityQuestion.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get visual theme resources
	 */
	public List<VisualThemeResource> getVisualThemeResources(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<VisualThemeResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(VisualThemeResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("resourceTypeEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VisualThemeResource.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get scope work efforts
	 */
	public List<WorkEffort> getScopeWorkEfforts(Enumeration enumeration,
			Integer start, Integer number, List<String> orderBy) {
		List<WorkEffort> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("scopeEnumId", EntityOperator.EQUALS,
						enumeration.getEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get expectation work effort party assignments
	 */
	public List<WorkEffortPartyAssignment> getExpectationWorkEffortPartyAssignments(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<WorkEffortPartyAssignment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortPartyAssignment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("expectationEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortPartyAssignment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get delegate reason work effort party assignments
	 */
	public List<WorkEffortPartyAssignment> getDelegateReasonWorkEffortPartyAssignments(
			Enumeration enumeration, Integer start, Integer number,
			List<String> orderBy) {
		List<WorkEffortPartyAssignment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortPartyAssignment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("delegateReasonEnumId",
						EntityOperator.EQUALS, enumeration.getEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortPartyAssignment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}