package org.apache.ofbiz.product.facility.service.base;

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
import org.apache.ofbiz.product.facility.FacilityGroupRollup;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.facility.FacilityGroup;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FacilityGroupRollupBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FacilityGroupRollupBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FacilityGroupRollups
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FacilityGroupRollup.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FacilityGroupRollups
	 */
	public List<FacilityGroupRollup> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FacilityGroupRollup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityGroupRollup.NAME);
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
				entityList = FacilityGroupRollup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FacilityGroupRollup
	 */
	public Optional<FacilityGroupRollup> findOne(Object facilityGroupId,
			Object parentFacilityGroupId, Object fromDate) {
		List<FacilityGroupRollup> entityList = null;
		In in = new In();
		in.setEntityName(FacilityGroupRollup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("facilityGroupId", EntityOperator.EQUALS,
						facilityGroupId), new EntityExpr(
						"parentFacilityGroupId", EntityOperator.EQUALS,
						parentFacilityGroupId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityGroupRollup.fromValues(out.getListIt()
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
	 * Get current facility group
	 */
	public Optional<FacilityGroup> getCurrentFacilityGroup(
			FacilityGroupRollup facilityGroupRollup) {
		List<FacilityGroup> entityList = null;
		In in = new In();
		in.setEntityName(FacilityGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityGroupId",
						EntityOperator.EQUALS, facilityGroupRollup
								.getFacilityGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityGroup.fromValues(out.getListIt()
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
	 * Get parent facility group
	 */
	public Optional<FacilityGroup> getParentFacilityGroup(
			FacilityGroupRollup facilityGroupRollup) {
		List<FacilityGroup> entityList = null;
		In in = new In();
		in.setEntityName(FacilityGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityGroupId",
						EntityOperator.EQUALS, facilityGroupRollup
								.getParentFacilityGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityGroup.fromValues(out.getListIt()
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
	 * Get child facility group rollups
	 */
	public List<FacilityGroupRollup> getChildFacilityGroupRollups(
			FacilityGroupRollup facilityGroupRollup, Integer start,
			Integer number, List<String> orderBy) {
		List<FacilityGroupRollup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityGroupRollup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentFacilityGroupId",
						EntityOperator.EQUALS, facilityGroupRollup
								.getFacilityGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityGroupRollup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get parent facility group rollups
	 */
	public List<FacilityGroupRollup> getParentFacilityGroupRollups(
			FacilityGroupRollup facilityGroupRollup, Integer start,
			Integer number, List<String> orderBy) {
		List<FacilityGroupRollup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityGroupRollup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityGroupId",
						EntityOperator.EQUALS, facilityGroupRollup
								.getParentFacilityGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityGroupRollup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sibling facility group rollups
	 */
	public List<FacilityGroupRollup> getSiblingFacilityGroupRollups(
			FacilityGroupRollup facilityGroupRollup, Integer start,
			Integer number, List<String> orderBy) {
		List<FacilityGroupRollup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityGroupRollup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentFacilityGroupId",
						EntityOperator.EQUALS, facilityGroupRollup
								.getParentFacilityGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityGroupRollup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}