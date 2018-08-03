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
import org.apache.ofbiz.party.party.PartyRelationshipToFrom;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyRelationshipToFromBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyRelationshipToFromBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PartyRelationshipToFroms
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PartyRelationshipToFrom.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PartyRelationshipToFroms
	 */
	public List<PartyRelationshipToFrom> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PartyRelationshipToFrom> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyRelationshipToFrom.NAME);
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
				entityList = PartyRelationshipToFrom.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PartyRelationshipToFrom
	 */
	public Optional<PartyRelationshipToFrom> findOne(Object oneRoleTypeIdTo,
			Object onePartyIdFrom, Object oneRoleTypeIdFrom,
			Object oneFromDate, Object onePartyIdTo, Object twoRoleTypeIdTo,
			Object twoPartyIdFrom, Object twoRoleTypeIdFrom,
			Object twoFromDate, Object twoPartyIdTo) {
		List<PartyRelationshipToFrom> entityList = null;
		In in = new In();
		in.setEntityName(PartyRelationshipToFrom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("oneRoleTypeIdTo", EntityOperator.EQUALS,
						oneRoleTypeIdTo), new EntityExpr("onePartyIdFrom",
						EntityOperator.EQUALS, onePartyIdFrom), new EntityExpr(
						"oneRoleTypeIdFrom", EntityOperator.EQUALS,
						oneRoleTypeIdFrom), new EntityExpr("oneFromDate",
						EntityOperator.EQUALS, oneFromDate), new EntityExpr(
						"onePartyIdTo", EntityOperator.EQUALS, onePartyIdTo),
				new EntityExpr("twoRoleTypeIdTo", EntityOperator.EQUALS,
						twoRoleTypeIdTo), new EntityExpr("twoPartyIdFrom",
						EntityOperator.EQUALS, twoPartyIdFrom), new EntityExpr(
						"twoRoleTypeIdFrom", EntityOperator.EQUALS,
						twoRoleTypeIdFrom), new EntityExpr("twoFromDate",
						EntityOperator.EQUALS, twoFromDate), new EntityExpr(
						"twoPartyIdTo", EntityOperator.EQUALS, twoPartyIdTo)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyRelationshipToFrom.fromValues(out.getListIt()
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