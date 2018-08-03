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
import org.apache.ofbiz.common.portal.PortalPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.security.securitygroup.SecurityGroup;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.common.portal.PortalPageColumn;
import org.apache.ofbiz.common.portal.PortalPagePortlet;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PortalPageBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PortalPageBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PortalPages
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PortalPage.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PortalPages
	 */
	public List<PortalPage> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PortalPage> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PortalPage.NAME);
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
				entityList = PortalPage.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PortalPage
	 */
	public Optional<PortalPage> findOne(Object portalPageId) {
		List<PortalPage> entityList = null;
		In in = new In();
		in.setEntityName(PortalPage.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("portalPageId", EntityOperator.EQUALS,
						portalPageId)), EntityOperator.AND));
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
	 * Get parent portal page
	 */
	public Optional<PortalPage> getParentPortalPage(PortalPage portalPage) {
		List<PortalPage> entityList = null;
		In in = new In();
		in.setEntityName(PortalPage.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("portalPageId", EntityOperator.EQUALS,
						portalPage.getParentPortalPageId())),
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
	 * Get security group
	 */
	public Optional<SecurityGroup> getSecurityGroup(PortalPage portalPage) {
		List<SecurityGroup> entityList = null;
		In in = new In();
		in.setEntityName(SecurityGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("groupId", EntityOperator.EQUALS,
						portalPage.getSecurityGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SecurityGroup.fromValues(out.getListIt()
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
	 * Get content
	 */
	public Optional<Content> getContent(PortalPage portalPage) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						portalPage.getHelpContentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Content.fromValues(out.getListIt()
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
	 * Get child portal pages
	 */
	public List<PortalPage> getChildPortalPages(PortalPage portalPage,
			Integer start, Integer number, List<String> orderBy) {
		List<PortalPage> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PortalPage.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentPortalPageId",
						EntityOperator.EQUALS, portalPage.getPortalPageId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortalPage.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get portal page columns
	 */
	public List<PortalPageColumn> getPortalPageColumns(PortalPage portalPage,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("portalPageId", EntityOperator.EQUALS,
						portalPage.getPortalPageId())), EntityOperator.AND));
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
	 * Get portal page portlets
	 */
	public List<PortalPagePortlet> getPortalPagePortlets(PortalPage portalPage,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("portalPageId", EntityOperator.EQUALS,
						portalPage.getPortalPageId())), EntityOperator.AND));
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