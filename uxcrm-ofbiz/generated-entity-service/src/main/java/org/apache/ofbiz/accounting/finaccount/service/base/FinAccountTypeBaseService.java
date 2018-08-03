package org.apache.ofbiz.accounting.finaccount.service.base;

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
import org.apache.ofbiz.accounting.finaccount.FinAccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.accounting.finaccount.FinAccount;
import org.apache.ofbiz.accounting.finaccount.FinAccountTypeAttr;
import org.apache.ofbiz.accounting.finaccount.FinAccountTypeGlAccount;
import org.apache.ofbiz.product.store.ProductStoreFinActSetting;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FinAccountTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FinAccountTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FinAccountTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FinAccountType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FinAccountTypes
	 */
	public List<FinAccountType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one FinAccountType
	 */
	public Optional<FinAccountType> findOne(Object finAccountTypeId) {
		List<FinAccountType> entityList = null;
		In in = new In();
		in.setEntityName(FinAccountType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTypeId",
						EntityOperator.EQUALS, finAccountTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountType.fromValues(out.getListIt()
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
	 * Get parent fin account type
	 */
	public Optional<FinAccountType> getParentFinAccountType(
			FinAccountType finAccountType) {
		List<FinAccountType> entityList = null;
		In in = new In();
		in.setEntityName(FinAccountType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("finAccountTypeId",
						EntityOperator.EQUALS, finAccountType.getParentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountType.fromValues(out.getListIt()
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
	 * Get replenish enumeration
	 */
	public Optional<Enumeration> getReplenishEnumeration(
			FinAccountType finAccountType) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						finAccountType.getReplenishEnumId())),
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
	 * Get fin accounts
	 */
	public List<FinAccount> getFinAccounts(FinAccountType finAccountType,
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
				.asList(new EntityExpr("finAccountTypeId",
						EntityOperator.EQUALS, finAccountType
								.getFinAccountTypeId())), EntityOperator.AND));
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
	 * Get child fin account types
	 */
	public List<FinAccountType> getChildFinAccountTypes(
			FinAccountType finAccountType, Integer start, Integer number,
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
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						finAccountType.getFinAccountTypeId())),
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
	 * Get fin account type attrs
	 */
	public List<FinAccountTypeAttr> getFinAccountTypeAttrs(
			FinAccountType finAccountType, Integer start, Integer number,
			List<String> orderBy) {
		List<FinAccountTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTypeId",
						EntityOperator.EQUALS, finAccountType
								.getFinAccountTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTypeAttr.fromValues(out.getListIt()
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
			FinAccountType finAccountType, Integer start, Integer number,
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
				.asList(new EntityExpr("finAccountTypeId",
						EntityOperator.EQUALS, finAccountType
								.getFinAccountTypeId())), EntityOperator.AND));
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
	 * Get product store fin act settings
	 */
	public List<ProductStoreFinActSetting> getProductStoreFinActSettings(
			FinAccountType finAccountType, Integer start, Integer number,
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
				.asList(new EntityExpr("finAccountTypeId",
						EntityOperator.EQUALS, finAccountType
								.getFinAccountTypeId())), EntityOperator.AND));
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
}