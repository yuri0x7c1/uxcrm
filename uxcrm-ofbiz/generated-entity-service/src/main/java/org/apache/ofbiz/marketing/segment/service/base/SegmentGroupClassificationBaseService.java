package org.apache.ofbiz.marketing.segment.service.base;

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
import org.apache.ofbiz.marketing.segment.SegmentGroupClassification;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.marketing.segment.SegmentGroup;
import org.apache.ofbiz.party.party.PartyClassificationGroup;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class SegmentGroupClassificationBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public SegmentGroupClassificationBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count SegmentGroupClassifications
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(SegmentGroupClassification.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find SegmentGroupClassifications
	 */
	public List<SegmentGroupClassification> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<SegmentGroupClassification> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SegmentGroupClassification.NAME);
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
				entityList = SegmentGroupClassification.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one SegmentGroupClassification
	 */
	public Optional<SegmentGroupClassification> findOne(Object segmentGroupId,
			Object partyClassificationGroupId) {
		List<SegmentGroupClassification> entityList = null;
		In in = new In();
		in.setEntityName(SegmentGroupClassification.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("segmentGroupId", EntityOperator.EQUALS,
						segmentGroupId), new EntityExpr(
						"partyClassificationGroupId", EntityOperator.EQUALS,
						partyClassificationGroupId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SegmentGroupClassification.fromValues(out
						.getListIt().getCompleteList());
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
	 * Get segment group
	 */
	public Optional<SegmentGroup> getSegmentGroup(
			SegmentGroupClassification segmentGroupClassification) {
		List<SegmentGroup> entityList = null;
		In in = new In();
		in.setEntityName(SegmentGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("segmentGroupId", EntityOperator.EQUALS,
						segmentGroupClassification.getSegmentGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SegmentGroup.fromValues(out.getListIt()
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
	 * Get party classification group
	 */
	public Optional<PartyClassificationGroup> getPartyClassificationGroup(
			SegmentGroupClassification segmentGroupClassification) {
		List<PartyClassificationGroup> entityList = null;
		In in = new In();
		in.setEntityName(PartyClassificationGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyClassificationGroupId",
						EntityOperator.EQUALS, segmentGroupClassification
								.getPartyClassificationGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyClassificationGroup.fromValues(out
						.getListIt().getCompleteList());
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