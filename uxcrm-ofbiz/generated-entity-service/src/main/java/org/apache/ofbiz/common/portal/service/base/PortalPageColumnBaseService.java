package org.apache.ofbiz.common.portal.service.base;

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
import org.apache.ofbiz.common.portal.PortalPageColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.portal.PortalPage;
import org.apache.ofbiz.common.portal.PortalPagePortlet;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PortalPageColumnBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PortalPageColumnBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PortalPageColumns
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PortalPageColumn.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PortalPageColumns
	 */
	public List<PortalPageColumn> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PortalPageColumn> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PortalPageColumn.NAME);
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
				entityList = PortalPageColumn.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PortalPageColumn
	 */
	public Optional<PortalPageColumn> findOne(Object portalPageId,
			Object columnSeqId) {
		List<PortalPageColumn> entityList = null;
		In in = new In();
		in.setEntityName(PortalPageColumn.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("portalPageId", EntityOperator.EQUALS,
						portalPageId), new EntityExpr("columnSeqId",
						EntityOperator.EQUALS, columnSeqId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortalPageColumn.fromValues(out.getListIt()
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
	 * Get portal page
	 */
	public Optional<PortalPage> getPortalPage(PortalPageColumn portalPageColumn) {
		List<PortalPage> entityList = null;
		In in = new In();
		in.setEntityName(PortalPage.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("portalPageId", EntityOperator.EQUALS,
						portalPageColumn.getPortalPageId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortalPage.fromValues(out.getListIt()
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
	 * Get portal page portlets
	 */
	public List<PortalPagePortlet> getPortalPagePortlets(
			PortalPageColumn portalPageColumn, Integer start, Integer number,
			List<String> orderBy) {
		List<PortalPagePortlet> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PortalPagePortlet.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("portalPageId", EntityOperator.EQUALS,
						portalPageColumn.getPortalPageId()),
				new EntityExpr("columnSeqId", EntityOperator.EQUALS,
						portalPageColumn.getColumnSeqId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortalPagePortlet.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}