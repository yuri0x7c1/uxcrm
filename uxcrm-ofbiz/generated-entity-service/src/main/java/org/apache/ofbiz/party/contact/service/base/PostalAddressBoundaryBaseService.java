package org.apache.ofbiz.party.contact.service.base;

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
import org.apache.ofbiz.party.contact.PostalAddressBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.contact.PostalAddress;
import org.apache.ofbiz.common.geo.Geo;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PostalAddressBoundaryBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PostalAddressBoundaryBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PostalAddressBoundaries
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PostalAddressBoundary.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PostalAddressBoundaries
	 */
	public List<PostalAddressBoundary> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PostalAddressBoundary> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PostalAddressBoundary.NAME);
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
				entityList = PostalAddressBoundary.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PostalAddressBoundary
	 */
	public Optional<PostalAddressBoundary> findOne(Object contactMechId,
			Object geoId) {
		List<PostalAddressBoundary> entityList = null;
		In in = new In();
		in.setEntityName(PostalAddressBoundary.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contactMechId", EntityOperator.EQUALS,
						contactMechId), new EntityExpr("geoId",
						EntityOperator.EQUALS, geoId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PostalAddressBoundary.fromValues(out.getListIt()
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
	 * Get postal address
	 */
	public Optional<PostalAddress> getPostalAddress(
			PostalAddressBoundary postalAddressBoundary) {
		List<PostalAddress> entityList = null;
		In in = new In();
		in.setEntityName(PostalAddress.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						postalAddressBoundary.getContactMechId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PostalAddress.fromValues(out.getListIt()
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
	public Optional<Geo> getGeo(PostalAddressBoundary postalAddressBoundary) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						postalAddressBoundary.getGeoId())), EntityOperator.AND));
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