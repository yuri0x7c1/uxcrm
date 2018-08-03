package org.apache.ofbiz.party.party.service.base;

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
import org.apache.ofbiz.party.party.PartyClassificationGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.PartyClassificationType;
import org.apache.ofbiz.product.supplier.MarketInterest;
import org.apache.ofbiz.party.party.PartyClassification;
import org.apache.ofbiz.marketing.segment.SegmentGroupClassification;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyClassificationGroupBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyClassificationGroupBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PartyClassificationGroups
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PartyClassificationGroup.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PartyClassificationGroups
	 */
	public List<PartyClassificationGroup> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PartyClassificationGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyClassificationGroup.NAME);
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
				entityList = PartyClassificationGroup.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PartyClassificationGroup
	 */
	public Optional<PartyClassificationGroup> findOne(
			Object partyClassificationGroupId) {
		List<PartyClassificationGroup> entityList = null;
		In in = new In();
		in.setEntityName(PartyClassificationGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyClassificationGroupId",
						EntityOperator.EQUALS, partyClassificationGroupId)),
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

	/**
	 * Get parent party classification group
	 */
	public Optional<PartyClassificationGroup> getParentPartyClassificationGroup(
			PartyClassificationGroup partyClassificationGroup) {
		List<PartyClassificationGroup> entityList = null;
		In in = new In();
		in.setEntityName(PartyClassificationGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyClassificationGroupId",
						EntityOperator.EQUALS, partyClassificationGroup
								.getParentGroupId())), EntityOperator.AND));
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

	/**
	 * Get party classification type
	 */
	public Optional<PartyClassificationType> getPartyClassificationType(
			PartyClassificationGroup partyClassificationGroup) {
		List<PartyClassificationType> entityList = null;
		In in = new In();
		in.setEntityName(PartyClassificationType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyClassificationTypeId",
						EntityOperator.EQUALS, partyClassificationGroup
								.getPartyClassificationTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyClassificationType.fromValues(out.getListIt()
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
	 * Get market interests
	 */
	public List<MarketInterest> getMarketInterests(
			PartyClassificationGroup partyClassificationGroup, Integer start,
			Integer number, List<String> orderBy) {
		List<MarketInterest> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketInterest.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyClassificationGroupId",
						EntityOperator.EQUALS, partyClassificationGroup
								.getPartyClassificationGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketInterest.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party classifications
	 */
	public List<PartyClassification> getPartyClassifications(
			PartyClassificationGroup partyClassificationGroup, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyClassification> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyClassification.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyClassificationGroupId",
						EntityOperator.EQUALS, partyClassificationGroup
								.getPartyClassificationGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyClassification.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child party classification groups
	 */
	public List<PartyClassificationGroup> getChildPartyClassificationGroups(
			PartyClassificationGroup partyClassificationGroup, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyClassificationGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyClassificationGroup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentGroupId", EntityOperator.EQUALS,
						partyClassificationGroup
								.getPartyClassificationGroupId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyClassificationGroup.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get segment group classifications
	 */
	public List<SegmentGroupClassification> getSegmentGroupClassifications(
			PartyClassificationGroup partyClassificationGroup, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyClassificationGroupId",
						EntityOperator.EQUALS, partyClassificationGroup
								.getPartyClassificationGroupId())),
				EntityOperator.AND));
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
}