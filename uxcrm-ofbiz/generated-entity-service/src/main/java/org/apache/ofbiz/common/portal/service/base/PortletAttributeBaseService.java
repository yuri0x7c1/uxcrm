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
import org.apache.ofbiz.common.portal.PortletAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.portal.PortalPortlet;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PortletAttributeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PortletAttributeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PortletAttributes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PortletAttribute.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PortletAttributes
	 */
	public List<PortletAttribute> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one PortletAttribute
	 */
	public Optional<PortletAttribute> findOne(Object portalPageId,
			Object portalPortletId, Object portletSeqId, Object attrName) {
		List<PortletAttribute> entityList = null;
		In in = new In();
		in.setEntityName(PortletAttribute.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("portalPageId", EntityOperator.EQUALS,
						portalPageId), new EntityExpr("portalPortletId",
						EntityOperator.EQUALS, portalPortletId),
				new EntityExpr("portletSeqId", EntityOperator.EQUALS,
						portletSeqId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortletAttribute.fromValues(out.getListIt()
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
	 * Get portal portlet
	 */
	public Optional<PortalPortlet> getPortalPortlet(
			PortletAttribute portletAttribute) {
		List<PortalPortlet> entityList = null;
		In in = new In();
		in.setEntityName(PortalPortlet.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("portalPortletId",
						EntityOperator.EQUALS, portletAttribute
								.getPortalPortletId())), EntityOperator.AND));
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
}