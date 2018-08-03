package org.apache.ofbiz.accounting.ledger.service.base;

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
import org.apache.ofbiz.accounting.ledger.GlAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.GlAccountType;
import org.apache.ofbiz.accounting.ledger.GlAccountClass;
import org.apache.ofbiz.accounting.ledger.GlResourceType;
import org.apache.ofbiz.accounting.ledger.GlXbrlClass;
import org.apache.ofbiz.accounting.ledger.AcctgTransEntry;
import org.apache.ofbiz.accounting.finaccount.FinAccount;
import org.apache.ofbiz.accounting.finaccount.FinAccountTypeGlAccount;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetTypeGlAccount;
import org.apache.ofbiz.accounting.ledger.GlAccountCategoryMember;
import org.apache.ofbiz.accounting.ledger.GlAccountGroupMember;
import org.apache.ofbiz.accounting.ledger.GlAccountHistory;
import org.apache.ofbiz.accounting.ledger.GlAccountOrganization;
import org.apache.ofbiz.accounting.ledger.GlAccountRole;
import org.apache.ofbiz.accounting.ledger.GlAccountTypeDefault;
import org.apache.ofbiz.accounting.ledger.GlBudgetXref;
import org.apache.ofbiz.accounting.ledger.GlReconciliation;
import org.apache.ofbiz.accounting.invoice.InvoiceItem;
import org.apache.ofbiz.accounting.invoice.InvoiceItemType;
import org.apache.ofbiz.accounting.invoice.InvoiceItemTypeGlAccount;
import org.apache.ofbiz.order.order.OrderAdjustment;
import org.apache.ofbiz.order.order.OrderItem;
import org.apache.ofbiz.accounting.ledger.PartyGlAccount;
import org.apache.ofbiz.accounting.payment.Payment;
import org.apache.ofbiz.accounting.payment.PaymentApplication;
import org.apache.ofbiz.accounting.payment.PaymentMethod;
import org.apache.ofbiz.accounting.payment.PaymentMethodType;
import org.apache.ofbiz.accounting.payment.PaymentMethodTypeGlAccount;
import org.apache.ofbiz.product.category.ProductCategoryGlAccount;
import org.apache.ofbiz.product.product.ProductGlAccount;
import org.apache.ofbiz.order.quote.QuoteAdjustment;
import org.apache.ofbiz.order._return.ReturnAdjustment;
import org.apache.ofbiz.accounting.tax.TaxAuthorityGlAccount;
import org.apache.ofbiz.accounting.ledger.VarianceReasonGlAccount;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class GlAccountBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public GlAccountBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count GlAccounts
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find GlAccounts
	 */
	public List<GlAccount> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<GlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccount.NAME);
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
				entityList = GlAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one GlAccount
	 */
	public Optional<GlAccount> findOne(Object glAccountId) {
		List<GlAccount> entityList = null;
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccountId)), EntityOperator.AND));
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
	 * Get gl account type
	 */
	public Optional<GlAccountType> getGlAccountType(GlAccount glAccount) {
		List<GlAccountType> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("glAccountTypeId",
						EntityOperator.EQUALS, glAccount.getGlAccountTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountType.fromValues(out.getListIt()
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
	 * Get gl account class
	 */
	public Optional<GlAccountClass> getGlAccountClass(GlAccount glAccount) {
		List<GlAccountClass> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountClass.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("glAccountClassId",
						EntityOperator.EQUALS, glAccount.getGlAccountClassId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountClass.fromValues(out.getListIt()
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
	 * Get gl resource type
	 */
	public Optional<GlResourceType> getGlResourceType(GlAccount glAccount) {
		List<GlResourceType> entityList = null;
		In in = new In();
		in.setEntityName(GlResourceType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("glResourceTypeId",
						EntityOperator.EQUALS, glAccount.getGlResourceTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlResourceType.fromValues(out.getListIt()
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
	 * Get gl xbrl class
	 */
	public Optional<GlXbrlClass> getGlXbrlClass(GlAccount glAccount) {
		List<GlXbrlClass> entityList = null;
		In in = new In();
		in.setEntityName(GlXbrlClass.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glXbrlClassId", EntityOperator.EQUALS,
						glAccount.getGlXbrlClassId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlXbrlClass.fromValues(out.getListIt()
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
	 * Get parent gl account
	 */
	public Optional<GlAccount> getParentGlAccount(GlAccount glAccount) {
		List<GlAccount> entityList = null;
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getParentGlAccountId())), EntityOperator.AND));
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
	 * Get acctg trans entries
	 */
	public List<AcctgTransEntry> getAcctgTransEntries(GlAccount glAccount,
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
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get post to fin accounts
	 */
	public List<FinAccount> getPostToFinAccounts(GlAccount glAccount,
			Integer start, Integer number, List<String> orderBy) {
		List<FinAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("postToGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get fin account type gl accounts
	 */
	public List<FinAccountTypeGlAccount> getFinAccountTypeGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<FinAccountTypeGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTypeGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get asset fixed asset type gl accounts
	 */
	public List<FixedAssetTypeGlAccount> getAssetFixedAssetTypeGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<FixedAssetTypeGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetTypeGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("assetGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get accumulated depreciation fixed asset type gl accounts
	 */
	public List<FixedAssetTypeGlAccount> getAccumulatedDepreciationFixedAssetTypeGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<FixedAssetTypeGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetTypeGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("accDepGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get depreciation fixed asset type gl accounts
	 */
	public List<FixedAssetTypeGlAccount> getDepreciationFixedAssetTypeGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<FixedAssetTypeGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetTypeGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("depGlAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get profit fixed asset type gl accounts
	 */
	public List<FixedAssetTypeGlAccount> getProfitFixedAssetTypeGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<FixedAssetTypeGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetTypeGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("profitGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get loss fixed asset type gl accounts
	 */
	public List<FixedAssetTypeGlAccount> getLossFixedAssetTypeGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<FixedAssetTypeGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetTypeGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("lossGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get child gl accounts
	 */
	public List<GlAccount> getChildGlAccounts(GlAccount glAccount,
			Integer start, Integer number, List<String> orderBy) {
		List<GlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get gl account category members
	 */
	public List<GlAccountCategoryMember> getGlAccountCategoryMembers(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<GlAccountCategoryMember> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountCategoryMember.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountCategoryMember.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get gl account group members
	 */
	public List<GlAccountGroupMember> getGlAccountGroupMembers(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<GlAccountGroupMember> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountGroupMember.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountGroupMember.fromValues(out.getListIt()
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
	public List<GlAccountHistory> getGlAccountHistories(GlAccount glAccount,
			Integer start, Integer number, List<String> orderBy) {
		List<GlAccountHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	public List<GlAccountOrganization> getGlAccountOrganizations(
			GlAccount glAccount, Integer start, Integer number,
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
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	public List<GlAccountRole> getGlAccountRoles(GlAccount glAccount,
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
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get gl account type defaults
	 */
	public List<GlAccountTypeDefault> getGlAccountTypeDefaults(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<GlAccountTypeDefault> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlAccountTypeDefault.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get gl budget xrefs
	 */
	public List<GlBudgetXref> getGlBudgetXrefs(GlAccount glAccount,
			Integer start, Integer number, List<String> orderBy) {
		List<GlBudgetXref> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlBudgetXref.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlBudgetXref.fromValues(out.getListIt()
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
	public List<GlReconciliation> getGlReconciliations(GlAccount glAccount,
			Integer start, Integer number, List<String> orderBy) {
		List<GlReconciliation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlReconciliation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get override invoice items
	 */
	public List<InvoiceItem> getOverrideInvoiceItems(GlAccount glAccount,
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
				.asList(new EntityExpr("overrideGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get default invoice item types
	 */
	public List<InvoiceItemType> getDefaultInvoiceItemTypes(
			GlAccount glAccount, Integer start, Integer number,
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
				.asList(new EntityExpr("defaultGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get invoice item type gl accounts
	 */
	public List<InvoiceItemTypeGlAccount> getInvoiceItemTypeGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
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
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get override order adjustments
	 */
	public List<OrderAdjustment> getOverrideOrderAdjustments(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
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
				.asList(new EntityExpr("overrideGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get override order items
	 */
	public List<OrderItem> getOverrideOrderItems(GlAccount glAccount,
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
				.asList(new EntityExpr("overrideGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get party gl accounts
	 */
	public List<PartyGlAccount> getPartyGlAccounts(GlAccount glAccount,
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
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get payments
	 */
	public List<Payment> getPayments(GlAccount glAccount, Integer start,
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
				.asList(new EntityExpr("overrideGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get payment applications
	 */
	public List<PaymentApplication> getPaymentApplications(GlAccount glAccount,
			Integer start, Integer number, List<String> orderBy) {
		List<PaymentApplication> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentApplication.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("overrideGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentApplication.fromValues(out.getListIt()
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
	public List<PaymentMethod> getPaymentMethods(GlAccount glAccount,
			Integer start, Integer number, List<String> orderBy) {
		List<PaymentMethod> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentMethod.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get default payment method types
	 */
	public List<PaymentMethodType> getDefaultPaymentMethodTypes(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<PaymentMethodType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentMethodType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("defaultGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentMethodType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get payment method type gl accounts
	 */
	public List<PaymentMethodTypeGlAccount> getPaymentMethodTypeGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<PaymentMethodTypeGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentMethodTypeGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get product category gl accounts
	 */
	public List<ProductCategoryGlAccount> getProductCategoryGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get product gl accounts
	 */
	public List<ProductGlAccount> getProductGlAccounts(GlAccount glAccount,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get override quote adjustments
	 */
	public List<QuoteAdjustment> getOverrideQuoteAdjustments(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
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
				.asList(new EntityExpr("overrideGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get override return adjustments
	 */
	public List<ReturnAdjustment> getOverrideReturnAdjustments(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
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
				.asList(new EntityExpr("overrideGlAccountId",
						EntityOperator.EQUALS, glAccount.getGlAccountId())),
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
	 * Get tax authority gl accounts
	 */
	public List<TaxAuthorityGlAccount> getTaxAuthorityGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<TaxAuthorityGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
	 * Get variance reason gl accounts
	 */
	public List<VarianceReasonGlAccount> getVarianceReasonGlAccounts(
			GlAccount glAccount, Integer start, Integer number,
			List<String> orderBy) {
		List<VarianceReasonGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(VarianceReasonGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						glAccount.getGlAccountId())), EntityOperator.AND));
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
}