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
import org.apache.ofbiz.party.party.PartyIdentificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.PartyIdentification;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyIdentificationTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyIdentificationTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PartyIdentificationTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PartyIdentificationType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PartyIdentificationTypes
	 */
	public List<PartyIdentificationType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PartyIdentificationType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyIdentificationType.NAME);
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
				entityList = PartyIdentificationType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PartyIdentificationType
	 */
	public Optional<PartyIdentificationType> findOne(
			Object partyIdentificationTypeId) {
		List<PartyIdentificationType> entityList = null;
		In in = new In();
		in.setEntityName(PartyIdentificationType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdentificationTypeId",
						EntityOperator.EQUALS, partyIdentificationTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyIdentificationType.fromValues(out.getListIt()
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
	 * Get parent party identification type
	 */
	public Optional<PartyIdentificationType> getParentPartyIdentificationType(
			PartyIdentificationType partyIdentificationType) {
		List<PartyIdentificationType> entityList = null;
		In in = new In();
		in.setEntityName(PartyIdentificationType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdentificationTypeId",
						EntityOperator.EQUALS, partyIdentificationType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyIdentificationType.fromValues(out.getListIt()
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
	 * Get party identifications
	 */
	public List<PartyIdentification> getPartyIdentifications(
			PartyIdentificationType partyIdentificationType, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyIdentification> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyIdentification.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyIdentificationTypeId",
						EntityOperator.EQUALS, partyIdentificationType
								.getPartyIdentificationTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyIdentification.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child party identification types
	 */
	public List<PartyIdentificationType> getChildPartyIdentificationTypes(
			PartyIdentificationType partyIdentificationType, Integer start,
			Integer number, List<String> orderBy) {
		List<PartyIdentificationType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyIdentificationType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("parentTypeId",
						EntityOperator.EQUALS, partyIdentificationType
								.getPartyIdentificationTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyIdentificationType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}