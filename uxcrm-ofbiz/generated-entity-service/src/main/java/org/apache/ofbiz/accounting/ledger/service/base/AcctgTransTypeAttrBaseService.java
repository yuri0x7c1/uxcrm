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
import org.apache.ofbiz.accounting.ledger.AcctgTransTypeAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.AcctgTransType;
import org.apache.ofbiz.accounting.ledger.AcctgTransAttribute;
import org.apache.ofbiz.accounting.ledger.AcctgTrans;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AcctgTransTypeAttrBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AcctgTransTypeAttrBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count AcctgTransTypeAttrs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(AcctgTransTypeAttr.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find AcctgTransTypeAttrs
	 */
	public List<AcctgTransTypeAttr> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<AcctgTransTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTransTypeAttr.NAME);
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
				entityList = AcctgTransTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one AcctgTransTypeAttr
	 */
	public Optional<AcctgTransTypeAttr> findOne(Object acctgTransTypeId,
			Object attrName) {
		List<AcctgTransTypeAttr> entityList = null;
		In in = new In();
		in.setEntityName(AcctgTransTypeAttr.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("acctgTransTypeId", EntityOperator.EQUALS,
						acctgTransTypeId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransTypeAttr.fromValues(out.getListIt()
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
	 * Get acctg trans type
	 */
	public Optional<AcctgTransType> getAcctgTransType(
			AcctgTransTypeAttr acctgTransTypeAttr) {
		List<AcctgTransType> entityList = null;
		In in = new In();
		in.setEntityName(AcctgTransType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("acctgTransTypeId",
						EntityOperator.EQUALS, acctgTransTypeAttr
								.getAcctgTransTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransType.fromValues(out.getListIt()
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
	 * Get acctg trans attributes
	 */
	public List<AcctgTransAttribute> getAcctgTransAttributes(
			AcctgTransTypeAttr acctgTransTypeAttr, Integer start,
			Integer number, List<String> orderBy) {
		List<AcctgTransAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTransAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						acctgTransTypeAttr.getAttrName())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransAttribute.fromValues(out.getListIt()
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
	public List<AcctgTrans> getAcctgTranses(
			AcctgTransTypeAttr acctgTransTypeAttr, Integer start,
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
				.asList(new EntityExpr("acctgTransTypeId",
						EntityOperator.EQUALS, acctgTransTypeAttr
								.getAcctgTransTypeId())), EntityOperator.AND));
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
}