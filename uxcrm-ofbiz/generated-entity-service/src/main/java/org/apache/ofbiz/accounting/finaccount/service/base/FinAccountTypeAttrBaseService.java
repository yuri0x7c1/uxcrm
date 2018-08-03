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
import org.apache.ofbiz.accounting.finaccount.FinAccountTypeAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.finaccount.FinAccountType;
import org.apache.ofbiz.accounting.finaccount.FinAccountAttribute;
import org.apache.ofbiz.accounting.finaccount.FinAccount;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FinAccountTypeAttrBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FinAccountTypeAttrBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FinAccountTypeAttrs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FinAccountTypeAttr.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FinAccountTypeAttrs
	 */
	public List<FinAccountTypeAttr> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one FinAccountTypeAttr
	 */
	public Optional<FinAccountTypeAttr> findOne(Object finAccountTypeId,
			Object attrName) {
		List<FinAccountTypeAttr> entityList = null;
		In in = new In();
		in.setEntityName(FinAccountTypeAttr.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("finAccountTypeId", EntityOperator.EQUALS,
						finAccountTypeId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTypeAttr.fromValues(out.getListIt()
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
	 * Get fin account type
	 */
	public Optional<FinAccountType> getFinAccountType(
			FinAccountTypeAttr finAccountTypeAttr) {
		List<FinAccountType> entityList = null;
		In in = new In();
		in.setEntityName(FinAccountType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTypeId",
						EntityOperator.EQUALS, finAccountTypeAttr
								.getFinAccountTypeId())), EntityOperator.AND));
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
	 * Get fin account attributes
	 */
	public List<FinAccountAttribute> getFinAccountAttributes(
			FinAccountTypeAttr finAccountTypeAttr, Integer start,
			Integer number, List<String> orderBy) {
		List<FinAccountAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						finAccountTypeAttr.getAttrName())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fin accounts
	 */
	public List<FinAccount> getFinAccounts(
			FinAccountTypeAttr finAccountTypeAttr, Integer start,
			Integer number, List<String> orderBy) {
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
						EntityOperator.EQUALS, finAccountTypeAttr
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
}