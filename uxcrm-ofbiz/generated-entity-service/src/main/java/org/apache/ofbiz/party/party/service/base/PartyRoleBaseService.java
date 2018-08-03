package org.apache.ofbiz.party.party.service.base;

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
import org.apache.ofbiz.party.party.PartyRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.RoleType;
import org.apache.ofbiz.party.party.RoleTypeAttr;
import org.apache.ofbiz.party.party.PartyAttribute;
import org.apache.ofbiz.accounting.ledger.AcctgTrans;
import org.apache.ofbiz.accounting.ledger.AcctgTransEntry;
import org.apache.ofbiz.party.agreement.Agreement;
import org.apache.ofbiz.party.agreement.AgreementRole;
import org.apache.ofbiz.accounting.payment.BillingAccountRole;
import org.apache.ofbiz.accounting.budget.BudgetRole;
import org.apache.ofbiz.shipment.shipment.CarrierShipmentMethod;
import org.apache.ofbiz.party.communication.CommunicationEvent;
import org.apache.ofbiz.party.communication.CommunicationEventRole;
import org.apache.ofbiz.content.content.ContentRole;
import org.apache.ofbiz.order.request.CustRequestParty;
import org.apache.ofbiz.content.data.DataResourceRole;
import org.apache.ofbiz.humanres.employment.Employment;
import org.apache.ofbiz.product.facility.FacilityGroupRole;
import org.apache.ofbiz.product.facility.FacilityParty;
import org.apache.ofbiz.accounting.finaccount.FinAccountRole;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;
import org.apache.ofbiz.accounting.ledger.GlAccountOrganization;
import org.apache.ofbiz.accounting.ledger.GlAccountRole;
import org.apache.ofbiz.accounting.invoice.Invoice;
import org.apache.ofbiz.accounting.invoice.InvoiceRole;
import org.apache.ofbiz.shipment.issuance.ItemIssuanceRole;
import org.apache.ofbiz.marketing.campaign.MarketingCampaignRole;
import org.apache.ofbiz.order.request.OldCustRequestRole;
import org.apache.ofbiz.order.order.OldOrderShipmentPreference;
import org.apache.ofbiz.order.order.OrderItemRole;
import org.apache.ofbiz.order.order.OrderItemShipGroup;
import org.apache.ofbiz.order.order.OrderRole;
import org.apache.ofbiz.humanres.employment.PartyBenefit;
import org.apache.ofbiz.party.contact.PartyContactMech;
import org.apache.ofbiz.accounting.fixedasset.PartyFixedAssetAssignment;
import org.apache.ofbiz.accounting.ledger.PartyGlAccount;
import org.apache.ofbiz.party.need.PartyNeed;
import org.apache.ofbiz.party.party.PartyRelationship;
import org.apache.ofbiz.accounting.payment.Payment;
import org.apache.ofbiz.humanres.employment.PayrollPreference;
import org.apache.ofbiz.humanres.ability.PerfReview;
import org.apache.ofbiz.humanres.ability.PerfReviewItem;
import org.apache.ofbiz.humanres.ability.PerformanceNote;
import org.apache.ofbiz.shipment.picklist.PicklistRole;
import org.apache.ofbiz.product.catalog.ProdCatalogRole;
import org.apache.ofbiz.product.category.ProductCategoryRole;
import org.apache.ofbiz.product.product.ProductRole;
import org.apache.ofbiz.product.store.ProductStoreGroupRole;
import org.apache.ofbiz.product.store.ProductStoreRole;
import org.apache.ofbiz.order.quote.QuoteRole;
import org.apache.ofbiz.order.requirement.RequirementRole;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunityRole;
import org.apache.ofbiz.marketing.segment.SegmentGroupRole;
import org.apache.ofbiz.shipment.shipment.ShipmentCostEstimate;
import org.apache.ofbiz.shipment.receipt.ShipmentReceiptRole;
import org.apache.ofbiz.product.subscription.Subscription;
import org.apache.ofbiz.workeffort.timesheet.TimesheetRole;
import org.apache.ofbiz.party.party.WebSiteRole;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortPartyAssignment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyRoleBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyRoleBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PartyRoles
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PartyRoles
	 */
	public List<PartyRole> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PartyRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRole.NAME);
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
	 * Find one PartyRole
	 */
	public Optional<PartyRole> findOne(Object partyId, Object roleTypeId) {
		List<PartyRole> entityList = null;
		In in = new In();
		in.setEntityName(PartyRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyId), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, roleTypeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRole.fromValues(out.getListIt()
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
	 * Get party
	 */
	public Optional<Party> getParty(PartyRole partyRole) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyRole.getPartyId())), EntityOperator.AND));
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
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get role type
	 */
	public Optional<RoleType> getRoleType(PartyRole partyRole) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						partyRole.getRoleTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RoleType.fromValues(out.getListIt()
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
	 * Get role type attrs
	 */
	public List<RoleTypeAttr> getRoleTypeAttrs(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<RoleTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RoleTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						partyRole.getRoleTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RoleTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party attributes
	 */
	public List<PartyAttribute> getPartyAttributes(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyRole.getPartyId())), EntityOperator.AND));
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
	 * Get acctg transes
	 */
	public List<AcctgTrans> getAcctgTranses(PartyRole partyRole, Integer start,
			Integer number, List<String> orderBy) {
		List<AcctgTrans> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTrans.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<AcctgTransEntry> getAcctgTransEntries(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<AcctgTransEntry> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTransEntry.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get from agreements
	 */
	public List<Agreement> getFromAgreements(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<Agreement> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Agreement.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdFrom",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<Agreement> getToAgreements(PartyRole partyRole, Integer start,
			Integer number, List<String> orderBy) {
		List<Agreement> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Agreement.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdTo",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get agreement roles
	 */
	public List<AgreementRole> getAgreementRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<AgreementRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<BillingAccountRole> getBillingAccountRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<BillingAccountRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BillingAccountRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get budget roles
	 */
	public List<BudgetRole> getBudgetRoles(PartyRole partyRole, Integer start,
			Integer number, List<String> orderBy) {
		List<BudgetRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get carrier shipment methods
	 */
	public List<CarrierShipmentMethod> getCarrierShipmentMethods(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<CarrierShipmentMethod> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CarrierShipmentMethod.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<CommunicationEvent> getToCommunicationEvents(
			PartyRole partyRole, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdTo",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<CommunicationEvent> getFromCommunicationEvents(
			PartyRole partyRole, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdFrom",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<CommunicationEventRole> getCommunicationEventRoles(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<CommunicationEventRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CommunicationEventRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get content roles
	 */
	public List<ContentRole> getContentRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get cust request parties
	 */
	public List<CustRequestParty> getCustRequestParties(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<CustRequestParty> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestParty.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get data resource roles
	 */
	public List<DataResourceRole> getDataResourceRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<DataResourceRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResourceRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get to employments
	 */
	public List<Employment> getToEmployments(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<Employment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Employment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdTo",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<Employment> getFromEmployments(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<Employment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Employment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdFrom",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get facility group roles
	 */
	public List<FacilityGroupRole> getFacilityGroupRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<FacilityGroupRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityGroupRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<FacilityParty> getFacilityParties(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<FacilityParty> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityParty.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get fin account roles
	 */
	public List<FinAccountRole> getFinAccountRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<FinAccountRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get fixed assets
	 */
	public List<FixedAsset> getFixedAssets(PartyRole partyRole, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get gl account organizations
	 */
	public List<GlAccountOrganization> getGlAccountOrganizations(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<GlAccountOrganization> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountOrganization.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("organizationPartyId", EntityOperator.EQUALS,
						partyRole.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
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
	public List<GlAccountRole> getGlAccountRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<GlAccountRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get invoices
	 */
	public List<Invoice> getInvoices(PartyRole partyRole, Integer start,
			Integer number, List<String> orderBy) {
		List<Invoice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Invoice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get invoice roles
	 */
	public List<InvoiceRole> getInvoiceRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<InvoiceRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<ItemIssuanceRole> getItemIssuanceRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<ItemIssuanceRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ItemIssuanceRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get marketing campaign roles
	 */
	public List<MarketingCampaignRole> getMarketingCampaignRoles(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<MarketingCampaignRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketingCampaignRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get old cust request roles
	 */
	public List<OldCustRequestRole> getOldCustRequestRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<OldCustRequestRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldCustRequestRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldCustRequestRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get carrier old order shipment preferences
	 */
	public List<OldOrderShipmentPreference> getCarrierOldOrderShipmentPreferences(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<OldOrderShipmentPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldOrderShipmentPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("carrierPartyId", EntityOperator.EQUALS,
						partyRole.getPartyId()),
				new EntityExpr("carrierRoleTypeId", EntityOperator.EQUALS,
						partyRole.getRoleTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldOrderShipmentPreference.fromValues(out
						.getListIt().getPartialList(start, number));
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
	public List<OrderItemRole> getOrderItemRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get carrier order item ship groups
	 */
	public List<OrderItemShipGroup> getCarrierOrderItemShipGroups(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemShipGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemShipGroup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("carrierPartyId", EntityOperator.EQUALS,
						partyRole.getPartyId()),
				new EntityExpr("carrierRoleTypeId", EntityOperator.EQUALS,
						partyRole.getRoleTypeId())), EntityOperator.AND));
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
	public List<OrderRole> getOrderRoles(PartyRole partyRole, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get to party benefits
	 */
	public List<PartyBenefit> getToPartyBenefits(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyBenefit> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyBenefit.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdTo",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<PartyBenefit> getFromPartyBenefits(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyBenefit> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyBenefit.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdFrom",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get party contact meches
	 */
	public List<PartyContactMech> getPartyContactMeches(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyContactMech> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyContactMech.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get party fixed asset assignments
	 */
	public List<PartyFixedAssetAssignment> getPartyFixedAssetAssignments(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyFixedAssetAssignment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyFixedAssetAssignment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get party gl accounts
	 */
	public List<PartyGlAccount> getPartyGlAccounts(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
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
	 * Get party needs
	 */
	public List<PartyNeed> getPartyNeeds(PartyRole partyRole, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyNeed> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyNeed.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get from party relationships
	 */
	public List<PartyRelationship> getFromPartyRelationships(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyRelationship> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationship.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdFrom",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<PartyRelationship> getToPartyRelationships(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyRelationship> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationship.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdTo",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get to payments
	 */
	public List<Payment> getToPayments(PartyRole partyRole, Integer start,
			Integer number, List<String> orderBy) {
		List<Payment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Payment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeIdTo",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get payroll preferences
	 */
	public List<PayrollPreference> getPayrollPreferences(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PayrollPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PayrollPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<PerfReview> getEmployeePerfReviews(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PerfReview> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PerfReview.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("employeePartyId", EntityOperator.EQUALS,
						partyRole.getPartyId()),
				new EntityExpr("employeeRoleTypeId", EntityOperator.EQUALS,
						partyRole.getRoleTypeId())), EntityOperator.AND));
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
	public List<PerfReview> getManagerPerfReviews(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PerfReview> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PerfReview.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("managerPartyId", EntityOperator.EQUALS,
						partyRole.getPartyId()),
				new EntityExpr("managerRoleTypeId", EntityOperator.EQUALS,
						partyRole.getRoleTypeId())), EntityOperator.AND));
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
	public List<PerfReviewItem> getEmployeePerfReviewItems(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PerfReviewItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PerfReviewItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("employeePartyId", EntityOperator.EQUALS,
						partyRole.getPartyId()),
				new EntityExpr("employeeRoleTypeId", EntityOperator.EQUALS,
						partyRole.getRoleTypeId())), EntityOperator.AND));
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
	public List<PerformanceNote> getPerformanceNotes(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PerformanceNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PerformanceNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get picklist roles
	 */
	public List<PicklistRole> getPicklistRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<PicklistRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PicklistRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PicklistRole.fromValues(out.getListIt()
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
	public List<ProdCatalogRole> getProdCatalogRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<ProdCatalogRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProdCatalogRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get product category roles
	 */
	public List<ProductCategoryRole> getProductCategoryRoles(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get product roles
	 */
	public List<ProductRole> getProductRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get product store group roles
	 */
	public List<ProductStoreGroupRole> getProductStoreGroupRoles(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStoreGroupRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreGroupRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<ProductStoreRole> getProductStoreRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductStoreRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get quote roles
	 */
	public List<QuoteRole> getQuoteRoles(PartyRole partyRole, Integer start,
			Integer number, List<String> orderBy) {
		List<QuoteRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get requirement roles
	 */
	public List<RequirementRole> getRequirementRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<RequirementRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get sales opportunity roles
	 */
	public List<SalesOpportunityRole> getSalesOpportunityRoles(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<SalesOpportunityRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesOpportunityRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<SegmentGroupRole> getSegmentGroupRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<SegmentGroupRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SegmentGroupRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get shipment cost estimates
	 */
	public List<ShipmentCostEstimate> getShipmentCostEstimates(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<ShipmentCostEstimate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentCostEstimate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	public List<ShipmentReceiptRole> getShipmentReceiptRoles(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<ShipmentReceiptRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentReceiptRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get subscriptions
	 */
	public List<Subscription> getSubscriptions(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<Subscription> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
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
	 * Get originated from subscriptions
	 */
	public List<Subscription> getOriginatedFromSubscriptions(
			PartyRole partyRole, Integer start, Integer number,
			List<String> orderBy) {
		List<Subscription> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("originatedFromPartyId", EntityOperator.EQUALS,
						partyRole.getPartyId()), new EntityExpr(
						"originatedFromRoleTypeId", EntityOperator.EQUALS,
						partyRole.getRoleTypeId())), EntityOperator.AND));
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
	 * Get timesheet roles
	 */
	public List<TimesheetRole> getTimesheetRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<TimesheetRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TimesheetRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get web site roles
	 */
	public List<WebSiteRole> getWebSiteRoles(PartyRole partyRole,
			Integer start, Integer number, List<String> orderBy) {
		List<WebSiteRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebSiteRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
				EntityOperator.AND));
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
	 * Get work effort party assignments
	 */
	public List<WorkEffortPartyAssignment> getWorkEffortPartyAssignments(
			PartyRole partyRole, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyRole
						.getPartyId()), new EntityExpr("roleTypeId",
						EntityOperator.EQUALS, partyRole.getRoleTypeId())),
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