package org.apache.ofbiz.security.login.service.base;

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
import org.apache.ofbiz.security.login.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.party.party.Person;
import org.apache.ofbiz.party.party.PartyGroup;
import org.apache.ofbiz.accounting.budget.BudgetStatus;
import org.apache.ofbiz.marketing.contact.ContactList;
import org.apache.ofbiz.marketing.contact.ContactListCommStatus;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.content.content.ContentAssoc;
import org.apache.ofbiz.order.request.CustRequestStatus;
import org.apache.ofbiz.content.data.DataResource;
import org.apache.ofbiz.accounting.finaccount.FinAccountStatus;
import org.apache.ofbiz.product.inventory.InventoryItemStatus;
import org.apache.ofbiz.accounting.invoice.InvoiceStatus;
import org.apache.ofbiz.shipment.issuance.ItemIssuance;
import org.apache.ofbiz.service.schedule.JobSandbox;
import org.apache.ofbiz.order.order.OrderAdjustment;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.order.order.OrderItem;
import org.apache.ofbiz.order.order.OrderItemChange;
import org.apache.ofbiz.order.order.OrderPaymentPreference;
import org.apache.ofbiz.order.order.OrderStatus;
import org.apache.ofbiz.party.party.PartyStatus;
import org.apache.ofbiz.shipment.picklist.PicklistRole;
import org.apache.ofbiz.shipment.picklist.PicklistStatusHistory;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.price.ProductFeaturePrice;
import org.apache.ofbiz.product.price.ProductPrice;
import org.apache.ofbiz.product.price.ProductPriceChange;
import org.apache.ofbiz.product.promo.ProductPromo;
import org.apache.ofbiz.product.promo.ProductPromoCode;
import org.apache.ofbiz.product.product.ProductReview;
import org.apache.ofbiz.order.quote.QuoteAdjustment;
import org.apache.ofbiz.order.requirement.RequirementStatus;
import org.apache.ofbiz.order._return.ReturnAdjustment;
import org.apache.ofbiz.order._return.ReturnHeader;
import org.apache.ofbiz.order._return.ReturnStatus;
import org.apache.ofbiz.marketing.opportunity.SalesForecast;
import org.apache.ofbiz.marketing.opportunity.SalesForecastHistory;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunity;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunityHistory;
import org.apache.ofbiz.shipment.receipt.ShipmentReceipt;
import org.apache.ofbiz.shipment.shipment.ShipmentStatus;
import org.apache.ofbiz.entity.test.TestingStatus;
import org.apache.ofbiz.workeffort.timesheet.Timesheet;
import org.apache.ofbiz.security.login.UserLoginHistory;
import org.apache.ofbiz.security.login.UserLoginPasswordHistory;
import org.apache.ofbiz.security.securitygroup.UserLoginSecurityGroup;
import org.apache.ofbiz.security.login.UserLoginSecurityQuestion;
import org.apache.ofbiz.security.login.UserLoginSession;
import org.apache.ofbiz.webapp.visit.Visitor;
import org.apache.ofbiz.content.preference.WebUserPreference;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortPartyAssignment;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortReview;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortStatus;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class UserLoginBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public UserLoginBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count UserLogins
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find UserLogins
	 */
	public List<UserLogin> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<UserLogin> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UserLogin.NAME);
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
	 * Find one UserLogin
	 */
	public Optional<UserLogin> findOne(Object userLoginId) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLoginId)), EntityOperator.AND));
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
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get party
	 */
	public Optional<Party> getParty(UserLogin userLogin) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						userLogin.getPartyId())), EntityOperator.AND));
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
	 * Get person
	 */
	public Optional<Person> getPerson(UserLogin userLogin) {
		List<Person> entityList = null;
		In in = new In();
		in.setEntityName(Person.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						userLogin.getPartyId())), EntityOperator.AND));
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
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get party group
	 */
	public Optional<PartyGroup> getPartyGroup(UserLogin userLogin) {
		List<PartyGroup> entityList = null;
		In in = new In();
		in.setEntityName(PartyGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						userLogin.getPartyId())), EntityOperator.AND));
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
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get change by budget statuses
	 */
	public List<BudgetStatus> getChangeByBudgetStatuses(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<BudgetStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get created by contact lists
	 */
	public List<ContactList> getCreatedByContactLists(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ContactList> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContactList.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
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
	 * Get last modified by contact lists
	 */
	public List<ContactList> getLastModifiedByContactLists(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ContactList> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContactList.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
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
	 * Get change by contact list comm statuses
	 */
	public List<ContactListCommStatus> getChangeByContactListCommStatuses(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<ContactListCommStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContactListCommStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
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
	 * Get created by contents
	 */
	public List<Content> getCreatedByContents(UserLogin userLogin,
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
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get last modified by contents
	 */
	public List<Content> getLastModifiedByContents(UserLogin userLogin,
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
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get created by content assocs
	 */
	public List<ContentAssoc> getCreatedByContentAssocs(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ContentAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get last modified by content assocs
	 */
	public List<ContentAssoc> getLastModifiedByContentAssocs(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<ContentAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get change by cust request statuses
	 */
	public List<CustRequestStatus> getChangeByCustRequestStatuses(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<CustRequestStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get created by data resources
	 */
	public List<DataResource> getCreatedByDataResources(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<DataResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResource.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get last modified by data resources
	 */
	public List<DataResource> getLastModifiedByDataResources(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<DataResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResource.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fin account statuses
	 */
	public List<FinAccountStatus> getFinAccountStatuses(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<FinAccountStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get inventory item statuses
	 */
	public List<InventoryItemStatus> getInventoryItemStatuses(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<InventoryItemStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItemStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItemStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get change by invoice statuses
	 */
	public List<InvoiceStatus> getChangeByInvoiceStatuses(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<InvoiceStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get issued by item issuances
	 */
	public List<ItemIssuance> getIssuedByItemIssuances(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ItemIssuance> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ItemIssuance.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("issuedByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ItemIssuance.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get auth job sandboxes
	 */
	public List<JobSandbox> getAuthJobSandboxes(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<JobSandbox> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(JobSandbox.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("authUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = JobSandbox.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get run as job sandboxes
	 */
	public List<JobSandbox> getRunAsJobSandboxes(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<JobSandbox> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(JobSandbox.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("runAsUser", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = JobSandbox.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order adjustments
	 */
	public List<OrderAdjustment> getOrderAdjustments(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderAdjustment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderAdjustment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get created by order headers
	 */
	public List<OrderHeader> getCreatedByOrderHeaders(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("createdBy", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
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
	 * Get dont cancel set order items
	 */
	public List<OrderItem> getDontCancelSetOrderItems(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dontCancelSetUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get change by order items
	 */
	public List<OrderItem> getChangeByOrderItems(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItem.fromValues(out.getListIt()
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
	public List<OrderItemChange> getOrderItemChanges(UserLogin userLogin,
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
				.asList(new EntityExpr("changeUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get order payment preferences
	 */
	public List<OrderPaymentPreference> getOrderPaymentPreferences(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderPaymentPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderPaymentPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderPaymentPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order statuses
	 */
	public List<OrderStatus> getOrderStatuses(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get created by parties
	 */
	public List<Party> getCreatedByParties(UserLogin userLogin, Integer start,
			Integer number, List<String> orderBy) {
		List<Party> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Party.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
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
	 * Get last modified by parties
	 */
	public List<Party> getLastModifiedByParties(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<Party> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Party.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
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
	 * Get change by party statuses
	 */
	public List<PartyStatus> getChangeByPartyStatuses(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
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
	 * Get created by picklist roles
	 */
	public List<PicklistRole> getCreatedByPicklistRoles(UserLogin userLogin,
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
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get last modified by picklist roles
	 */
	public List<PicklistRole> getLastModifiedByPicklistRoles(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
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
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get change picklist status histories
	 */
	public List<PicklistStatusHistory> getChangePicklistStatusHistories(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<PicklistStatusHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PicklistStatusHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PicklistStatusHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get created by products
	 */
	public List<Product> getCreatedByProducts(UserLogin userLogin,
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
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get last modified by products
	 */
	public List<Product> getLastModifiedByProducts(UserLogin userLogin,
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
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get created by product feature prices
	 */
	public List<ProductFeaturePrice> getCreatedByProductFeaturePrices(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductFeaturePrice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeaturePrice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeaturePrice.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get last modified by product feature prices
	 */
	public List<ProductFeaturePrice> getLastModifiedByProductFeaturePrices(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductFeaturePrice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeaturePrice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeaturePrice.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get created by product prices
	 */
	public List<ProductPrice> getCreatedByProductPrices(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductPrice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPrice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
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
	 * Get last modified by product prices
	 */
	public List<ProductPrice> getLastModifiedByProductPrices(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPrice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPrice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
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
	 * Get changed by product price changes
	 */
	public List<ProductPriceChange> getChangedByProductPriceChanges(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPriceChange> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPriceChange.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPriceChange.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get created by product promoes
	 */
	public List<ProductPromo> getCreatedByProductPromoes(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductPromo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get last modified by product promoes
	 */
	public List<ProductPromo> getLastModifiedByProductPromoes(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPromo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get created by product promo codes
	 */
	public List<ProductPromoCode> getCreatedByProductPromoCodes(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPromoCode> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoCode.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCode.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get last modified by product promo codes
	 */
	public List<ProductPromoCode> getLastModifiedByProductPromoCodes(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPromoCode> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoCode.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("lastModifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCode.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product reviews
	 */
	public List<ProductReview> getProductReviews(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductReview> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductReview.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductReview.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quote adjustments
	 */
	public List<QuoteAdjustment> getQuoteAdjustments(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<QuoteAdjustment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteAdjustment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteAdjustment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get change by requirement statuses
	 */
	public List<RequirementStatus> getChangeByRequirementStatuses(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<RequirementStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get return adjustments
	 */
	public List<ReturnAdjustment> getReturnAdjustments(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ReturnAdjustment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnAdjustment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnAdjustment.fromValues(out.getListIt()
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
	public List<ReturnHeader> getReturnHeaders(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ReturnHeader> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnHeader.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdBy", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
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
	 * Get change by return statuses
	 */
	public List<ReturnStatus> getChangeByReturnStatuses(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ReturnStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get created by sales forecasts
	 */
	public List<SalesForecast> getCreatedBySalesForecasts(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<SalesForecast> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesForecast.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("createdByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get modified by sales forecasts
	 */
	public List<SalesForecast> getModifiedBySalesForecasts(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<SalesForecast> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesForecast.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("modifiedByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get modified by sales forecast histories
	 */
	public List<SalesForecastHistory> getModifiedBySalesForecastHistories(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<SalesForecastHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesForecastHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("modifiedByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get sales opportunities
	 */
	public List<SalesOpportunity> getSalesOpportunities(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("createdByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
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
	 * Get sales opportunity histories
	 */
	public List<SalesOpportunityHistory> getSalesOpportunityHistories(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<SalesOpportunityHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesOpportunityHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("modifiedByUserLogin",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunityHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shipment receipts
	 */
	public List<ShipmentReceipt> getShipmentReceipts(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentReceipt> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentReceipt.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("receivedByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentReceipt.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get change by shipment statuses
	 */
	public List<ShipmentStatus> getChangeByShipmentStatuses(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<ShipmentStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get change by testing statuses
	 */
	public List<TestingStatus> getChangeByTestingStatuses(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<TestingStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TestingStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("changeByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TestingStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get approved by timesheets
	 */
	public List<Timesheet> getApprovedByTimesheets(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<Timesheet> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Timesheet.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("approvedByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
				EntityOperator.AND));
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
	 * Get user login histories
	 */
	public List<UserLoginHistory> getUserLoginHistories(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<UserLoginHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UserLoginHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
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
	 * Get user login password histories
	 */
	public List<UserLoginPasswordHistory> getUserLoginPasswordHistories(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<UserLoginPasswordHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UserLoginPasswordHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLoginPasswordHistory.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get user login security groups
	 */
	public List<UserLoginSecurityGroup> getUserLoginSecurityGroups(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<UserLoginSecurityGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UserLoginSecurityGroup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLoginSecurityGroup.fromValues(out.getListIt()
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
			UserLogin userLogin, Integer start, Integer number,
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
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
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
	 * Get user login session
	 */
	public Optional<UserLoginSession> getUserLoginSession(UserLogin userLogin) {
		List<UserLoginSession> entityList = null;
		In in = new In();
		in.setEntityName(UserLoginSession.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLoginSession.fromValues(out.getListIt()
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
	 * Get visitors
	 */
	public List<Visitor> getVisitors(UserLogin userLogin, Integer start,
			Integer number, List<String> orderBy) {
		List<Visitor> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Visitor.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Visitor.fromValues(out.getListIt().getPartialList(
						start, number));
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
	public List<WebUserPreference> getWebUserPreferences(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<WebUserPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebUserPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
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
	 * Get assigned by work effort party assignments
	 */
	public List<WorkEffortPartyAssignment> getAssignedByWorkEffortPartyAssignments(
			UserLogin userLogin, Integer start, Integer number,
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
				.asList(new EntityExpr("assignedByUserLoginId",
						EntityOperator.EQUALS, userLogin.getUserLoginId())),
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
	 * Get work effort reviews
	 */
	public List<WorkEffortReview> getWorkEffortReviews(UserLogin userLogin,
			Integer start, Integer number, List<String> orderBy) {
		List<WorkEffortReview> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortReview.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortReview.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get set by work effort statuses
	 */
	public List<WorkEffortStatus> getSetByWorkEffortStatuses(
			UserLogin userLogin, Integer start, Integer number,
			List<String> orderBy) {
		List<WorkEffortStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("setByUserLogin", EntityOperator.EQUALS,
						userLogin.getUserLoginId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}