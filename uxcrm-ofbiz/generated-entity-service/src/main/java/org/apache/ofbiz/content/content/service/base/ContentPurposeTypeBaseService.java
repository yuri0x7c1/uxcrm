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
import org.apache.ofbiz.content.content.ContentPurposeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.content.ContentPurpose;
import org.apache.ofbiz.content.content.ContentPurposeOperation;
import org.apache.ofbiz.content.data.DataResourcePurpose;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContentPurposeTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContentPurposeTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContentPurposeTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContentPurposeType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContentPurposeTypes
	 */
	public List<ContentPurposeType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ContentPurposeType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentPurposeType.NAME);
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
				entityList = ContentPurposeType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContentPurposeType
	 */
	public Optional<ContentPurposeType> findOne(Object contentPurposeTypeId) {
		List<ContentPurposeType> entityList = null;
		In in = new In();
		in.setEntityName(ContentPurposeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentPurposeTypeId",
						EntityOperator.EQUALS, contentPurposeTypeId)),
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

	/**
	 * Get content purposes
	 */
	public List<ContentPurpose> getContentPurposes(
			ContentPurposeType contentPurposeType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentPurposeTypeId",
						EntityOperator.EQUALS, contentPurposeType
								.getContentPurposeTypeId())),
				EntityOperator.AND));
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
	 * Get content purpose operations
	 */
	public List<ContentPurposeOperation> getContentPurposeOperations(
			ContentPurposeType contentPurposeType, Integer start,
			Integer number, List<String> orderBy) {
		List<ContentPurposeOperation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentPurposeOperation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentPurposeTypeId",
						EntityOperator.EQUALS, contentPurposeType
								.getContentPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentPurposeOperation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get data resource purposes
	 */
	public List<DataResourcePurpose> getDataResourcePurposes(
			ContentPurposeType contentPurposeType, Integer start,
			Integer number, List<String> orderBy) {
		List<DataResourcePurpose> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResourcePurpose.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentPurposeTypeId",
						EntityOperator.EQUALS, contentPurposeType
								.getContentPurposeTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourcePurpose.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}