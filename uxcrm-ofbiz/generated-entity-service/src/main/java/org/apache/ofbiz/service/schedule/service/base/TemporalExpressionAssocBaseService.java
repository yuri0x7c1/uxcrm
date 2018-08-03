package org.apache.ofbiz.service.schedule.service.base;

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
import org.apache.ofbiz.service.schedule.TemporalExpressionAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.service.schedule.TemporalExpression;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TemporalExpressionAssocBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TemporalExpressionAssocBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TemporalExpressionAssocs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TemporalExpressionAssoc.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TemporalExpressionAssocs
	 */
	public List<TemporalExpressionAssoc> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TemporalExpressionAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TemporalExpressionAssoc.NAME);
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
				entityList = TemporalExpressionAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TemporalExpressionAssoc
	 */
	public Optional<TemporalExpressionAssoc> findOne(Object fromTempExprId,
			Object toTempExprId) {
		List<TemporalExpressionAssoc> entityList = null;
		In in = new In();
		in.setEntityName(TemporalExpressionAssoc.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fromTempExprId", EntityOperator.EQUALS,
						fromTempExprId), new EntityExpr("toTempExprId",
						EntityOperator.EQUALS, toTempExprId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TemporalExpressionAssoc.fromValues(out.getListIt()
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
	 * Get from temporal expression
	 */
	public Optional<TemporalExpression> getFromTemporalExpression(
			TemporalExpressionAssoc temporalExpressionAssoc) {
		List<TemporalExpression> entityList = null;
		In in = new In();
		in.setEntityName(TemporalExpression.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("tempExprId", EntityOperator.EQUALS,
						temporalExpressionAssoc.getFromTempExprId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TemporalExpression.fromValues(out.getListIt()
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
	 * Get to temporal expression
	 */
	public Optional<TemporalExpression> getToTemporalExpression(
			TemporalExpressionAssoc temporalExpressionAssoc) {
		List<TemporalExpression> entityList = null;
		In in = new In();
		in.setEntityName(TemporalExpression.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("tempExprId", EntityOperator.EQUALS,
						temporalExpressionAssoc.getToTempExprId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TemporalExpression.fromValues(out.getListIt()
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