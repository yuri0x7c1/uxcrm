package org.apache.ofbiz.common.theme.service.base;

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
import org.apache.ofbiz.common.theme.VisualThemeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.theme.VisualTheme;
import org.apache.ofbiz.webapp.website.WebSite;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class VisualThemeSetBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public VisualThemeSetBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count VisualThemeSets
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(VisualThemeSet.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find VisualThemeSets
	 */
	public List<VisualThemeSet> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<VisualThemeSet> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(VisualThemeSet.NAME);
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
				entityList = VisualThemeSet.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one VisualThemeSet
	 */
	public Optional<VisualThemeSet> findOne(Object visualThemeSetId) {
		List<VisualThemeSet> entityList = null;
		In in = new In();
		in.setEntityName(VisualThemeSet.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("visualThemeSetId",
						EntityOperator.EQUALS, visualThemeSetId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VisualThemeSet.fromValues(out.getListIt()
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
	 * Get visual themes
	 */
	public List<VisualTheme> getVisualThemes(VisualThemeSet visualThemeSet,
			Integer start, Integer number, List<String> orderBy) {
		List<VisualTheme> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(VisualTheme.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("visualThemeSetId",
						EntityOperator.EQUALS, visualThemeSet
								.getVisualThemeSetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VisualTheme.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get web sites
	 */
	public List<WebSite> getWebSites(VisualThemeSet visualThemeSet,
			Integer start, Integer number, List<String> orderBy) {
		List<WebSite> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WebSite.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("visualThemeSetId",
						EntityOperator.EQUALS, visualThemeSet
								.getVisualThemeSetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WebSite.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}