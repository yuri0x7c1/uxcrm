package org.apache.ofbiz.accounting.budget.service.base;

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
import org.apache.ofbiz.accounting.budget.BudgetReviewResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.budget.BudgetReview;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BudgetReviewResultTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BudgetReviewResultTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BudgetReviewResultTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BudgetReviewResultType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BudgetReviewResultTypes
	 */
	public List<BudgetReviewResultType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<BudgetReviewResultType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetReviewResultType.NAME);
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
				entityList = BudgetReviewResultType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one BudgetReviewResultType
	 */
	public Optional<BudgetReviewResultType> findOne(
			Object budgetReviewResultTypeId) {
		List<BudgetReviewResultType> entityList = null;
		In in = new In();
		in.setEntityName(BudgetReviewResultType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetReviewResultTypeId",
						EntityOperator.EQUALS, budgetReviewResultTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetReviewResultType.fromValues(out.getListIt()
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
	 * Get budget reviews
	 */
	public List<BudgetReview> getBudgetReviews(
			BudgetReviewResultType budgetReviewResultType, Integer start,
			Integer number, List<String> orderBy) {
		List<BudgetReview> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetReview.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetReviewResultTypeId",
						EntityOperator.EQUALS, budgetReviewResultType
								.getBudgetReviewResultTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetReview.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}