package org.apache.ofbiz.order._return.service.base;

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
import org.apache.ofbiz.order._return.ReturnItemTypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order._return.ReturnItemType;
import org.apache.ofbiz.order._return.ReturnHeaderType;
import org.apache.ofbiz.order._return.ReturnAdjustmentType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ReturnItemTypeMapBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ReturnItemTypeMapBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ReturnItemTypeMaps
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ReturnItemTypeMap.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ReturnItemTypeMaps
	 */
	public List<ReturnItemTypeMap> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ReturnItemTypeMap> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnItemTypeMap.NAME);
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
				entityList = ReturnItemTypeMap.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ReturnItemTypeMap
	 */
	public Optional<ReturnItemTypeMap> findOne(Object returnItemMapKey,
			Object returnHeaderTypeId) {
		List<ReturnItemTypeMap> entityList = null;
		In in = new In();
		in.setEntityName(ReturnItemTypeMap.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("returnItemMapKey", EntityOperator.EQUALS,
						returnItemMapKey), new EntityExpr("returnHeaderTypeId",
						EntityOperator.EQUALS, returnHeaderTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItemTypeMap.fromValues(out.getListIt()
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
	 * Get return item type
	 */
	public Optional<ReturnItemType> getReturnItemType(
			ReturnItemTypeMap returnItemTypeMap) {
		List<ReturnItemType> entityList = null;
		In in = new In();
		in.setEntityName(ReturnItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnItemTypeId",
						EntityOperator.EQUALS, returnItemTypeMap
								.getReturnItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItemType.fromValues(out.getListIt()
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
	 * Get return header type
	 */
	public Optional<ReturnHeaderType> getReturnHeaderType(
			ReturnItemTypeMap returnItemTypeMap) {
		List<ReturnHeaderType> entityList = null;
		In in = new In();
		in.setEntityName(ReturnHeaderType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnHeaderTypeId",
						EntityOperator.EQUALS, returnItemTypeMap
								.getReturnHeaderTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnHeaderType.fromValues(out.getListIt()
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
	 * Get return adjustment type
	 */
	public Optional<ReturnAdjustmentType> getReturnAdjustmentType(
			ReturnItemTypeMap returnItemTypeMap) {
		List<ReturnAdjustmentType> entityList = null;
		In in = new In();
		in.setEntityName(ReturnAdjustmentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnAdjustmentTypeId",
						EntityOperator.EQUALS, returnItemTypeMap
								.getReturnItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnAdjustmentType.fromValues(out.getListIt()
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