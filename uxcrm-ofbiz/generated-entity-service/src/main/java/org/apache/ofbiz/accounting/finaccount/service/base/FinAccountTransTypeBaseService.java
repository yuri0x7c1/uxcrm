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
import org.apache.ofbiz.accounting.finaccount.FinAccountTransType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.finaccount.FinAccountTrans;
import org.apache.ofbiz.accounting.finaccount.FinAccountTransTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FinAccountTransTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FinAccountTransTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FinAccountTransTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FinAccountTransType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FinAccountTransTypes
	 */
	public List<FinAccountTransType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FinAccountTransType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTransType.NAME);
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
				entityList = FinAccountTransType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FinAccountTransType
	 */
	public Optional<FinAccountTransType> findOne(Object finAccountTransTypeId) {
		List<FinAccountTransType> entityList = null;
		In in = new In();
		in.setEntityName(FinAccountTransType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransTypeId",
						EntityOperator.EQUALS, finAccountTransTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTransType.fromValues(out.getListIt()
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
	 * Get parent fin account trans type
	 */
	public Optional<FinAccountTransType> getParentFinAccountTransType(
			FinAccountTransType finAccountTransType) {
		List<FinAccountTransType> entityList = null;
		In in = new In();
		in.setEntityName(FinAccountTransType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransTypeId",
						EntityOperator.EQUALS, finAccountTransType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTransType.fromValues(out.getListIt()
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
	 * Get fin account transes
	 */
	public List<FinAccountTrans> getFinAccountTranses(
			FinAccountTransType finAccountTransType, Integer start,
			Integer number, List<String> orderBy) {
		List<FinAccountTrans> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTrans.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransTypeId",
						EntityOperator.EQUALS, finAccountTransType
								.getFinAccountTransTypeId())),
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
	 * Get child fin account trans types
	 */
	public List<FinAccountTransType> getChildFinAccountTransTypes(
			FinAccountTransType finAccountTransType, Integer start,
			Integer number, List<String> orderBy) {
		List<FinAccountTransType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTransType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						finAccountTransType.getFinAccountTransTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTransType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fin account trans type attrs
	 */
	public List<FinAccountTransTypeAttr> getFinAccountTransTypeAttrs(
			FinAccountTransType finAccountTransType, Integer start,
			Integer number, List<String> orderBy) {
		List<FinAccountTransTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTransTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("finAccountTransTypeId",
						EntityOperator.EQUALS, finAccountTransType
								.getFinAccountTransTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTransTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}