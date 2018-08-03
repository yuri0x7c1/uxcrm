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
import org.apache.ofbiz.common.portal.PortalPortlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.portal.PortalPagePortlet;
import org.apache.ofbiz.common.portal.PortletAttribute;
import org.apache.ofbiz.common.portal.PortletPortletCategory;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PortalPortletBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PortalPortletBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PortalPortlets
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PortalPortlet.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PortalPortlets
	 */
	public List<PortalPortlet> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PortalPortlet> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PortalPortlet.NAME);
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
				entityList = PortalPortlet.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PortalPortlet
	 */
	public Optional<PortalPortlet> findOne(Object portalPortletId) {
		List<PortalPortlet> entityList = null;
		In in = new In();
		in.setEntityName(PortalPortlet.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("portalPortletId",
						EntityOperator.EQUALS, portalPortletId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortalPortlet.fromValues(out.getListIt()
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
			PortalPortlet portalPortlet, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("portalPortletId",
						EntityOperator.EQUALS, portalPortlet
								.getPortalPortletId())), EntityOperator.AND));
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

	/**
	 * Get portlet attributes
	 */
	public List<PortletAttribute> getPortletAttributes(
			PortalPortlet portalPortlet, Integer start, Integer number,
			List<String> orderBy) {
		List<PortletAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PortletAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("portalPortletId",
						EntityOperator.EQUALS, portalPortlet
								.getPortalPortletId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortletAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get portlet portlet categories
	 */
	public List<PortletPortletCategory> getPortletPortletCategories(
			PortalPortlet portalPortlet, Integer start, Integer number,
			List<String> orderBy) {
		List<PortletPortletCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PortletPortletCategory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("portalPortletId",
						EntityOperator.EQUALS, portalPortlet
								.getPortalPortletId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortletPortletCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}