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
import org.apache.ofbiz.content.content.ContentPurpose;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.content.content.ContentPurposeType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContentPurposeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContentPurposeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContentPurposes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContentPurpose.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContentPurposes
	 */
	public List<ContentPurpose> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ContentPurpose> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentPurpose.NAME);
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
				entityList = ContentPurpose.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContentPurpose
	 */
	public Optional<ContentPurpose> findOne(Object contentId,
			Object contentPurposeTypeId) {
		List<ContentPurpose> entityList = null;
		In in = new In();
		in.setEntityName(ContentPurpose.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contentId", EntityOperator.EQUALS, contentId),
				new EntityExpr("contentPurposeTypeId", EntityOperator.EQUALS,
						contentPurposeTypeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentPurpose.fromValues(out.getListIt()
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
	public Optional<Content> getContent(ContentPurpose contentPurpose) {
		List<Content> entityList = null;
		In in = new In();
		in.setEntityName(Content.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentId", EntityOperator.EQUALS,
						contentPurpose.getContentId())), EntityOperator.AND));
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
	 * Get content purpose type
	 */
	public Optional<ContentPurposeType> getContentPurposeType(
			ContentPurpose contentPurpose) {
		List<ContentPurposeType> entityList = null;
		In in = new In();
		in.setEntityName(ContentPurposeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentPurposeTypeId",
						EntityOperator.EQUALS, contentPurpose
								.getContentPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentPurposeType.fromValues(out.getListIt()
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