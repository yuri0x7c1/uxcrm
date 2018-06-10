package org.apache.ofbiz.party.party.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.common.ExecuteFindService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;
import org.apache.ofbiz.party.party.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.PartyType;
import org.apache.ofbiz.security.login.UserLogin;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.party.party.PartyTypeAttr;
import org.apache.ofbiz.common.datasource.DataSource;
import org.apache.ofbiz.accounting.ledger.AcctgTrans;
import org.apache.ofbiz.accounting.ledger.AcctgTransEntry;
import org.apache.ofbiz.party.party.Affiliate;
import org.apache.ofbiz.party.agreement.Agreement;
import org.apache.ofbiz.party.agreement.AgreementPartyApplic;
import org.apache.ofbiz.party.agreement.AgreementRole;
import org.apache.ofbiz.accounting.payment.BillingAccountRole;
import org.apache.ofbiz.accounting.budget.BudgetReview;
import org.apache.ofbiz.accounting.budget.BudgetRole;
import org.apache.ofbiz.shipment.shipment.CarrierShipmentBoxType;
import org.apache.ofbiz.shipment.shipment.CarrierShipmentMethod;
import org.apache.ofbiz.party.communication.CommunicationEvent;
import org.apache.ofbiz.party.communication.CommunicationEventRole;
import org.apache.ofbiz.marketing.contact.ContactList;
import org.apache.ofbiz.marketing.contact.ContactListCommStatus;
import org.apache.ofbiz.marketing.contact.ContactListParty;
import org.apache.ofbiz.content.content.ContentApproval;
import org.apache.ofbiz.content.content.ContentRevision;
import org.apache.ofbiz.content.content.ContentRole;
import org.apache.ofbiz.product.cost.CostComponent;
import org.apache.ofbiz.order.request.CustRequest;
import org.apache.ofbiz.order.request.CustRequestParty;
import org.apache.ofbiz.order.request.CustRequestType;
import org.apache.ofbiz.common.period.CustomTimePeriod;
import org.apache.ofbiz.content.data.DataResourceRole;
import org.apache.ofbiz.humanres.employment.EmplLeave;
import org.apache.ofbiz.humanres.position.EmplPosition;
import org.apache.ofbiz.humanres.position.EmplPositionFulfillment;
import org.apache.ofbiz.humanres.employment.Employment;
import org.apache.ofbiz.humanres.employment.EmploymentApp;
import org.apache.ofbiz.product.facility.Facility;
import org.apache.ofbiz.product.facility.FacilityCarrierShipment;
import org.apache.ofbiz.product.facility.FacilityGroupRole;
import org.apache.ofbiz.product.facility.FacilityParty;
import org.apache.ofbiz.accounting.finaccount.FinAccount;
import org.apache.ofbiz.accounting.finaccount.FinAccountRole;
import org.apache.ofbiz.accounting.finaccount.FinAccountTrans;
import org.apache.ofbiz.accounting.finaccount.FinAccountTypeGlAccount;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetRegistration;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetTypeGlAccount;
import org.apache.ofbiz.accounting.payment.GiftCardFulfillment;
import org.apache.ofbiz.accounting.ledger.GlAccountHistory;
import org.apache.ofbiz.accounting.ledger.GlAccountOrganization;
import org.apache.ofbiz.accounting.ledger.GlAccountRole;
import org.apache.ofbiz.accounting.ledger.GlAccountTypeDefault;
import org.apache.ofbiz.accounting.ledger.GlJournal;
import org.apache.ofbiz.accounting.ledger.GlReconciliation;
import org.apache.ofbiz.product.inventory.InventoryItem;
import org.apache.ofbiz.accounting.invoice.Invoice;
import org.apache.ofbiz.accounting.invoice.InvoiceItem;
import org.apache.ofbiz.accounting.invoice.InvoiceItemAssoc;
import org.apache.ofbiz.accounting.invoice.InvoiceItemTypeGlAccount;
import org.apache.ofbiz.accounting.invoice.InvoiceRole;
import org.apache.ofbiz.shipment.issuance.ItemIssuanceRole;
import org.apache.ofbiz.humanres.recruitment.JobInterview;
import org.apache.ofbiz.marketing.campaign.MarketingCampaignRole;
import org.apache.ofbiz.common.note.NoteData;
import org.apache.ofbiz.order.order.OrderItemRole;
import org.apache.ofbiz.order.order.OrderItemShipGroup;
import org.apache.ofbiz.order.order.OrderRole;
import org.apache.ofbiz.accounting.ledger.PartyAcctgPreference;
import org.apache.ofbiz.party.party.PartyAttribute;
import org.apache.ofbiz.humanres.employment.PartyBenefit;
import org.apache.ofbiz.party.party.PartyCarrierAccount;
import org.apache.ofbiz.party.party.PartyClassification;
import org.apache.ofbiz.party.contact.PartyContactMech;
import org.apache.ofbiz.party.contact.PartyContactMechPurpose;
import org.apache.ofbiz.party.party.PartyContent;
import org.apache.ofbiz.party.party.PartyDataSource;
import org.apache.ofbiz.accounting.fixedasset.PartyFixedAssetAssignment;
import org.apache.ofbiz.party.party.PartyGeoPoint;
import org.apache.ofbiz.accounting.ledger.PartyGlAccount;
import org.apache.ofbiz.party.party.PartyGroup;
import org.apache.ofbiz.party.party.PartyIcsAvsOverride;
import org.apache.ofbiz.party.party.PartyIdentification;
import org.apache.ofbiz.party.party.PartyInvitation;
import org.apache.ofbiz.party.party.PartyInvitationGroupAssoc;
import org.apache.ofbiz.party.party.PartyNameHistory;
import org.apache.ofbiz.party.need.PartyNeed;
import org.apache.ofbiz.party.party.PartyNote;
import org.apache.ofbiz.accounting.ledger.PartyPrefDocTypeTpl;
import org.apache.ofbiz.party.party.PartyProfileDefault;
import org.apache.ofbiz.humanres.ability.PartyQual;
import org.apache.ofbiz.accounting.rate.PartyRate;
import org.apache.ofbiz.party.party.PartyRelationship;
import org.apache.ofbiz.humanres.ability.PartyResume;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.humanres.ability.PartySkill;
import org.apache.ofbiz.party.party.PartyStatus;
import org.apache.ofbiz.accounting.tax.PartyTaxAuthInfo;
import org.apache.ofbiz.accounting.payment.Payment;
import org.apache.ofbiz.accounting.payment.PaymentGlAccountTypeMap;
import org.apache.ofbiz.accounting.payment.PaymentMethod;
import org.apache.ofbiz.accounting.payment.PaymentMethodTypeGlAccount;
import org.apache.ofbiz.humanres.employment.PayrollPreference;
import org.apache.ofbiz.humanres.ability.PerfReview;
import org.apache.ofbiz.humanres.ability.PerfReviewItem;
import org.apache.ofbiz.humanres.ability.PerformanceNote;
import org.apache.ofbiz.party.party.Person;
import org.apache.ofbiz.humanres.ability.PersonTraining;
import org.apache.ofbiz.product.catalog.ProdCatalogRole;
import org.apache.ofbiz.accounting.ledger.ProductAverageCost;
import org.apache.ofbiz.product.category.ProductCategoryGlAccount;
import org.apache.ofbiz.product.category.ProductCategoryRole;
import org.apache.ofbiz.product.product.ProductGlAccount;
import org.apache.ofbiz.product.price.ProductPrice;
import org.apache.ofbiz.product.promo.ProductPromo;
import org.apache.ofbiz.product.promo.ProductPromoCodeParty;
import org.apache.ofbiz.product.promo.ProductPromoUse;
import org.apache.ofbiz.product.product.ProductRole;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.product.store.ProductStoreGroupRole;
import org.apache.ofbiz.product.store.ProductStoreRole;
import org.apache.ofbiz.product.store.ProductStoreShipmentMeth;
import org.apache.ofbiz.product.store.ProductStoreVendorPayment;
import org.apache.ofbiz.product.store.ProductStoreVendorShipment;
import org.apache.ofbiz.order.quote.Quote;
import org.apache.ofbiz.order.quote.QuoteRole;
import org.apache.ofbiz.accounting.rate.RateAmount;
import org.apache.ofbiz.product.supplier.ReorderGuideline;
import org.apache.ofbiz.order.requirement.RequirementRole;
import org.apache.ofbiz.order.request.RespondingParty;
import org.apache.ofbiz.order._return.ReturnHeader;
import org.apache.ofbiz.marketing.opportunity.SalesForecast;
import org.apache.ofbiz.marketing.opportunity.SalesForecastHistory;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunityRole;
import org.apache.ofbiz.marketing.segment.SegmentGroupRole;
import org.apache.ofbiz.webapp.visit.ServerHit;
import org.apache.ofbiz.shipment.shipment.Shipment;
import org.apache.ofbiz.shipment.shipment.ShipmentCostEstimate;
import org.apache.ofbiz.shipment.receipt.ShipmentReceiptRole;
import org.apache.ofbiz.shipment.shipment.ShipmentRouteSegment;
import org.apache.ofbiz.order.shoppinglist.ShoppingList;
import org.apache.ofbiz.product.subscription.Subscription;
import org.apache.ofbiz.product.supplier.SupplierProduct;
import org.apache.ofbiz.product.supplier.SupplierProductFeature;
import org.apache.ofbiz.content.survey.SurveyResponse;
import org.apache.ofbiz.accounting.tax.TaxAuthority;
import org.apache.ofbiz.accounting.tax.TaxAuthorityGlAccount;
import org.apache.ofbiz.workeffort.timesheet.TimeEntry;
import org.apache.ofbiz.workeffort.timesheet.Timesheet;
import org.apache.ofbiz.workeffort.timesheet.TimesheetRole;
import org.apache.ofbiz.security.login.UserLoginHistory;
import org.apache.ofbiz.accounting.ledger.VarianceReasonGlAccount;
import org.apache.ofbiz.party.party.Vendor;
import org.apache.ofbiz.product.product.VendorProduct;
import org.apache.ofbiz.party.party.WebSiteRole;
import org.apache.ofbiz.content.preference.WebUserPreference;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortEventReminder;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortPartyAssignment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Parties
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Party.NAME);
		if (conditions == null) {
			in.setNoConditionFind(FindUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Parties
	 */
	public List<Party> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<Party> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(FindUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Party
	 */
	public Party findOne(Object partyId) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party
						.fromValues(out.getListIt().getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get party type
	 */
	public PartyType getPartyType(Party party) {
		List<PartyType> entityList = null;
		In in = new In();
		in.setEntityName(PartyType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyTypeId", EntityOperator.EQUALS,
						party.getPartyTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyType.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get created by user login
	 */
	public UserLogin getCreatedByUserLogin(Party party) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						party.getCreatedByUserLogin())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get last modified by user login
	 */
	public UserLogin getLastModifiedByUserLogin(Party party) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						party.getLastModifiedByUserLogin())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get uom
	 */
	public Uom getUom(Party party) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, party
						.getPreferredCurrencyUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Uom.fromValues(out.getListIt().getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get status item
	 */
	public StatusItem getStatusItem(Party party) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS, party
						.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusItem.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get party type attrs
	 */
	public List<PartyTypeAttr> getPartyTypeAttrs(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyTypeAttr> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyTypeAttr.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyTypeId", EntityOperator.EQUALS,
						party.getPartyTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get data source
	 */
	public DataSource getDataSource(Party party) {
		List<DataSource> entityList = null;
		In in = new In();
		in.setEntityName(DataSource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataSourceId", EntityOperator.EQUALS,
						party.getDataSourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataSource.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get acctg transes
	 */
	public List<AcctgTrans> getAcctgTranses(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<AcctgTrans> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(AcctgTrans.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTrans.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get acctg trans entries
	 */
	public List<AcctgTransEntry> getAcctgTransEntries(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<AcctgTransEntry> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(AcctgTransEntry.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransEntry.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get affiliate
	 */
	public Affiliate getAffiliate(Party party) {
		List<Affiliate> entityList = null;
		In in = new In();
		in.setEntityName(Affiliate.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Affiliate.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get from agreements
	 */
	public List<Agreement> getFromAgreements(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Agreement> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Agreement.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Agreement.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to agreements
	 */
	public List<Agreement> getToAgreements(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Agreement> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Agreement.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Agreement.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement party applics
	 */
	public List<AgreementPartyApplic> getAgreementPartyApplics(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<AgreementPartyApplic> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(AgreementPartyApplic.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementPartyApplic.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get agreement roles
	 */
	public List<AgreementRole> getAgreementRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<AgreementRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(AgreementRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get billing account roles
	 */
	public List<BillingAccountRole> getBillingAccountRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<BillingAccountRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(BillingAccountRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BillingAccountRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget reviews
	 */
	public List<BudgetReview> getBudgetReviews(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<BudgetReview> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(BudgetReview.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetReview.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget roles
	 */
	public List<BudgetRole> getBudgetRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<BudgetRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(BudgetRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get carrier shipment box types
	 */
	public List<CarrierShipmentBoxType> getCarrierShipmentBoxTypes(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<CarrierShipmentBoxType> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CarrierShipmentBoxType.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CarrierShipmentBoxType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get carrier shipment methods
	 */
	public List<CarrierShipmentMethod> getCarrierShipmentMethods(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<CarrierShipmentMethod> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CarrierShipmentMethod.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CarrierShipmentMethod.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to communication events
	 */
	public List<CommunicationEvent> getToCommunicationEvents(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<CommunicationEvent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CommunicationEvent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
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
	 * Get from communication events
	 */
	public List<CommunicationEvent> getFromCommunicationEvents(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<CommunicationEvent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CommunicationEvent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
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
	 * Get communication event roles
	 */
	public List<CommunicationEventRole> getCommunicationEventRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<CommunicationEventRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CommunicationEventRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommunicationEventRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get owner contact lists
	 */
	public List<ContactList> getOwnerContactLists(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<ContactList> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContactList.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("ownerPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactList.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get contact list comm statuses
	 */
	public List<ContactListCommStatus> getContactListCommStatuses(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ContactListCommStatus> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContactListCommStatus.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactListCommStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get contact list parties
	 */
	public List<ContactListParty> getContactListParties(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ContactListParty> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContactListParty.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactListParty.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get content approvals
	 */
	public List<ContentApproval> getContentApprovals(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentApproval> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentApproval.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentApproval.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get committed by content revisions
	 */
	public List<ContentRevision> getCommittedByContentRevisions(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentRevision> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentRevision.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("committedByPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentRevision.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get content roles
	 */
	public List<ContentRole> getContentRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<ContentRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ContentRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cost components
	 */
	public List<CostComponent> getCostComponents(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<CostComponent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CostComponent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CostComponent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from cust requests
	 */
	public List<CustRequest> getFromCustRequests(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<CustRequest> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CustRequest.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("fromPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
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
	 * Get cust request parties
	 */
	public List<CustRequestParty> getCustRequestParties(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<CustRequestParty> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CustRequestParty.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestParty.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cust request types
	 */
	public List<CustRequestType> getCustRequestTypes(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<CustRequestType> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CustRequestType.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get organization custom time periods
	 */
	public List<CustomTimePeriod> getOrganizationCustomTimePeriods(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<CustomTimePeriod> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(CustomTimePeriod.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomTimePeriod.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get data resource roles
	 */
	public List<DataResourceRole> getDataResourceRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<DataResourceRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(DataResourceRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourceRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get empl leaves
	 */
	public List<EmplLeave> getEmplLeaves(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<EmplLeave> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(EmplLeave.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplLeave.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get approver empl leaves
	 */
	public List<EmplLeave> getApproverEmplLeaves(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<EmplLeave> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(EmplLeave.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("approverPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplLeave.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get empl positions
	 */
	public List<EmplPosition> getEmplPositions(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<EmplPosition> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(EmplPosition.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPosition.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get empl position fulfillments
	 */
	public List<EmplPositionFulfillment> getEmplPositionFulfillments(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<EmplPositionFulfillment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(EmplPositionFulfillment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionFulfillment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to employments
	 */
	public List<Employment> getToEmployments(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Employment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Employment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Employment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from employments
	 */
	public List<Employment> getFromEmployments(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Employment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Employment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Employment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get applying employment apps
	 */
	public List<EmploymentApp> getApplyingEmploymentApps(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<EmploymentApp> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(EmploymentApp.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("applyingPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmploymentApp.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get referred by employment apps
	 */
	public List<EmploymentApp> getReferredByEmploymentApps(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<EmploymentApp> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(EmploymentApp.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("referredByPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmploymentApp.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get approver employment apps
	 */
	public List<EmploymentApp> getApproverEmploymentApps(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<EmploymentApp> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(EmploymentApp.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("approverPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmploymentApp.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get owner facilities
	 */
	public List<Facility> getOwnerFacilities(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Facility> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Facility.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("ownerPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Facility.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get facility carrier shipments
	 */
	public List<FacilityCarrierShipment> getFacilityCarrierShipments(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<FacilityCarrierShipment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FacilityCarrierShipment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityCarrierShipment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get facility group roles
	 */
	public List<FacilityGroupRole> getFacilityGroupRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<FacilityGroupRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FacilityGroupRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityGroupRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get facility parties
	 */
	public List<FacilityParty> getFacilityParties(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<FacilityParty> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FacilityParty.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityParty.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get organization fin accounts
	 */
	public List<FinAccount> getOrganizationFinAccounts(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<FinAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FinAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get owner fin accounts
	 */
	public List<FinAccount> getOwnerFinAccounts(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<FinAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FinAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("ownerPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fin account roles
	 */
	public List<FinAccountRole> getFinAccountRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<FinAccountRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FinAccountRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fin account transes
	 */
	public List<FinAccountTrans> getFinAccountTranses(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<FinAccountTrans> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FinAccountTrans.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
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
	 * Get performed by fin account transes
	 */
	public List<FinAccountTrans> getPerformedByFinAccountTranses(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<FinAccountTrans> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FinAccountTrans.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("performedByPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
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
	 * Get organization fin account type gl accounts
	 */
	public List<FinAccountTypeGlAccount> getOrganizationFinAccountTypeGlAccounts(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<FinAccountTypeGlAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FinAccountTypeGlAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTypeGlAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fixed assets
	 */
	public List<FixedAsset> getFixedAssets(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<FixedAsset> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FixedAsset.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
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
	 * Get gov agency fixed asset registrations
	 */
	public List<FixedAssetRegistration> getGovAgencyFixedAssetRegistrations(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<FixedAssetRegistration> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FixedAssetRegistration.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("govAgencyPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetRegistration.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fixed asset type gl accounts
	 */
	public List<FixedAssetTypeGlAccount> getFixedAssetTypeGlAccounts(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<FixedAssetTypeGlAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(FixedAssetTypeGlAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetTypeGlAccount.fromValues(out.getListIt()
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
	public List<GiftCardFulfillment> getGiftCardFulfillments(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<GiftCardFulfillment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(GiftCardFulfillment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
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
	 * Get gl account histories
	 */
	public List<GlAccountHistory> getGlAccountHistories(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<GlAccountHistory> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(GlAccountHistory.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get gl account organizations
	 */
	public List<GlAccountOrganization> getGlAccountOrganizations(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<GlAccountOrganization> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(GlAccountOrganization.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountOrganization.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get gl account roles
	 */
	public List<GlAccountRole> getGlAccountRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<GlAccountRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(GlAccountRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get organization gl account type defaults
	 */
	public List<GlAccountTypeDefault> getOrganizationGlAccountTypeDefaults(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<GlAccountTypeDefault> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(GlAccountTypeDefault.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountTypeDefault.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get gl journals
	 */
	public List<GlJournal> getGlJournals(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<GlJournal> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(GlJournal.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlJournal.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get gl reconciliations
	 */
	public List<GlReconciliation> getGlReconciliations(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<GlReconciliation> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(GlReconciliation.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlReconciliation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get inventory items
	 */
	public List<InventoryItem> getInventoryItems(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<InventoryItem> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get owner inventory items
	 */
	public List<InventoryItem> getOwnerInventoryItems(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<InventoryItem> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("ownerPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from invoices
	 */
	public List<Invoice> getFromInvoices(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Invoice> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Invoice.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Invoice.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get invoices
	 */
	public List<Invoice> getInvoices(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Invoice> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Invoice.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Invoice.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tax authority invoice items
	 */
	public List<InvoiceItem> getTaxAuthorityInvoiceItems(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<InvoiceItem> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(InvoiceItem.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get override org invoice items
	 */
	public List<InvoiceItem> getOverrideOrgInvoiceItems(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<InvoiceItem> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(InvoiceItem.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("overrideOrgPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from invoice item assocs
	 */
	public List<InvoiceItemAssoc> getFromInvoiceItemAssocs(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<InvoiceItemAssoc> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(InvoiceItemAssoc.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to invoice item assocs
	 */
	public List<InvoiceItemAssoc> getToInvoiceItemAssocs(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<InvoiceItemAssoc> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(InvoiceItemAssoc.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get organization invoice item type gl accounts
	 */
	public List<InvoiceItemTypeGlAccount> getOrganizationInvoiceItemTypeGlAccounts(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<InvoiceItemTypeGlAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(InvoiceItemTypeGlAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemTypeGlAccount.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get invoice roles
	 */
	public List<InvoiceRole> getInvoiceRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<InvoiceRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(InvoiceRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get item issuance roles
	 */
	public List<ItemIssuanceRole> getItemIssuanceRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ItemIssuanceRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ItemIssuanceRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ItemIssuanceRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get interviewee job interviews
	 */
	public List<JobInterview> getIntervieweeJobInterviews(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<JobInterview> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(JobInterview.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("jobIntervieweePartyId",
						EntityOperator.EQUALS, party.getPartyId())),
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
	 * Get interviewer job interviews
	 */
	public List<JobInterview> getInterviewerJobInterviews(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<JobInterview> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(JobInterview.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("jobInterviewerPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
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
	 * Get marketing campaign roles
	 */
	public List<MarketingCampaignRole> getMarketingCampaignRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<MarketingCampaignRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(MarketingCampaignRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaignRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get note note datas
	 */
	public List<NoteData> getNoteNoteDatas(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<NoteData> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(NoteData.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("noteParty", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = NoteData.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item roles
	 */
	public List<OrderItemRole> getOrderItemRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderItemRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(OrderItemRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get supplier order item ship groups
	 */
	public List<OrderItemShipGroup> getSupplierOrderItemShipGroups(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemShipGroup> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(OrderItemShipGroup.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("supplierPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get vendor order item ship groups
	 */
	public List<OrderItemShipGroup> getVendorOrderItemShipGroups(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemShipGroup> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(OrderItemShipGroup.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("vendorPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get carrier order item ship groups
	 */
	public List<OrderItemShipGroup> getCarrierOrderItemShipGroups(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemShipGroup> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(OrderItemShipGroup.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("carrierPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order roles
	 */
	public List<OrderRole> getOrderRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(OrderRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party acctg preference
	 */
	public PartyAcctgPreference getPartyAcctgPreference(Party party) {
		List<PartyAcctgPreference> entityList = null;
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get party attributes
	 */
	public List<PartyAttribute> getPartyAttributes(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyAttribute> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyAttribute.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to party benefits
	 */
	public List<PartyBenefit> getToPartyBenefits(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyBenefit> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyBenefit.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyBenefit.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from party benefits
	 */
	public List<PartyBenefit> getFromPartyBenefits(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyBenefit> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyBenefit.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyBenefit.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party carrier accounts
	 */
	public List<PartyCarrierAccount> getPartyCarrierAccounts(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyCarrierAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyCarrierAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyCarrierAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get carrier party carrier accounts
	 */
	public List<PartyCarrierAccount> getCarrierPartyCarrierAccounts(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<PartyCarrierAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyCarrierAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("carrierPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyCarrierAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party classifications
	 */
	public List<PartyClassification> getPartyClassifications(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyClassification> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyClassification.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyClassification.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party contact meches
	 */
	public List<PartyContactMech> getPartyContactMeches(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyContactMech> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyContactMech.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyContactMech.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party contact mech purposes
	 */
	public List<PartyContactMechPurpose> getPartyContactMechPurposes(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<PartyContactMechPurpose> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyContactMechPurpose.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyContactMechPurpose.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party contents
	 */
	public List<PartyContent> getPartyContents(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyContent> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyContent.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party data sources
	 */
	public List<PartyDataSource> getPartyDataSources(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyDataSource> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyDataSource.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyDataSource.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party fixed asset assignments
	 */
	public List<PartyFixedAssetAssignment> getPartyFixedAssetAssignments(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<PartyFixedAssetAssignment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyFixedAssetAssignment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyFixedAssetAssignment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party geo points
	 */
	public List<PartyGeoPoint> getPartyGeoPoints(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyGeoPoint> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyGeoPoint.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyGeoPoint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get organization party gl accounts
	 */
	public List<PartyGlAccount> getOrganizationPartyGlAccounts(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyGlAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyGlAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyGlAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party gl accounts
	 */
	public List<PartyGlAccount> getPartyGlAccounts(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyGlAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyGlAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyGlAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party group
	 */
	public PartyGroup getPartyGroup(Party party) {
		List<PartyGroup> entityList = null;
		In in = new In();
		in.setEntityName(PartyGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyGroup.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get party ics avs override
	 */
	public PartyIcsAvsOverride getPartyIcsAvsOverride(Party party) {
		List<PartyIcsAvsOverride> entityList = null;
		In in = new In();
		in.setEntityName(PartyIcsAvsOverride.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyIcsAvsOverride.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get party identifications
	 */
	public List<PartyIdentification> getPartyIdentifications(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyIdentification> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyIdentification.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyIdentification.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party invitations
	 */
	public List<PartyInvitation> getPartyInvitations(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyInvitation> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyInvitation.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyInvitation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to party invitation group assocs
	 */
	public List<PartyInvitationGroupAssoc> getToPartyInvitationGroupAssocs(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<PartyInvitationGroupAssoc> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyInvitationGroupAssoc.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyInvitationGroupAssoc.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party name histories
	 */
	public List<PartyNameHistory> getPartyNameHistories(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyNameHistory> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyNameHistory.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyNameHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party needs
	 */
	public List<PartyNeed> getPartyNeeds(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyNeed> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyNeed.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyNeed.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party notes
	 */
	public List<PartyNote> getPartyNotes(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyNote> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyNote.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party pref doc type tpls
	 */
	public List<PartyPrefDocTypeTpl> getPartyPrefDocTypeTpls(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyPrefDocTypeTpl> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyPrefDocTypeTpl.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyPrefDocTypeTpl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party profile defaults
	 */
	public List<PartyProfileDefault> getPartyProfileDefaults(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyProfileDefault> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyProfileDefault.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyProfileDefault.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party quals
	 */
	public List<PartyQual> getPartyQuals(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyQual> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyQual.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyQual.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party rates
	 */
	public List<PartyRate> getPartyRates(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyRate> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyRate.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from party relationships
	 */
	public List<PartyRelationship> getFromPartyRelationships(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyRelationship> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyRelationship.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationship.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to party relationships
	 */
	public List<PartyRelationship> getToPartyRelationships(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyRelationship> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyRelationship.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationship.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party resumes
	 */
	public List<PartyResume> getPartyResumes(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyResume> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyResume.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyResume.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party roles
	 */
	public List<PartyRole> getPartyRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party skills
	 */
	public List<PartySkill> getPartySkills(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartySkill> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartySkill.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartySkill.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party statuses
	 */
	public List<PartyStatus> getPartyStatuses(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyStatus> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyStatus.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party tax auth infoes
	 */
	public List<PartyTaxAuthInfo> getPartyTaxAuthInfoes(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyTaxAuthInfo> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PartyTaxAuthInfo.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyTaxAuthInfo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from payments
	 */
	public List<Payment> getFromPayments(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Payment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Payment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Payment.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to payments
	 */
	public List<Payment> getToPayments(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Payment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Payment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Payment.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get payment gl account type maps
	 */
	public List<PaymentGlAccountTypeMap> getPaymentGlAccountTypeMaps(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<PaymentGlAccountTypeMap> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PaymentGlAccountTypeMap.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGlAccountTypeMap.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get payment methods
	 */
	public List<PaymentMethod> getPaymentMethods(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PaymentMethod> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PaymentMethod.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentMethod.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get organization payment method type gl accounts
	 */
	public List<PaymentMethodTypeGlAccount> getOrganizationPaymentMethodTypeGlAccounts(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<PaymentMethodTypeGlAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PaymentMethodTypeGlAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentMethodTypeGlAccount.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get payroll preferences
	 */
	public List<PayrollPreference> getPayrollPreferences(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PayrollPreference> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PayrollPreference.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PayrollPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get employee perf reviews
	 */
	public List<PerfReview> getEmployeePerfReviews(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PerfReview> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PerfReview.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("employeePartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReview.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get manager perf reviews
	 */
	public List<PerfReview> getManagerPerfReviews(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PerfReview> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PerfReview.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("managerPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReview.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get employee perf review items
	 */
	public List<PerfReviewItem> getEmployeePerfReviewItems(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PerfReviewItem> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PerfReviewItem.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("employeePartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReviewItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get performance notes
	 */
	public List<PerformanceNote> getPerformanceNotes(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<PerformanceNote> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PerformanceNote.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerformanceNote.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get person
	 */
	public Person getPerson(Party party) {
		List<Person> entityList = null;
		In in = new In();
		in.setEntityName(Person.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Person.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get person trainings
	 */
	public List<PersonTraining> getPersonTrainings(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<PersonTraining> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(PersonTraining.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PersonTraining.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get prod catalog roles
	 */
	public List<ProdCatalogRole> getProdCatalogRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ProdCatalogRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProdCatalogRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdCatalogRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product average costs
	 */
	public List<ProductAverageCost> getProductAverageCosts(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductAverageCost> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductAverageCost.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductAverageCost.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product category gl accounts
	 */
	public List<ProductCategoryGlAccount> getProductCategoryGlAccounts(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<ProductCategoryGlAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductCategoryGlAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryGlAccount.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product category roles
	 */
	public List<ProductCategoryRole> getProductCategoryRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductCategoryRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductCategoryRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product gl accounts
	 */
	public List<ProductGlAccount> getProductGlAccounts(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductGlAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductGlAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductGlAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tax authority product prices
	 */
	public List<ProductPrice> getTaxAuthorityProductPrices(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductPrice> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductPrice.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPrice.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product promoes
	 */
	public List<ProductPromo> getProductPromoes(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductPromo> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductPromo.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("overrideOrgPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product promo code parties
	 */
	public List<ProductPromoCodeParty> getProductPromoCodeParties(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductPromoCodeParty> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductPromoCodeParty.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCodeParty.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product promice
	 */
	public List<ProductPromoUse> getProductPromice(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductPromoUse> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductPromoUse.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoUse.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product roles
	 */
	public List<ProductRole> getProductRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product stores
	 */
	public List<ProductStore> getProductStores(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductStore> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("payToPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
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
	 * Get product store group roles
	 */
	public List<ProductStoreGroupRole> getProductStoreGroupRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductStoreGroupRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductStoreGroupRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreGroupRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store roles
	 */
	public List<ProductStoreRole> getProductStoreRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductStoreRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductStoreRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store shipment meths
	 */
	public List<ProductStoreShipmentMeth> getProductStoreShipmentMeths(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<ProductStoreShipmentMeth> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductStoreShipmentMeth.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("companyPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreShipmentMeth.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get vendor product store vendor payments
	 */
	public List<ProductStoreVendorPayment> getVendorProductStoreVendorPayments(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<ProductStoreVendorPayment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductStoreVendorPayment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("vendorPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
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
	 * Get vendor product store vendor shipments
	 */
	public List<ProductStoreVendorShipment> getVendorProductStoreVendorShipments(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<ProductStoreVendorShipment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductStoreVendorShipment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("vendorPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreVendorShipment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get carrier product store vendor shipments
	 */
	public List<ProductStoreVendorShipment> getCarrierProductStoreVendorShipments(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<ProductStoreVendorShipment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ProductStoreVendorShipment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("carrierPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreVendorShipment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quotes
	 */
	public List<Quote> getQuotes(Party party, Integer start, Integer number,
			List<String> orderBy) {
		List<Quote> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Quote.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
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
	 * Get quote roles
	 */
	public List<QuoteRole> getQuoteRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<QuoteRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(QuoteRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get rate amounts
	 */
	public List<RateAmount> getRateAmounts(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<RateAmount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(RateAmount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RateAmount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get reorder guidelines
	 */
	public List<ReorderGuideline> getReorderGuidelines(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ReorderGuideline> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ReorderGuideline.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReorderGuideline.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get requirement roles
	 */
	public List<RequirementRole> getRequirementRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<RequirementRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(RequirementRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get responding parties
	 */
	public List<RespondingParty> getRespondingParties(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<RespondingParty> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(RespondingParty.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RespondingParty.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get return headers
	 */
	public List<ReturnHeader> getReturnHeaders(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<ReturnHeader> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ReturnHeader.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("fromPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnHeader.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to return headers
	 */
	public List<ReturnHeader> getToReturnHeaders(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<ReturnHeader> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ReturnHeader.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("toPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnHeader.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get organization sales forecasts
	 */
	public List<SalesForecast> getOrganizationSalesForecasts(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<SalesForecast> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SalesForecast.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesForecast.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get internal sales forecasts
	 */
	public List<SalesForecast> getInternalSalesForecasts(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<SalesForecast> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SalesForecast.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("internalPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesForecast.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get organization sales forecast histories
	 */
	public List<SalesForecastHistory> getOrganizationSalesForecastHistories(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<SalesForecastHistory> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SalesForecastHistory.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesForecastHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get internal sales forecast histories
	 */
	public List<SalesForecastHistory> getInternalSalesForecastHistories(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<SalesForecastHistory> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SalesForecastHistory.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("internalPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesForecastHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales opportunity roles
	 */
	public List<SalesOpportunityRole> getSalesOpportunityRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<SalesOpportunityRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SalesOpportunityRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunityRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get segment group roles
	 */
	public List<SegmentGroupRole> getSegmentGroupRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<SegmentGroupRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SegmentGroupRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SegmentGroupRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get server hits
	 */
	public List<ServerHit> getServerHits(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<ServerHit> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ServerHit.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ServerHit.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to shipments
	 */
	public List<Shipment> getToShipments(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Shipment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Shipment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdTo", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Shipment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get from shipments
	 */
	public List<Shipment> getFromShipments(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Shipment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Shipment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdFrom", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Shipment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shipment cost estimates
	 */
	public List<ShipmentCostEstimate> getShipmentCostEstimates(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentCostEstimate> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ShipmentCostEstimate.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentCostEstimate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shipment receipt roles
	 */
	public List<ShipmentReceiptRole> getShipmentReceiptRoles(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentReceiptRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ShipmentReceiptRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentReceiptRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get carrier shipment route segments
	 */
	public List<ShipmentRouteSegment> getCarrierShipmentRouteSegments(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<ShipmentRouteSegment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ShipmentRouteSegment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("carrierPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentRouteSegment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shopping lists
	 */
	public List<ShoppingList> getShoppingLists(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<ShoppingList> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingList.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get subscriptions
	 */
	public List<Subscription> getSubscriptions(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Subscription> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Subscription.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get originated from subscriptions
	 */
	public List<Subscription> getOriginatedFromSubscriptions(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<Subscription> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("originatedFromPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Subscription.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get supplier products
	 */
	public List<SupplierProduct> getSupplierProducts(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<SupplierProduct> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SupplierProduct.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SupplierProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get supplier product features
	 */
	public List<SupplierProductFeature> getSupplierProductFeatures(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<SupplierProductFeature> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SupplierProductFeature.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SupplierProductFeature.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get survey responses
	 */
	public List<SurveyResponse> getSurveyResponses(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<SurveyResponse> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(SurveyResponse.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyResponse.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tax auth tax authorities
	 */
	public List<TaxAuthority> getTaxAuthTaxAuthorities(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<TaxAuthority> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(TaxAuthority.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthority.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get organization tax authority gl accounts
	 */
	public List<TaxAuthorityGlAccount> getOrganizationTaxAuthorityGlAccounts(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<TaxAuthorityGlAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(TaxAuthorityGlAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityGlAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get time entries
	 */
	public List<TimeEntry> getTimeEntries(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<TimeEntry> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(TimeEntry.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TimeEntry.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get timesheets
	 */
	public List<Timesheet> getTimesheets(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Timesheet> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Timesheet.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Timesheet.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get client timesheets
	 */
	public List<Timesheet> getClientTimesheets(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<Timesheet> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(Timesheet.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("clientPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Timesheet.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get timesheet roles
	 */
	public List<TimesheetRole> getTimesheetRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<TimesheetRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(TimesheetRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TimesheetRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get user logins
	 */
	public List<UserLogin> getUserLogins(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<UserLogin> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get user login histories
	 */
	public List<UserLoginHistory> getUserLoginHistories(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<UserLoginHistory> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(UserLoginHistory.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLoginHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get organization variance reason gl accounts
	 */
	public List<VarianceReasonGlAccount> getOrganizationVarianceReasonGlAccounts(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<VarianceReasonGlAccount> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(VarianceReasonGlAccount.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("organizationPartyId",
						EntityOperator.EQUALS, party.getPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VarianceReasonGlAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get vendor
	 */
	public Vendor getVendor(Party party) {
		List<Vendor> entityList = null;
		In in = new In();
		in.setEntityName(Vendor.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Vendor.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return entityList.get(0);
		}
		return null;
	}

	/**
	 * Get vendor vendor products
	 */
	public List<VendorProduct> getVendorVendorProducts(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<VendorProduct> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(VendorProduct.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("vendorPartyId", EntityOperator.EQUALS,
						party.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VendorProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web site roles
	 */
	public List<WebSiteRole> getWebSiteRoles(Party party, Integer start,
			Integer number, List<String> orderBy) {
		List<WebSiteRole> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(WebSiteRole.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSiteRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web user preferences
	 */
	public List<WebUserPreference> getWebUserPreferences(Party party,
			Integer start, Integer number, List<String> orderBy) {
		List<WebUserPreference> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(WebUserPreference.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebUserPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort event reminders
	 */
	public List<WorkEffortEventReminder> getWorkEffortEventReminders(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<WorkEffortEventReminder> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(WorkEffortEventReminder.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortEventReminder.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort party assignments
	 */
	public List<WorkEffortPartyAssignment> getWorkEffortPartyAssignments(
			Party party, Integer start, Integer number, List<String> orderBy) {
		List<WorkEffortPartyAssignment> entityList = new ArrayList<>();
		In in = new In();
		in.setEntityName(WorkEffortPartyAssignment.NAME);
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS, party
						.getPartyId())), EntityOperator.AND));
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