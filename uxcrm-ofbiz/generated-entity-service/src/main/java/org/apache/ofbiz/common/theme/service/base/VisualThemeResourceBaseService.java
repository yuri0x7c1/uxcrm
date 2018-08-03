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
import org.apache.ofbiz.common.theme.VisualThemeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.theme.VisualTheme;
import org.apache.ofbiz.common._enum.Enumeration;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class VisualThemeResourceBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public VisualThemeResourceBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count VisualThemeResources
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(VisualThemeResource.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find VisualThemeResources
	 */
	public List<VisualThemeResource> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<VisualThemeResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(VisualThemeResource.NAME);
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
				entityList = VisualThemeResource.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one VisualThemeResource
	 */
	public Optional<VisualThemeResource> findOne(Object visualThemeId,
			Object resourceTypeEnumId, Object sequenceId) {
		List<VisualThemeResource> entityList = null;
		In in = new In();
		in.setEntityName(VisualThemeResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("visualThemeId", EntityOperator.EQUALS,
						visualThemeId), new EntityExpr("resourceTypeEnumId",
						EntityOperator.EQUALS, resourceTypeEnumId),
						new EntityExpr("sequenceId", EntityOperator.EQUALS,
								sequenceId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VisualThemeResource.fromValues(out.getListIt()
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
	 * Get visual theme
	 */
	public Optional<VisualTheme> getVisualTheme(
			VisualThemeResource visualThemeResource) {
		List<VisualTheme> entityList = null;
		In in = new In();
		in.setEntityName(VisualTheme.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("visualThemeId", EntityOperator.EQUALS,
						visualThemeResource.getVisualThemeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VisualTheme.fromValues(out.getListIt()
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
	 * Get enumeration
	 */
	public Optional<Enumeration> getEnumeration(
			VisualThemeResource visualThemeResource) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						visualThemeResource.getResourceTypeEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
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