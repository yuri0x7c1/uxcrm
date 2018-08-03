package org.apache.ofbiz.accounting.invoice.service.base;

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
import org.apache.ofbiz.accounting.invoice.InvoiceItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.GlAccount;
import org.apache.ofbiz.party.agreement.AgreementTerm;
import org.apache.ofbiz.accounting.invoice.InvoiceItem;
import org.apache.ofbiz.accounting.invoice.InvoiceItemTypeAttr;
import org.apache.ofbiz.accounting.invoice.InvoiceItemTypeGlAccount;
import org.apache.ofbiz.accounting.invoice.InvoiceItemTypeMap;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class InvoiceItemTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public InvoiceItemTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count InvoiceItemTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(InvoiceItemType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find InvoiceItemTypes
	 */
	public List<InvoiceItemType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<InvoiceItemType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceItemType.NAME);
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
				entityList = InvoiceItemType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one InvoiceItemType
	 */
	public Optional<InvoiceItemType> findOne(Object invoiceItemTypeId) {
		List<InvoiceItemType> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceItemTypeId",
						EntityOperator.EQUALS, invoiceItemTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemType.fromValues(out.getListIt()
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
	 * Get parent invoice item type
	 */
	public Optional<InvoiceItemType> getParentInvoiceItemType(
			InvoiceItemType invoiceItemType) {
		List<InvoiceItemType> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceItemTypeId",
						EntityOperator.EQUALS, invoiceItemType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemType.fromValues(out.getListIt()
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
	 * Get default gl account
	 */
	public Optional<GlAccount> getDefaultGlAccount(
			InvoiceItemType invoiceItemType) {
		List<GlAccount> entityList = null;
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						invoiceItemType.getDefaultGlAccountId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccount.fromValues(out.getListIt()
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
	 * Get agreement terms
	 */
	public List<AgreementTerm> getAgreementTerms(
			InvoiceItemType invoiceItemType, Integer start, Integer number,
			List<String> orderBy) {
		List<AgreementTerm> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementTerm.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceItemTypeId",
						EntityOperator.EQUALS, invoiceItemType
								.getInvoiceItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementTerm.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get invoice items
	 */
	public List<InvoiceItem> getInvoiceItems(InvoiceItemType invoiceItemType,
			Integer start, Integer number, List<String> orderBy) {
		List<InvoiceItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceItemTypeId",
						EntityOperator.EQUALS, invoiceItemType
								.getInvoiceItemTypeId())), EntityOperator.AND));
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
	 * Get child invoice item types
	 */
	public List<InvoiceItemType> getChildInvoiceItemTypes(
			InvoiceItemType invoiceItemType, Integer start, Integer number,
			List<String> orderBy) {
		List<InvoiceItemType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceItemType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						invoiceItemType.getInvoiceItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get invoice item type attrs
	 */
	public List<InvoiceItemTypeAttr> getInvoiceItemTypeAttrs(
			InvoiceItemType invoiceItemType, Integer start, Integer number,
			List<String> orderBy) {
		List<InvoiceItemTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceItemTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceItemTypeId",
						EntityOperator.EQUALS, invoiceItemType
								.getInvoiceItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get invoice item type gl accounts
	 */
	public List<InvoiceItemTypeGlAccount> getInvoiceItemTypeGlAccounts(
			InvoiceItemType invoiceItemType, Integer start, Integer number,
			List<String> orderBy) {
		List<InvoiceItemTypeGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceItemTypeGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceItemTypeId",
						EntityOperator.EQUALS, invoiceItemType
								.getInvoiceItemTypeId())), EntityOperator.AND));
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
	 * Get invoice item type maps
	 */
	public List<InvoiceItemTypeMap> getInvoiceItemTypeMaps(
			InvoiceItemType invoiceItemType, Integer start, Integer number,
			List<String> orderBy) {
		List<InvoiceItemTypeMap> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceItemTypeMap.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceItemTypeId",
						EntityOperator.EQUALS, invoiceItemType
								.getInvoiceItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemTypeMap.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}