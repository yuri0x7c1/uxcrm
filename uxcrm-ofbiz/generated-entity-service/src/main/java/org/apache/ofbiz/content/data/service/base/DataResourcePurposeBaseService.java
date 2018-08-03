package org.apache.ofbiz.content.data.service.base;

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
import org.apache.ofbiz.content.data.DataResourcePurpose;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.data.DataResource;
import org.apache.ofbiz.content.content.ContentPurposeType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class DataResourcePurposeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public DataResourcePurposeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count DataResourcePurposes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(DataResourcePurpose.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find DataResourcePurposes
	 */
	public List<DataResourcePurpose> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one DataResourcePurpose
	 */
	public Optional<DataResourcePurpose> findOne(Object dataResourceId,
			Object contentPurposeTypeId) {
		List<DataResourcePurpose> entityList = null;
		In in = new In();
		in.setEntityName(DataResourcePurpose.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResourceId), new EntityExpr("contentPurposeTypeId",
						EntityOperator.EQUALS, contentPurposeTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourcePurpose.fromValues(out.getListIt()
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
	 * Get data resource
	 */
	public Optional<DataResource> getDataResource(
			DataResourcePurpose dataResourcePurpose) {
		List<DataResource> entityList = null;
		In in = new In();
		in.setEntityName(DataResource.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dataResourceId", EntityOperator.EQUALS,
						dataResourcePurpose.getDataResourceId())),
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
	 * Get content purpose type
	 */
	public Optional<ContentPurposeType> getContentPurposeType(
			DataResourcePurpose dataResourcePurpose) {
		List<ContentPurposeType> entityList = null;
		In in = new In();
		in.setEntityName(ContentPurposeType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contentPurposeTypeId",
						EntityOperator.EQUALS, dataResourcePurpose
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