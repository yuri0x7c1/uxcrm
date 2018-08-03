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
import org.apache.ofbiz.product.facility.FacilityLocationAndGeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.facility.FacilityLocationGeoPoint;
import org.apache.ofbiz.product.facility.FacilityLocation;
import org.apache.ofbiz.common.geo.GeoPoint;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FacilityLocationAndGeoPointBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FacilityLocationAndGeoPointBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FacilityLocationAndGeoPoints
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FacilityLocationAndGeoPoint.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FacilityLocationAndGeoPoints
	 */
	public List<FacilityLocationAndGeoPoint> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<FacilityLocationAndGeoPoint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityLocationAndGeoPoint.NAME);
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
				entityList = FacilityLocationAndGeoPoint.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FacilityLocationAndGeoPoint
	 */
	public Optional<FacilityLocationAndGeoPoint> findOne(Object facilityId,
			Object locationSeqId, Object fromDate, Object geoPointId) {
		List<FacilityLocationAndGeoPoint> entityList = null;
		In in = new In();
		in.setEntityName(FacilityLocationAndGeoPoint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						facilityId), new EntityExpr("locationSeqId",
						EntityOperator.EQUALS, locationSeqId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate),
						new EntityExpr("geoPointId", EntityOperator.EQUALS,
								geoPointId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityLocationAndGeoPoint.fromValues(out
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
	 * Get facility location geo points
	 */
	public List<FacilityLocationGeoPoint> getFacilityLocationGeoPoints(
			FacilityLocationAndGeoPoint facilityLocationAndGeoPoint,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("facilityId", EntityOperator.EQUALS,
						facilityLocationAndGeoPoint.getFacilityId()),
				new EntityExpr("locationSeqId", EntityOperator.EQUALS,
						facilityLocationAndGeoPoint.getLocationSeqId()),
				new EntityExpr("geoPointId", EntityOperator.EQUALS,
						facilityLocationAndGeoPoint.getGeoPointId())),
				EntityOperator.AND));
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
	 * Get facility location
	 */
	public Optional<FacilityLocation> getFacilityLocation(
			FacilityLocationAndGeoPoint facilityLocationAndGeoPoint) {
		List<FacilityLocation> entityList = null;
		In in = new In();
		in.setEntityName(FacilityLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("facilityId", EntityOperator.EQUALS,
						facilityLocationAndGeoPoint.getFacilityId()),
				new EntityExpr("locationSeqId", EntityOperator.EQUALS,
						facilityLocationAndGeoPoint.getLocationSeqId())),
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
			FacilityLocationAndGeoPoint facilityLocationAndGeoPoint) {
		List<GeoPoint> entityList = null;
		In in = new In();
		in.setEntityName(GeoPoint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						facilityLocationAndGeoPoint.getGeoPointId())),
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