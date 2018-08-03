package org.apache.ofbiz.webapp.visit.service.base;

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
import org.apache.ofbiz.webapp.visit.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.webapp.visit.BrowserType;
import org.apache.ofbiz.webapp.visit.PlatformType;
import org.apache.ofbiz.webapp.visit.ProtocolType;
import org.apache.ofbiz.webapp.visit.UserAgentType;
import org.apache.ofbiz.webapp.visit.UserAgentMethodType;
import org.apache.ofbiz.webapp.visit.Visit;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class UserAgentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public UserAgentBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count UserAgents
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(UserAgent.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find UserAgents
	 */
	public List<UserAgent> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<UserAgent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UserAgent.NAME);
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
				entityList = UserAgent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one UserAgent
	 */
	public Optional<UserAgent> findOne(Object userAgentId) {
		List<UserAgent> entityList = null;
		In in = new In();
		in.setEntityName(UserAgent.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userAgentId", EntityOperator.EQUALS,
						userAgentId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserAgent.fromValues(out.getListIt()
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
	 * Get browser type
	 */
	public Optional<BrowserType> getBrowserType(UserAgent userAgent) {
		List<BrowserType> entityList = null;
		In in = new In();
		in.setEntityName(BrowserType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("browserTypeId", EntityOperator.EQUALS,
						userAgent.getBrowserTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BrowserType.fromValues(out.getListIt()
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
	 * Get platform type
	 */
	public Optional<PlatformType> getPlatformType(UserAgent userAgent) {
		List<PlatformType> entityList = null;
		In in = new In();
		in.setEntityName(PlatformType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("platformTypeId", EntityOperator.EQUALS,
						userAgent.getPlatformTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PlatformType.fromValues(out.getListIt()
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
	 * Get protocol type
	 */
	public Optional<ProtocolType> getProtocolType(UserAgent userAgent) {
		List<ProtocolType> entityList = null;
		In in = new In();
		in.setEntityName(ProtocolType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("protocolTypeId", EntityOperator.EQUALS,
						userAgent.getProtocolTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProtocolType.fromValues(out.getListIt()
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
	 * Get user agent type
	 */
	public Optional<UserAgentType> getUserAgentType(UserAgent userAgent) {
		List<UserAgentType> entityList = null;
		In in = new In();
		in.setEntityName(UserAgentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("userAgentTypeId",
						EntityOperator.EQUALS, userAgent.getUserAgentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserAgentType.fromValues(out.getListIt()
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
	 * Get user agent method type
	 */
	public Optional<UserAgentMethodType> getUserAgentMethodType(
			UserAgent userAgent) {
		List<UserAgentMethodType> entityList = null;
		In in = new In();
		in.setEntityName(UserAgentMethodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userAgentMethodTypeId",
						EntityOperator.EQUALS, userAgent
								.getUserAgentMethodTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserAgentMethodType.fromValues(out.getListIt()
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
	 * Get visits
	 */
	public List<Visit> getVisits(UserAgent userAgent, Integer start,
			Integer number, List<String> orderBy) {
		List<Visit> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Visit.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userAgentId", EntityOperator.EQUALS,
						userAgent.getUserAgentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Visit.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}