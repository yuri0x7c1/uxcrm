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
import org.apache.ofbiz.order._return.ReturnItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order._return.ReturnItem;
import org.apache.ofbiz.order._return.ReturnItemTypeMap;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ReturnItemTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ReturnItemTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ReturnItemTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ReturnItemType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ReturnItemTypes
	 */
	public List<ReturnItemType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ReturnItemType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnItemType.NAME);
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
				entityList = ReturnItemType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ReturnItemType
	 */
	public Optional<ReturnItemType> findOne(Object returnItemTypeId) {
		List<ReturnItemType> entityList = null;
		In in = new In();
		in.setEntityName(ReturnItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnItemTypeId",
						EntityOperator.EQUALS, returnItemTypeId)),
				EntityOperator.AND));
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
	 * Get parent return item type
	 */
	public Optional<ReturnItemType> getParentReturnItemType(
			ReturnItemType returnItemType) {
		List<ReturnItemType> entityList = null;
		In in = new In();
		in.setEntityName(ReturnItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("returnItemTypeId",
						EntityOperator.EQUALS, returnItemType.getParentTypeId())),
				EntityOperator.AND));
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
	 * Get return items
	 */
	public List<ReturnItem> getReturnItems(ReturnItemType returnItemType,
			Integer start, Integer number, List<String> orderBy) {
		List<ReturnItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnItemTypeId",
						EntityOperator.EQUALS, returnItemType
								.getReturnItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child return item types
	 */
	public List<ReturnItemType> getChildReturnItemTypes(
			ReturnItemType returnItemType, Integer start, Integer number,
			List<String> orderBy) {
		List<ReturnItemType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnItemType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						returnItemType.getReturnItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItemType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get return item type maps
	 */
	public List<ReturnItemTypeMap> getReturnItemTypeMaps(
			ReturnItemType returnItemType, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnItemTypeId",
						EntityOperator.EQUALS, returnItemType
								.getReturnItemTypeId())), EntityOperator.AND));
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
}