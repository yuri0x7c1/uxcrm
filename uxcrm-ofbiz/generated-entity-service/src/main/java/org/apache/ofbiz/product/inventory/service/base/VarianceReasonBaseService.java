package org.apache.ofbiz.product.inventory.service.base;

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
import org.apache.ofbiz.product.inventory.VarianceReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.inventory.InventoryItemVariance;
import org.apache.ofbiz.accounting.ledger.VarianceReasonGlAccount;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class VarianceReasonBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public VarianceReasonBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count VarianceReasons
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(VarianceReason.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find VarianceReasons
	 */
	public List<VarianceReason> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<VarianceReason> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(VarianceReason.NAME);
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
				entityList = VarianceReason.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one VarianceReason
	 */
	public Optional<VarianceReason> findOne(Object varianceReasonId) {
		List<VarianceReason> entityList = null;
		In in = new In();
		in.setEntityName(VarianceReason.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("varianceReasonId",
						EntityOperator.EQUALS, varianceReasonId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VarianceReason.fromValues(out.getListIt()
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
	 * Get inventory item variances
	 */
	public List<InventoryItemVariance> getInventoryItemVariances(
			VarianceReason varianceReason, Integer start, Integer number,
			List<String> orderBy) {
		List<InventoryItemVariance> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItemVariance.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("varianceReasonId",
						EntityOperator.EQUALS, varianceReason
								.getVarianceReasonId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItemVariance.fromValues(out.getListIt()
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
			VarianceReason varianceReason, Integer start, Integer number,
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
				.asList(new EntityExpr("varianceReasonId",
						EntityOperator.EQUALS, varianceReason
								.getVarianceReasonId())), EntityOperator.AND));
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