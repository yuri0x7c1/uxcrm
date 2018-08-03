package org.apache.ofbiz.content.website.service.base;

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
import org.apache.ofbiz.content.website.WebAnalyticsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.website.WebAnalyticsConfig;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WebAnalyticsTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WebAnalyticsTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WebAnalyticsTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WebAnalyticsType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WebAnalyticsTypes
	 */
	public List<WebAnalyticsType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<WebAnalyticsType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebAnalyticsType.NAME);
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
				entityList = WebAnalyticsType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one WebAnalyticsType
	 */
	public Optional<WebAnalyticsType> findOne(Object webAnalyticsTypeId) {
		List<WebAnalyticsType> entityList = null;
		In in = new In();
		in.setEntityName(WebAnalyticsType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webAnalyticsTypeId",
						EntityOperator.EQUALS, webAnalyticsTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebAnalyticsType.fromValues(out.getListIt()
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
	 * Get parent web analytics type
	 */
	public Optional<WebAnalyticsType> getParentWebAnalyticsType(
			WebAnalyticsType webAnalyticsType) {
		List<WebAnalyticsType> entityList = null;
		In in = new In();
		in.setEntityName(WebAnalyticsType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webAnalyticsTypeId",
						EntityOperator.EQUALS, webAnalyticsType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebAnalyticsType.fromValues(out.getListIt()
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
	 * Get web analytics configs
	 */
	public List<WebAnalyticsConfig> getWebAnalyticsConfigs(
			WebAnalyticsType webAnalyticsType, Integer start, Integer number,
			List<String> orderBy) {
		List<WebAnalyticsConfig> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebAnalyticsConfig.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("webAnalyticsTypeId",
						EntityOperator.EQUALS, webAnalyticsType
								.getWebAnalyticsTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebAnalyticsConfig.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child web analytics types
	 */
	public List<WebAnalyticsType> getChildWebAnalyticsTypes(
			WebAnalyticsType webAnalyticsType, Integer start, Integer number,
			List<String> orderBy) {
		List<WebAnalyticsType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebAnalyticsType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						webAnalyticsType.getWebAnalyticsTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebAnalyticsType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}