package org.apache.ofbiz.common.geo.service.base;

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
import org.apache.ofbiz.common.geo.GeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.datasource.DataSource;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.product.facility.ContainerGeoPoint;
import org.apache.ofbiz.product.facility.Facility;
import org.apache.ofbiz.product.facility.FacilityLocation;
import org.apache.ofbiz.product.facility.FacilityLocationGeoPoint;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetGeoPoint;
import org.apache.ofbiz.party.party.PartyGeoPoint;
import org.apache.ofbiz.party.contact.PostalAddress;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class GeoPointBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public GeoPointBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count GeoPoints
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(GeoPoint.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find GeoPoints
	 */
	public List<GeoPoint> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<GeoPoint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GeoPoint.NAME);
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
				entityList = GeoPoint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one GeoPoint
	 */
	public Optional<GeoPoint> findOne(Object geoPointId) {
		List<GeoPoint> entityList = null;
		In in = new In();
		in.setEntityName(GeoPoint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						geoPointId)), EntityOperator.AND));
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

	/**
	 * Get data source
	 */
	public Optional<DataSource> getDataSource(GeoPoint geoPoint) {
		List<DataSource> entityList = null;
		In in = new In();
		in.setEntityName(DataSource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataSourceId", EntityOperator.EQUALS,
						geoPoint.getDataSourceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataSource.fromValues(out.getListIt()
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
	 * Get geo point type enumeration
	 */
	public Optional<Enumeration> getGeoPointTypeEnumeration(GeoPoint geoPoint) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						geoPoint.getGeoPointTypeEnumId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
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
	 * Get elevation uom
	 */
	public Optional<Uom> getElevationUom(GeoPoint geoPoint) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, geoPoint
						.getElevationUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Uom.fromValues(out.getListIt().getCompleteList());
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
	 * Get container geo points
	 */
	public List<ContainerGeoPoint> getContainerGeoPoints(GeoPoint geoPoint,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						geoPoint.getGeoPointId())), EntityOperator.AND));
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
	 * Get facilities
	 */
	public List<Facility> getFacilities(GeoPoint geoPoint, Integer start,
			Integer number, List<String> orderBy) {
		List<Facility> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Facility.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						geoPoint.getGeoPointId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Facility.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get facility locations
	 */
	public List<FacilityLocation> getFacilityLocations(GeoPoint geoPoint,
			Integer start, Integer number, List<String> orderBy) {
		List<FacilityLocation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FacilityLocation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						geoPoint.getGeoPointId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityLocation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get facility location geo points
	 */
	public List<FacilityLocationGeoPoint> getFacilityLocationGeoPoints(
			GeoPoint geoPoint, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						geoPoint.getGeoPointId())), EntityOperator.AND));
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
	 * Get fixed asset geo points
	 */
	public List<FixedAssetGeoPoint> getFixedAssetGeoPoints(GeoPoint geoPoint,
			Integer start, Integer number, List<String> orderBy) {
		List<FixedAssetGeoPoint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetGeoPoint.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						geoPoint.getGeoPointId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetGeoPoint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party geo points
	 */
	public List<PartyGeoPoint> getPartyGeoPoints(GeoPoint geoPoint,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyGeoPoint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyGeoPoint.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						geoPoint.getGeoPointId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyGeoPoint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get postal addresses
	 */
	public List<PostalAddress> getPostalAddresses(GeoPoint geoPoint,
			Integer start, Integer number, List<String> orderBy) {
		List<PostalAddress> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PostalAddress.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoPointId", EntityOperator.EQUALS,
						geoPoint.getGeoPointId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PostalAddress.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}