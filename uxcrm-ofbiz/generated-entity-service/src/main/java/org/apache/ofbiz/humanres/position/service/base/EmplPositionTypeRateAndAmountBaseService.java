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
import org.apache.ofbiz.humanres.position.EmplPositionTypeRateAndAmount;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class EmplPositionTypeRateAndAmountBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public EmplPositionTypeRateAndAmountBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count EmplPositionTypeRateAndAmounts
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(EmplPositionTypeRateAndAmount.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find EmplPositionTypeRateAndAmounts
	 */
	public List<EmplPositionTypeRateAndAmount> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<EmplPositionTypeRateAndAmount> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(EmplPositionTypeRateAndAmount.NAME);
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
				entityList = EmplPositionTypeRateAndAmount.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one EmplPositionTypeRateAndAmount
	 */
	public Optional<EmplPositionTypeRateAndAmount> findOne(Object periodTypeId,
			Object rateCurrencyUomId, Object rateAmountFromDate,
			Object fromDate, Object rateTypeId, Object emplPositionTypeId) {
		List<EmplPositionTypeRateAndAmount> entityList = null;
		In in = new In();
		in.setEntityName(EmplPositionTypeRateAndAmount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("periodTypeId", EntityOperator.EQUALS,
						periodTypeId), new EntityExpr("rateCurrencyUomId",
						EntityOperator.EQUALS, rateCurrencyUomId),
				new EntityExpr("rateAmountFromDate", EntityOperator.EQUALS,
						rateAmountFromDate), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate), new EntityExpr(
						"rateTypeId", EntityOperator.EQUALS, rateTypeId),
				new EntityExpr("emplPositionTypeId", EntityOperator.EQUALS,
						emplPositionTypeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPositionTypeRateAndAmount.fromValues(out
						.getListIt().getCompleteList());
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