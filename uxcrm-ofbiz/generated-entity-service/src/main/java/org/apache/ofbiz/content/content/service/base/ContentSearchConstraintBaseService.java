package org.apache.ofbiz.content.content.service.base;

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
import org.apache.ofbiz.content.content.ContentSearchConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.content.ContentSearchResult;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContentSearchConstraintBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContentSearchConstraintBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContentSearchConstraints
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContentSearchConstraint.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContentSearchConstraints
	 */
	public List<ContentSearchConstraint> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ContentSearchConstraint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentSearchConstraint.NAME);
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
				entityList = ContentSearchConstraint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContentSearchConstraint
	 */
	public Optional<ContentSearchConstraint> findOne(
			Object contentSearchResultId, Object constraintSeqId) {
		List<ContentSearchConstraint> entityList = null;
		In in = new In();
		in.setEntityName(ContentSearchConstraint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contentSearchResultId", EntityOperator.EQUALS,
						contentSearchResultId), new EntityExpr(
						"constraintSeqId", EntityOperator.EQUALS,
						constraintSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentSearchConstraint.fromValues(out.getListIt()
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
	 * Get content search result
	 */
	public Optional<ContentSearchResult> getContentSearchResult(
			ContentSearchConstraint contentSearchConstraint) {
		List<ContentSearchResult> entityList = null;
		In in = new In();
		in.setEntityName(ContentSearchResult.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentSearchResultId",
						EntityOperator.EQUALS, contentSearchConstraint
								.getContentSearchResultId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentSearchResult.fromValues(out.getListIt()
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