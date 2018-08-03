package org.apache.ofbiz.humanres.employment.service.base;

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
import org.apache.ofbiz.humanres.employment.BenefitTypeAndParty;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BenefitTypeAndPartyBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BenefitTypeAndPartyBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BenefitTypeAndParties
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BenefitTypeAndParty.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BenefitTypeAndParties
	 */
	public List<BenefitTypeAndParty> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<BenefitTypeAndParty> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BenefitTypeAndParty.NAME);
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
				entityList = BenefitTypeAndParty.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one BenefitTypeAndParty
	 */
	public Optional<BenefitTypeAndParty> findOne(Object benefitTypeId,
			Object roleTypeIdTo, Object partyIdFrom, Object roleTypeIdFrom,
			Object fromDate, Object partyIdTo) {
		List<BenefitTypeAndParty> entityList = null;
		In in = new In();
		in.setEntityName(BenefitTypeAndParty.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("benefitTypeId", EntityOperator.EQUALS,
						benefitTypeId), new EntityExpr("roleTypeIdTo",
						EntityOperator.EQUALS, roleTypeIdTo), new EntityExpr(
						"partyIdFrom", EntityOperator.EQUALS, partyIdFrom),
				new EntityExpr("roleTypeIdFrom", EntityOperator.EQUALS,
						roleTypeIdFrom), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate), new EntityExpr(
						"partyIdTo", EntityOperator.EQUALS, partyIdTo)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BenefitTypeAndParty.fromValues(out.getListIt()
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