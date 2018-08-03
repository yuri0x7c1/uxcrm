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
import org.apache.ofbiz.party.party.PartyClassificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.PartyClassificationGroup;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyClassificationTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyClassificationTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PartyClassificationTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PartyClassificationType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PartyClassificationTypes
	 */
	public List<PartyClassificationType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PartyClassificationType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyClassificationType.NAME);
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
				entityList = PartyClassificationType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PartyClassificationType
	 */
	public Optional<PartyClassificationType> findOne(
			Object partyClassificationTypeId) {
		List<PartyClassificationType> entityList = null;
		In in = new In();
		in.setEntityName(PartyClassificationType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyClassificationTypeId",
						EntityOperator.EQUALS, partyClassificationTypeId)),
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
	 * Get parent party classification type
	 */
	public Optional<PartyClassificationType> getParentPartyClassificationType(
			PartyClassificationType partyClassificationType) {
		List<PartyClassificationType> entityList = null;
		In in = new In();
		in.setEntityName(PartyClassificationType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyClassificationTypeId",
						EntityOperator.EQUALS, partyClassificationType
								.getParentTypeId())), EntityOperator.AND));
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
	 * Get party classification groups
	 */
	public List<PartyClassificationGroup> getPartyClassificationGroups(
			PartyClassificationType partyClassificationType, Integer start,
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
				.asList(new EntityExpr("partyClassificationTypeId",
						EntityOperator.EQUALS, partyClassificationType
								.getPartyClassificationTypeId())),
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
	 * Get child party classification types
	 */
	public List<PartyClassificationType> getChildPartyClassificationTypes(
			PartyClassificationType partyClassificationType, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyClassificationType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyClassificationType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("parentTypeId",
						EntityOperator.EQUALS, partyClassificationType
								.getPartyClassificationTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyClassificationType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}