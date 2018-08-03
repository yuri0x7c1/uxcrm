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
import org.apache.ofbiz.humanres.employment.OldSalaryStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.employment.PayGrade;
import org.apache.ofbiz.humanres.position.OldEmplPositionTypeRate;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OldSalaryStepBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OldSalaryStepBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OldSalarySteps
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OldSalaryStep.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OldSalarySteps
	 */
	public List<OldSalaryStep> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<OldSalaryStep> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldSalaryStep.NAME);
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
				entityList = OldSalaryStep.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OldSalaryStep
	 */
	public Optional<OldSalaryStep> findOne(Object salaryStepSeqId,
			Object payGradeId) {
		List<OldSalaryStep> entityList = null;
		In in = new In();
		in.setEntityName(OldSalaryStep.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("salaryStepSeqId", EntityOperator.EQUALS,
						salaryStepSeqId), new EntityExpr("payGradeId",
						EntityOperator.EQUALS, payGradeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldSalaryStep.fromValues(out.getListIt()
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
	public Optional<PayGrade> getPayGrade(OldSalaryStep oldSalaryStep) {
		List<PayGrade> entityList = null;
		In in = new In();
		in.setEntityName(PayGrade.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("payGradeId", EntityOperator.EQUALS,
						oldSalaryStep.getPayGradeId())), EntityOperator.AND));
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
	 * Get old empl position type rates
	 */
	public List<OldEmplPositionTypeRate> getOldEmplPositionTypeRates(
			OldSalaryStep oldSalaryStep, Integer start, Integer number,
			List<String> orderBy) {
		List<OldEmplPositionTypeRate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldEmplPositionTypeRate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("salaryStepSeqId", EntityOperator.EQUALS,
						oldSalaryStep.getSalaryStepSeqId()),
				new EntityExpr("payGradeId", EntityOperator.EQUALS,
						oldSalaryStep.getPayGradeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldEmplPositionTypeRate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}