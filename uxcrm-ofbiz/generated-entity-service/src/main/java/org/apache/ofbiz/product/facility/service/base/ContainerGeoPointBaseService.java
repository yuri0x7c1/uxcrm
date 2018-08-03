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
import org.apache.ofbiz.product.facility.ContainerGeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.facility.Container;
import org.apache.ofbiz.common.geo.GeoPoint;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContainerGeoPointBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContainerGeoPointBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContainerGeoPoints
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContainerGeoPoint.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContainerGeoPoints
	 */
	public List<ContainerGeoPoint> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ContainerGeoPoint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContainerGeoPoint.NAME);
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
				entityList = ContainerGeoPoint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContainerGeoPoint
	 */
	public Optional<ContainerGeoPoint> findOne(Object containerId,
			Object geoPointId, Object fromDate) {
		List<ContainerGeoPoint> entityList = null;
		In in = new In();
		in.setEntityName(ContainerGeoPoint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("containerId", EntityOperator.EQUALS,
						containerId), new EntityExpr("geoPointId",
						EntityOperator.EQUALS, geoPointId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContainerGeoPoint.fromValues(out.getListIt()
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
	 * Get container
	 */
	public Optional<Container> getContainer(ContainerGeoPoint containerGeoPoint) {
		List<Container> entityList = null;
		In in = new In();
		in.setEntityName(Container.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("containerId", EntityOperator.EQUALS,
						containerGeoPoint.getContainerId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Container.fromValues(out.getListIt()
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
	public Optional<GeoPoint> getGeoPoint(ContainerGeoPoint containerGeoPoint) {
		List<GeoPoint> entityList = null;
		In in = new In();
		in.setEntityName(GeoPoint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						containerGeoPoint.getGeoPointId())), EntityOperator.AND));
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