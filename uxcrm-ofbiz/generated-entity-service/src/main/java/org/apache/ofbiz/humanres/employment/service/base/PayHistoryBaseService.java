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
import org.apache.ofbiz.humanres.employment.PayHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.employment.Employment;
import org.apache.ofbiz.humanres.employment.PayGrade;
import org.apache.ofbiz.humanres.employment.SalaryStep;
import org.apache.ofbiz.common.period.PeriodType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PayHistoryBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PayHistoryBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PayHistories
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PayHistory.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PayHistories
	 */
	public List<PayHistory> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one PayHistory
	 */
	public Optional<PayHistory> findOne(Object roleTypeIdFrom,
			Object roleTypeIdTo, Object partyIdFrom, Object partyIdTo,
			Object fromDate) {
		List<PayHistory> entityList = null;
		In in = new In();
		in.setEntityName(PayHistory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						roleTypeIdFrom), new EntityExpr("roleTypeIdTo",
						EntityOperator.EQUALS, roleTypeIdTo), new EntityExpr(
						"partyIdFrom", EntityOperator.EQUALS, partyIdFrom),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, partyIdTo),
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PayHistory.fromValues(out.getListIt()
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
	 * Get employment
	 */
	public Optional<Employment> getEmployment(PayHistory payHistory) {
		List<Employment> entityList = null;
		In in = new In();
		in.setEntityName(Employment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						payHistory.getRoleTypeIdFrom()),
				new EntityExpr("roleTypeIdTo", EntityOperator.EQUALS,
						payHistory.getRoleTypeIdTo()),
				new EntityExpr("partyIdFrom", EntityOperator.EQUALS, payHistory
						.getPartyIdFrom()),
				new EntityExpr("partyIdTo", EntityOperator.EQUALS, payHistory
						.getPartyIdTo()),
				new EntityExpr("fromDate", EntityOperator.EQUALS, payHistory
						.getFromDate())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Employment.fromValues(out.getListIt()
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
	public Optional<PayGrade> getPayGrade(PayHistory payHistory) {
		List<PayGrade> entityList = null;
		In in = new In();
		in.setEntityName(PayGrade.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("payGradeId", EntityOperator.EQUALS,
						payHistory.getPayGradeId())), EntityOperator.AND));
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
	 * Get salary step
	 */
	public Optional<SalaryStep> getSalaryStep(PayHistory payHistory) {
		List<SalaryStep> entityList = null;
		In in = new In();
		in.setEntityName(SalaryStep.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("salaryStepSeqId", EntityOperator.EQUALS,
						payHistory.getSalaryStepSeqId()),
				new EntityExpr("payGradeId", EntityOperator.EQUALS, payHistory
						.getPayGradeId()), new EntityExpr("fromDate",
						EntityOperator.EQUALS, payHistory.getFromDate())),
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
	 * Get period type
	 */
	public Optional<PeriodType> getPeriodType(PayHistory payHistory) {
		List<PeriodType> entityList = null;
		In in = new In();
		in.setEntityName(PeriodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("periodTypeId", EntityOperator.EQUALS,
						payHistory.getPeriodTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PeriodType.fromValues(out.getListIt()
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
}