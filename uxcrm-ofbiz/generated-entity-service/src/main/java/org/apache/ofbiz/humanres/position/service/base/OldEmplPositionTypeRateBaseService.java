package org.apache.ofbiz.humanres.position.service.base;

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
import org.apache.ofbiz.humanres.position.OldEmplPositionTypeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.position.EmplPositionType;
import org.apache.ofbiz.common.period.PeriodType;
import org.apache.ofbiz.humanres.employment.OldSalaryStep;
import org.apache.ofbiz.accounting.rate.RateType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OldEmplPositionTypeRateBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OldEmplPositionTypeRateBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OldEmplPositionTypeRates
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OldEmplPositionTypeRate.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OldEmplPositionTypeRates
	 */
	public List<OldEmplPositionTypeRate> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one OldEmplPositionTypeRate
	 */
	public Optional<OldEmplPositionTypeRate> findOne(Object emplPositionTypeId,
			Object periodTypeId, Object fromDate) {
		List<OldEmplPositionTypeRate> entityList = null;
		In in = new In();
		in.setEntityName(OldEmplPositionTypeRate.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("emplPositionTypeId", EntityOperator.EQUALS,
						emplPositionTypeId), new EntityExpr("periodTypeId",
						EntityOperator.EQUALS, periodTypeId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldEmplPositionTypeRate.fromValues(out.getListIt()
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
	 * Get empl position type
	 */
	public Optional<EmplPositionType> getEmplPositionType(
			OldEmplPositionTypeRate oldEmplPositionTypeRate) {
		List<EmplPositionType> entityList = null;
		In in = new In();
		in.setEntityName(EmplPositionType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("emplPositionTypeId",
						EntityOperator.EQUALS, oldEmplPositionTypeRate
								.getEmplPositionTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionType.fromValues(out.getListIt()
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
	public Optional<PeriodType> getPeriodType(
			OldEmplPositionTypeRate oldEmplPositionTypeRate) {
		List<PeriodType> entityList = null;
		In in = new In();
		in.setEntityName(PeriodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("periodTypeId", EntityOperator.EQUALS,
						oldEmplPositionTypeRate.getPeriodTypeId())),
				EntityOperator.AND));
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

	/**
	 * Get old salary step
	 */
	public Optional<OldSalaryStep> getOldSalaryStep(
			OldEmplPositionTypeRate oldEmplPositionTypeRate) {
		List<OldSalaryStep> entityList = null;
		In in = new In();
		in.setEntityName(OldSalaryStep.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("salaryStepSeqId", EntityOperator.EQUALS,
						oldEmplPositionTypeRate.getSalaryStepSeqId()),
				new EntityExpr("payGradeId", EntityOperator.EQUALS,
						oldEmplPositionTypeRate.getPayGradeId())),
				EntityOperator.AND));
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
	 * Get rate type
	 */
	public Optional<RateType> getRateType(
			OldEmplPositionTypeRate oldEmplPositionTypeRate) {
		List<RateType> entityList = null;
		In in = new In();
		in.setEntityName(RateType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateTypeId", EntityOperator.EQUALS,
						oldEmplPositionTypeRate.getRateTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RateType.fromValues(out.getListIt()
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