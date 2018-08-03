package org.apache.ofbiz.order.reservations.service.base;

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
import org.apache.ofbiz.order.reservations.AccommodationSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.fixedasset.AccommodationClass;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AccommodationSpotBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AccommodationSpotBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count AccommodationSpots
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(AccommodationSpot.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find AccommodationSpots
	 */
	public List<AccommodationSpot> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<AccommodationSpot> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AccommodationSpot.NAME);
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
				entityList = AccommodationSpot.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one AccommodationSpot
	 */
	public Optional<AccommodationSpot> findOne(Object accommodationSpotId) {
		List<AccommodationSpot> entityList = null;
		In in = new In();
		in.setEntityName(AccommodationSpot.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("accommodationSpotId",
						EntityOperator.EQUALS, accommodationSpotId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AccommodationSpot.fromValues(out.getListIt()
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
	 * Get accommodation class
	 */
	public Optional<AccommodationClass> getAccommodationClass(
			AccommodationSpot accommodationSpot) {
		List<AccommodationClass> entityList = null;
		In in = new In();
		in.setEntityName(AccommodationClass.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("accommodationClassId",
						EntityOperator.EQUALS, accommodationSpot
								.getAccommodationClassId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AccommodationClass.fromValues(out.getListIt()
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
	 * Get fixed asset
	 */
	public Optional<FixedAsset> getFixedAsset(
			AccommodationSpot accommodationSpot) {
		List<FixedAsset> entityList = null;
		In in = new In();
		in.setEntityName(FixedAsset.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						accommodationSpot.getFixedAssetId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAsset.fromValues(out.getListIt()
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
	 * Get work efforts
	 */
	public List<WorkEffort> getWorkEfforts(AccommodationSpot accommodationSpot,
			Integer start, Integer number, List<String> orderBy) {
		List<WorkEffort> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("accommodationSpotId",
						EntityOperator.EQUALS, accommodationSpot
								.getAccommodationSpotId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}