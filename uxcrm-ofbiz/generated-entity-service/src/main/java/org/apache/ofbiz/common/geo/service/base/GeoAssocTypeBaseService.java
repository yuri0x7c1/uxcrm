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
import org.apache.ofbiz.common.geo.GeoAssocType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.geo.CountryAddressFormat;
import org.apache.ofbiz.common.geo.GeoAssoc;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class GeoAssocTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public GeoAssocTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count GeoAssocTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(GeoAssocType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find GeoAssocTypes
	 */
	public List<GeoAssocType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<GeoAssocType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GeoAssocType.NAME);
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
				entityList = GeoAssocType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one GeoAssocType
	 */
	public Optional<GeoAssocType> findOne(Object geoAssocTypeId) {
		List<GeoAssocType> entityList = null;
		In in = new In();
		in.setEntityName(GeoAssocType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoAssocTypeId", EntityOperator.EQUALS,
						geoAssocTypeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GeoAssocType.fromValues(out.getListIt()
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
	 * Get country address formats
	 */
	public List<CountryAddressFormat> getCountryAddressFormats(
			GeoAssocType geoAssocType, Integer start, Integer number,
			List<String> orderBy) {
		List<CountryAddressFormat> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CountryAddressFormat.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoAssocTypeId", EntityOperator.EQUALS,
						geoAssocType.getGeoAssocTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CountryAddressFormat.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get geo assocs
	 */
	public List<GeoAssoc> getGeoAssocs(GeoAssocType geoAssocType,
			Integer start, Integer number, List<String> orderBy) {
		List<GeoAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GeoAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoAssocTypeId", EntityOperator.EQUALS,
						geoAssocType.getGeoAssocTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GeoAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}