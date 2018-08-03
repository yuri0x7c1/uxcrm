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
import org.apache.ofbiz.marketing.segment.SegmentGroupGeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.marketing.segment.SegmentGroup;
import org.apache.ofbiz.common.geo.Geo;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SegmentGroupGeoBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SegmentGroupGeoBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SegmentGroupGeos
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SegmentGroupGeo.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SegmentGroupGeos
	 */
	public List<SegmentGroupGeo> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one SegmentGroupGeo
	 */
	public Optional<SegmentGroupGeo> findOne(Object segmentGroupId, Object geoId) {
		List<SegmentGroupGeo> entityList = null;
		In in = new In();
		in.setEntityName(SegmentGroupGeo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("segmentGroupId", EntityOperator.EQUALS,
						segmentGroupId), new EntityExpr("geoId",
						EntityOperator.EQUALS, geoId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SegmentGroupGeo.fromValues(out.getListIt()
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
	 * Get segment group
	 */
	public Optional<SegmentGroup> getSegmentGroup(
			SegmentGroupGeo segmentGroupGeo) {
		List<SegmentGroup> entityList = null;
		In in = new In();
		in.setEntityName(SegmentGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("segmentGroupId", EntityOperator.EQUALS,
						segmentGroupGeo.getSegmentGroupId())),
				EntityOperator.AND));
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
	 * Get geo
	 */
	public Optional<Geo> getGeo(SegmentGroupGeo segmentGroupGeo) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						segmentGroupGeo.getGeoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Geo.fromValues(out.getListIt().getCompleteList());
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