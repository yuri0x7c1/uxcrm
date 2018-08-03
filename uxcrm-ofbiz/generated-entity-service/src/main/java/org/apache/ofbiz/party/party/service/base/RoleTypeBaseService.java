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
import org.apache.ofbiz.party.party.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.AcctgTrans;
import org.apache.ofbiz.accounting.ledger.AcctgTransEntry;
import org.apache.ofbiz.party.agreement.Agreement;
import org.apache.ofbiz.party.agreement.AgreementRole;
import org.apache.ofbiz.accounting.payment.BillingAccountRole;
import org.apache.ofbiz.party.communication.CommunicationEvent;
import org.apache.ofbiz.party.communication.CommunicationEventRole;
import org.apache.ofbiz.content.content.ContentApproval;
import org.apache.ofbiz.content.content.ContentPurposeOperation;
import org.apache.ofbiz.order.request.CustRequestParty;
import org.apache.ofbiz.product.facility.FacilityGroupRole;
import org.apache.ofbiz.product.facility.FacilityParty;
import org.apache.ofbiz.accounting.finaccount.FinAccountRole;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;
import org.apache.ofbiz.accounting.ledger.GlAccountOrganization;
import org.apache.ofbiz.accounting.ledger.GlAccountRole;
import org.apache.ofbiz.accounting.invoice.Invoice;
import org.apache.ofbiz.accounting.invoice.InvoiceRole;
import org.apache.ofbiz.marketing.campaign.MarketingCampaignRole;
import org.apache.ofbiz.order.request.OldCustRequestRole;
import org.apache.ofbiz.product.facility.OldFacilityRole;
import org.apache.ofbiz.order.order.OrderItemRole;
import org.apache.ofbiz.order.order.OrderRole;
import org.apache.ofbiz.party.contact.PartyContactMech;
import org.apache.ofbiz.accounting.fixedasset.PartyFixedAssetAssignment;
import org.apache.ofbiz.accounting.ledger.PartyGlAccount;
import org.apache.ofbiz.party.party.PartyInvitationRoleAssoc;
import org.apache.ofbiz.party.need.PartyNeed;
import org.apache.ofbiz.party.party.PartyRelationship;
import org.apache.ofbiz.party.party.PartyRelationshipType;
import org.apache.ofbiz.party.party.PartyRole;
import org.apache.ofbiz.accounting.payment.Payment;
import org.apache.ofbiz.shipment.picklist.PicklistRole;
import org.apache.ofbiz.product.catalog.ProdCatalogRole;
import org.apache.ofbiz.product.category.ProductCategoryRole;
import org.apache.ofbiz.product.product.ProductContent;
import org.apache.ofbiz.product.product.ProductRole;
import org.apache.ofbiz.product.store.ProductStoreGroupRole;
import org.apache.ofbiz.product.store.ProductStoreRole;
import org.apache.ofbiz.product.subscription.ProductSubscriptionResource;
import org.apache.ofbiz.order.quote.QuoteRole;
import org.apache.ofbiz.party.party.RoleTypeAttr;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunityRole;
import org.apache.ofbiz.marketing.segment.SegmentGroupRole;
import org.apache.ofbiz.shipment.shipment.ShipmentCostEstimate;
import org.apache.ofbiz.product.subscription.Subscription;
import org.apache.ofbiz.workeffort.timesheet.TimesheetRole;
import org.apache.ofbiz.party.contact.ValidContactMechRole;
import org.apache.ofbiz.party.party.WebSiteRole;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortPartyAssignment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class RoleTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public RoleTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count RoleTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(RoleType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find RoleTypes
	 */
	public List<RoleType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<RoleType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RoleType.NAME);
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
				entityList = RoleType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one RoleType
	 */
	public Optional<RoleType> findOne(Object roleTypeId) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleTypeId)), EntityOperator.AND));
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
	 * Get parent role type
	 */
	public Optional<RoleType> getParentRoleType(RoleType roleType) {
		List<RoleType> entityList = null;
		In in = new In();
		in.setEntityName(RoleType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getParentTypeId())), EntityOperator.AND));
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
	 * Get acctg transes
	 */
	public List<AcctgTrans> getAcctgTranses(RoleType roleType, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<AcctgTransEntry> getAcctgTransEntries(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<Agreement> getFromAgreements(RoleType roleType, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<Agreement> getToAgreements(RoleType roleType, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<AgreementRole> getAgreementRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<BillingAccountRole> getBillingAccountRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get to communication events
	 */
	public List<CommunicationEvent> getToCommunicationEvents(RoleType roleType,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
			RoleType roleType, Integer start, Integer number,
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
				.asList(new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
			RoleType roleType, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get content approvals
	 */
	public List<ContentApproval> getContentApprovals(RoleType roleType,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentApproval> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentApproval.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get content purpose operations
	 */
	public List<ContentPurposeOperation> getContentPurposeOperations(
			RoleType roleType, Integer start, Integer number,
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
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get cust request parties
	 */
	public List<CustRequestParty> getCustRequestParties(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get facility group roles
	 */
	public List<FacilityGroupRole> getFacilityGroupRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<FacilityParty> getFacilityParties(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<FinAccountRole> getFinAccountRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<FixedAsset> getFixedAssets(RoleType roleType, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
			RoleType roleType, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<GlAccountRole> getGlAccountRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<Invoice> getInvoices(RoleType roleType, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<InvoiceRole> getInvoiceRoles(RoleType roleType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get marketing campaign roles
	 */
	public List<MarketingCampaignRole> getMarketingCampaignRoles(
			RoleType roleType, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<OldCustRequestRole> getOldCustRequestRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get old facility roles
	 */
	public List<OldFacilityRole> getOldFacilityRoles(RoleType roleType,
			Integer start, Integer number, List<String> orderBy) {
		List<OldFacilityRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldFacilityRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldFacilityRole.fromValues(out.getListIt()
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
	public List<OrderItemRole> getOrderItemRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get order roles
	 */
	public List<OrderRole> getOrderRoles(RoleType roleType, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get party contact meches
	 */
	public List<PartyContactMech> getPartyContactMeches(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
			RoleType roleType, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<PartyGlAccount> getPartyGlAccounts(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get party invitation role assocs
	 */
	public List<PartyInvitationRoleAssoc> getPartyInvitationRoleAssocs(
			RoleType roleType, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyInvitationRoleAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyInvitationRoleAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyInvitationRoleAssoc.fromValues(out
						.getListIt().getPartialList(start, number));
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
	public List<PartyNeed> getPartyNeeds(RoleType roleType, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<PartyRelationship> getFromPartyRelationships(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<PartyRelationship> getToPartyRelationships(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get valid from party relationship types
	 */
	public List<PartyRelationshipType> getValidFromPartyRelationshipTypes(
			RoleType roleType, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyRelationshipType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationshipType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeIdValidFrom",
						EntityOperator.EQUALS, roleType.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationshipType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get valid to party relationship types
	 */
	public List<PartyRelationshipType> getValidToPartyRelationshipTypes(
			RoleType roleType, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyRelationshipType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationshipType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeIdValidTo",
						EntityOperator.EQUALS, roleType.getRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationshipType.fromValues(out.getListIt()
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
	public List<PartyRole> getPartyRoles(RoleType roleType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get to payments
	 */
	public List<Payment> getToPayments(RoleType roleType, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get picklist roles
	 */
	public List<PicklistRole> getPicklistRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<ProdCatalogRole> getProdCatalogRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<ProductCategoryRole> getProductCategoryRoles(RoleType roleType,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get use product contents
	 */
	public List<ProductContent> getUseProductContents(RoleType roleType,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductContent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductContent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("useRoleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductContent.fromValues(out.getListIt()
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
	public List<ProductRole> getProductRoles(RoleType roleType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
			RoleType roleType, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<ProductStoreRole> getProductStoreRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get use product subscription resources
	 */
	public List<ProductSubscriptionResource> getUseProductSubscriptionResources(
			RoleType roleType, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductSubscriptionResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductSubscriptionResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("useRoleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductSubscriptionResource.fromValues(out
						.getListIt().getPartialList(start, number));
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
	public List<QuoteRole> getQuoteRoles(RoleType roleType, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get child role types
	 */
	public List<RoleType> getChildRoleTypes(RoleType roleType, Integer start,
			Integer number, List<String> orderBy) {
		List<RoleType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RoleType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RoleType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get role type attrs
	 */
	public List<RoleTypeAttr> getRoleTypeAttrs(RoleType roleType,
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
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get sales opportunity roles
	 */
	public List<SalesOpportunityRole> getSalesOpportunityRoles(
			RoleType roleType, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<SegmentGroupRole> getSegmentGroupRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
			RoleType roleType, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get subscriptions
	 */
	public List<Subscription> getSubscriptions(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	public List<Subscription> getOriginatedFromSubscriptions(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("originatedFromRoleTypeId",
						EntityOperator.EQUALS, roleType.getRoleTypeId())),
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
	 * Get timesheet roles
	 */
	public List<TimesheetRole> getTimesheetRoles(RoleType roleType,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
	 * Get valid contact mech roles
	 */
	public List<ValidContactMechRole> getValidContactMechRoles(
			RoleType roleType, Integer start, Integer number,
			List<String> orderBy) {
		List<ValidContactMechRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ValidContactMechRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ValidContactMechRole.fromValues(out.getListIt()
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
	public List<WebSiteRole> getWebSiteRoles(RoleType roleType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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
			RoleType roleType, Integer start, Integer number,
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
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleType.getRoleTypeId())), EntityOperator.AND));
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