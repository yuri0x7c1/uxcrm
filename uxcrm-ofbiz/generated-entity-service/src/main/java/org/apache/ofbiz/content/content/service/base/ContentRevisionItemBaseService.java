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
import org.apache.ofbiz.content.content.ContentRevisionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.content.ContentRevision;
import org.apache.ofbiz.content.data.DataResource;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContentRevisionItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContentRevisionItemBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContentRevisionItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContentRevisionItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContentRevisionItems
	 */
	public List<ContentRevisionItem> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ContentRevisionItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentRevisionItem.NAME);
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
				entityList = ContentRevisionItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContentRevisionItem
	 */
	public Optional<ContentRevisionItem> findOne(Object contentId,
			Object contentRevisionSeqId, Object itemContentId) {
		List<ContentRevisionItem> entityList = null;
		In in = new In();
		in.setEntityName(ContentRevisionItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contentId", EntityOperator.EQUALS, contentId),
				new EntityExpr("contentRevisionSeqId", EntityOperator.EQUALS,
						contentRevisionSeqId), new EntityExpr("itemContentId",
						EntityOperator.EQUALS, itemContentId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentRevisionItem.fromValues(out.getListIt()
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
	 * Get content revision
	 */
	public Optional<ContentRevision> getContentRevision(
			ContentRevisionItem contentRevisionItem) {
		List<ContentRevision> entityList = null;
		In in = new In();
		in.setEntityName(ContentRevision.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contentId", EntityOperator.EQUALS,
						contentRevisionItem.getContentId()), new EntityExpr(
						"contentRevisionSeqId", EntityOperator.EQUALS,
						contentRevisionItem.getContentRevisionSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentRevision.fromValues(out.getListIt()
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
	 * Get old data resource
	 */
	public Optional<DataResource> getOldDataResource(
			ContentRevisionItem contentRevisionItem) {
		List<DataResource> entityList = null;
		In in = new In();
		in.setEntityName(DataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						contentRevisionItem.getOldDataResourceId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResource.fromValues(out.getListIt()
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
	 * Get new data resource
	 */
	public Optional<DataResource> getNewDataResource(
			ContentRevisionItem contentRevisionItem) {
		List<DataResource> entityList = null;
		In in = new In();
		in.setEntityName(DataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						contentRevisionItem.getNewDataResourceId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResource.fromValues(out.getListIt()
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