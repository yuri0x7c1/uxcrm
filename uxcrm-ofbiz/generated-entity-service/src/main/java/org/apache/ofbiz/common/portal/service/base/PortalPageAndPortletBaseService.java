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
import org.apache.ofbiz.common.portal.PortalPageAndPortlet;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PortalPageAndPortletBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PortalPageAndPortletBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PortalPageAndPortlets
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PortalPageAndPortlet.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PortalPageAndPortlets
	 */
	public List<PortalPageAndPortlet> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PortalPageAndPortlet> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PortalPageAndPortlet.NAME);
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
				entityList = PortalPageAndPortlet.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PortalPageAndPortlet
	 */
	public Optional<PortalPageAndPortlet> findOne(Object portalPageId,
			Object portletSeqId, Object portalPortletId) {
		List<PortalPageAndPortlet> entityList = null;
		In in = new In();
		in.setEntityName(PortalPageAndPortlet.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("portalPageId", EntityOperator.EQUALS,
						portalPageId), new EntityExpr("portletSeqId",
						EntityOperator.EQUALS, portletSeqId), new EntityExpr(
						"portalPortletId", EntityOperator.EQUALS,
						portalPortletId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PortalPageAndPortlet.fromValues(out.getListIt()
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