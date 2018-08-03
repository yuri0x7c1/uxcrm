package org.apache.ofbiz.humanres.ability.service.base;

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
import org.apache.ofbiz.humanres.ability.PerfReviewItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.humanres.ability.PerfReviewItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PerfReviewItemTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PerfReviewItemTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PerfReviewItemTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PerfReviewItemType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PerfReviewItemTypes
	 */
	public List<PerfReviewItemType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PerfReviewItemType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PerfReviewItemType.NAME);
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
				entityList = PerfReviewItemType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PerfReviewItemType
	 */
	public Optional<PerfReviewItemType> findOne(Object perfReviewItemTypeId) {
		List<PerfReviewItemType> entityList = null;
		In in = new In();
		in.setEntityName(PerfReviewItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("perfReviewItemTypeId",
						EntityOperator.EQUALS, perfReviewItemTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReviewItemType.fromValues(out.getListIt()
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
	 * Get parent perf review item type
	 */
	public Optional<PerfReviewItemType> getParentPerfReviewItemType(
			PerfReviewItemType perfReviewItemType) {
		List<PerfReviewItemType> entityList = null;
		In in = new In();
		in.setEntityName(PerfReviewItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("perfReviewItemTypeId",
						EntityOperator.EQUALS, perfReviewItemType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReviewItemType.fromValues(out.getListIt()
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
	 * Get perf review items
	 */
	public List<PerfReviewItem> getPerfReviewItems(
			PerfReviewItemType perfReviewItemType, Integer start,
			Integer number, List<String> orderBy) {
		List<PerfReviewItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PerfReviewItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("perfReviewItemTypeId",
						EntityOperator.EQUALS, perfReviewItemType
								.getPerfReviewItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReviewItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child perf review item types
	 */
	public List<PerfReviewItemType> getChildPerfReviewItemTypes(
			PerfReviewItemType perfReviewItemType, Integer start,
			Integer number, List<String> orderBy) {
		List<PerfReviewItemType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PerfReviewItemType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						perfReviewItemType.getPerfReviewItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PerfReviewItemType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}