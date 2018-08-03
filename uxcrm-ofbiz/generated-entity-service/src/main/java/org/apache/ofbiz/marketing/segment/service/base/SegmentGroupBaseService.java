package org.apache.ofbiz.marketing.segment.service.base;

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
import org.apache.ofbiz.marketing.segment.SegmentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.marketing.segment.SegmentGroupType;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.marketing.segment.SegmentGroupClassification;
import org.apache.ofbiz.marketing.segment.SegmentGroupGeo;
import org.apache.ofbiz.marketing.segment.SegmentGroupRole;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SegmentGroupBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SegmentGroupBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SegmentGroups
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SegmentGroup.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SegmentGroups
	 */
	public List<SegmentGroup> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SegmentGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SegmentGroup.NAME);
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
				entityList = SegmentGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SegmentGroup
	 */
	public Optional<SegmentGroup> findOne(Object segmentGroupId) {
		List<SegmentGroup> entityList = null;
		In in = new In();
		in.setEntityName(SegmentGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("segmentGroupId", EntityOperator.EQUALS,
						segmentGroupId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SegmentGroup.fromValues(out.getListIt()
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
	 * Get segment group type
	 */
	public Optional<SegmentGroupType> getSegmentGroupType(
			SegmentGroup segmentGroup) {
		List<SegmentGroupType> entityList = null;
		In in = new In();
		in.setEntityName(SegmentGroupType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("segmentGroupTypeId",
						EntityOperator.EQUALS, segmentGroup
								.getSegmentGroupTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SegmentGroupType.fromValues(out.getListIt()
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
	 * Get product store
	 */
	public Optional<ProductStore> getProductStore(SegmentGroup segmentGroup) {
		List<ProductStore> entityList = null;
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreId", EntityOperator.EQUALS,
						segmentGroup.getProductStoreId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
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
	 * Get segment group classifications
	 */
	public List<SegmentGroupClassification> getSegmentGroupClassifications(
			SegmentGroup segmentGroup, Integer start, Integer number,
			List<String> orderBy) {
		List<SegmentGroupClassification> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SegmentGroupClassification.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("segmentGroupId", EntityOperator.EQUALS,
						segmentGroup.getSegmentGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SegmentGroupClassification.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get segment group geos
	 */
	public List<SegmentGroupGeo> getSegmentGroupGeos(SegmentGroup segmentGroup,
			Integer start, Integer number, List<String> orderBy) {
		List<SegmentGroupGeo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SegmentGroupGeo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("segmentGroupId", EntityOperator.EQUALS,
						segmentGroup.getSegmentGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SegmentGroupGeo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get segment group roles
	 */
	public List<SegmentGroupRole> getSegmentGroupRoles(
			SegmentGroup segmentGroup, Integer start, Integer number,
			List<String> orderBy) {
		List<SegmentGroupRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SegmentGroupRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("segmentGroupId", EntityOperator.EQUALS,
						segmentGroup.getSegmentGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SegmentGroupRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}