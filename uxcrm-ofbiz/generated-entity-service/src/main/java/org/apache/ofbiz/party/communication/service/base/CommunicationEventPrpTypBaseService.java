package org.apache.ofbiz.party.communication.service.base;

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
import org.apache.ofbiz.party.communication.CommunicationEventPrpTyp;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.communication.CommunicationEventPurpose;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CommunicationEventPrpTypBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CommunicationEventPrpTypBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CommunicationEventPrpTyps
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CommunicationEventPrpTyp.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CommunicationEventPrpTyps
	 */
	public List<CommunicationEventPrpTyp> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<CommunicationEventPrpTyp> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CommunicationEventPrpTyp.NAME);
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
				entityList = CommunicationEventPrpTyp.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CommunicationEventPrpTyp
	 */
	public Optional<CommunicationEventPrpTyp> findOne(
			Object communicationEventPrpTypId) {
		List<CommunicationEventPrpTyp> entityList = null;
		In in = new In();
		in.setEntityName(CommunicationEventPrpTyp.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("communicationEventPrpTypId",
						EntityOperator.EQUALS, communicationEventPrpTypId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommunicationEventPrpTyp.fromValues(out
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
	 * Get parent communication event prp typ
	 */
	public Optional<CommunicationEventPrpTyp> getParentCommunicationEventPrpTyp(
			CommunicationEventPrpTyp communicationEventPrpTyp) {
		List<CommunicationEventPrpTyp> entityList = null;
		In in = new In();
		in.setEntityName(CommunicationEventPrpTyp.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("communicationEventPrpTypId",
						EntityOperator.EQUALS, communicationEventPrpTyp
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommunicationEventPrpTyp.fromValues(out
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
	 * Get child communication event prp typs
	 */
	public List<CommunicationEventPrpTyp> getChildCommunicationEventPrpTyps(
			CommunicationEventPrpTyp communicationEventPrpTyp, Integer start,
			Integer number, List<String> orderBy) {
		List<CommunicationEventPrpTyp> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CommunicationEventPrpTyp.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						communicationEventPrpTyp
								.getCommunicationEventPrpTypId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommunicationEventPrpTyp.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get communication event purposes
	 */
	public List<CommunicationEventPurpose> getCommunicationEventPurposes(
			CommunicationEventPrpTyp communicationEventPrpTyp, Integer start,
			Integer number, List<String> orderBy) {
		List<CommunicationEventPurpose> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CommunicationEventPurpose.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("communicationEventPrpTypId",
						EntityOperator.EQUALS, communicationEventPrpTyp
								.getCommunicationEventPrpTypId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CommunicationEventPurpose.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}