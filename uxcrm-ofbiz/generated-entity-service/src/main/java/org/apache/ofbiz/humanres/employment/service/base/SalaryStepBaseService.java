package org.apache.ofbiz.humanres.employment.service.base;

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
import org.apache.ofbiz.humanres.employment.SalaryStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.employment.PayGrade;
import org.apache.ofbiz.humanres.position.EmplPositionTypeRate;
import org.apache.ofbiz.humanres.employment.PayHistory;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SalaryStepBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SalaryStepBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SalarySteps
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SalaryStep.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SalarySteps
	 */
	public List<SalaryStep> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SalaryStep> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalaryStep.NAME);
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
				entityList = SalaryStep.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SalaryStep
	 */
	public Optional<SalaryStep> findOne(Object salaryStepSeqId,
			Object payGradeId, Object fromDate) {
		List<SalaryStep> entityList = null;
		In in = new In();
		in.setEntityName(SalaryStep.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("salaryStepSeqId", EntityOperator.EQUALS,
						salaryStepSeqId), new EntityExpr("payGradeId",
						EntityOperator.EQUALS, payGradeId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalaryStep.fromValues(out.getListIt()
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
	 * Get pay grade
	 */
	public Optional<PayGrade> getPayGrade(SalaryStep salaryStep) {
		List<PayGrade> entityList = null;
		In in = new In();
		in.setEntityName(PayGrade.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("payGradeId", EntityOperator.EQUALS,
						salaryStep.getPayGradeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PayGrade.fromValues(out.getListIt()
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
	 * Get empl position type rates
	 */
	public List<EmplPositionTypeRate> getEmplPositionTypeRates(
			SalaryStep salaryStep, Integer start, Integer number,
			List<String> orderBy) {
		List<EmplPositionTypeRate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionTypeRate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("salaryStepSeqId", EntityOperator.EQUALS,
						salaryStep.getSalaryStepSeqId()),
				new EntityExpr("payGradeId", EntityOperator.EQUALS, salaryStep
						.getPayGradeId()), new EntityExpr("fromDate",
						EntityOperator.EQUALS, salaryStep.getFromDate())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionTypeRate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get pay histories
	 */
	public List<PayHistory> getPayHistories(SalaryStep salaryStep,
			Integer start, Integer number, List<String> orderBy) {
		List<PayHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PayHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("salaryStepSeqId", EntityOperator.EQUALS,
						salaryStep.getSalaryStepSeqId()),
				new EntityExpr("payGradeId", EntityOperator.EQUALS, salaryStep
						.getPayGradeId()), new EntityExpr("fromDate",
						EntityOperator.EQUALS, salaryStep.getFromDate())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PayHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}