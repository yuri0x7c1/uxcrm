package org.apache.ofbiz.order.request.service.base;

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
import org.apache.ofbiz.order.request.CustRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.request.CustRequestType;
import org.apache.ofbiz.order.request.CustRequestCategory;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.order.request.CustRequestTypeAttr;
import org.apache.ofbiz.party.contact.ContactMech;
import org.apache.ofbiz.order.request.CustRequestAttribute;
import org.apache.ofbiz.order.request.CustRequestCommEvent;
import org.apache.ofbiz.order.request.CustRequestContent;
import org.apache.ofbiz.order.request.CustRequestItem;
import org.apache.ofbiz.order.request.CustRequestItemWorkEffort;
import org.apache.ofbiz.order.request.CustRequestNote;
import org.apache.ofbiz.order.request.CustRequestParty;
import org.apache.ofbiz.order.request.CustRequestStatus;
import org.apache.ofbiz.order.request.CustRequestWorkEffort;
import org.apache.ofbiz.order.request.OldCustRequestRole;
import org.apache.ofbiz.order.quote.QuoteItem;
import org.apache.ofbiz.order.requirement.RequirementCustRequest;
import org.apache.ofbiz.order.request.RespondingParty;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CustRequestBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CustRequestBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CustRequests
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CustRequest.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CustRequests
	 */
	public List<CustRequest> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one CustRequest
	 */
	public Optional<CustRequest> findOne(Object custRequestId) {
		List<CustRequest> entityList = null;
		In in = new In();
		in.setEntityName(CustRequest.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequestId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequest.fromValues(out.getListIt()
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
	 * Get cust request type
	 */
	public Optional<CustRequestType> getCustRequestType(CustRequest custRequest) {
		List<CustRequestType> entityList = null;
		In in = new In();
		in.setEntityName(CustRequestType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestTypeId",
						EntityOperator.EQUALS, custRequest
								.getCustRequestTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestType.fromValues(out.getListIt()
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
	 * Get cust request category
	 */
	public Optional<CustRequestCategory> getCustRequestCategory(
			CustRequest custRequest) {
		List<CustRequestCategory> entityList = null;
		In in = new In();
		in.setEntityName(CustRequestCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestCategoryId",
						EntityOperator.EQUALS, custRequest
								.getCustRequestCategoryId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestCategory.fromValues(out.getListIt()
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
	 * Get status item
	 */
	public Optional<StatusItem> getStatusItem(CustRequest custRequest) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						custRequest.getStatusId())), EntityOperator.AND));
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
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get from party
	 */
	public Optional<Party> getFromParty(CustRequest custRequest) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						custRequest.getFromPartyId())), EntityOperator.AND));
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
	 * Get maximum amount uom
	 */
	public Optional<Uom> getMaximumAmountUom(CustRequest custRequest) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						custRequest.getMaximumAmountUomId())),
				EntityOperator.AND));
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
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get product store
	 */
	public Optional<ProductStore> getProductStore(CustRequest custRequest) {
		List<ProductStore> entityList = null;
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreId", EntityOperator.EQUALS,
						custRequest.getProductStoreId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
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
	 * Get sales channel enumeration
	 */
	public Optional<Enumeration> getSalesChannelEnumeration(
			CustRequest custRequest) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						custRequest.getSalesChannelEnumId())),
				EntityOperator.AND));
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
	 * Get cust request type attrs
	 */
	public List<CustRequestTypeAttr> getCustRequestTypeAttrs(
			CustRequest custRequest, Integer start, Integer number,
			List<String> orderBy) {
		List<CustRequestTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestTypeId",
						EntityOperator.EQUALS, custRequest
								.getCustRequestTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fulfill contact mech
	 */
	public Optional<ContactMech> getFulfillContactMech(CustRequest custRequest) {
		List<ContactMech> entityList = null;
		In in = new In();
		in.setEntityName(ContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						custRequest.getFulfillContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactMech.fromValues(out.getListIt()
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
	 * Get currency uom
	 */
	public Optional<Uom> getCurrencyUom(CustRequest custRequest) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						custRequest.getCurrencyUomId())), EntityOperator.AND));
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
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get cust request attributes
	 */
	public List<CustRequestAttribute> getCustRequestAttributes(
			CustRequest custRequest, Integer start, Integer number,
			List<String> orderBy) {
		List<CustRequestAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cust request comm events
	 */
	public List<CustRequestCommEvent> getCustRequestCommEvents(
			CustRequest custRequest, Integer start, Integer number,
			List<String> orderBy) {
		List<CustRequestCommEvent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestCommEvent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestCommEvent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cust request contents
	 */
	public List<CustRequestContent> getCustRequestContents(
			CustRequest custRequest, Integer start, Integer number,
			List<String> orderBy) {
		List<CustRequestContent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestContent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cust request items
	 */
	public List<CustRequestItem> getCustRequestItems(CustRequest custRequest,
			Integer start, Integer number, List<String> orderBy) {
		List<CustRequestItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cust request item work efforts
	 */
	public List<CustRequestItemWorkEffort> getCustRequestItemWorkEfforts(
			CustRequest custRequest, Integer start, Integer number,
			List<String> orderBy) {
		List<CustRequestItemWorkEffort> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestItemWorkEffort.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestItemWorkEffort.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cust request notes
	 */
	public List<CustRequestNote> getCustRequestNotes(CustRequest custRequest,
			Integer start, Integer number, List<String> orderBy) {
		List<CustRequestNote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestNote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestNote.fromValues(out.getListIt()
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
	public List<CustRequestParty> getCustRequestParties(
			CustRequest custRequest, Integer start, Integer number,
			List<String> orderBy) {
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
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
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
	 * Get cust request statuses
	 */
	public List<CustRequestStatus> getCustRequestStatuses(
			CustRequest custRequest, Integer start, Integer number,
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
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
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
	 * Get cust request work efforts
	 */
	public List<CustRequestWorkEffort> getCustRequestWorkEfforts(
			CustRequest custRequest, Integer start, Integer number,
			List<String> orderBy) {
		List<CustRequestWorkEffort> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequestWorkEffort.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequestWorkEffort.fromValues(out.getListIt()
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
	public List<OldCustRequestRole> getOldCustRequestRoles(
			CustRequest custRequest, Integer start, Integer number,
			List<String> orderBy) {
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
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
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
	 * Get quote items
	 */
	public List<QuoteItem> getQuoteItems(CustRequest custRequest,
			Integer start, Integer number, List<String> orderBy) {
		List<QuoteItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get requirement cust requests
	 */
	public List<RequirementCustRequest> getRequirementCustRequests(
			CustRequest custRequest, Integer start, Integer number,
			List<String> orderBy) {
		List<RequirementCustRequest> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementCustRequest.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementCustRequest.fromValues(out.getListIt()
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
	public List<RespondingParty> getRespondingParties(CustRequest custRequest,
			Integer start, Integer number, List<String> orderBy) {
		List<RespondingParty> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RespondingParty.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("custRequestId", EntityOperator.EQUALS,
						custRequest.getCustRequestId())), EntityOperator.AND));
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
}