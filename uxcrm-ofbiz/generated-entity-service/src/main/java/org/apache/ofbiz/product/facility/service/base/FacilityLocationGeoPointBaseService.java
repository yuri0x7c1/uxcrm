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
import org.apache.ofbiz.product.facility.FacilityLocationGeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.facility.FacilityLocation;
import org.apache.ofbiz.common.geo.GeoPoint;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FacilityLocationGeoPointBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FacilityLocationGeoPointBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FacilityLocationGeoPoints
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FacilityLocationGeoPoint.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FacilityLocationGeoPoints
	 */
	public List<FacilityLocationGeoPoint> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FacilityLocationGeoPoint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityLocationGeoPoint.NAME);
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
				entityList = FacilityLocationGeoPoint.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FacilityLocationGeoPoint
	 */
	public Optional<FacilityLocationGeoPoint> findOne(Object facilityId,
			Object locationSeqId, Object geoPointId, Object fromDate) {
		List<FacilityLocationGeoPoint> entityList = null;
		In in = new In();
		in.setEntityName(FacilityLocationGeoPoint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						facilityId), new EntityExpr("locationSeqId",
						EntityOperator.EQUALS, locationSeqId), new EntityExpr(
						"geoPointId", EntityOperator.EQUALS, geoPointId),
						new EntityExpr("fromDate", EntityOperator.EQUALS,
								fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityLocationGeoPoint.fromValues(out
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

	/**
	 * Get facility location
	 */
	public Optional<FacilityLocation> getFacilityLocation(
			FacilityLocationGeoPoint facilityLocationGeoPoint) {
		List<FacilityLocation> entityList = null;
		In in = new In();
		in.setEntityName(FacilityLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("facilityId", EntityOperator.EQUALS,
						facilityLocationGeoPoint.getFacilityId()),
				new EntityExpr("locationSeqId", EntityOperator.EQUALS,
						facilityLocationGeoPoint.getLocationSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityLocation.fromValues(out.getListIt()
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
	 * Get geo point
	 */
	public Optional<GeoPoint> getGeoPoint(
			FacilityLocationGeoPoint facilityLocationGeoPoint) {
		List<GeoPoint> entityList = null;
		In in = new In();
		in.setEntityName(GeoPoint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						facilityLocationGeoPoint.getGeoPointId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GeoPoint.fromValues(out.getListIt()
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